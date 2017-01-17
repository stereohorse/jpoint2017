#!/usr/bin/env bash


docker rm -f reasons-api-v2 || true
docker run -d --name reasons-api-v2 -e PORT=$PORT -p $PORT:$PORT 0x06065a/jpoint2017/reasons-api:v2
