if ls /var/lib/jenkins/workspace/1\ Git\ Pull/*.* | grep html
then
  sudo /usr/local/bin/ansible-playbook /jenkins_job_files/ansible/deploy-web.yml --extra-vars "type=html"
elif ls /var/lib/jenkins/workspace/1\ Git\ Pull/*.* | grep php
then
  sudo /usr/local/bin/ansible-playbook /jenkins_job_files/ansible/deploy-web.yml --extra-vars "type=php"
fi
