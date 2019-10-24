package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public class JdbcTemplate {
	public void update(String sql, PreparedStatementSetter pss) throws DataAccessException {
        
        try (Connection con = ConnectionManager.getConnection();
        		PreparedStatement pstmt = con.prepareStatement(sql)){
            pss.setValue(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	throw new DataAccessException(e);
        }
    }
	
	// 가변인자 update
	public void update(String sql, Object... parameters) throws DataAccessException{
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			for (int i=0; i<parameters.length; i++) {
				pstmt.setObject(i+1, parameters[i]);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	}
	
	public List query(String sql, RowMapper rowMapper, Object... parameters) throws SQLException {
		return query(sql, createPreparedStatementSetter(parameters), rowMapper);
	}
	
	public List query(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<Object> list = null;
        try {
        	con = ConnectionManager.getConnection();
        	pstmt = con.prepareStatement(sql);
        	pss.setValue(pstmt);
        	rs = pstmt.executeQuery();
        	list = new ArrayList<Object>();
        	while(rs.next()) {
        		list.add(rowMapper.mapRow(rs));
        		System.out.println("rs = "+rowMapper.mapRow(rs));
        	}
        } finally {
        	if (rs != null) {
        		rs.close();
        	}
        	if (pstmt != null) {
        		pstmt.close();
        	}
        	if (con != null) {
        		con.close();
        	}
        }
    	
    	
        return list;
	}
	
	public Object queryForObject(String sql, RowMapper rowMapper, Object... parameters) throws SQLException {
		return queryForObject(sql, createPreparedStatementSetter(parameters), rowMapper);
	}
	
	public Object queryForObject(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
		List<Object> list = query(sql, pss, rowMapper);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	private PreparedStatementSetter createPreparedStatementSetter(Object... parameters) {
		return new PreparedStatementSetter() {

			@Override
			public void setValue(PreparedStatement pstmt) throws SQLException {
				for (int i = 0; i < parameters.length; i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
				
			}

		};
	}
}
