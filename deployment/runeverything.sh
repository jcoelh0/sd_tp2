#!/bin/bash

expect senddata.exp &&

sh runrepository.sh &
sh runlounge.sh &
sh runoutsideworld.sh &
sh runpark.sh &
sh runrepairarea.sh &
sh runsuppliersite.sh &
sh runmanager.sh &
sh runmechanic.sh &
sh runcustomer.sh &

sleep 60

expect getlog.exp