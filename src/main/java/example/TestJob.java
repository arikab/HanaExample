package example;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJob implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		DataSource ds;
		JdbcTemplate jdbcTemplate;
		try {
			InitialContext initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/DefaultDB");
			
			jdbcTemplate = new JdbcTemplate(ds);
			jdbcTemplate.update("INSERT INTO PRODUCTS(PRODUCTID) values(PRODUCT_SEQ.NEXTVAL)");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
