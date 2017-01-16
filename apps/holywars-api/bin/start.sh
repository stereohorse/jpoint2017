#!/usr/bin/env bash


cd "$(dirname "$0")"

PORT=5050 ../build/install/holywars-api/bin/holywars-api &>../logs.txt \
  & echo $! > ../pid
