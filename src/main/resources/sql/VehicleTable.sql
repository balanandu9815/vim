CREATE TABLE IF NOT EXISTS vehicle (
		  vehicleId INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
		  VehicleName varchar(100),
		  vehicleType varchar(100),
	 	  vehicleYear INT,
	 	  vehicleMake varchar(100),
	      vehicleModel varchar(100),
	      vehiclePrice DECIMAL(10, 2),
	      vehicleSpeed INT,
	      vehicleRegisterDate varchar(50) ,
	      description varchar(150),
	      features varchar(150),
	      registeredBy varchar(100)
		);
		
