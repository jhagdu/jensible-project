AWS
===

Role for Deploying Instance for Jenkins and EKS Cluster along with Node Groups for Web-Infrastructure on AWS.

Requirements
------------
  
AWSCLIv2 should be installed and configured  
  
Required Python Packages -  
- boto  
- boto3  
- botocore  
- python >= 2.6  

Role Variables
--------------

Variables which should be included in variable files -  

    # Specify AWS CLI Profile to be Used  
    aws_profile: default  

    # Path to Ansible Config Directory
    ans_conf_dir: /etc/ansible/
    $ Path to ansible Inventory
    ans_inv_path: /etc/ansible/hosts.txt

    # Your Public IP
    # This Public IP is allowed through Security Group which is created for Instance
    # So that Instance Can be accessible
    #
    # If not specified, then by default 0.0.0.0/0 will be allowed
    # That is Instance is vulnerable as it is publically open
    pub_ip: "0.0.0.0/0"

    # Specify AWS Subnets
    # For the Instance -
    jen_subnet_id: "subnet-id1"
    # For EKS Cluster (Two Different) -
    eks_subnet1_id: "{{ jen_subnet_id }}"
    eks_subnet2_id: "subnet-id2"

    # Specify AMI ID
    ami_id: ami-amiidhere

    # Specify Instance Types
    # For Instance -
    jen_inst_type: m5.large
    # For EKS Node Groups -
    ng_inst_type1: m5.large
    ng_inst_type2: m5.xlarge

    # jhagdu.jenjobs Role Path
    # By default AWS, Jenkins and JenJobs Roles are in same folder where Playbook Is!
    # But if you put JenJobs role somewhere else
    # Then you have to specify path here
    jenkins_role_path: roles/

Variables in vars/main.yml -  

    # Key Pair Names
    # For Instance -
    jen_key: jenkey
    # For EKS Node Groups -
    ng_key: ngkey
    
    # Security Group Names
    # For Instance -
    jen_sg_name: JenSG
    # For EKS Node Groups -
    ng_sg_name: ngSG
    
    # EKS Cluster Config
    eks_cluster_name: web_cluster
    k8s_version: 1.18
    
    # EKS Node Group Scaling Config
    desired_size: 1
    max_size: 2
    min_size: 1

         
Dependencies
------------

Depends on Ansible Collections -
- community.aws (To install it use 'ansible-galaxy collection install community.aws')

Example Playbook
----------------

aws_vars.yml variable file should include all the variables specified above.

    - hosts: servers
      vars_files:
         - aws_vars.yml
      roles:
         - username.aws 

License
-------

BSD

Author Information
------------------

Author Name: Aman Jhagrolia  
Contact: https://www.linkedin.com/in/amanjhagrolia143  
