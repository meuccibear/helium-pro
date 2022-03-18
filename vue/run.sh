#!/bin/sh
help()
{
        cat << EOF
Usage:
        cn                              install chinese phala script | 中文安装
        en                              install english phala script | 英文安装
        help                            show install help information ｜ 展示帮助信息
EOF
exit 0
}


rm -rf dist

unzip dist.zip

docker rm -f smsvue
docker rmi -f smsvue

docker build -t smsvue .
rm -rf dist*
docker run --name smsvue -d -p 9020:80 smsvue

#sed -i 's/BZZ/勤智/' 1.js
