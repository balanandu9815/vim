<html>
<body>
	<h2>Welcome to Vehicle Inventory Management(VIM)</h2>
	<br>
	<pre>Design a simple Restful application (do not use springboot)to handle vehicles inventory & search. Share your coding assessment via public git repo.

Basic requirements: 

1)     Vehicle could be of different types with specific properties and behaviors. Types: Car, Truck, Airplane, Drone, Amphibian, Boat.
2)     CRUD operations to manage vehicles
3)     Save to a local db like h2 or sqlite
4)     Ability to search for vehicles
5)     Delete recent API - should delete last added vehicle</pre>
	<br>
	<h4>Rest API Documentation</h4>
	<p>Please follow below points to access above restful VIM
		application api's.</p>
	<h5>To View all Vehicles</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
		{"Vehicle":[{"vehicleId":1,"vehicleName":"Ashok Leyland","vehicleType":"Truck","vehicleYear":2018,"vehicleMake":"TATA","vehicleModel":"Eicher","vehiclePrice":600000.00,"vehicleSpeed":180,"vehicleRegisterDate":1545244200000,"description":"Heavy load Carrier","features":"20 wheels","registeredBy":"balanandu"},{"vehicleId":2,"vehicleName":"Nano","vehicleType":"Car","vehicleYear":2019,"vehicleMake":"TATA","vehicleModel":"deluxe","vehiclePrice":500000.00,"vehicleSpeed":180,"vehicleRegisterDate":1545244200000,"description":"nano from tata","features":"non-AC","registeredBy":"balanandu"},{"vehicleId":3,"vehicleName":"Benz","vehicleType":"Car","vehicleYear":2018,"vehicleMake":"Mercedaz","vehicleModel":"luxury","vehiclePrice":2000000.00,"vehicleSpeed":180,"vehicleRegisterDate":1576780200000,"description":"business class for rich","features":"AC with accident proof","registeredBy":"balanandu"},{"vehicleId":4,"vehicleName":"Ashok Leyland","vehicleType":"Truck","vehicleYear":2018,"vehicleMake":"TATA","vehicleModel":"Eicher","vehiclePrice":600000.00,"vehicleSpeed":180,"vehicleRegisterDate":1545244200000,"description":"Heavy load Carrier","features":"20 wheels","registeredBy":"balanandu"},{"vehicleId":5,"vehicleName":"Nano","vehicleType":"Car","vehicleYear":2019,"vehicleMake":"TATA","vehicleModel":"deluxe","vehiclePrice":500000.00,"vehicleSpeed":180,"vehicleRegisterDate":1545244200000,"description":"nano from tata","features":"non-AC","registeredBy":"balanandu"},{"vehicleId":6,"vehicleName":"Benz","vehicleType":"Car","vehicleYear":2018,"vehicleMake":"Mercedaz","vehicleModel":"luxury","vehiclePrice":2000000.00,"vehicleSpeed":180,"vehicleRegisterDate":1576780200000,"description":"business class for rich","features":"AC with accident proof","registeredBy":"balanandu"}]}
	
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<VehicleList>
	<Vehicle>
	<description>Heavy load Carrier</description>
	<features>20 wheels</features>
	<registeredBy>balanandu</registeredBy>
	<vehicleId>1</vehicleId>
	<vehicleMake>TATA</vehicleMake>
	<vehicleModel>Eicher</vehicleModel>
	<vehicleName>Ashok Leyland</vehicleName>
	<vehiclePrice>600000.00</vehiclePrice>
	<vehicleRegisterDate>2018-12-20T00:00:00+05:30</vehicleRegisterDate>
	<vehicleSpeed>180</vehicleSpeed>
	<vehicleType>Truck</vehicleType>
	<vehicleYear>2018</vehicleYear>
	</Vehicle>
	<Vehicle>
	<description>nano from tata</description>
	<features>non-AC</features>
	<registeredBy>balanandu</registeredBy>
	<vehicleId>2</vehicleId>
	<vehicleMake>TATA</vehicleMake>
	<vehicleModel>deluxe</vehicleModel>
	<vehicleName>Nano</vehicleName>
	<vehiclePrice>500000.00</vehiclePrice>
	<vehicleRegisterDate>2018-12-20T00:00:00+05:30</vehicleRegisterDate>
	<vehicleSpeed>180</vehicleSpeed>
	<vehicleType>Car</vehicleType>
	<vehicleYear>2019</vehicleYear>
	</Vehicle>
	<Vehicle>
	<description>business class for rich</description>
	<features>AC with accident proof</features>
	<registeredBy>balanandu</registeredBy>
	<vehicleId>3</vehicleId>
	<vehicleMake>Mercedaz</vehicleMake>
	<vehicleModel>luxury</vehicleModel>
	<vehicleName>Benz</vehicleName>
	<vehiclePrice>2000000.00</vehiclePrice>
	<vehicleRegisterDate>2019-12-20T00:00:00+05:30</vehicleRegisterDate>
	<vehicleSpeed>180</vehicleSpeed>
	<vehicleType>Car</vehicleType>
	<vehicleYear>2018</vehicleYear>
	</Vehicle>
	</VehicleList>	
	</pre>
	<h5>To View or Search Vehicle By Id</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/1
	PathParam: vehicleId(int type)
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{"vehicleId":1,"vehicleName":"Ashok Leyland","vehicleType":"Truck","vehicleYear":2018,"vehicleMake":"TATA","vehicleModel":"Eicher","vehiclePrice":600000.00,"vehicleSpeed":180,"vehicleRegisterDate":1545244200000,"description":"Heavy load Carrier","features":"20 wheels","registeredBy":"balanandu"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		<description>Heavy load Carrier</description>
		<features>20 wheels</features>
		<registeredBy>balanandu</registeredBy>
		<vehicleId>1</vehicleId>
		<vehicleMake>TATA</vehicleMake>
		<vehicleModel>Eicher</vehicleModel>
		<vehicleName>Ashok Leyland</vehicleName>
		<vehiclePrice>600000.00</vehiclePrice>
		<vehicleRegisterDate>2018-12-20T00:00:00+05:30</vehicleRegisterDate>
		<vehicleSpeed>180</vehicleSpeed>
		<vehicleType>Truck</vehicleType>
		<vehicleYear>2018</vehicleYear></vehicle>
	</pre>
	<h5>To View last added Vehicle</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/recent
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{"vehicleId":24,"vehicleName":"Benz","vehicleType":"Car","vehicleYear":2018,"vehicleMake":"Mercedaz","vehicleModel":"luxury","vehiclePrice":2000000.00,"vehicleSpeed":180,"vehicleRegisterDate":1576780200000,"description":"business class for rich","features":"AC with accident proof","registeredBy":"balanandu"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		<description>business class for rich</description>
		<features>AC with accident proof</features>
		<registeredBy>balanandu</registeredBy>
		<vehicleId>27</vehicleId>
		<vehicleMake>Mercedaz</vehicleMake>
		<vehicleModel>luxury</vehicleModel>
		<vehicleName>Benz</vehicleName>
		<vehiclePrice>2000000.00</vehiclePrice>
		<vehicleRegisterDate>2019-12-20T00:00:00+05:30</vehicleRegisterDate>
		<vehicleSpeed>180</vehicleSpeed>
		<vehicleType>Car</vehicleType>
		<vehicleYear>2018</vehicleYear>
		</vehicle>
	</pre>
	<h5>To View or Search Vehicle with invalid data(Exception
		Handling)</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/434
	PathParam: vehicleId(int type)
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 404 Not Found
	Response:
	{"respCode":404,"respMessage":"No Data Found for Vehicle Id: 434"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 404 Not Found
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>404</respCode>
		<respMessage>No Data Found for Vehicle Id: 434</respMessage>
		</Response>
	</pre>
	<h5>To Create or add new Vehicle Data</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles
	Request Method: POST
	Request Body: 
	{"vehicleId":891,"vehicleName":"Ecosport","vehicleType":"Car","vehicleYear":2019,"vehicleMake":"FORD","vehicleModel":"luxury","vehiclePrice":900000.00,"vehicleSpeed":190,"vehicleRegisterDate":1545244200000,"description":"nano from tata","features":"non-AC","registeredBy":"mettu"}
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 201 Created
	Response:
	{"respCode":200,"respMessage":"New Vehicle Data created Successfully"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Request Body: 
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		<description>Heavy load Carrier</description>
		<features>20 wheels</features>
		<registeredBy>balanandu</registeredBy>
		<vehicleId>123</vehicleId>
		<vehicleMake>TATA</vehicleMake>
		<vehicleModel>Eicher</vehicleModel>
		<vehicleName>Ashok Leyland</vehicleName>
		<vehiclePrice>600000.00</vehiclePrice>
		<vehicleRegisterDate>2018-12-20</vehicleRegisterDate>
		<vehicleSpeed>180</vehicleSpeed>
		<vehicleType>Truck</vehicleType>
		<vehicleYear>2018</vehicleYear>
		</vehicle>
	Http Status: 201 Created
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>New Vehicle Data created Successfully</respMessage>
		</Response>
	</pre>
	<h5>To update an Exist Vehicle Data</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/2
	PathParam: vehicleId(int type)
	Request Method: PUT
	Request Body: 
	{"vehicleId":22,"vehicleName":"Ashok Leyland eqwe","vehicleType":"Truck","vehicleYear":2018,"vehicleMake":"TATA","vehicleModel":"Eicher","vehiclePrice":21123.00,"vehicleSpeed":180,"vehicleRegisterDate":"2018-12-20","description":"Heavy load Carrier","features":"20 wheels","registeredBy":"madhu sdas"}
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 201 Created
	Response:
	{"respCode":200,"respMessage":"Exist Vehicle Data updated Successfully"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Request Body: 
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<vehicle>
		<description>Heavy load Carrier</description>
		<features>20 wheels</features>
		<registeredBy>madhu sdas</registeredBy>
		<vehicleId>131232</vehicleId>
		<vehicleMake>TATA</vehicleMake>
		<vehicleModel>Eicher</vehicleModel>
		<vehicleName>Ashok Leyland</vehicleName>
		<vehiclePrice>21123.00</vehiclePrice>
		<vehicleRegisterDate>2018-12-20</vehicleRegisterDate>
		<vehicleSpeed>180</vehicleSpeed>
		<vehicleType>Truck</vehicleType>
		<vehicleYear>2018</vehicleYear></vehicle>
	Http Status: 201 Created
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>Exist Vehicle Data updated Successfully</respMessage></Response>
	</pre>
	<h5>To Delete an Exist Vehicle Data</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/delete/2
	PathParam: vehicleId(int type)
	Request Method: DELETE
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{"respCode":200,"respMessage":"Vehicle Id 2 Data Deleted Successfully"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>Vehicle Id 2 Data Deleted Successfully</respMessage>
		</Response>
	</pre>
	<h5>To Delete an last added Vehicle Data</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/recent/delete
	Request Method: DELETE
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{"respCode":200,"respMessage":"Recent Vehicle Data Deleted Successfully"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>Recent Vehicle Data Deleted Successfully</respMessage></Response>
	</pre>
	<h5>To Delete All Vehicles Data</h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles/delete
	Request Method: DELETE
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{"respCode":200,"respMessage":"All Vehicles Data Deleted Successfully"}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>All Vehicles Data Deleted Successfully</respMessage></Response>
	</pre>
</body>
</html>
