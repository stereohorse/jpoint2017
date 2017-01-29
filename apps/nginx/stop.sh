#!/usr/bin/env bash


kill `cat /usr/local/var/log/nginx/nginx.pid` || true
