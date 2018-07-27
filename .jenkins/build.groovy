node {
    echo 'The pipeline started'

    def branchVersion = ""

    stage ('Checkout') {
        // checkout repository
        checkout scm

        // checkout input branch
        echo "BRANCH NAME: ${BRANCH_NAME}"
        bat "git checkout ${BRANCH_NAME}"
    }

    stage ('Determine Branch Version') {
        // add maven to path
        def MVN_HOME = "${tool 'Maven-3.5.4'}/bin"
        echo "MAVEN_HOME: $MVN_HOME"
        bat "mvn versions:set -DnewVersion=1.0"
    }

    stage ('Java Build') {
        // build .war package
        bat 'mvn clean package -U'
    }

    stage ('Docker Build') {
        // prepare docker build context
        bat "copy target/jenkinspipeline-1.0.jar tmp-docker-build-context"

        // Build and push image with Jenkins' docker-plugin
        withDockerServer([uri: "tcp://192.168.50.171:4243"]) {
            withDockerRegistry([credentialsId: 'docker-registry-credentials', url: "https://192.168.50.171:5000/"]) {
                // we give the image the same version as the .war package
                def image = docker.build("jenkinspipeline:latest}", "--build-arg PACKAGE_VERSION=1.0 tmp-docker-build-context")
                image.push()
            }
        }
    }
}