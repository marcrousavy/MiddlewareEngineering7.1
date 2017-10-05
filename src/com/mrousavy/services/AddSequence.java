package com.mrousavy.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/addseq")
public class AddSequence {
	  @GET // HTTP Get (= via URL) Metadata
	  @Produces("application/xml")
	  public String addDefault() {
		  return addWithInput("0");
	  }
	  
	  @Path("{s}") // Parameter alias
	  @GET // HTTP Get (= via URL) Metadata
	  @Produces("application/xml") // Result Metadata (application/xml)
	  public String addWithInput(@PathParam("s") String input) {
		  try {
			  String[] split = input.split(","); // Seperate by ","
			  double total = 0;
			  for (int i = 0; i < split.length; i++) { // Loop through each input
				  total += Double.valueOf(split[i].trim()); // Add each string
			  }
	
			  String result = "addWithInput(string) Output: \n\nSequence Sum Output: \n\n" + total; // Build result with header
		      return "<addseq>" + "<values>" + input + "</values><result>" + result + "</result>" + "</addseq>"; // Actual XML response
		  } catch (Exception ex) {
			  return "<addseq>Invalid input.</addseq>";
		  }
	  }
}
