#!/usr/bin/env bash


cd "$(dirname "$0")"
touch ../logs.txt
tail -n 0 -f ../logs.txt
