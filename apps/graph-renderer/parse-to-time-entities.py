#!/usr/bin/env python3

import fileinput


for line in fileinput.input():
    parts = line.split(' ')
    time = parts[0] + ' ' + parts[1]

    if 'Connection refused' in line:
        err = 1
    elif 'Unexpected end of file' in line:
        err = 3
    elif 'Connection reset' in line:
        err = 2
    else:
        err = line

    print('%s,%s' % (time, err))


