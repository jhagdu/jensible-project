cp -r /var/lib/jenkins/workspace/1\ Git\ Pull/* .
code=webapp.*
code_file=$(echo $code)
hostname=$(kubectl get svc -o jsonpath={.items[0].status.loadBalancer.ingress[0].hostname} --namespace webspace)
status=$(curl -s -w "%{http_code}" -o /dev/nell http://$hostname/$code_file)

if [ $status -eq 200 ]
then
  exit 1
else 
  exit 0
fi

