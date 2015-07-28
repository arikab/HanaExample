package example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.dao.DataAccessException;
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
		
		JdbcTemplate jdbcTemplate;
		List<JsonObject> productslist = null;
		JsonObject resObj;
		JsonArray productsArr;
		
		DataSource ds;
		
		try {
			InitialContext ctx = new InitialContext();
			
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

			jdbcTemplate = new JdbcTemplate(ds);
			productslist = jdbcTemplate.query(
				"SELECT * FROM PRODUCTS ",
				new RowMapper<JsonObject>() {

					@Override
					public JsonObject mapRow(ResultSet rs, int rowNum) throws SQLException {

						JsonObject templateObj = new JsonObject();

						templateObj.addProperty("productId", rs.getInt("PRODUCTID"));
						templateObj.addProperty("name", rs.getString("NAME"));
						templateObj.addProperty("category", rs.getString("CATEGORY"));
						templateObj.addProperty("vendor", rs.getString("VENDOR"));
						templateObj.addProperty("price", rs.getInt("PRICE"));
						templateObj.addProperty("quantity", rs.getInt("QUANTITY"));

						return templateObj;
					}}
				);
		} catch (DataAccessException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		productsArr = new JsonArray();

		for (JsonObject obj: productslist){
			productsArr.add(obj);
		}
		
		resObj = new JsonObject();
		
		resObj.add("Products", productsArr);
		
		//return resObj;
		
		return Response.ok().entity(resObj.toString()).build();
		
		//return null;
	}
	
}
