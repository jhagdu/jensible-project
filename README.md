# Jensible: Ansible Jenkins Integration  

Three Ansible Roles are created for different purposes - 
-	**Role aws** will run on localhost and connect with AWS as a client for provisioning the infrastructure. It’ll create key-pairs, security groups, launch instances and create EKS cluster. This role is also responsible for updating the Public IP address of newly launched instance in ansible inventory file under the specified host group. Here our host group name is ‘jensible’.
-	**Role jenkins** will install and setup the Jenkins on the hosts under jensible group which is dynamically updated by aws role with IP of launched instance.
-	**Role jenjobs** will create and trigger the seed job in Jenkins which will generate other jobs and pipeline.

## Prerequisites   
- Ansible should be installed and Configured
- AWS CLI Should be Installed and Configured  
- Other requirements of Roles are included in Readme file of particular Role

## How to Start 
- Clone or Download the Repository  
- Change variable values in aws_vars.yml and jen_vars.yml accordingly  
- Create or edit a vault named mail_config.yml (Here mail_config.yml is demo vault, pass - test)  
- Finally run web_cicd.yml using 'ansible-playbook --ask-vault-pass web_cicd.yml' command  

## Note  
- Recommended to use RedHat AMI  
- Ansible Config file should include previliage_escalation block to become root user to configure AWS Instances  

# Links
Article -  
Video -  
  
***Feel free to Contact for any issue!!*** (Linkedin - www.linkedin.com/in/amanjhagrolia143)  
