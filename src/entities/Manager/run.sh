#!/bin/bash
rm -r classes;
mkdir classes;
javac -d "classes" *.java ../../communication/*.java ../../messages/LoungeMessage/*.java ../../messages/OutsideWorldMessage/*.java ../../messages/ParkMessage/*.java ../../messages/RepairAreaMessage/*.java ../../messages/RepositoryMessage/*.java ../../messages/SupplierSiteMessage/*.java ../../settings/*.java ../../shared/Lounge/*.java ../../shared/OutsideWorld/*.java ../../shared/Park/*.java ../../shared/RepairArea/*.java ../../shared/Repository/*.java ../../shared/SupplierSite/*.java;
java -classpath "classes" entities.Manager.ManagerRun.java
