package com.balu.vim.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.resteasy.spi.BadRequestException;

import com.balu.vim.dao.VehicleDao;
import com.balu.vim.model.Vehicle;
import com.balu.vim.resources.VehicleDescs;

//service Layer Logic
public class VehicleInventoryServiceImpl implements VehicleInventoryService {

	@Inject
	private VehicleDao vehicleDao;

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleDao.findAllVehicles();
	}

	@Override
	public Vehicle readVehicle(int id) {
		return vehicleDao.findVehicle(id);
	}

	@Override
	public Vehicle getLastAddedVehicle() {
		return vehicleDao.getLastAddedVehicle();
	}

	@Override
	public boolean createVehicle(Vehicle vehicle) {
		boolean isCreated=false;
		if(vehicle!=null) {
			checkVehicleData(vehicle);
			isCreated=vehicleDao.saveVehicle(vehicle);
		}
		return isCreated;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle, int id) {
		boolean isUpdated=false;
		if(vehicle!=null) {
			checkVehicleData(vehicle);
			isUpdated=vehicleDao.updateVehicle(vehicle, id);
		}
		return isUpdated;
	}

	@Override
	public boolean deleteVehicle( int id) {
		return vehicleDao.deleteVehicle(id);
	}

	@Override
	public boolean deleteAllVehicles() {
		return vehicleDao.deleteAllVehicles();
	}

	@Override
	public boolean deleteLatestVehicle() {
		return vehicleDao.deleteLatestVehicle();
	}
	
	private void checkVehicleData(Vehicle vehicle) {
		if(vehicle.getVehicleName() == null) {
			vehicle.setVehicleName("");
		}else if(vehicle.getVehicleType() == null || vehicle.getVehicleType().isEmpty()) {
			throw new BadRequestException("Please provide Valid Vehicle Type(Ex: Car)");
		}else if(vehicle.getVehicleMake() == null) {
			vehicle.setVehicleMake("");
		}else if(vehicle.getVehicleModel() == null) {
			vehicle.setVehicleModel("");
		}else if(vehicle.getDescription() == null || vehicle.getFeatures() == null) {
			getVehicleFeatureAndDescription(vehicle);
		}else if(vehicle.getVehicleRegisterDate() == null) {
			vehicle.setVehicleRegisterDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
		}else if(vehicle.getVehiclePrice() == null) {
			vehicle.setVehiclePrice(new BigDecimal("0.00"));
		}else if(vehicle.getVehicleYear() == 0) {
			vehicle.setVehicleYear(2019);
		}else if(vehicle.getRegisteredBy() == null){
			vehicle.setRegisteredBy(VehicleDescs.defaultRegister);
		}
	}

	private void getVehicleFeatureAndDescription(Vehicle vehicle) {
		if (vehicle.getVehicleType() != null) {
			String vehicleType = vehicle.getVehicleType();
			if ("Car".equals(vehicleType)) {
				updateVehicleData(vehicle, VehicleDescs.carFeatures, VehicleDescs.carDescription);
			} else if ("Truck".equals(vehicleType)) {
				updateVehicleData(vehicle, VehicleDescs.truckFeatures, VehicleDescs.truckDescription);
			} else if ("Airplane".equals(vehicleType)) {
				updateVehicleData(vehicle, VehicleDescs.airoplaneFeatures, VehicleDescs.airplaneDescription);
			} else if ("Drone".equals(vehicleType)) {
				updateVehicleData(vehicle, VehicleDescs.droneFeatures, VehicleDescs.droneDescription);
			} else if ("Boat".equals(vehicleType)) {
				updateVehicleData(vehicle, VehicleDescs.boatFeatures, VehicleDescs.boatDescription);
			}
		}
	}

	private void updateVehicleData(Vehicle vehicle, String features, String description) {
		vehicle.setFeatures(features);
		vehicle.setDescription(description);
	}
}