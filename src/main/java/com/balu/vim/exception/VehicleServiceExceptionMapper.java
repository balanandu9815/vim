package com.balu.vim.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.balu.vim.model.ApiResponse;

//Custom Exception Handling
@Provider
public class VehicleServiceExceptionMapper {

	public VehicleServiceExceptionMapper() {
	}
	
	@Provider
    public static class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

    	@Override
    	public Response toResponse(ResourceNotFoundException exception) {
    		ApiResponse errorResponse = new ApiResponse();
    		errorResponse.setRespCode(Response.Status.NOT_FOUND.getStatusCode());
    		errorResponse.setRespMessage(exception.getMessage());
    		return Response.status(Response.Status.NOT_FOUND).entity(
    				errorResponse).build();
    	}
    }

    @Provider
    public static class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

        @Override
        public Response toResponse(BadRequestException exception) {
        	ApiResponse errorResponse = new ApiResponse();
    		errorResponse.setRespCode(Response.Status.BAD_REQUEST.getStatusCode());
    		errorResponse.setRespMessage(exception.getMessage());
    		return Response.status(Response.Status.BAD_REQUEST).entity(
    				errorResponse).build();
        }
    }

    @Provider
    public static class InternalServerExceptionMapper implements ExceptionMapper<InternalServerException> {

        @Override
        public Response toResponse(InternalServerException exception) {
        	ApiResponse errorResponse = new ApiResponse();
    		errorResponse.setRespCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    		errorResponse.setRespMessage(exception.getMessage());
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
    				errorResponse).build();
        }
    }
}