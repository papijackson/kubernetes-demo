# kubernetes-demo 

## Build docker image , run and push to DockerHub
docker build -t papijackson/demo-app .
docker run -d -p 8080:8080 papijackson/demo-app


## Kubectl port forwarding
kubectl port-forward demo-app 8080:8080
