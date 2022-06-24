
## compile && build docker image to docker daemon 
> you need install [docker](https://docs.docker.com/get-docker/) first.

`mvn clean compile`

## deploy to k8s
```shell
kubectl apply -f deploy/user.yaml
kubectl apply -f deploy/dept.yaml
```

## testing
```shell
> configRefresh http://yourserver:30088/config
> microservice http://yourserver:30088/userinfo
```
