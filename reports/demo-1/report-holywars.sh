#!/usr/bin/env bash

# -- warm up
echo "==> warming up"
echo "GET http://192.168.5.2:8081/holywar" | vegeta attack -duration=10s | vegeta report
sleep 1


# -- stress test

# initiate app update
(cd ../../vms && ansible-playbook -i vagrant play-update-names-api.yml && echo "==> app updated") &

# simulate load
REPORT_NAME=holywars-api

echo "==> simulating load"

echo "GET http://192.168.5.2:8081/holywar" | vegeta attack -duration=10s > $REPORT_NAME.bin
cat $REPORT_NAME.bin | vegeta report
cat $REPORT_NAME.bin | vegeta report -reporter=plot > $REPORT_NAME.html
