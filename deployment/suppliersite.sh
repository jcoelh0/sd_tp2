#!/bin/bash
sshpass -p qwerty ssh -tt -o StrictHostKeyChecking=no sd0301@l040101-ws05.ua.pt "cd assignment/src/shared/SupplierSite && sh run.sh"