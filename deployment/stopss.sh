#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws05.ua.pt "fuser -n tcp -k 22314 && exit"