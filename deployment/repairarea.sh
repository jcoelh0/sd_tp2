#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws06.ua.pt "cd assignment/src/shared/RepairArea && sh run.sh"