#!/usr/bin/env bash

# -- warm up
echo "==> warming up"
echo "POST http://vm1:8081/transactions" \
  | vegeta attack -header "Content-Type: application/json" -body ../body.json -duration=10s \
  | vegeta report
sleep 1


# -- stress test

# initiate app update
(cd ../../vms && ansible-playbook -i vagrant play-demo-4.yml && echo "==> app updated") &

# simulate load
echo "==> simulating load"

echo "POST http://vm1:8081/transactions" \
  | vegeta attack -header "Content-Type: application/json" -body ../body.json -duration=15s -rate 150 > report.bin

cat report.bin | vegeta report
cat report.bin | vegeta report -reporter=plot > report.html
