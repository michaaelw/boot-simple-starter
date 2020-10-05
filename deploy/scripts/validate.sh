#!/usr/bin/env bash

waitPeriod=5
runtime="$waitPeriod minute"
endTime=$(date -ud "$runtime" +%s)

while true
do
    result=$(curl -s http://localhost:8080/actuator/health)

    if [ "$result" == '{"status":"UP"}' ]
    then
        echo "Health check succeded. The response is [$result]"
        exit 0
    elif [[ $(date -u +%s) -ge $endTime ]]
    then
        echo "Waited for $waitPeriod minutes, giving up now.."
        exit 1
    else
        echo "Health check Failed. The response is [$result]. Will wait 3s then try again."
        sleep 3s
    fi
done