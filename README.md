# doomsdayclock
spaced-repetition learning web application

## our setup
java - 11,
data-base - PostgreSQL
plugins - Lambock, Thymeleaf, Swagger, MapStruct, SonarLint

                                    
## initialization
.clone project 
.add postgreSQL to your IDE, set |username-postgres, password-root|, create DB named DoomsDay
.make shure you add and enabe all plugins
.run app

##MapStruct config
for MapStruct to work correctly, instruct Maven to perform a clean operation before each application launch. To do this,
 go to the application launch configuration settings (Run-> Edit Configurations) and add the Maven clean task in the 
 Before launch field (scroll to the very bottom of the window).
 
![Screenshot](src/main/resources/static/images/clean_goal.jpg)

## Database schema
![Screenshot](https://user-images.githubusercontent.com/26733045/101560882-4f870c80-39d5-11eb-9207-2002b230a939.png)
