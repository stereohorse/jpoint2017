#!/usr/bin/env bash


cd "$(dirname "$0")"
./build.sh

cp ../Dockerfile ../build/install
cd ../build/install

docker build -t 0x06065a/jpoint2017/reasons-api:v2 .
