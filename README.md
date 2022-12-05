# Tap Technical Test - Backend 
Used Java - Spring Boot

API Endpoints:

Get all driver profiles
[Get]localhost:8080/api/driver-profile

Register new driver
[Post]localhost:8080/api/driver-profile/
Sample data:
{
    "name": "Driver",
    "surname": "A",
    "email": "driver_a@gmail.com",
    "vehicleType": "sedan",
    "baseFarePrice": 200,
    "baseFareDistance": 150
}

Update driver
[Put] localhost:8080/api/driver-profile/<driver ID>


Delete driver profile
[Delete] localhost:8080/api/driver-profile/<driver ID>


View calculated fares by driver ID
[Get]localhost:8080/api/fare/view-fares/<driver ID>

Calculate fares by driver ID
[Get]localhost:8080/api/fare/calculate-fare/<driver ID>


