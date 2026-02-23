def call(String dockerUser, String imageName, String credsId) {
    // Uses the jrn0444 username and the dckr_pat token you generated
    withCredentials([usernamePassword(credentialsId: credsId, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t ${dockerUser}/${imageName}:${BUILD_NUMBER} ."
        sh "docker build -t ${dockerUser}/${imageName}:latest ."
        sh "echo \$PASS | docker login -u \$USER --password-stdin"
        sh "docker push ${dockerUser}/${imageName}:${BUILD_NUMBER}"
        sh "docker push ${dockerUser}/${imageName}:latest"
    }
}
