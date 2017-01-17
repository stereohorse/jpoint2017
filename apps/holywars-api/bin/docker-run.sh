#!/usr/bin/env bash


docker rm -f holywars-api || true
docker run -d --name holywars-api -e PORT=$PORT -p $PORT:$PORT 0x06065a/jpoint2017/holywars-api
