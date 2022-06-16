def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t issam97docker/jenkins_test:JMA2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push issam97docker/jenkins_test:JMA2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

def buildApp() {
    echo 'building the application...'
    sh 'mvn package'
} 

def testApp() {
    echo 'testing the application...'
}
return this
