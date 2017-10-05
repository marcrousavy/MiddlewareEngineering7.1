package com.mrousavy.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
 
@Path("/subseq")
public class SubstractSequence {
	  @GET // HTTP Get (= via URL) Metadata
	  @Produces("application/json") // Result Metadata (application/json)
	  public Response subDefault() {
		return subWithInput("0");  
	  }
	  
	  @Path("{s}") // Parameter alias
	  @GET // HTTP Get (= via URL) Metadata
	  @Produces("application/json") // Result Metadata (application/json)
	  public Response subWithInput(@PathParam("s") String input) {
		  try {
			  String[] split = input.split(","); // Seperate by ","
			  double total = Double.valueOf(split[0]); // starting value is first value
			  for (int i = 1; i < split.length; i++) { // Loop through each input
				  total -= Double.valueOf(split[i].trim()); // Substract each value from "total", starting from index 1
			  }
			
				JSONObject jsonObject = new JSONObject(); // Build JSON Object from org.json
				jsonObject.put("Input", input); // Push_back to JSON
				jsonObject.put("Output", total); // Push_back to JSON
				 
				String result = "subWithInput(string) Output: \n\nSubstract Sequence Service: \n\n" + jsonObject; // Actual JSON result
				return Response.status(200).entity(result).build(); // Status 200: OK
		  } catch (Exception ex) {
			  return Response.status(200).entity("Invalid input.").build();
		  }	  
	  }
}
