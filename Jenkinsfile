pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo 'in test'
            }
        }
        stage('deploy') {
            steps {
                echo 'in deploy'
            }
        }
    }
    post{
    
        always{
            emailext body: 'have a great day', subject: 'Checking', to: 'swapnildyeutkar@gmail.com'
        }
    }
}
