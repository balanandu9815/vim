package com.balu.vim.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleList")
public class VehicleList {
 
    @XmlElement(name = "Vehicle")
    protected List<Vehicle> vehicleList;
 
    public List<Vehicle> getVehicleList() {
        if (vehicleList == null) {
        	vehicleList = new ArrayList<Vehicle>();
        }
        return this.vehicleList;
    }
}