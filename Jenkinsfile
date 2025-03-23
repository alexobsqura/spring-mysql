pipeline {

    tools {
        maven 'mvn'
    }
    agent any

    stages {
        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t spring-mysql-app:$BUILD_NUMBER .'
                }
            }
        }
    }
}
