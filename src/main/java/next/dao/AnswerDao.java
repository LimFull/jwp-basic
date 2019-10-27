package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import next.model.Answer;

public class AnswerDao {
	public List<Answer> findAllByQuestionId(long questionId) throws SQLException{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT answerId, writer, contents, createdDate FROM ANSWERS WHERE questionId = ? ORDER BY answerId DESC";
		RowMapper rowMapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				return new Answer(rs.getLong("answerId"), rs.getString("writer"), rs.getString("contents"), rs.getTimestamp("createdDate"), questionId);
			}
		};
		return jdbcTemplate.query(sql, rowMapper, questionId);
		
	}

}
