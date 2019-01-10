
	Welcome to Vehicle Inventory Management(VIM)
	Design a simple Restful application (do not use springboot)to handle vehicles inventory & search. Share your coding assessment via public git repo.

Basic requirements: 

1)     Vehicle could be of different types with specific properties and behaviors. Types: Car, Truck, Airplane, Drone, Amphibian, Boat.
2)     CRUD operations to manage vehicles
3)     Save to a local db like h2 or sqlite
4)     Ability to search for vehicles
5)     Delete recent API - should delete last added vehicle
<br/>
Technologies Used:
Maven 3.6
java 1.8
Tomcat 8.0
RestEasy 3.1.4
H2 Database 1.4.197

	Rest API Documentation
	Please follow below points to access above restful VIM
		application api's.
	To Create or add new Vehicle Data:
	
	URL:http://localhost:8080/vim/rest/vehicles
	Request Method: POST
	Request Body: 
	{
		"vehicleName":"BenZ ",
		"vehicleType":"Car",
		"vehicleYear":2018,
	 	"vehicleMake":"Mercedaz",
	 	"vehicleModel":"luxury",
	 	"vehiclePrice":2000000.00,
	  	"vehicleSpeed":180,
	 	"description":"business class for rich",
	 	"features":"AC with accident proof",
	  	"registeredBy":"balanandu"
	 }
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
	    <description>business class for rich</description>
	    <features>AC with accident proof</features>
	    <registeredBy>balanandu</registeredBy>
	    <vehicleMake>Mercedaz</vehicleMake>
	    <vehicleModel>luxury</vehicleModel>
	    <vehicleName>BenZ </vehicleName>
	    <vehiclePrice>2000000.00</vehiclePrice>
	    <vehicleSpeed>180</vehicleSpeed>
	    <vehicleType>Car</vehicleType>
	    <vehicleYear>2018</vehicleYear>
	</vehicle>
	Http Status: 201 Created
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>New Vehicle Data created Successfully</respMessage>
		</Response>
	
	<h5>For Empty List of Vehicles Data </h5>
	<pre>
	URL:http://localhost:8080/vim/rest/vehicles
	Ex:http://localhost:8080/vim/rest/vehicles
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	Response:
	{
	    "vehicleList": []
	}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<VehicleList/>
	
	<h5>To View all Vehicles</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	JSON Response:
		{
		    "vehicleList": [
		        {
		            "vehicleId": 1,
		            "vehicleName": "BenZ ",
		            "vehicleType": "Car",
		            "vehicleYear": 2018,
		            "vehicleMake": "Mercedaz",
		            "vehicleModel": "luxury",
		            "vehiclePrice": 2000000,
		            "vehicleSpeed": 180,
		            "vehicleRegisterDate": "2019-01-10 23:36:38",
		            "description": "business class for rich",
		            "features": "AC with accident proof",
		            "registeredBy": "balanandu"
		        },
		        {
		            "vehicleId": 2,
		            "vehicleName": "Ashok Leyland",
		            "vehicleType": "Truck",
		            "vehicleYear": 2018,
		            "vehicleMake": "TATA",
		            "vehicleModel": "Eicher",
		            "vehiclePrice": 600000,
		            "vehicleSpeed": 180,
		            "vehicleRegisterDate": "2019-01-10 23:41:04",
		            "description": "Heavy load Carrier",
		            "features": "20 wheels",
		            "registeredBy": "balanandu"
		        }
		    ]
		}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	XML Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
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
	        <vehicleRegisterDate>2019-01-10 23:28:34</vehicleRegisterDate>
	        <vehicleSpeed>180</vehicleSpeed>
	        <vehicleType>Truck</vehicleType>
	        <vehicleYear>2018</vehicleYear>
	    </Vehicle>
	    <Vehicle>
	        <description>business class for rich</description>
	        <features>AC with accident proof</features>
	        <registeredBy>balanandu</registeredBy>
	        <vehicleId>2</vehicleId>
	        <vehicleMake>Mercedaz</vehicleMake>
	        <vehicleModel>luxury</vehicleModel>
	        <vehicleName>BenZ </vehicleName>
	        <vehiclePrice>2000000.00</vehiclePrice>
	        <vehicleRegisterDate>2019-01-10 23:31:21</vehicleRegisterDate>
	        <vehicleSpeed>180</vehicleSpeed>
	        <vehicleType>Car</vehicleType>
	        <vehicleYear>2018</vehicleYear>
	    </Vehicle>
	</VehicleList>
	
	<h5>To View or Search Vehicle By Id</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles/{vehicleId}
	Ex:http://localhost:8080/vim/rest/vehicles/1
	PathParam: vehicleId(int type)
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	JSON Response:
	{
	    "vehicleId": 1,
	    "vehicleName": "BenZ ",
	    "vehicleType": "Car",
	    "vehicleYear": 2018,
	    "vehicleMake": "Mercedaz",
	    "vehicleModel": "luxury",
	    "vehiclePrice": 2000000,
	    "vehicleSpeed": 180,
	    "vehicleRegisterDate": "2019-01-10 23:36:38",
	    "description": "business class for rich",
	    "features": "AC with accident proof",
	    "registeredBy": "balanandu"
	}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	XML Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<vehicle>
	    <description>business class for rich</description>
	    <features>AC with accident proof</features>
	    <registeredBy>balanandu</registeredBy>
	    <vehicleId>1</vehicleId>
	    <vehicleMake>Mercedaz</vehicleMake>
	    <vehicleModel>luxury</vehicleModel>
	    <vehicleName>BenZ </vehicleName>
	    <vehiclePrice>2000000.00</vehiclePrice>
	    <vehicleRegisterDate>2019-01-10 23:36:38</vehicleRegisterDate>
	    <vehicleSpeed>180</vehicleSpeed>
	    <vehicleType>Car</vehicleType>
	    <vehicleYear>2018</vehicleYear>
	</vehicle>
	
	<h5>To View last added Vehicle</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles/recent
	Request Method: GET
	Request Body: none
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 200 OK
	JSON Response:
	{
	    "vehicleId": 2,
	    "vehicleName": "Ashok Leyland",
	    "vehicleType": "Truck",
	    "vehicleYear": 2018,
	    "vehicleMake": "TATA",
	    "vehicleModel": "Eicher",
	    "vehiclePrice": 600000,
	    "vehicleSpeed": 180,
	    "vehicleRegisterDate": "2019-01-10 23:41:04",
	    "description": "Heavy load Carrier",
	    "features": "20 wheels",
	    "registeredBy": "balanandu"
	}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Http Status: 200 OK
	XML Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<vehicle>
	    <description>Heavy load Carrier</description>
	    <features>20 wheels</features>
	    <registeredBy>balanandu</registeredBy>
	    <vehicleId>2</vehicleId>
	    <vehicleMake>TATA</vehicleMake>
	    <vehicleModel>Eicher</vehicleModel>
	    <vehicleName>Ashok Leyland</vehicleName>
	    <vehiclePrice>600000.00</vehiclePrice>
	    <vehicleRegisterDate>2019-01-10 23:41:04</vehicleRegisterDate>
	    <vehicleSpeed>180</vehicleSpeed>
	    <vehicleType>Truck</vehicleType>
	    <vehicleYear>2018</vehicleYear>
	</vehicle>
	
	<h5>To View or Search Vehicle with invalid data(Exception
		Handling)</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles/{vehicleId}
	Ex:http://localhost:8080/vim/rest/vehicles/434
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
	
	<h5>To update an Exist Vehicle Data</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles/{vehicleId}
	Ex: http://localhost:8080/vim/rest/vehicles/1
	PathParam: vehicleId(int type)
	Request Method: PUT
	Request Body: 
	{
		"vehicleName":"BenZ ",
		"vehicleType":"Car",
		"vehicleYear":2018,
	 	"vehicleMake":"Mercedaz",
	 	"vehicleModel":"luxury",
	 	"vehiclePrice":2000000.00,
	  	"vehicleSpeed":180,
	 	"description":"business class for rich",
	 	"features":"AC with accident proof",
	  	"registeredBy":"balanandu"
	 }
	Headers:
	Content-type: application/json:charset=UTF-8
	Accept: application/json
	Http Status: 201 Created
	Response:
	{
	    "respCode": 200,
	    "respMessage": "Exist Vehicle with  Id 1 's Data updated Successfully"
	}
	Headers:
	Content-type: application/xml;charset=UTF-8
	Accept: application/xml
	Request Body: 
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<vehicle>
		<description>Heavy load Carrier</description>
		<features>20 wheels</features>
		<registeredBy>balanandu</registeredBy>
		<vehicleMake>TATA</vehicleMake>
		<vehicleModel>Eicher</vehicleModel>
		<vehicleName>Ashok Leyland</vehicleName>
		<vehiclePrice>600000.00</vehiclePrice>
		<vehicleSpeed>180</vehicleSpeed>
		<vehicleType>Truck</vehicleType>
		<vehicleYear>2018</vehicleYear>
	</vehicle>
	Http Status: 201 Created
	Response:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<Response>
		<respCode>200</respCode>
		<respMessage>Exist Vehicle with  Id 1 's Data updated Successfully</respMessage>
		</Response>
	
	<h5>To Delete an Exist Vehicle Data</h5>
	
	URL:http://localhost:8080/vim/rest/vehicles/delete/{vehicleId}
	Ex: http://localhost:8080/vim/rest/vehicles/2
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
	
	<h5>To Delete an last added Vehicle Data</h5>
	
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
	
	<h5>To Delete All Vehicles Data</h5>
	
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
		<respMessage>All Vehicles Data Deleted Successfully</respMessage>
	   </Response>
	
