package com.balu.vim.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.balu.vim.exception.InternalServerException;
import com.balu.vim.exception.VehicleServiceException;
import com.balu.vim.model.ApiResponse;
import com.balu.vim.model.Vehicle;
import com.balu.vim.model.VehicleList;
import com.balu.vim.services.VehicleInventoryService;

//This Class Provides API Logics for restful web services of Vehicle Inventory Management
@Path("vehicles")
public class VehicleResource {

	// It injects VehicleInventoryService to this class code
	@Inject
	private VehicleInventoryService vehicleInventoryService;
	
	/*
	 * Creates a new Vehicle. This request should carry a request body that includes
	 * the data that should be associated with the newly created Vehicle. If the
	 * Vehicle is created, an HTTP 201 (Created) status is returned.
	 * 
	 * URL:http://localhost:8080/vim/rest/vehicles
	 * 
	 * Request Method: POST 
	 * Request Body:
	 * {
	 *	 	"vehicleName":"BenZ ",
	 * 		"vehicleType":"Car",
	 * 		"vehicleYear":2018,
	 * 		"vehicleMake":"Mercedaz",
	 * 		"vehicleModel":"luxury",
	 * 		"vehiclePrice":2000000.00,
	 * 		"vehicleSpeed":180,
	 * 		"description":"business class for rich",
	 * 		"features":"AC with accident proof",
	 * 		"registeredBy":"balanandu"
	 * } 
	 * Headers:
	 * Content-type:
	 * application/json:charset=UTF-8 Accept: application/json 
	 * Http Status: 201
	 * Created JSON Response:
	 * 	{
	 * 		"respCode":200,
	 * 		"respMessage":"New Vehicle Data created Successfully"
	 * }
	 * Headers:
	 *  Content-type: application/xml;charset=UTF-8 
	 *  Accept: application/xml
	 * Request Body: 
	 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	 * <vehicle> 
	 * 		<description>business class for rich</description> 
	 * 		<features>AC with accident proof</features>
	 * 		<registeredBy>balanandu</registeredBy>
	 * 		<vehicleMake>Mercedaz</vehicleMake> 
	 * 		<vehicleModel>luxury</vehicleModel>
	 * 		<vehicleName>BenZ </vehicleName> 
	 * 		<vehiclePrice>2000000.00</vehiclePrice>
	 * 		<vehicleSpeed>180</vehicleSpeed> 
	 * 		<vehicleType>Car</vehicleType>
	 * 		<vehicleYear>2018</vehicleYear> 
	 * </vehicle> 
	 * Http Status: 201 Created XML
	 * Response: 
	 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?> 
	 * <Response>
	 * 		<respCode>200</respCode> 
	 * 		<respMessage>New Vehicle Data created Successfully</respMessage> 
	 * </Response>
	 */

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveVehicle(Vehicle vehicle) {
		boolean status = vehicleInventoryService.createVehicle(vehicle);
		if (status) {
			return Response.ok().status(Response.Status.CREATED).entity(
					new ApiResponse(Response.Status.OK.getStatusCode(), "New Vehicle Data created Successfully"))
					.build();
		} else {
			return Response.notModified().entity(new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(),
					"New Vehicle Data Not Saved Successfully")).build();
		}
	}

	/*
	 * Obtains the list of all Vehicles currently created in the system. If the list
	 * is successfully obtained, the list of existing Vehicles is returned, along
	 * with an HTTP 200(OK) status.
	 * 
	 * URL:http://localhost:8080/vim/rest/vehicles
	 * 
	 * Request Method: GET 
	 * Request Body: none 
	 * Headers: 
	 * 		Content-type: application/json or application/XML :charset=UTF-8
	 * 		Accept: application/json or application/XML
	 * Http Status: 200 OK 
	 * Response:
	 * {
		    "vehicleList": [
		        {
		            "vehicleId": 1,
		            "vehicleName": "BenZ ",
		            "vehicleType": "Car",
		            "vehicleYear": 2018,
		            "vehicleMake": "Mercedaz",
		            "vehicleModel": "luxury",
		            "vehiclePrice": 2000000,
		            "vehicleSpeed": 180,
		            "vehicleRegisterDate": "2019-01-10 23:36:38",
		            "description": "business class for rich",
		            "features": "AC with accident proof",
		            "registeredBy": "balanandu"
		        },
		        {
		            "vehicleId": 2,
		            "vehicleName": "Ashok Leyland",
		            "vehicleType": "Truck",
		            "vehicleYear": 2018,
		            "vehicleMake": "TATA",
		            "vehicleModel": "Eicher",
		            "vehiclePrice": 600000,
		            "vehicleSpeed": 180,
		            "vehicleRegisterDate": "2019-01-10 23:41:04",
		            "description": "Heavy load Carrier",
		            "features": "20 wheels",
		            "registeredBy": "balanandu"
		        }
		    ]
		}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	XML Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<VehicleList>
	    <Vehicle>
	        <description>Heavy load Carrier</description>
	        <features>20 wheels</features>
	        <registeredBy>balanandu</registeredBy>
	        <vehicleId>1</vehicleId>
	        <vehicleMake>TATA</vehicleMake>
	        <vehicleModel>Eicher</vehicleModel>
	        <vehicleName>Ashok Leyland</vehicleName>
	        <vehiclePrice>600000.00</vehiclePrice>
	        <vehicleRegisterDate>2019-01-10 23:28:34</vehicleRegisterDate>
	        <vehicleSpeed>180</vehicleSpeed>
	        <vehicleType>Truck</vehicleType>
	        <vehicleYear>2018</vehicleYear>
	    </Vehicle>
	    <Vehicle>
	        <description>business class for rich</description>
	        <features>AC with accident proof</features>
	        <registeredBy>balanandu</registeredBy>
	        <vehicleId>2</vehicleId>
	        <vehicleMake>Mercedaz</vehicleMake>
	        <vehicleModel>luxury</vehicleModel>
	        <vehicleName>BenZ </vehicleName>
	        <vehiclePrice>2000000.00</vehiclePrice>
	        <vehicleRegisterDate>2019-01-10 23:31:21</vehicleRegisterDate>
	        <vehicleSpeed>180</vehicleSpeed>
	        <vehicleType>Car</vehicleType>
	        <vehicleYear>2018</vehicleYear>
	    </Vehicle>
	</VehicleList>
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getVehicles() {
		List<Vehicle> vehicles = vehicleInventoryService.getAllVehicles();
		VehicleList vehicleList = new VehicleList();
		if (!vehicles.isEmpty()) {
			for (Vehicle Vehicle : vehicles) {
				vehicleList.getVehicleList().add(Vehicle);
			}
		}
		return Response.ok(vehicleList).build();
	}

	/*
	 * Obtains the Vehicle associated with the given ID. If no Vehicle exists, an
	 * HTTP 404 (Not Found) status is returned. If the Vehicle can be found, an HTTP
	 * 200 status is returned and the response body contains the information
	 * associated with the Vehicle.
	 * 
	 *  URL:http://localhost:8080/vim/rest/vehicles/{vehicleId}
		Ex:http://localhost:8080/vim/rest/vehicles/1
		PathParam: vehicleId(int type)
		Request Method: GET
		Request Body: none
		Headers:
		Content-type: application/json:charset=UTF-8
		Accept: application/json
		Http Status: 200 OK
		JSON Response:
		{
		    "vehicleId": 1,
		    "vehicleName": "BenZ ",
		    "vehicleType": "Car",
		    "vehicleYear": 2018,
		    "vehicleMake": "Mercedaz",
		    "vehicleModel": "luxury",
		    "vehiclePrice": 2000000,
		    "vehicleSpeed": 180,
		    "vehicleRegisterDate": "2019-01-10 23:36:38",
		    "description": "business class for rich",
		    "features": "AC with accident proof",
		    "registeredBy": "balanandu"
		}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Http Status: 200 OK
		XML Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		    <description>business class for rich</description>
		    <features>AC with accident proof</features>
		    <registeredBy>balanandu</registeredBy>
		    <vehicleId>1</vehicleId>
		    <vehicleMake>Mercedaz</vehicleMake>
		    <vehicleModel>luxury</vehicleModel>
		    <vehicleName>BenZ </vehicleName>
		    <vehiclePrice>2000000.00</vehiclePrice>
		    <vehicleRegisterDate>2019-01-10 23:36:38</vehicleRegisterDate>
		    <vehicleSpeed>180</vehicleSpeed>
		    <vehicleType>Car</vehicleType>
		    <vehicleYear>2018</vehicleYear>
		</vehicle>
		
	 */
	@Path("/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findVehicle(@PathParam("id") int id) throws VehicleServiceException {
		try {
			validateVechicleId(id);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
					new InternalServerException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()))
					.build();
		}
		Vehicle vehicle = vehicleInventoryService.readVehicle(id);
		if (vehicle.getVehicleId() > 0) {
			return Response.ok(vehicle).build();
		} else {
			return Response.status(Response.Status.OK).entity(
					new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(), "No Data Found for Vehicle Id: " + id))
					.build();
		}
	}

	/*
	 * Obtains recent or last added Vehicle
	 * 
	 * URL:http://localhost:8080/vim/rest/vehicles/recent 
	 * Request Method: GET
	 * Request Body: none 
	 * Headers: 
	 * Content-type: application/json:charset=UTF-8
	 * Accept: application/json 
	 * Http Status: 200 OK 
	 * JSON Response:
	 * {
		    "vehicleId": 2,
		    "vehicleName": "Ashok Leyland",
		    "vehicleType": "Truck",
		    "vehicleYear": 2018,
		    "vehicleMake": "TATA",
		    "vehicleModel": "Eicher",
		    "vehiclePrice": 600000,
		    "vehicleSpeed": 180,
		    "vehicleRegisterDate": "2019-01-10 23:41:04",
		    "description": "Heavy load Carrier",
		    "features": "20 wheels",
		    "registeredBy": "balanandu"
		}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Http Status: 200 OK
		XML Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		    <description>Heavy load Carrier</description>
		    <features>20 wheels</features>
		    <registeredBy>balanandu</registeredBy>
		    <vehicleId>2</vehicleId>
		    <vehicleMake>TATA</vehicleMake>
		    <vehicleModel>Eicher</vehicleModel>
		    <vehicleName>Ashok Leyland</vehicleName>
		    <vehiclePrice>600000.00</vehiclePrice>
		    <vehicleRegisterDate>2019-01-10 23:41:04</vehicleRegisterDate>
		    <vehicleSpeed>180</vehicleSpeed>
		    <vehicleType>Truck</vehicleType>
		    <vehicleYear>2018</vehicleYear>
		</vehicle>
	 */
	@Path("/recent")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getRecentVehicle() throws VehicleServiceException {
		Vehicle vehicle = vehicleInventoryService.getLastAddedVehicle();
		if (vehicle.getVehicleId() > 0) {
			return Response.ok(vehicle).build();
		} else {
			return Response.status(Response.Status.OK).entity(
					new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(), "Recent vehicle Data Not Found"))
					.build();
		}
	}
	
	/*
	 * It updates an Exist Vehicle Data
	 * 
	 * 	URL:http://localhost:8080/vim/rest/vehicles/{vehicleId}
		Ex: http://localhost:8080/vim/rest/vehicles/1
		PathParam: vehicleId(int type)
		Request Method: PUT
		Request Body: 
		{
			"vehicleName":"BenZ ",
			"vehicleType":"Car",
			"vehicleYear":2018,
		 	"vehicleMake":"Mercedaz",
		 	"vehicleModel":"luxury",
		 	"vehiclePrice":2000000.00,
		  	"vehicleSpeed":180,
		 	"description":"business class for rich",
		 	"features":"AC with accident proof",
		  	"registeredBy":"balanandu"
		 }
		Headers:
		Content-type: application/json:charset=UTF-8
		Accept: application/json
		Http Status: 201 Created
		Response:
		{
		    "respCode": 200,
		    "respMessage": "Exist Vehicle with  Id 1 's Data updated Successfully"
		}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Request Body: 
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
			<description>Heavy load Carrier</description>
			<features>20 wheels</features>
			<registeredBy>balanandu</registeredBy>
			<vehicleMake>TATA</vehicleMake>
			<vehicleModel>Eicher</vehicleModel>
			<vehicleName>Ashok Leyland</vehicleName>
			<vehiclePrice>600000.00</vehiclePrice>
			<vehicleSpeed>180</vehicleSpeed>
			<vehicleType>Truck</vehicleType>
			<vehicleYear>2018</vehicleYear>
		</vehicle>
		Http Status: 201 Created
		Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<Response>
			<respCode>200</respCode>
			<respMessage>Exist Vehicle with  Id 1 's Data updated Successfully</respMessage>
			</Response>
	 */
	@Path("/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateCity(Vehicle vehicle, @PathParam("id") int id) {
		try {
			validateVechicleId(id);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
					new InternalServerException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()))
					.build();
		}
		boolean status = vehicleInventoryService.updateVehicle(vehicle, id);
		if (status) {
			return Response.ok().status(Response.Status.CREATED)
					.entity(new ApiResponse(Response.Status.OK.getStatusCode(),
							"Exist Vehicle with  Id " + id + " 's Data updated Successfully"))
					.build();
		} else {
			return Response.notModified().entity(new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(),
					"Exist Vehicle  with Id " + id + "'s Data Not updated Successfully")).build();
		}

	}
	
	/*
	 *	It Deletes Exist Data based on Vehicle Id
	 *
	 *	URL:http://localhost:8080/vim/rest/vehicles/delete/{vehicleId}
		Ex: http://localhost:8080/vim/rest/vehicles/2
		PathParam: vehicleId(int type)
		Request Method: DELETE
		Headers:
		Content-type: application/json:charset=UTF-8
		Accept: application/json
		Http Status: 200 OK
		Response:
		{"respCode":200,"respMessage":"Vehicle Id 2 Data Deleted Successfully"}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Http Status: 200 OK
		Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<Response>
				<respCode>200</respCode>
				<respMessage>Vehicle Id 2 Data Deleted Successfully</respMessage>
			</Response>
	 * 
	 */

	@Path("/delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteVehicle(@PathParam("id") int id) throws VehicleServiceException {
		try {
			validateVechicleId(id);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
					new InternalServerException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()))
					.build();
		}
		boolean status = vehicleInventoryService.deleteVehicle(id);

		if (status) {
			return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK.getStatusCode(),
					"Vehicle Id " + id + " Data Deleted Successfully")).build();
		} else {
			return Response.notModified()
					.entity(new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(), "Vehicle Data Not Modified"))
					.build();
		}
	}

	/*
	 * It Delete All Existing Vehicles Data
	 * 
	 *	URL:http://localhost:8080/vim/rest/vehicles/delete
		Request Method: DELETE
		Headers:
		Content-type: application/json:charset=UTF-8
		Accept: application/json
		Http Status: 200 OK
		Response:
		{"respCode":200,"respMessage":"All Vehicles Data Deleted Successfully"}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Http Status: 200 OK
		Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
			<respCode>200</respCode>
			<respMessage>All Vehicles Data Deleted Successfully</respMessage>
		</Response>
	 */
	@Path("/delete")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteAllVehicle() throws VehicleServiceException {
		boolean status = vehicleInventoryService.deleteAllVehicles();
		if (status) {
			return Response.status(Response.Status.OK).entity(
					new ApiResponse(Response.Status.OK.getStatusCode(), "All Vehicles Data Deleted Successfully"))
					.build();
		} else {
			return Response.notModified()
					.entity(new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(), "Vehicle Data Not Modified"))
					.build();
		}
	}

	/*
	 * It Deletes an recent or last added Vehicle Data
	 * 
	 * URL:http://localhost:8080/vim/rest/vehicles/recent/delete
		Request Method: DELETE
		Headers:
		Content-type: application/json:charset=UTF-8
		Accept: application/json
		Http Status: 200 OK
		Response:
		{"respCode":200,"respMessage":"Recent Vehicle Data Deleted Successfully"}
		Headers:
		Content-type: application/xml;charset=UTF-8
		Accept: application/xml
		Http Status: 200 OK
		Response:
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
			<respCode>200</respCode>
			<respMessage>Recent Vehicle Data Deleted Successfully</respMessage>
		</Response>
	 */
	@Path("/recent/delete")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteRecentVehicle() throws VehicleServiceException {
		boolean status = vehicleInventoryService.deleteLatestVehicle();
		if (status) {
			return Response.status(Response.Status.OK).entity(
					new ApiResponse(Response.Status.OK.getStatusCode(), "Recent Vehicle Data Deleted Successfully"))
					.build();
		} else {
			return Response.notModified().entity(
					new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(), "Recent Vehicle Data Not Modified"))
					.build();
		}
	}


	/*
	 * It validates vehicle id , on invalid data throws exception
	 */
	private void validateVechicleId(int id) throws VehicleServiceException {
		if (id <= 0) {
			throw new VehicleServiceException(1, "Not a Valid Vehicle ID!..");
		}
		try {
			Integer.parseInt(String.valueOf(id));
		} catch (NumberFormatException e) {
			throw new VehicleServiceException(801, "Vehicle ID is not a number !!");
		}
	}
}