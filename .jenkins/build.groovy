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

        def pomVersion = bat(script: 'mvn -q -Dexec.executable=\'echo\' -Dexec.args=\'${project.version}\' --non-recursive exec:exec', returnStdout: true).trim()
        echo "POM Version: ${pomVersion}"

    }
}