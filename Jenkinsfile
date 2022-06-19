def label = "mypod-${UUID.randomUUID().toString()}"
podTemplate(label: label, cloud: 'kubernetes', containers: [
    containerTemplate(name: 'maven', image: 'maven:3.8.6-openjdk-8-slim', ttyEnabled: true, command: 'cat'),
  ]) {

    node(label) {
        stage('Get a Maven Project') {
            //git 'https://github.com/jenkinsci/kubernetes-plugin.git'
            container('maven') {
                stage('Build a Maven project') {
                    sh 'mvn -DskipTests=true clean package'
                }
            }
        }
    }
}
