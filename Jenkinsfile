pipeline {
    agent {
      label "jenkins-maven"
    }
    environment {
      ORG               = 'salaboy'
      APP_NAME          = 'spring-cloud-k8s-minion'
      //CHARTMUSEUM_CREDS = credentials('jenkins-x-chartmuseum')
    }
    stages {
      stage('CI Build and push snapshot') {
        environment {
          PREVIEW_VERSION = "0.0.0-SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER"
          PREVIEW_NAMESPACE = "$APP_NAME-$BRANCH_NAME".toLowerCase()
          HELM_RELEASE = "$PREVIEW_NAMESPACE".toLowerCase()
        }
        steps {
          container('maven') {
            sh "mvn clean package"
           // sh 'export VERSION=$PREVIEW_VERSION && skaffold build -f skaffold.yaml'


            //sh "jx step post build --image $DOCKER_REGISTRY/$ORG/$APP_NAME:$PREVIEW_VERSION"
          }


          }
        }
      }
    }
    post {
        always {
            cleanWs()
        }
    }
  }
