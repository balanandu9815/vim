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
//This Class Provides API Logic for restful web services
@Path("vehicles")
public class VehicleResource {

	@Inject
	private VehicleInventoryService vehicleInventoryService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getVehicles() {
		List<Vehicle> vehicles = vehicleInventoryService.getAllVehicles();
		if (!vehicles.isEmpty()) {
			VehicleList vehicleList = new VehicleList();
			for (Vehicle Vehicle : vehicles) {
				vehicleList.getVehicleList().add(Vehicle);
			}
			return Response.ok(vehicleList).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(), "No Data Found")).build();
		}
	}

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
		Vehicle Vehicle = vehicleInventoryService.readVehicle(id);
		if (Vehicle.getVehicleId() > 0) {
			return Response.ok(Vehicle).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity(
					new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(), "No Data Found for Vehicle Id: " + id))
					.build();
		}
	}

	@Path("/recent")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getRecentVehicle() throws VehicleServiceException {
		Vehicle Vehicle = vehicleInventoryService.getLastAddedVehicle();
		if (Vehicle.getVehicleId() > 0) {
			return Response.ok(Vehicle).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new ApiResponse(Response.Status.NOT_FOUND.getStatusCode(), "No Recent vehicle Data Found"))
					.build();
		}
	}

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

	@Path("/recent/delete")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteRecentVehicle() throws VehicleServiceException {
		boolean status = vehicleInventoryService.deleteLatestVehicle();
		if (status) {
			return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK.getStatusCode(),
					"Recent Vehicle Data Deleted Successfully")).build();
		} else {
			return Response.notModified().entity(
					new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(), "Recent Vehicle Data Not Modified"))
					.build();
		}
	}

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
			return Response.ok().status(Response.Status.CREATED).entity(
					new ApiResponse(Response.Status.OK.getStatusCode(), "Exist Vehicle Data updated Successfully"))
					.build();
		} else {
			return Response.notModified().entity(new ApiResponse(Response.Status.NOT_MODIFIED.getStatusCode(),
					"Exist Vehicle Data Not updated Successfully")).build();
		}

	}

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