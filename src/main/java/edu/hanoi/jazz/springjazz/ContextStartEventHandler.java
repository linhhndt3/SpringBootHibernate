package edu.hanoi.jazz.springjazz;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent>{
	private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
		LOGGER.info(" context start application: " + dataSource);
		try {
			createTableIfNotExist();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info(e.getMessage(), e);
		}
	}
	
	private void createTableIfNotExist() throws SQLException {
		DatabaseMetaData dbms = dataSource.getConnection().getMetaData();
		ResultSet rs = dbms.getTables(null, null, "HN_GROUP",null);
		if(rs.next()) {
			LOGGER.info("table have already existed");
			return;
		}

		String createTableScript = "CREATE TABLE HN_GROUP ("
				+ "id int auto_increment primary key ,"
				+ "name varchar(255)"
				+ ")";
		
		LOGGER.info("create table script: " + createTableScript);
		dataSource.getConnection().createStatement().executeUpdate(createTableScript);
	}
}
