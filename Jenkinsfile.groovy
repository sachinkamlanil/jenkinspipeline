String fname = "Test"


pipeline {
  agent {
    
  }
  parameters {
      string(defaultValue: 'https://github.com/sachinkamlanil/jenkinspipeline.git', description: 'My Git Url', name: 'GIT_URL')
  }
  stages {
    stage("FirstStage){
          steps {
            script {
              sh "Hello World $fname"
              sh "git clone ${params.GIT_URL} codebase"
            }
          }
          }
  }  
}
