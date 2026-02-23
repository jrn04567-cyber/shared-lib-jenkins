def call() {
    sh "docker compose pull"
    sh "docker compose up -d"
}
