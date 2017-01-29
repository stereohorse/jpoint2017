names-api/build/install/names-api:
	names-api/bin/build.sh

run-names-api: stop-names-api names-api/build/install/names-api
	names-api/bin/start.sh

stop-names-api:
	names-api/bin/stop.sh


reasons-api/build/install/reasons-api:
	reasons-api/bin/build.sh

run-reasons-api: stop-reasons-api stop-reasons-api-v2 reasons-api/build/install/reasons-api
	reasons-api/bin/start.sh

run-reasons-api-5053: stop-reasons-api stop-reasons-api-v2 reasons-api/build/install/reasons-api
	reasons-api/bin/start-5053.sh

stop-reasons-api:
	reasons-api/bin/stop.sh


reasons-api-v2/build/install/reasons-api:
	reasons-api-v2/bin/build.sh

run-reasons-api-v2: stop-reasons-api-v2 reasons-api-v2/build/install/reasons-api
	reasons-api-v2/bin/start.sh

run-reasons-api-v2-5054: stop-reasons-api-v2 reasons-api-v2/build/install/reasons-api
	reasons-api-v2/bin/start-5054.sh

stop-reasons-api-v2:
	reasons-api-v2/bin/stop.sh


holywars-api/build/install/holywars-api:
	holywars-api/bin/build.sh

run-holywars-api: stop-holywars-api holywars-api/build/install/holywars-api
	holywars-api/bin/start.sh

stop-holywars-api:
	holywars-api/bin/stop.sh








# --[ update in-place ] --

measure-in-place:
	make run-reasons-api
	sleep 2s
	echo 'starting test'
	REPORT_NAME=in-place make report & (sleep 1s && make update-in-place)

update-in-place:
	make stop-reasons-api
	make run-reasons-api-v2


# --[ plain nginx ] --

measure-plain-nginx:
	make run-reasons-api-5053
	make set-reasons-api-location
	sleep 2s
	echo 'starting test'
	REPORT_NAME=plain-nginx make report & (sleep 1s && make update-plain-nginx)

update-plain-nginx:
	make run-reasons-api-v2-5054
	make set-reasons-api-upstream
	sleep 2s
	make set-reasons-api-v2-location
	make stop-reasons-api


# --[ haproxy ] --

measure-haproxy:
	make run-reasons-api-5053
	make set-reasons-api-ha
	sleep 2s
	echo 'starting test'
	REPORT_NAME=haproxy make report & (sleep 1s && make update-haproxy)

update-haproxy:
	make run-reasons-api-v2-5054
	make set-reasons-api-upstream-ha
	sleep 3s
	make set-reasons-api-v2-ha
	make stop-reasons-api



# --[ reporter ]--

report:
	echo "GET http://localhost:5050/holywar" | vegeta attack -rate=150 -duration=5s > $(REPORT_NAME).bin
	cat $(REPORT_NAME).bin | vegeta report
	cat $(REPORT_NAME).bin | vegeta report -reporter=plot > $(REPORT_NAME).html













# --[ initializers ]--

init-in-place: \
	stop \
	run-names-api \
	run-reasons-api \
	run-holywars-api

init-plain-nginx: \
	stop \
	run-names-api \
	run-reasons-api-5053 \
	run-holywars-api \
	set-reasons-api-location
	nginx/restart.sh

init-haproxy: \
	stop \
	run-names-api \
	run-reasons-api-5053 \
	run-holywars-api \
	set-reasons-api-ha
	haproxy/restart.sh



set-reasons-api-location:
	cp nginx/reasons-api.conf /usr/local/etc/nginx/servers/nginx.conf
	nginx/reload.sh

set-reasons-api-upstream:
	cp nginx/reasons-api-upstream.conf /usr/local/etc/nginx/servers/nginx.conf
	nginx/reload.sh

set-reasons-api-v2-location:
	cp nginx/reasons-api-v2.conf /usr/local/etc/nginx/servers/nginx.conf
	nginx/reload.sh


set-reasons-api-ha:
	cp haproxy/reasons-api.conf /tmp/haproxy.conf
	haproxy/reload.sh

set-reasons-api-upstream-ha:
	cp haproxy/reasons-api-upstream.conf /tmp/haproxy.conf
	haproxy/reload.sh

set-reasons-api-v2-ha:
	cp haproxy/reasons-api-v2.conf /tmp/haproxy.conf
	haproxy/reload.sh


# --

stop: \
	stop-names-api \
	stop-reasons-api \
	stop-reasons-api-v2 \
	stop-holywars-api
	nginx/stop.sh
	haproxy/stop.sh

terminate:
	killall java

clean-builds:
	rm -rf names-api/build
	rm -rf reasons-api/build
	rm -rf reasons-api-v2/build
	rm -rf holywars-api/build

clean: clean-builds
	rm -f  names-api/logs.txt
	rm -f  reasons-api/logs.txt
	rm -f  reasons-api-v2/logs.txt
	rm -f  holywars-api/logs.txt

build: names-api/build/install/names-api \
	reasons-api/build/install/reasons-api \
	reasons-api-v2/build/install/reasons-api \
	holywars-api/build/install/holywars-api
