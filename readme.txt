NOTES APPLICATION:
1. A system needs to store the notes of different users.
2. After a user successfully logins into the application, the API should return recent 10 notes.
3. The system needs to delete all the notes other than last 10 recent notes on the hourly basis.

Validations to be considered: 
 
1- The notes will only allow [@, ; & * + -] special characters.
2- The Notes cannot be more than 500 letters.
3- Allow User to delete the notes.

---------------------------------------------------------------------------------------------------

**SERVER SIDE APPLICATION**
1. Used JAVA in the backend using the SpringBoot Framework
2. Provided JWT Based user authentication (role based authentication as used in my  exit test-3)
3. All the URLs are authenticated and authorised using AntMatchers and Security Filters into
	Spring Security 
4. Proper coding convention has been followed like proper code structure, proper variable naming,
	use of POJO classes, interfaces, etc.
5. All the APIs are tested thoroughly using POSTMAN.

---------------------------------------------------------------------------------------------------

**CLIENT SIDE APPLICATION**
1. Used Angular 15 in the frontend.
2. Used the following angular libraries in the project:
	- Angular Material
	- Angular PopUp Notifications
	- Bootstrap 5 
3. Used HTTP_CLIENT module to establish the connection with the server and hit the APIs
4. Also with the help of AUTH GUARDS, all the routes are protected and any unauthorized access is
	redirected to the forbidden page
5. All the validations mentioned are implemented with proper display of error messages.


---------------------------------------------------------------------------------------------------
