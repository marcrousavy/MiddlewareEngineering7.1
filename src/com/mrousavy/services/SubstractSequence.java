package com.mrousavy.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
 
@Path("/subseq")
public class SubstractSequence {
	  @Path("{s}")
	  @GET
	  @Produces("application/json")
	  public Response addWithInput(@PathParam("s") String input) {
		  String[] split = input.split(","); // Seperate by ","
		  double total = 0;
		  for (int i = 0; i < split.length; i++) { // Loop through each input
			  total -= Double.valueOf(split[i].trim()); // Add each string
		  }

		JSONObject jsonObject = new JSONObject(); // Build JSON Object from org.json
		jsonObject.put("Input", input); // Push_back to JSON
		jsonObject.put("Output", total); // Push_back to JSON
 
		String result = "@Produces(\"application/json\") Output: \n\nSubstract Sequence Service: \n\n" + jsonObject; // Actual JSON result
		return Response.status(200).entity(result).build(); // Status 200: OK	  
	  }
}
