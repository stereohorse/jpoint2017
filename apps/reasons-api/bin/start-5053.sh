#!/usr/bin/env bash


cd "$(dirname "$0")"

PORT=5053 ../build/install/reasons-api/bin/reasons-api &>../logs.txt \
  & echo $! > ../pid
