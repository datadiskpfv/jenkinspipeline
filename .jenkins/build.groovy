node {
    echo 'The pipeline started'

    def branchVersion = ""

    stage ('Checkout') {
        // checkout repository
        //checkout scm

        // checkout input branch
        echo "BRANCH NAME: ${BRANCH_NAME}"
        bat "git checkout ${BRANCH_NAME}"
    }
}