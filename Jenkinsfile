pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'niama123/jenkins:latest'
        DOCKER_USERNAME = 'niama123'
        DOCKER_PASSWORD = '*P!zpUA7yR+YL5y'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo 'On construit l\'application...'
                    bat 'mvn clean package'
                }
            }
        }
        stage('Unit Tests') {
            steps {
                script {
                    echo 'On lance les tests unitaires...'
                    bat 'mvn test'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    echo 'On crée l\'image Docker...'
                    bat "docker build -t %DOCKER_IMAGE% ."
                }
            }
        }
        stage('Push Docker Image to DockerHub') {
            steps {
                script {
                    echo 'Connexion à DockerHub...'
                    bat "docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%"
                    echo 'On envoie l\'image Docker sur DockerHub...'
                    bat "docker push %DOCKER_IMAGE%"
                }
            }
        }
    }

    post {
        success {
            echo 'Tout s\'est bien passé ! 🎉'
        }
        failure {
            echo 'Oups, il y a eu un problème. 😔'
        }
    }
}