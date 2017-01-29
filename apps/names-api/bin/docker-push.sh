#!/usr/bin/env bash


cd "$(dirname "$0")"
./docker-image.sh

docker push 0x06065a/jpoint2017-names-api
