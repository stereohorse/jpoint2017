#!/usr/bin/env bash


cd "$(dirname "$0")"
./nginx-stop.sh
./nginx-start.sh
