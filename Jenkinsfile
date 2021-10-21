pipeline {
    agent any

    tools {
        maven "Mvn3.8.3"
    }

    stages {
        stage("Build"){
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}