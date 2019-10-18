package next.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	public void setValue(PreparedStatement pstmt) throws SQLException;
}
