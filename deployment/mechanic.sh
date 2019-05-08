#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws08.ua.pt "cd assignment/src/entities/Mechanic && sh run.sh"