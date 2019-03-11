# General
This project is created in order to allow users to perform Http requests 
for Entity objects.

# Instructions to generate swagger file
- Open git bash and navigate to entities directory, run "gradle build"
- In entities-api/build/classes/java/main/META-INF/swagger there will be 
yaml file

# Architecture notes
- EntityController: Handles server httprequests
- TestRepository: Used to mock fulfilling requests using collaborate
- IEntityRepository: A class implementing this interface is responsible 
handling Entity requests
- Entity: This is the entity object
- EntityStatus: Status of an entity request
- EntityResponseStatus: Id and status of that entity