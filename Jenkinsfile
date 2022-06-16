#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
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
                    BRANCH_NAME=="master"
                }
            }
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {

            when{
                expression{
                    BRANCH_NAME=="master"
                }
            }

            steps {
                script {
                    gv.buildImage()
                } 
            }
        }
        stage("deploy") {

            when{
                expression{
                    BRANCH_NAME=="master"
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
