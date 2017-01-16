#!/usr/bin/env bash


watch -n1 -d 'ps aux | grep reasons-api-v2 | grep java | grep -v "grep" | grep -v "bash"'
