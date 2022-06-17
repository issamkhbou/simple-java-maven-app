#!/usr/bin/env groovy
@Library('jenkins_shared_library')
def gv

pipeline {
    agent any
    tools {
        maven 'maven3.8'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("test") {
            steps {
                script {
                    gv.testApp()
                    echo "executing tests on $BRANCH_NAME"
                }
            }
        }

        stage("build jar") {
            when{
                expression{
                    BRANCH_NAME=="jenkins_shared_lib"
                }
            }
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build image") {

            when{
                expression{
                    BRANCH_NAME=="jenkins_shared_lib"
                }
            }

            steps {
                script {
                    buildImage "issam97docker/jenkins_test:JMA3.0"
                } 
            }
        }
        stage("deploy") {

            when{
                expression{
                    BRANCH_NAME=="jenkins_shared_lib"
                }
            }


            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
