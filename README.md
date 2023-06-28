# Interview Experience Portal

The Interview Experience Portal is a web application aimed at helping people learn from the interview experiences of others. It provides a platform where users can share their interview experiences and browse through experiences shared by others, thus gaining insights and knowledge about various companies, job positions, and interview processes.

## Features

- Post and view interview experiences
- Upvote or downvote experiences to indicate their helpfulness
  
## View
![View of the Page](https://github.com/amisinha/SpringBoot-ReactJS-AWS-FullStack/blob/main/view.JPG)

## Technologies Used

- Backend: Spring Boot with Java
- Frontend: ReactJS
- Backend Deployment: AWS RDS and EC2
- Frontend Deployment: AWS S3

## Deployment

The project can be deployed to AWS using the following steps:

### Backend Deployment (EC2 and RDS):

1. Set up an AWS account and create an EC2 instance for hosting the backend server.
2. Connect to the EC2 instance using SSH.
3. Install Java and any other required dependencies on the EC2 instance.
4. Clone the project repository from GitHub onto the EC2 instance.
5. Configure the backend application properties file to connect to the RDS instance.
6. Build the backend using Maven and package it as a JAR file.
7. Start the backend server by running the JAR file.
8. Ensure that the necessary inbound and outbound security group rules are configured for the EC2 instance and RDS instance to allow appropriate traffic.

### Frontend Deployment (S3):

1. Set up an S3 bucket in AWS for hosting the frontend files.
2. Build the frontend using `npm` or `yarn` and create the optimized production build.
3. Upload the frontend build files to the S3 bucket.
4. Configure the S3 bucket to allow public read access to the frontend files.
5. Enable static website hosting on the S3 bucket and note the provided endpoint URL.

### Connecting Backend and Frontend:

1. In the backend application properties file, set the frontend endpoint URL to the S3 bucket endpoint URL.
2. Rebuild the backend application and redeploy it to the EC2 instance.
3. Access the deployed application by using the EC2 instance's public IP address or domain name.

Please note that these instructions provide a general overview of the deployment process, and you may need to customize them based on your specific project requirements and AWS configurations. Ensure that you follow AWS best practices for security, permissions, and networking when deploying your application.

For more detailed instructions and guidance on deploying to AWS, refer to the AWS documentation or seek additional resources specific to deploying Spring Boot applications, configuring RDS, and hosting static files on S3.

Remember to adjust these instructions based on your specific setup and requirements.


## Development Setup

To set up the project for local development, follow these steps:

1. Clone the project repository from GitHub.
2. Set up the backend by importing the project into your preferred IDE (such as IntelliJ or Eclipse).
3. Configure the backend database settings in the application properties file.
4. Build and run the backend server.
5. Set up the frontend by navigating to the frontend directory in your terminal.
6. Install the frontend dependencies using `npm install` or `yarn install`.
7. Start the frontend development server using `npm start` or `yarn start`.
8. Access the development server at `http://localhost:3000` in your web browser.





