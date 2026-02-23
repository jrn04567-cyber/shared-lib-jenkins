@Library('my-shared-lib') _

pipeline {
    agent { label 'linux-build' }

    environment {
        DOCKER_HUB_USER = 'jrn0444' // Your verified username
        IMAGE_NAME = 'django-notes-app'
    }

    stages {
        stage('Clone') {
            steps {
                checkoutCode('gcp-vm-key', 'git@github.com:jrn04567-cyber/django-notes-app.git')
            }
        }
        stage('Build & Push') {
            steps {
                // Calls the specific script from your library
                dockerBuildPush(env.DOCKER_HUB_USER, env.IMAGE_NAME, 'dockerhubpass')
            }
        }
        stage('Deploy') {
            steps {
                dockerDeploy()
            }
        }
    }
}
