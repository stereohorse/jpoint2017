#!/usr/bin/env bash

REPORT_NAME=report

echo "GET http://192.168.5.2:5050/holywar" | vegeta attack -duration=5s > $REPORT_NAME.bin
cat $REPORT_NAME.bin | vegeta report
cat $REPORT_NAME.bin | vegeta report -reporter=plot > $REPORT_NAME.html
