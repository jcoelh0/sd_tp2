#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws02.ua.pt "cd assignment/src/shared/Lounge && sh run.sh"