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
                echo 'On construit l\'application avec Maven...'
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Unit Tests') {
            steps {
                echo 'On exécute les tests unitaires...'
                sh './mvnw test'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'On construit l\'image Docker...'
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }
        stage('Push Docker Image to DockerHub') {
            steps {
                echo 'Connexion à DockerHub...'
                sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
                echo 'On pousse l\'image Docker vers DockerHub...'
                sh "docker push ${DOCKER_IMAGE}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline terminé avec succès ! '
        }
        failure {
            echo 'Le pipeline a échoué. Vérifiez les journaux pour en savoir plus.'
        }
    }
}