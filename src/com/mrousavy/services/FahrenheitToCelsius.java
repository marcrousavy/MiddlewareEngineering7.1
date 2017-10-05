package com.mrousavy.services;


/**
 * @author mrousavy
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/ftoc")
public class FahrenheitToCelsius {
	  @GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
		JSONObject jsonObject = new JSONObject(); // Build JSON Object from org.json
		Double fahrenheit = 98.24; // Default value
		double celsius = (fahrenheit - 32)*5/9; // Actual calculation 
		jsonObject.put("F Value", fahrenheit); // Push_back to JSON
		jsonObject.put("C Value", celsius); // Push_back to JSON
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject; // Actual JSON result
		return Response.status(200).entity(result).build(); // Status 200: OK
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
		JSONObject jsonObject = new JSONObject(); // Build JSON Object from org.json
		float celsius =  (f - 32)*5/9; // Actual calculation (with floats)
		jsonObject.put("F Value", f);  // Push_back to JSON
		jsonObject.put("C Value", celsius); // Push_back to JSON
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject; // Actual JSON result
		return Response.status(200).entity(result).build(); // Status 200: OK
	  }
}
