#!/bin/bash

#expect senddata.exp &&

sh repository.sh &
sh lounge.sh &
sh outsideworld.sh &
sh park.sh &
sh repairarea.sh &
sh suppliersite.sh &
sh manager.sh &
sh mechanic.sh &
sh customer.sh &

sleep 60

expect getlog.exp