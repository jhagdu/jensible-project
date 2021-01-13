# Jensible: Ansible Jenkins Integration  

Every technology that exists in this world has two phases just like a coin i.e. every tool and technology that's having some brilliance highlighted features also contains some effortful challenges. Ansible is meant for configuration management or workflow automation, it's not a great CI/CD tool while Jenkins is a great CI/CD tool but not good at configuration and provisioning. So here's the power of both is put together to create a simple completely automated workflow. Here Ansible is used as a provisioning and configuration tool and Jenkins as a CI/CD tool.  

Three Ansible Roles are created for different purposes - 
-	**Role aws** will run on localhost and connect with AWS as a client for provisioning the infrastructure. It’ll create key-pairs, security groups, launch instances and create EKS cluster. This role is also responsible for updating the Public IP address of newly launched instance in ansible inventory file under the specified host group. Here our host group name is ‘jensible’.
-	**Role jenkins** will install and setup the Jenkins on the hosts under jensible group which is dynamically updated by aws role with IP of launched instance.
-	**Role jenjobs** will create and trigger the seed job in Jenkins which will generate other jobs and pipeline.
  
After the successful execution of these roles, Jenkins will be totally configured on EC2 Instance and seed job will be created and triggered. On triggered, seed job will generate other jobs and a pipeline. This pipeline consists of four jobs and on triggered, this pipeline will test and deploy the website on EKS Infrastructure after downloading the code from the developer's GitHub Repository. One of the jobs of the pipeline will again use Ansible Playbook to provision EKS Infrastructure and deploy the website on it. Ansible is used in two scenarios, first to install and configure Jenkins then Jenkins job uses it to deploy the website. After this, when the developer pushes updated website code to Github Repository that pipeline will be again triggered using Github webhooks and automatically website running in the production environment will be updated.  
  
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
Article - https://amanjhagrolia.medium.com/jensible-ansible-jenkins-integration-b52568c632d5   
Video - https://youtu.be/Nb9Q2eRZnYw   
  
***Feel free to Contact for any issue!!*** (Linkedin - www.linkedin.com/in/amanjhagrolia143)  
