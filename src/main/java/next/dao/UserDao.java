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
		JdbcTemplate jt= new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jt.update(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
        
    }
  
    public void update(User user) throws SQLException {
        JdbcTemplate jt = new JdbcTemplate();
        String sql = "UPDATE USERS SET password=?, name=?, email=? WHERE userId=?";
        jt.update(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() throws SQLException {
    	JdbcTemplate jt = new JdbcTemplate();
    	
    	RowMapper rowMapper = new RowMapper(){
    		@Override
    		public Object mapRow(ResultSet rs) throws SQLException {
    			return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    		}
    	};
    	
    	PreparedStatementSetter pss = new PreparedStatementSetter(){
			@Override
			public void setValue(PreparedStatement pstmt) throws SQLException {
				
			}
    		
    	};
    

    	String sql = "SELECT userId, password, name, email FROM USERS";
        return (List<User>) jt.query(sql, pss, rowMapper);
    }

    public User findByUserId(String userId) throws SQLException {
    	JdbcTemplate jt = new JdbcTemplate();
    	/*RowMapper rowMapper = new RowMapper(){
    		@Override
    		public User mapRow(ResultSet rs) throws SQLException {
    			return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    		}
    	};*/
    	
    	PreparedStatementSetter pss = new PreparedStatementSetter() {	
			@Override
			public void setValue(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, userId);
			}
		};
    	


    	
    	String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
        //return jt.queryForObject(sql, pss, rowMapper);
    	return (User) jt.queryForObject(sql, pss, (ResultSet rs) -> {
    		return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    	});
        
        
    }
}
