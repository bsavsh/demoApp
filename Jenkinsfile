pipeline {
    agent any

    tools {
        maven 'maven_3_5_0'
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile test-compile"
            }
        }

         stage('unit testing stage') {
             steps {
                bat "mvn test"
             }
         }

         stage('integration testing stage') {
            steps {
                bat "mvn failsafe:integration-test -P test"
            }
         }

         stage('deployment to test server') {
             steps {
               bat "mvn clean package -P test"
               bat "mvn tomcat7:redeploy -P tesProfileForDeploying"
             }
         }
    }
}