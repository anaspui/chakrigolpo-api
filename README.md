ChakriGolpo (RESTful API)
=========================

ChakriGolpo is a RESTful API designed to facilitate job posting and application processes for a web project of the same name. The API is built using Java Spring MVC framework and managed with Maven for efficient project management.

Backend Technologies
--------------------

### Frameworks and Libraries

-   Hibernate: Hibernate is utilized for data persistence, simplifying database operations, and enhancing scalability.
-   MySQL: MySQL is employed for efficient data storage and retrieval, providing a robust database solution.
-   Spring Security: Spring Security is integrated to provide robust authentication and authorization mechanisms, ensuring secure access to resources.
-   Jackson: Jackson library is utilized for JSON data binding and serialization, facilitating seamless communication between the API and clients.
-   Commons FileUpload: Commons FileUpload library is incorporated for handling file uploads, enabling users to upload documents or images as part of job applications.
-   Maven: Maven is used to manage project dependencies and build processes, streamlining development and deployment workflows.

Project Structure
-----------------

The project follows a standard MVC (Model-View-Controller) architecture, with separate packages for models, controllers, services, repositories, and configuration files. This structure promotes modularity, code organization, and ease of maintenance.

API Endpoints
-------------
<details>
  <summary>API Endpoints</summary>

  1. **Auth Context**
     - Method: GET
     - URL: `http://localhost:8090/ChakriGolpo/auth/secured`
     - Request Body: N/A
     - Response: N/A

  2. **Registration**
     - Method: POST
     - URL: `http://localhost:8090/ChakriGolpo/auth/register`
     - Request Body:
       ```json
       {
           "username": "",
           "password": ""
       }
       ```
     - Response: N/A

  3. **Get Role**
     - Method: GET
     - URL: `http://localhost:8090/ChakriGolpo/roles`
     - Request Body: N/A
     - Response: N/A

  4. **Post Role**
     - Method: POST
     - URL: `http://localhost:8090/ChakriGolpo/roles`
     - Request Body:
       ```json
       {
           "roleName": ,
           "users": [
               {
                   "userId": 49
               }
           ]
       }
       ```
     - Response: N/A

  5. **Get Users**
     - Method: GET
     - URL: `http://localhost:8090/ChakriGolpo/auth/users`
     - Request Body: N/A
     - Response: N/A

  6. **By Username**
     - Method: GET
     - URL: `http://localhost:8090/ChakriGolpo/auth/users/kawasaki23`
     - Request Body: N/A
     - Response: N/A

  7. **Update User**
     - Method: PUT
     - URL: `http://localhost:8090/ChakriGolpo/auth/users/`
     - Request Body: N/A
     - Response: N/A

  8. **Delete User**
     - Method: DELETE
     - URL: `http://localhost:8090/ChakriGolpo/auth/users/40`
     - Request Body: N/A
     - Response: N/A

  9. **Apply - Job**
     - Method: POST
     - URL: `http://localhost:8090/ChakriGolpo/candidate/application/apply`
     - Request Body:
       ```json
       {
           "jobSeeker": {
               "jobSeekerId": 1,
               "user": {
                   "userId": 1,
                   "username": "kawasaki23"
               }
           },
           "job": {
               "jobId": 1,
               "jobTitle": "Corporate Innovation Facilitator"
           },
           "status": "PENDING",
           "appliedAt": "2024-01-02T16:45:30.491"
       }
       ```
     - Response: N/A

  10. **Get Application**
      - Method: GET
      - URL: `http://localhost:8090/ChakriGolpo/candidate/application/2`
      - Request Body: N/A
      - Response: N/A

  11. **Delete Application**
      - Method: DELETE
      - URL: `http://localhost:8090/ChakriGolpo/candidate/application/3`
      - Request Body: N/A
      - Response: N/A

  12. **Update Application**
      - Method: PUT
      - URL: `http://localhost:8090/ChakriGolpo/candidate/application`
      - Request Body:
        ```json
        {
            "applicationId": 2,
            "jobSeekerId": 1,
            "job": {
                "jobId": 1,
                "company": {
                    "companyId": 1
                },
                "jobTitle": "Corporate Innovation Facilitator",
                "updatedAt": [ 2024,1,1,23,51,36 ]
            },
            "status": "APPROVED",
            "appliedAt": [
                2021,
                1,
                2,
                1,
                43,
                10
            ]
        }
        ```

  13. **Post Candidate Record**
      - Method: POST
      - URL: `http://localhost:8090/ChakriGolpo/candidate/`
      - Request Body:
        ```json
        {
            "user": {
                "userId": 54
            },
            "fullName": "dawd",
            "biography": "dwad"
        }
        ```

  14. **Get Candidate Record**
      - Method: GET
      - URL: `http://localhost:8090/ChakriGolpo/candidate/1`
      - Request Body: N/A
      - Response: N/A

  15. **Update Candidate Record**
      - Method: PUT
      - URL: `http://localhost:8090/ChakriGolpo/candidate/1`
      - Request Body:
        ```json
        {
            "candidateId": 1,
            "user": {
                "userId": 54
            },
            "fullName": "dawd",
            "biography": "dwad"
        }
        ```

  16. **Delete Candidate Record**
      - Method: DELETE
      - URL: `http://localhost:8090/ChakriGolpo/candidate/1`
      - Request Body: N/A
      - Response: N/A

  17. **Post Employer Record**
      - Method: POST
      - URL: `http://localhost:8090/ChakriGolpo/employer/`
      - Request Body:
        ```json
        {
            "user": {
                "userId": 40
            },
            "companyName": "Dawd",
            "description": "dawd"
        }
        ```

  18. **Get Employer Record**
      - Method: GET
      - URL: `http://localhost:8090/ChakriGolpo/employer/1`
      - Request Body: N/A
      - Response: N/A

  19. **Update Employer Record**
      - Method: PUT
      - URL: `http://localhost:8090/ChakriGolpo/employer/1`
      - Request Body:
        ```json
        {
            "employerId": 1,
            "user": {
                "userId": 40
            },
            "companyName": "Dawd",
            "description": "dawd"
        }
        ```

  20. **Delete Employer Record**
      - Method: DELETE
      - URL: `http://localhost:8090/ChakriGolpo/employer/1`
      - Request Body: N/A
      - Response: N/A

  21. **Get Employer Applications**
      - Method: GET
      - URL: `http://localhost:8090/ChakriGolpo/employer/1/applications`
      - Request Body: N/A
      - Response: N/A

  22. **Post Job**
      - Method: POST
      - URL: `http://localhost:8090/ChakriGolpo/employer/1/jobs`
      - Request Body:
        ```json
        {
            "jobTitle": "Corporate Innovation Facilitator",
            "description": "Requires strong analytical skills",
            "postedAt": "2024-01-01T00:00:00",
            "status": "OPEN"
        }
        ```
      - Response: N/A

  23. **Get Job**
      - Method: GET
      - URL: `http://localhost:8090/ChakriGolpo/employer/1/jobs/1`
      - Request Body: N/A
      - Response: N/A

  24. **Update Job**
      - Method: PUT
      - URL: `http://localhost:8090/ChakriGolpo/employer/1/jobs/1`
      - Request Body:
        ```json
        {
            "jobId": 1,
            "employer": {
                "employerId": 1
            },
            "jobTitle": "Corporate Innovation Facilitator",
            "description": "Requires strong analytical skills",
            "postedAt": [
                2024,
                1,
                1,
                0,
                0,
                0
            ],
            "status": "OPEN"
        }
        ```
      - Response: N/A

  25. **Delete Job**
      - Method: DELETE
      - URL: `http://localhost:8090/ChakriGolpo/employer/1/jobs/1`
      - Request Body: N/A
      - Response: N/A

</details>

Getting Started
---------------

To get started with the ChakriGolpo API, follow these steps:

1.  Clone the Repository: Clone the Chakrigolpo-Api repository from GitHub to your local machine.

2.  Set Up MySQL Database: Set up a MySQL database and configure the database connection properties in the `application.properties` file.

3.  Build and Run the Application: Use Maven to build the application and run it using a Java IDE or command-line interface.

4.  Explore the API: Once the application is running, you can explore the API endpoints using tools like Postman or curl.

Contributing
------------

Contributions to the ChakriGolpo project are welcome! Feel free to submit bug reports, feature requests, or pull requests through the GitHub repository.

License
-------

This project is licensed under the [MIT License](https://chat.openai.com/c/LICENSE). Feel free to use, modify, and distribute the code for your own purposes.

Contact
-------

For any inquiries or support regarding the ChakriGolpo API, please contact Mohammad Omar.
