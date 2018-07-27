node {
    echo 'The pipeline started'

    def branchVersion = ""

    stage ('Checkout') {
        // checkout repository
        //checkout scm

        // checkout input branch
        echo "BRANCH NAME: ${caller.env.BRANCH_NAME}"
        //bat "git checkout ${caller.env.BRANCH_NAME}"
    }
}