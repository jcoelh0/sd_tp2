#!/bin/bash

#expect senddata.exp &&

sh runnables/repository.sh &
sh runnables/lounge.sh &
sh runnables/outsideworld.sh &
sh runnables/park.sh &
sh runnables/repairarea.sh &
sh runnables/suppliersite.sh &
sh runnables/manager.sh &
sh runnables/mechanic.sh &
sh runnables/customer.sh &

sleep 60

expect getlog.exp
