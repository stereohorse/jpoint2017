names-api/build/install/names-api:
	names-api/bin/build.sh

run-names-api: stop-names-api names-api/build/install/names-api
	names-api/bin/start.sh

stop-names-api:
	names-api/bin/stop.sh


reasons-api/build/install/reasons-api:
	reasons-api/bin/build.sh

run-reasons-api: stop-reasons-api reasons-api/build/install/reasons-api
	reasons-api/bin/start.sh

stop-reasons-api: stop-reasons-api-v2
	reasons-api/bin/stop.sh

update-in-place: stop-reasons-api run-reasons-api-v2


reasons-api-v2/build/install/reasons-api:
	reasons-api-v2/bin/build.sh

run-reasons-api-v2: stop-reasons-api-v2 reasons-api-v2/build/install/reasons-api
	reasons-api-v2/bin/start.sh

stop-reasons-api-v2:
	reasons-api-v2/bin/stop.sh


holywars-api/build/install/holywars-api:
	holywars-api/bin/build.sh

run-holywars-api: stop-holywars-api holywars-api/build/install/holywars-api
	holywars-api/bin/start.sh

stop-holywars-api:
	holywars-api/bin/stop.sh


report:
	echo "GET http://localhost:5050" | vegeta attack -duration=5s > report.bin
	cat report.bin | vegeta report
	cat report.bin | vegeta report -reporter=plot > report.html

measure-in-place:
	make run-reasons-api
	sleep 2s
	make report & (sleep 1s && make update-in-place)


run: run-names-api run-reasons-api run-holywars-api

stop: stop-names-api stop-reasons-api stop-holywars-api

terminate:
	killall java

clean:
	rm -rf names-api/build
	rm -f  names-api/logs.txt
	rm -rf reasons-api/build
	rm -f  reasons-api/logs.txt
	rm -rf holywars-api/build
	rm -f  holywars-api/logs.txt
