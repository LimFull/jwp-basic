package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public class UserDao {
	public void insert(User user) throws SQLException {
        JdbcTemplate jt= new JdbcTemplate() {
        	@Override
        	void setValue(PreparedStatement pstmt) throws SQLException {
        		pstmt.setString(1, user.getUserId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());    
        		
        	}
        };
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jt.update(sql);
        
    }

 
  
    public void update(User user) throws SQLException {
        JdbcTemplate jt = new JdbcTemplate() {
        	@Override
        	void setValue(PreparedStatement pstmt) throws SQLException {
        		pstmt.setString(1, user.getPassword());
        	    pstmt.setString(2, user.getName());
        	    pstmt.setString(3, user.getEmail());
        	    pstmt.setString(4, user.getUserId());
        	}
        };
        String sql = "UPDATE USERS SET password=?, name=?, email=? WHERE userId=?";
        jt.update(sql);
    }
  


    public List<User> findAll() throws SQLException {
    	SelectJdbcTemplate jt = new SelectJdbcTemplate() {
    		@Override
    		User mapRow(ResultSet rs) throws SQLException {
    			return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    		}
    		@Override
    		void setValue(PreparedStatement pstmt) throws SQLException {
    		}
    	};
    	
    	String sql = "SELECT userId, password, name, email FROM USERS";
        return (List<User>) jt.query(sql);
    }

    public User findByUserId(String userId) throws SQLException {
    	SelectJdbcTemplate jt = new SelectJdbcTemplate() {
    		@Override
    		User mapRow(ResultSet rs) throws SQLException {
    			return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    		}
    		@Override
    		void setValue(PreparedStatement pstmt) throws SQLException {
    			pstmt.setString(1, userId);
    		}
    	};
    	
    	String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
        return jt.queryForObject(sql);
        
        
    }
}
