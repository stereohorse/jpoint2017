#!/usr/bin/env bash


kill -HUP `cat /usr/local/var/log/nginx/nginx.pid` || true
