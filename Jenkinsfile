pipeline {

    agent any
 
    tools {

        maven 'Maven'

    }
 
    environment {

        // This line is where the error happens.

        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')

        DOCKER_IMAGE_NAME = "sugaanks/java-app" // Ensure this is your correct Docker Hub username

        DOCKER_IMAGE_TAG  = "latest"

    }
 
    stages {

        stage('Build with Maven') {

            steps {

                sh 'mvn clean package'

            }

        }
 
        stage('Build Docker Image') {

            steps {

                script {

                    docker.build(DOCKER_IMAGE_NAME, ".")

                }

            }

        }
 
        // <<< THIS IS THE CRITICAL NEW STAGE >>>

        stage('Debug Credentials') {

            steps {

                // This will ONLY work if the credential is a 'Username with password' type.

                // The pipeline automatically provides _USR and _PSW variables.

                sh 'echo "DEBUG: Successfully found the credential. Username is: ${DOCKERHUB_CREDENTIALS_USR}"'

            }

        }
 
        stage('Push Docker Image') {

            steps {

                script {

                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-creds') {

                        docker.image(DOCKER_IMAGE_NAME).push(DOCKER_IMAGE_TAG)

                    }

                }

            }

        }

    }

}

 
