pipeline{

    agent any
    tools {
        maven 'Maven'
    }
    stages {
    stage("build")
    {
        steps {
            script{
                sh 'docker build -t abdoumin/fullstackapp-backend:0.0.1 -f ./Internship-ReactJS/docker-compose.yml .'
                sh 'docker build -t abdoumin/fullstackapp-frontend:0.0.1 -f ./Internship-Backend/docker-compose.yml .'
            }
        }
    }


    stage("deploy")
        {
            steps {
            echo "deploying the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push abdoumin/fullstackapp-backend:0.0.1"
                        sh "docker push abdoumin/fullstackapp-frontend:0.0.1"
                        sh "docker-compose down"
                        sh "docker-compose up --build -d "
                    }}
        }
    }
    }