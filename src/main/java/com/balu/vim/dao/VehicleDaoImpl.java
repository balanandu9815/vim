package com.balu.vim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.balu.vim.model.Vehicle;
import com.balu.vim.utils.DataSourceUtil;
//DAO LOGIC
public class VehicleDaoImpl implements VehicleDao {

	@Override
	public List<Vehicle> findAllVehicles() {
		List<Vehicle> Vehicles = new ArrayList<>();
		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			Vehicles = jtm.query(FETCH_ALL_VEHICLES, new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}
		return Vehicles;
	}

	@Override
	public Vehicle findVehicle(int id) {
		Vehicle vehicle = new Vehicle();

		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			vehicle = (Vehicle) jtm.queryForObject(FETCH_VEHICLE_BY_ID, new Object[] { id },
					new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}
		return vehicle;
	}

	@Override
	public Vehicle getLastAddedVehicle() {
		Vehicle vehicle = new Vehicle();
		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			vehicle = (Vehicle) jtm.queryForObject(FETCH_RECENT_VEHICLE, new Object[] {},
					new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}
		return vehicle;
	}

	@Override
	public boolean saveVehicle(Vehicle vehicle) {
		boolean isSaved = false;
		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			//int rowCount = jtm.update(SAVE_VEHICLE_DATA, vehicle);
			int rowCount = jtm.update(SAVE_VEHICLE_DATA, new Object[] {
					vehicle.getVehicleName(), vehicle.getVehicleType(),vehicle.getVehicleYear(),vehicle.getVehicleMake(),
					vehicle.getVehicleModel(),vehicle.getVehiclePrice(),vehicle.getVehicleSpeed(),vehicle.getVehicleRegisterDate(),
					vehicle.getDescription(),vehicle.getFeatures(),vehicle.getRegisteredBy()});
			if (rowCount >= 1) {
				isSaved = true;
			}
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}
		return isSaved;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle,int id) {
		boolean isUpdated = false;
		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			int rowCount = jtm.update(UPDATE_VEHICLE_DATA, new Object[] {
					vehicle.getVehicleName(), vehicle.getVehicleType(),vehicle.getVehicleYear(),vehicle.getVehicleMake(),
					vehicle.getVehicleModel(),vehicle.getVehiclePrice(),vehicle.getVehicleSpeed(),vehicle.getVehicleRegisterDate(),
					vehicle.getDescription(),vehicle.getFeatures(),vehicle.getRegisteredBy(), id });
			if (rowCount >= 1) {
				isUpdated = true;
			}
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}

		return isUpdated;
	}

	@Override
	public boolean deleteVehicle(int id) {
		boolean deleted = false;
		try {
			Vehicle vehicle = findVehicle(id);
			JdbcTemplate jtm = DataSourceUtil.getSession();
			if (vehicle != null && vehicle.getVehicleId() > 0) {
				int nOfRows = jtm.update(DELETE_VEHICLE_BY_ID, new Object[] { vehicle.getVehicleId() });
				if (nOfRows >= 1) {
					deleted = true;
				}
			}
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}

		return deleted;
	}

	@Override
	public boolean deleteAllVehicles() {
		boolean deleted = false;
		try {
			JdbcTemplate jtm = DataSourceUtil.getSession();
			int nOfRows = jtm.update(DELETE_ALL_VEHICLE);
			if (nOfRows >= 1) {
				deleted = true;
			}
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}
		return deleted;
	}

	@Override
	public boolean deleteLatestVehicle() {
		boolean deleted = false;
		try {
			Vehicle vehicle = getLastAddedVehicle();
			if (vehicle != null && vehicle.getVehicleId() > 0) {
				deleted=deleteVehicle(vehicle.getVehicleId());
			}
		} catch (DataAccessException dae) {
			Logger lgr = Logger.getLogger(VehicleDaoImpl.class.getName());
			lgr.log(Level.SEVERE, dae.getMessage(), dae);
		}

		return deleted;
	}
}