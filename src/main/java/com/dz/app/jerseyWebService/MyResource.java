package com.dz.app.jerseyWebService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dz.app.dto.EmployeeDto;
import com.dz.app.service.serviceImpl.EmployeeServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 * 
 * Sets the path to base URL + /myresource
 * 
 */
//@Path("myresource")
public class MyResource {

	/**
	 * 
	 * 
	 * Plain old Java Object it does not extend as class or implements an interface
	 * 
	 * The class registers its methods for the HTTP GET request using the @GET
	 * annotation. Using the @Produces annotation, it defines that it can deliver
	 * several MIME types, text, XML and HTML.
	 * 
	 * The browser requests per default the HTML MIME type.
	 * 
	 * 
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getWelcomeMessageAsHtml() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</body></h1>"
				+ "</html> ";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getWelcomeMessageAsText() {
		return "welcome to jersey web service !";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	
	@GET()
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchEmployee(@PathParam("name") String name) {

		return "wellcome "+name+" ";
	}
	
//	--------------------------------------------------------------------
	
	@GET  
    @Path("/{name}")  
    public Response getMsg(@PathParam("name") String msg) {  
        String output = "Welcome  : " + msg;  
        return Response.status(200).entity(output).build();  
    }  
}