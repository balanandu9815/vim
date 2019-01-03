package com.balu.vim.dao;

import java.util.List;

import com.balu.vim.model.Vehicle;

public interface VehicleDao {

	public static final String FETCH_ALL_VEHICLES = "SELECT * FROM Vehicle ";
	public static final String FETCH_VEHICLE_BY_ID = "SELECT * FROM Vehicle WHERE vehicleId = ? ";
	public static final String FETCH_RECENT_VEHICLE = "SELECT * FROM Vehicle ORDER BY vehicleId DESC LIMIT 1";
	public static final String DELETE_VEHICLE_BY_ID = "DELETE FROM Vehicle WHERE vehicleId = ? ";
	public static final String DELETE_ALL_VEHICLE = "DELETE FROM Vehicle";
	public static final String SAVE_VEHICLE_DATA = "INSERT INTO vehicle(vehicleName,vehicleType,vehicleYear,"
			+ "vehicleMake,vehicleModel,vehiclePrice,vehicleSpeed,vehicleRegisterDate," 
			+ "description,features,registeredBy) " 
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_VEHICLE_DATA = "UPDATE vehicle SET vehicleName=?,vehicleType=?,vehicleYear=?,"
			+ "vehicleMake=?,vehicleModel=?,vehiclePrice=?,vehicleSpeed=?,vehicleRegisterDate=?," 
			+ "description=?,features=?,registeredBy=? " 
			+ "WHERE vehicleId = ? ";

	// READ Operation
	public List<Vehicle> findAllVehicles();

	public Vehicle findVehicle(int id);

	public Vehicle getLastAddedVehicle();

	// CREATE operation
	public boolean saveVehicle(Vehicle v);

	// UPDATE operation
	public boolean updateVehicle(Vehicle vehicle,int id);

	// DELETE Operation
	public boolean deleteVehicle(int id);

	public boolean deleteAllVehicles();

	public boolean deleteLatestVehicle();

}