pipeline {
    agent any
    tools { 
        maven 'maven' 
    }
    stages {
        stage ('Build') {
            steps {
                sh '''
                    mvn clean install -DskipTests
                    mvn surefire:test
                    '''
            }
        }
    }
}
