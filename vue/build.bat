yarn run build
docker build -f Dockerfile -t zhuozhuang/helium-vue:1.1.4 .
docker build -f Dockerfile -t helium-vue:1.1.4 .
docker push zhuozhuang/helium-vue:1.1.4
