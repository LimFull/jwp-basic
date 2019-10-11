package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public abstract class SelectJdbcTemplate {
	public List query(String sql) throws SQLException {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<User> users = null;
        try {
        	con = ConnectionManager.getConnection();
        	pstmt = con.prepareStatement(sql);
        	setValue(pstmt);
        	rs = pstmt.executeQuery();
        	User user;
        	users = new ArrayList<User>();
        	while(rs.next()) {
        		user = mapRow(rs);//new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
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
	
	public User queryForObject(String sql) throws SQLException {
		List<User> users = query(sql);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	abstract void setValue(PreparedStatement pstmt)  throws SQLException;
	abstract User mapRow(ResultSet rs) throws SQLException;
	
}
