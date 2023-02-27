String fname = "Test"


pipeline {
  agent {
     label "sachinmachine"
  }
  parameters {
      string(defaultValue: 'https://github.com/sachinkamlanil/jenkinspipeline.git', description: 'My Git Url', name: 'GIT_URL')
      choice(choices: "Sujata\nRohit\nJagdish\nRupali", description: 'Student List', name: 'NameList')
  }
  stages {
    stage("CodeCheckout"){
          steps {
            script {
              echo "Hello World $fname"
              bat "git clone ${params.GIT_URL} codebase"
            }
          }
          }
    stage("Echo Message Stage"){
      steps {
        script{
          dir("codebase"){
            echo "Hello ${params.NameList} > ${params.NameList}_file.txt"
            bat "git add ${params.NameList}_file.txt"
            bat "git commit -m 'Added ${params.NameList}_file.txt'"
            bat "git push" 
          }
        }
      }
    }
  }
  post{
    always {
      script{
         //cleanWs() 
      }
     }
  }
}
