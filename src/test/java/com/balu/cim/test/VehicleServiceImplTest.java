package com.balu.cim.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.balu.vim.dao.VehicleDaoImpl;
import com.balu.vim.model.Vehicle;
import com.balu.vim.services.VehicleInventoryServiceImpl;

public class VehicleServiceImplTest {

	@InjectMocks
	VehicleInventoryServiceImpl vehicleInventoryServiceImpl;

	@Mock
	VehicleDaoImpl vehicleDaoImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllVehicles_returnsVehicleList() {
		// Setup
		List<Vehicle> vehicleList = new ArrayList<>();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleType("Airplane");
		vehicle1.setVehicleMake("Jet");

		vehicleList.add(vehicle);
		vehicleList.add(vehicle1);

		// Mock
		Mockito.when(vehicleDaoImpl.findAllVehicles()).thenReturn(vehicleList);

		// Run
		List<Vehicle> allVehicles = vehicleInventoryServiceImpl.getAllVehicles();

		// Assert
		assertEquals(vehicleList, allVehicles);

	}

	@Test
	public void getAllVehicles_returnsEmptyList() {

		// Mock
		Mockito.when(vehicleDaoImpl.findAllVehicles()).thenReturn(null);

		// Run
		List<Vehicle> allVehicles = vehicleInventoryServiceImpl.getAllVehicles();

		// Assert
		assertNull(allVehicles);
	}

	@Test
	public void getVehicle_returnsVehicle() {

		// Setup
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");
		vehicle.setVehicleId(1);

		// Mock
		Mockito.when(vehicleDaoImpl.findVehicle(1)).thenReturn(vehicle);

		// Run
		Vehicle vehicleResponse = vehicleInventoryServiceImpl.readVehicle(1);

		// Assert
		assertEquals(vehicle, vehicleResponse);
	}

	@Test
	public void getVehicle_returnsNull() {

		// Mock
		Mockito.when(vehicleDaoImpl.findVehicle(1)).thenReturn(null);

		// Run
		Vehicle vehicleResponse = vehicleInventoryServiceImpl.readVehicle(1);

		// Assert
		assertNull(vehicleResponse);
	}
	
	@Test
	public void saveVehicle_returnsTrue() {

		// Setup
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Honda S");
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");

		// Run
		boolean status = vehicleInventoryServiceImpl.createVehicle(vehicle);
	}

	@Test
	public void updateVehicle_returnsTrue() {

		// Setup
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");

		// Run
		boolean status = vehicleInventoryServiceImpl.updateVehicle(vehicle, 1);
		
	}

}
