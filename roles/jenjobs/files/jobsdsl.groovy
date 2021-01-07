job("1 Git Pull") {
  description("Pulls Website Code From GitHub Repository")
  
  scm {
    github("git-user/repo-name", "main") 
  }

  triggers {
    githubPush()
    authenticationToken("Job1Trigger")
  }
}

job("2 Check And Deploy") {
  description("Check Code Language and Deploy Accordingly")
  
  triggers {
    upstream("1 Git Pull")
  }

  steps {
    shell(readFileFromWorkspace("script_4_deploy.sh"))
  }
}

job("3 Test App") {
  description("Test our Site, Working or Not")
  
  triggers {
    upstream("2 Check And Deploy")
  }

  steps {
    shell(readFileFromWorkspace("testing_script.sh"))
  }
}

job("4 Send Mail") {
  description("If site Not Working Send Mail to Developer")
  
  triggers {
    upstream("3 Test App")
  }

  publishers {
        mailer('mailat@gmail.com')
  }
}

buildPipelineView("K8s Deploy WebApp") {
  title("From Git to K8s Deploy")
  description("Code from Git to Kubernetes - Complete Pipeline to Deploy")
  selectedJob("1 Git Pull")
  alwaysAllowManualTrigger(true)
  refreshFrequency(3)
  displayedBuilds(1)
  showPipelineParameters(true)
}