#!/usr/bin/env python3

import fileinput
import json


for line in fileinput.input():
    msg = json.loads(line)

    if msg['latency'] > 100000000 and msg['code'] != 200:
        print(msg)
