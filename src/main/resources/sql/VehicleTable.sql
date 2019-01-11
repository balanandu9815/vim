CREATE TABLE IF NOT EXISTS vehicle (
		  vehicleId INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
		  VehicleName VARCHAR(100),
		  vehicleType VARCHAR(100),
	 	  vehicleYear INT,
	 	  vehicleMake VARCHAR(100),
	      vehicleModel VARCHAR(100),
	      vehiclePrice DECIMAL(10, 2),
	      vehicleSpeed INT,
	      vehicleRegisterDate varchar(100),
	      description VARCHAR(150),
	      features VARCHAR(150),
	      registeredBy VARCHAR(100)
		);
		
