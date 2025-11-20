pipeline{
    agent any
    environment{
        DOCKER_IMAGE='demo_pipe'
        CONTAINER_NAME='demo_pipe_con'
    //    ENVIRONMENT='prod'
    }
    parameters{
             //   string(name:'ENVIRONMENT', defaultValue:'', description:'Environment Name')
         choice(name:'ENVIRONMENT', choices:['testing','prod'], description:'Environment Name')
    }
    stages{
        stage('git clone'){
            steps{
                git branch: 'main', url: 'https://github.com/Natarajan15/jenkins_demo.git'
            }
        }
         stage('check list'){
            steps{
               bat 'dir'
            }
        }
        stage('run test case'){
            
           when{
               expression{
                   params.ENVIRONMENT== 'testing'
               }
           }
            steps{
               bat 'mvn test'
            }
        }
        stage('build project'){
            steps{
               bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('build image'){
            steps{
               bat 'docker build -t %DOCKER_IMAGE%:%BUILD_NUMBER% .'
            }
        }
         stage('stop container'){
            steps{
              bat 'docker stop %CONTAINER_NAME%'
            }
        }
          stage('remove container'){
            steps{
              bat 'docker rm %CONTAINER_NAME%'
            }
        }
//         stage('Remove container if exists') {
//     steps {
//         bat 'for /f "tokens=*" %%i in (\'docker ps -aq -f "name=demo_pile"\') do docker rm -f %%i'
//     }
// }

        stage('run container'){
            steps{
               bat 'docker run -d -p 8081:8081 --name=demo_pipe_con %DOCKER_IMAGE%:%BUILD_NUMBER%'
            }
        }
    }
}
