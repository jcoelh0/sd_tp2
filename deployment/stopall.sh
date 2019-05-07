#!/bin/bash

#expect senddata.exp &&

sh stoprep.sh &
sh stopl.sh &
sh stopow.sh &
sh stopp.sh &
sh stopra.sh &
#sh manager.sh &
#sh mechanic.sh &
#sh customer.sh &

sleep 60

expect getlog.exp