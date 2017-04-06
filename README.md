# JPoint 2017 - Where is my service, dude? - live demo

## Setup

There are 2 vagrant VMs:

1. vm1 - no Mesos
2. vm2 - with Mesos

Type this to spin both of them:

```bash
$ cd vms
$ vagrant up
```

## Demos

Prepared demo results are situated in dirs `demo-\[1-5\]/out/`.

### In-place update

```bash
# setup env
$ cd vms
$ ansible-playbook -i vagrant play-apps-demo-1.yml

# run test
$ cd reports/demo-1
$ ./report.sh
```

### Dumb proxy

```bash
# setup env
$ cd vms
$ ansible-playbook -i vagrant play-apps-demo-2.yml

# run test
$ cd reports/demo-2
$ ./report.sh
```

### Proxy with healthcheck

```bash
# setup env
$ cd vms
$ ansible-playbook -i vagrant play-apps-demo-2.yml

# run test
$ cd reports/demo-3
$ ./report.sh
```

### Proxy with load balancing

```bash
# setup env
$ cd vms
$ ansible-playbook -i vagrant play-apps-demo-2.yml

# run test
$ cd reports/demo-4
$ ./report.sh
```

### Mesos & Marathon

```bash
$ cd reports/demo-5
$ ./report.sh
```
