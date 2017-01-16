#!/usr/bin/env bash


watch -n1 -d 'ps aux | grep names-api | grep java | grep -v "grep" | grep -v "bash"'
