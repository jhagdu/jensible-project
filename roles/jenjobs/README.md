JenJobs
=======

Ansible Role to Configure Seed Job in Jenkins to generate other Jobs/Pipeline and Deploy K8s Infrastructure.

Requirements
------------
  
Operating System should be RedHat Linux  

Role Variables
--------------

Variables which should be included in jen_vars.yml variable file -  

    # Path to your AWS CLI Configuration Directory
    aws_conf_dir: "/root/.aws/"

Variables which should be included in mail_conf.yml vault file -  

    # A mail is sent after Configuring Jenkins Jobs and Website deployment on EKS Cluster
    # Mail includes the URL of Website which is deployed   
    email: *******@gmail.com  
    emailPasswd: ***********
    mail_to: *******@gmail.com

Variables in vars/main.yml -  
 
    # Path to Jenkins Installation Directory
    jenkins_path: /var/lib/jenkins/
    
    # Path to Ansible Collections and Roles
    ans_path: /root/.ansible/
           
Dependencies
------------

Depends on Ansible Roles -
- jhagdu.aws
- jhagdu.jenkins

Example Playbook
----------------

jen_vars.yml and mail_conf.yml vault/variable files should include all the variables specified above.

    - hosts: servers
      vars_files:
        - jen_vars.yml
        - mail_conf.yml
      roles:
        - jhagdu.jenjobs


License
-------

BSD

Author Information
------------------

Author Name: Aman Jhagrolia  
Contact: https://www.linkedin.com/in/amanjhagrolia143  
