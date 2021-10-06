pipeline {

    agent any

    parameters {
        booleanParam(name: "RELEASE", defaultValue: false)
        choice(name: "DEPLOY_TO", choices: ["", "INT", "PRE", "PROD"])
    }

    stages {

        stage("Build") {
            steps {
                sh "./gradlew build"
            }
        }

        stage("Publish") {
            parallel {
                stage('Pre-Release') {
                    when { expression { !params.RELEASE } }
                    steps {
                        sh "echo preRelease"
                    }
                }
                stage("Release") {
                    when { expression { params.RELEASE } }
                    steps {
                        sh "echo release"
                    }
                }
            }
        }

        stage("Deploy") {
            parallel {
                stage("INT") {
                    when { expression { params.DEPLOY_TO == "INT" } }
                    steps {
                        sh "echo int"
                    }
                }
                stage("PRE") {
                    when { expression { params.DEPLOY_TO == "PRE" } }
                    steps {
                        sh "echo pre"
                    }
                }
                stage("PROD") {
                    when { expression { params.DEPLOY_TO == "PROD" } }
                    steps {
                        sh "echo prod"
                    }
                }
            }
        }
    }
}