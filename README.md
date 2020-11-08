# PetCircleAssesment
1) Three controllers help handling request for booking, employee(admin), customer
- url for customer request: http://localhost:8020/customer/register
request json -
{
    "firstName": "FirstTest",
    "lastName": "ls",
    "email": "first.test@gmail.com",
    "password": "test1234",
    "driverDetails": [
        {
            "firstName": "driver1",
            "lastName": "driver1ln",
            "licenceNo": "APG12345",
            "dateOfExpiry": "20/11/2027",
            "age": "34"
        }
    ]

}
- url for booking request : http://localhost:8020/booking
  request json - 
  {
  	"id": "1",
  	"username": "first.test@gmail.com"
  }

- url for admin request: http://localhost:8020/admin
	request json- 
{
    "username": "admin@gmail.com",
    "firstName": "rob",
    "lastName": "walter",
    "password": "test12345"

}
- url for admin update booking status: http://localhost:8020/admin/updatestatus
  request json - 
 {
 	"id": "1",
 	"status": "CANCEL"
 }
 
 2) The ER diagram is in the file  - CarBookingER.png
 3) The process flow block diagram - CarBookingWithLicenceValidator.png


