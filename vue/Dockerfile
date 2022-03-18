FROM nginx

RUN rm /etc/nginx/conf.d/default.conf

RUN apt update && apt install -y vim

ADD deploy/nginx.conf /etc/nginx/conf.d/default.conf
COPY dist/ /usr/share/nginx/html/

#docker build -t zhuozhuang/helium-vue:1.1.5 .
# yarn run build
# docker stop hnt
# docker rmi hnt-vue:v1.0
# docker build -f Dockerfile -t hnt-vue:v1.0 .
# docker save -o hnt-vue.tar hnt-vue:v1.0
#
# npm run build --pord
# docker build -t zhuozhuang/helium-vue:1.1.6 .
