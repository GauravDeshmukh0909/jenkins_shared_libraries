def call(String credId, String imageName){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
                
                bat "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                bat "docker image tag ${imageName} ${env.dockerHubUser}/${imageName}"
                bat "docker push ${env.dockerHubUser}/${imageName}:latest"
            
                }  
}
