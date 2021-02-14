Jenkins
=======

Ansible Role For Install and Configure Jenkins.

Requirements
------------
  
Operating System should be RedHat Linux      

Role Variables
--------------

Variables which should be included in variable/vault files -  

    # After Installing and Configuring Jenkins a mail is sent to specified email
    # Mail include Jenkins URL and Initial Admin Passwd   
    email: *******@gmail.com  
    emailPasswd: ***********
    mail_to: *******@gmail.com

Variables in vars/main.yml -  

    # Specify Jenkins Plugins to be Installed
    jenkins_plugins:
      - plugin1
      - plugin2
      - plugin3

         
Example Playbook
----------------

mail_conf.yml is a vault or variable file should include all the variables specified above.

    - hosts: servers
      vars_files:
        - vault/mail_conf.yml
      roles:
        - jhagdu.jenkins

License
-------

BSD

Author Information
------------------

Author Name: Aman Jhagrolia  
Contact: https://www.linkedin.com/in/amanjhagrolia143  
