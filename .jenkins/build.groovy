node {
    echo 'The pipeline started'

    def branchVersion = ""

    stage ('Checkout') {
        // checkout repository
        checkout scm

        // checkout input branch
        sh "git checkout ${caller.env.BRANCH_NAME}"
    }
}