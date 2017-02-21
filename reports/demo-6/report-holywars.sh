#!/usr/bin/env sh


echo "GET http://192.168.5.3:31600/holywar" | vegeta attack > eureka.bin

cat eureka.bin | vegeta report -reporter=plot > eureka.html
cat eureka.bin | vegeta report
