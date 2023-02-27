String fname = "Test"


pipeline {
  agent {
     label "sachinmachine"
  }
  parameters {
      string(defaultValue: 'https://github.com/sachinkamlanil/jenkinspipeline.git', description: 'My Git Url', name: 'GIT_URL')
  }
  stages {
    stage("FirstStage"){
          steps {
            script {
              echo "Hello World $fname"
              bat "git clone ${params.GIT_URL} codebase"
            }
          }
          }
  }  
}
