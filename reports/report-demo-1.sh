#!/usr/bin/env bash


run_vegeta () {
  echo "GET http://192.168.5.2:5050/holywar" | vegeta attack -duration=20s > demo-1.bin
  cat demo-1.bin | vegeta report
  cat demo-1.bin | vegeta report -reporter=plot > demo-1.html
}

switch_names_api () {
  cd ../vms
  ansible-playbook -i vagrant play-app.yml -t names-api
}



run_vegeta &
sleep 1 && switch_names_api
wait
