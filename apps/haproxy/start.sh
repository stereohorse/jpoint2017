#!/usr/bin/env bash


haproxy -f /tmp/haproxy.conf -D -p /tmp/haproxy.pid
