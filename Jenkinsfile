pipeline {
    agent any

    tools {
        maven 'maven_3_5_0'
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile"
            }
        }

         stage('testing stage') {
             steps {
                bat "mvn test"
             }
         }

          stage('deployment stage') {
              steps {
                bat "mvn tomcat7:redeploy -P prodProfileForDeploying"
              }
          }
    }
}