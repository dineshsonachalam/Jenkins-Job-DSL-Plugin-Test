def myjob = pipelineJob('Github_DSL_Plugin_2') {
    parameters {
        stringParam('INPUT', '', 'csv')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name('origin')
                        url('https://github.com/dineshsonachalam/Jenkins-Job-DSL-Plugin-Test.git')
                    }
                }
            }
            scriptPath('runway/Jenkinsfile')
        }
    }
}
