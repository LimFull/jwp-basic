package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface PreparedStatementCreator {
	PreparedStatement createPreparedStatement(Connection con);

}
