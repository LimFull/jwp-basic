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
	public void update(String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setValue(pstmt);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
	
	public List query(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<User> users = null;
        try {
        	con = ConnectionManager.getConnection();
        	pstmt = con.prepareStatement(sql);
        	pss.setValue(pstmt);
        	rs = pstmt.executeQuery();
        	User user;
        	users = new ArrayList<User>();
        	while(rs.next()) {
        		user = (User) rowMapper.mapRow(rs);//new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
        		users.add(user);
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
    	
    	
        return users;
	}
	
	public User queryForObject(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
		List<User> users = query(sql, pss, rowMapper);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	
}
