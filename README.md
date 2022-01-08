# Shopify Challenge
This project implements the backend APIs and a React frontend form for CRUD operations of items with an additional feature for generating CSV files.
## Install
To install, first **clone** the source code from the [GitHub Repository](https://github.com/tdq45gj/inventory). Then ```cd``` into the root directory of the repository.
### Docker
**Docker** is **recommended** to install the application. You might need to install [docker-compose](https://docs.docker.com/compose/install/) before running the following command. Run the following command to build and run the Docker images.
```bash
sudo docker-compose up
```
### Manually
You can also install and run the application mannually.
- Build and run the backend
1. ```cd``` to the project root directory
2. ```mvn clean install```
3. ```java -jar target/Shopify-0.0.1-SNAPSHOT.jar```
- Build and run the frontend
1. ```cd src/main/js``` from the project root directory
2. ```npm install```
3. ```REACT_APP_API_BASE_URL=http://localhost:8080 npm start```
## Deployed Application
The implementation can be verified **_without installing anything_**. The application has already been deployed on a **t2.micro** type **AWS EC2** instance. The instance is running **Ubuntu 20.04** with **1 vCPU**, **8GB storage**, and **1GB memory**. You can visit the application frontend at [link](http://44.201.208.51:3000). You can view and test a list of implemented APIs at [link](http://44.201.208.51:8080/swagger-ui/).
## APIs
All available APIs are listed at [link](http://44.201.208.51:8080/swagger-ui/).
