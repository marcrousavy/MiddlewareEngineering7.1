package com.mrousavy.services;

/**
 * @author mrousavy
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/ctof")
public class CelsiusToFahrenheit {
	@GET
	@Produces("application/xml")
	public String convertCtoF() {
		double celsius = 36.8; // Default value
		double fahrenheit = ((celsius * 9) / 5) + 32; // actual calculation
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit; // Build result with header
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>"; // Actual XML response
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		double celsius = c;
		double fahrenheit = ((celsius * 9) / 5) + 32; // actual calculation
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit; // Build result with header
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>"; // Actual XML response
	}
}