# kubernetes-demo 

## Build docker image , run and push to DockerHub
docker build -t papijackson/demo-app .
docker run -d -p 8080:8080 papijackson/demo-app


## Kubectl port forwarding
kubectl port-forward demo-app 8080:8080

# Installation

## Helm
brew install helm

## Prometheus Stack

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts

helm repo update

kubectl create ns monitoring

helm install prom prometheus-community/kube-prometheus-stack -n monitoring --values monitoring-stack/values.yaml
### Port forwarding to prometheus
kubectl port-forward service/prom-kube-prometheus-stack-prometheus -n monitoring 9090:9090

## Install Promtail and Loki

helm repo add grafana https://grafana.github.io/helm-charts
helm upgrade --install promtail grafana/promtail -f monitoring/promtail-values.yaml -n monitoring

helm upgrade --install loki grafana/loki-distributed -n monitoring
