#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws10.ua.pt "cd src/entities/Customer && sh run.sh"