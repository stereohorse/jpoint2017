FROM 0x06065a/mesos:1.0.0
MAINTAINER Nguyen Viet <inbox@dev-forge.ru>

RUN apt-get install -y software-properties-common \
  && apt-get clean

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections \
  && echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections

RUN add-apt-repository ppa:webupd8team/java \
  && apt-get -y update \
  && apt-get install -y oracle-java8-installer \
  && apt-get install -y oracle-java8-set-default \
  && apt-get clean

RUN apt-get install -y marathon \
  && apt-get clean
