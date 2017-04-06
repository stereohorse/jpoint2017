#!/usr/bin/env bash

# -- warm up
echo "==> warming up"
echo "POST http://vm1:8081/transactions" \
  | vegeta attack -header "Content-Type: application/json" -body ../body.json -duration=3s \
  | vegeta report
sleep 1


# -- stress test

# initiate app update
(cd ../../vms && ansible-playbook -i vagrant play-demo-2.yml && echo "==> app updated") &

# simulate load
echo "==> simulating load"

echo "POST http://vm1:8081/transactions" \
  | vegeta attack -header "Content-Type: application/json" -body ../body.json -duration=10s > report.bin

cat report.bin | vegeta report
cat report.bin | vegeta report -reporter=plot > report.html
