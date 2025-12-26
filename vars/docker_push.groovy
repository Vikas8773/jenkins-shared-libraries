def call(String Project, String ImageTag){
  withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]){
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker image tag ${Project}:latest ${dockerHubUser}/${Project}:${ImageTag}"
        sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}
