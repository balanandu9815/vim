package com.balu.vim.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Balanandu Mettu
 *
 */
//Model CLass for Vehicle Inventory
@XmlRootElement
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;

	private int vehicleId;
	private String vehicleName;
	private String vehicleType;// Car, Truck, Airplane, Drone, Amphibian, Boat
	private int vehicleYear;//manufacture year
	private String vehicleMake;//manufacturer name
	private String vehicleModel;//vehicle model
	private BigDecimal vehiclePrice;//price of the vehicle
	private int vehicleSpeed;//speed of the vehicle
	private String vehicleRegisterDate;//vehicle registered or inserted timestamp
	private String description;
	private String features;
	private String registeredBy;
	
	public Vehicle(){
	}
	
	
	public Vehicle(int vehicleId, String vehicleName, String vehicleType, int vehicleYear, String vehicleMake,
			String vehicleModel, BigDecimal vehiclePrice, int vehicleSpeed, String vehicleRegisterDate,
			String description, String features, String registeredBy) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehiclePrice = vehiclePrice;
		this.vehicleSpeed = vehicleSpeed;
		this.vehicleRegisterDate = vehicleRegisterDate;
		this.description = description;
		this.features = features;
		this.registeredBy = registeredBy;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public BigDecimal getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(BigDecimal vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public int getVehicleSpeed() {
		return vehicleSpeed;
	}
	public void setVehicleSpeed(int vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}
	public String getVehicleRegisterDate() {
		return vehicleRegisterDate;
	}
	public void setVehicleRegisterDate(String vehicleRegisterDate) {
		this.vehicleRegisterDate = vehicleRegisterDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getRegisteredBy() {
		return registeredBy;
	}
	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", vehicleYear=" + vehicleYear + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel
				+ ", vehiclePrice=" + vehiclePrice + ", vehicleSpeed=" + vehicleSpeed + ", vehicleRegisterDate="
				+ vehicleRegisterDate + ", description=" + description + ", features=" + features + ", registeredBy="
				+ registeredBy + "]";
	}

}
