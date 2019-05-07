#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws02.ua.pt "cd sd_tp2/src/shared/Lounge && sh run.sh"