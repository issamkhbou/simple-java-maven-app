pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                echo "building stage" 
            }
        }
      
      stage('test') {
            steps {
              echo "testing stage" 
            }
        }
      
      stage('deploy') {
            steps {
                echo "deployment stage"
            }
        }
      
    }
}
