#!/usr/bin/env bash


cd "$(dirname "$0")"

NAMES_API_ENDPOINT="http://localhost:5051" REASONS_API_ENDPOINT="http://localhost:5052" PORT=5050 ../build/install/holywars-api/bin/holywars-api &>../logs.txt \
  & echo $! > ../pid
