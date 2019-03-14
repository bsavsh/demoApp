pipeline {
    agent any

    tools {
        maven 'maven_3_5_0'
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean"
                bat "mvn compile -P test"
                bat "mvn test-compile -P test"
            }
        }

         stage('unit testing stage') {
             steps {
                bat "mvn test"
             }
         }

         stage('integration testing stage') {
            steps {
                bat "mvn failsafe:integration-test"
            }
         }

         stage('deployment to test server') {
             steps {
               bat "mvn clean package -P test"
               bat "mvn tomcat7:redeploy -P testProfileForDeploying"
             }
         }

         stage('deployment to prod server') {
            steps {
                bat "mvn clean package -P prod"
                bat "mvn tomcat7:redeploy -P prodProfileForDeploying"
            }
         }
    }
}