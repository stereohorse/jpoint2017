FROM docker:1.12.0
MAINTAINER Viet Nguyen <tnguen@alfabank.ru>

ADD https://releases.hashicorp.com/consul-template/0.16.0/consul-template_0.16.0_linux_amd64.zip /tmp

RUN unzip -q -d /usr/local/bin /tmp/consul-template_0.16.0_linux_amd64.zip \
  && rm -f /tmp/consul-template_0.16.0_linux_amd64.zip \

CMD /consul-template
