Read Me
mvn clean install
mvn clean package
running the app 

mvn spring-boot:run

java -jar target/tradestore-0.0.1-SNAPSHOT.jar

Requirements JDK 1.8 installed on system


testing the api through postman
http://localhost:8080/createtrade (POST)
//below is request body 
{
"tradeId":"T1", 
"version":1,
"counterPartyId":"CP-1",  
"bookingId": "B1", 
 "maturityDate": "2022-04-08",
"expired":"N"
}

http://localhost:8080/trades  (GET) //this endpoint will retieve records