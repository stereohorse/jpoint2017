#!/usr/bin/env bash


cd "$(dirname "$0")"
touch ../logs.txt
tail -f ../logs.txt
