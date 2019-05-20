

/*

def project = 'nodejs-docker-demo'
def jobName = 'nodejs-demo'

job(jobName) {
    scm {
        git("git://github.com/sandjaie/${project}.git") {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('sandjaie')
            node / gitConfigEmail('sandjaie@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
*/

job('DSL Plugin Demo') {
    logRotator(-1, 10)
    jdk('Java 6')
    scm {
        github('https://github.com/dineshsonachalam/Jenkins-Job-DSL-Plugin-Test', 'master')
    }
    steps {
        sh build.sh
        sh test.sh
        sh deploy.sh
    }
}