pipeline {
    agent any
    stages {
        stage('Build and Deploy') { // Added stage name
            steps {
                script {
                    sh 'docker-compose -f ./src/main/docker/app.yml up'
                }
            }
        }
    }
}
