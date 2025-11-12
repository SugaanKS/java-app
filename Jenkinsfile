pipeline {

    agent any

    environment {

        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')

        DOCKER_IMAGE = "sugaanks/java-app"

    }

    stages {

        stage('Checkout Code') {

            steps {

                git url: 'https://github.com/SugaanKS/java-app.git', branch: 'main'

            }

        }

        stage('Build with Maven') {

            steps {

                sh 'mvn clean install'

            }

        }

        stage('Build Docker Image') {

            steps {

                sh 'docker build -t $DOCKER_IMAGE .'

            }

        }

        stage('Login to Docker Hub') {

            steps {

                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'

            }

        }

        stage('Push Docker Image') {

            steps {

                sh 'docker push $DOCKER_IMAGE'

            }

        }

    }

    post {

        always {

            echo 'Pipeline finished!'

        }

    }

}
 
