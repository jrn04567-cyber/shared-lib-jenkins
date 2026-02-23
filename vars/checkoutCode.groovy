def call(String credsId, String repoUrl) {
    git credentialsId: credsId, url: repoUrl, branch: 'main'
}
