#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws07.ua.pt "cd src/entities/Manager && sh run.sh"