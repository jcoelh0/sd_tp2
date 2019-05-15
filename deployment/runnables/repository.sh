#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws01.ua.pt "cd src/shared/Repository && sh run.sh"