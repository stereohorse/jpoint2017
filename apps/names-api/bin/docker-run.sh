#!/usr/bin/env bash


docker rm -f names-api || true
docker run -d --name names-api -e PORT=$PORT -p $PORT:$PORT 0x06065a/jpoint2017/names-api
