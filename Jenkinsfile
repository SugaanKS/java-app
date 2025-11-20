pipeline {

    agent any
 
    tools {

        maven 'Maven'

    }
 
    environment {

        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')

        DOCKER_IMAGE_NAME = "sugaanks/java-app" 

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
        stage('Debug Credentials') {
            steps {
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
	stage('Deploy with Ansible') {
    steps {
        sshagent(credentials: ['devops-key']) {
            sh 'export ANSIBLE_HOST_KEY_CHECKING=False && ansible-playbook -i inventory deploy-docker.yml'
        }
    }
}
    }
}

 
