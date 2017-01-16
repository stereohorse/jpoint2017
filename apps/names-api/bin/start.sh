#!/usr/bin/env bash


cd "$(dirname "$0")"

PORT=5051 ../build/install/names-api/bin/names-api &>../logs.txt \
  & echo $! > ../pid
