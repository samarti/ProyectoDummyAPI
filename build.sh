git pull origin master
docker build -t dummy-api .

docker-compose stop
docker rm $(docker ps -a -q --filter="name=dummy")
docker rmi $(docker images -f "dangling=true" -q)
docker run -v /var/run/docker.sock:/var/run/docker.sock -v /var/lib/docker:/var/lib/docker --rm martin/docker-cleanup-volumes
docker-compose up -d
