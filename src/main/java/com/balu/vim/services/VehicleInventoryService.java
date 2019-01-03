/**
 * @author Balanandu Mettu
 *
 */
package com.balu.vim.services;

import java.util.List;

import com.balu.vim.model.Vehicle;

public interface VehicleInventoryService {
	
	//READ Operation
	public List<Vehicle> getAllVehicles();
	public Vehicle readVehicle(int id);
	public Vehicle getLastAddedVehicle();
	//CREATE operation 
	public boolean createVehicle(Vehicle v);
	//UPDATE operation 
	public boolean updateVehicle(Vehicle v,int id) ;
	//DELETE Operation
	public boolean deleteVehicle(int id);
	public boolean deleteAllVehicles();
	public boolean deleteLatestVehicle();
	
}
