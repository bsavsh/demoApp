pipeline {

    agent any

    stages {
        stage ('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {
            withMaven(maven: 'maven_3_5_0') {
                sh 'mvn test'
            }
        }

        stage ('Build War file') {
            withMaven(maven: 'maven_3_5_0') {
                sh 'mvn package -P prod'
            }
        }

        stage ('Deployment Stage') {
            steps {
                withMaven(mave: 'maven_3_5_0') {
                    sh 'mvn tomcat7:redeploy -P prodProfileForDeploying'
                }
            }
        }
    }
}