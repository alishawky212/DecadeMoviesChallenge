pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Unit tests') {
            steps {
            sh "chmod +x ./gradlew"
            sh "./gradlew testDebugUnitTest"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}