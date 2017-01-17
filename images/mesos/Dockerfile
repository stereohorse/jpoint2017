FROM ubuntu:14.04.5
MAINTAINER Nguyen Viet <inbox@dev-forge.ru>

RUN sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv E56151BF \
  && echo "deb http://repos.mesosphere.com/ubuntu trusty main" | sudo tee /etc/apt/sources.list.d/mesosphere.list \
  && apt-get -y update \
  && apt-get install -y mesos \
  && apt-get clean
