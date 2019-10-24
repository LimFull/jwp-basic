package next.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import next.model.Question;

public class QuestionDao {
	public List<Question> findAll() throws SQLException{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS " + "order by questionId desc";
		
		RowMapper rowMapper = new RowMapper() {@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				return new Question(rs.getLong("questionId"), rs.getString("writer"), rs.getString("title"), rs.getString("contents"), rs.getTimestamp("createdDate"), rs.getInt("countOfAnswer"));
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public Question findById(long questionId) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId = ?";
		
		RowMapper rowMapper = new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				return new Question(rs.getLong("questionId"), rs.getString("writer"), rs.getString("title"), rs.getString("contents"), rs.getTimestamp("createdDate"), rs.getInt("countOfAnswer"));
			}
		};
		
		return (Question) jdbcTemplate.queryForObject(sql, rowMapper, questionId);
		
	}
}
