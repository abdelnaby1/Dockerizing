pipeline{
    agent any

    stages{
        stage("Building Jar"){
            steps{
                bat "mvn clean package -DskipTests"
            }
        }
         stage("Build The Image"){

             steps{
                 bat "docker build -t=abdelnaby1/selenium ."
             }
         }
         stage("Push The Image"){
            steps{
                bat "docker push abdelnaby1/selenium"
            }
         }
    }

}