package example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Path("/Products")
public class Products {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts()  {
		
		/*JdbcTemplate jdbcTemplate;
		List<JsonObject> templatelist = null;
		JsonObject resObj;
		JsonArray templateArr;
		
		DataSource ds;
		
		InitialContext ctx;
		
		if (MonsoonUtils.ds == null){
			ctx = new InitialContext();
			MonsoonUtils.ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
		}

		jdbcTemplate = new JdbcTemplate(MonsoonUtils.getDataSource());
		templatelist = jdbcTemplate.query(
			"SELECT * FROM TBLTEMPLATE WHERE READYMADEID = ? ",
			new Object[]{readymade},
			new RowMapper<JsonObject>() {

				@Override
				public JsonObject mapRow(ResultSet rs, int rowNum) throws SQLException {

					JsonObject templateObj = new JsonObject();

					templateObj.addProperty("key", rs.getInt("TEMPLATEID"));
					templateObj.addProperty("desc", rs.getString("TEMPLATENAME"));

					return templateObj;
				}}
			);


		templateArr = new JsonArray();

		for (JsonObject obj: templatelist){
			templateArr.add(obj);
		}
		
		resObj = new JsonObject();
		
		resObj.add("TEMPLATES", templateArr);
		
		return resObj;
		
		return Response.ok().entity(resObj.toString()).build();*/
		
		return null;
	}
	
}
