-- SELECT * FROM business_device where address = "112R6T7ZdaKsSNJYDPPfkE8kvj1vysi82QLDBchsc3faz5Koy8GK";
-- SELECT * FROM business_device where `online` is null;
SELECT * FROM business_device where `online` is null and `name` is not null;
SELECT * FROM business_device where `online` is null and `name` is null;
-- SELECT * FROM business_device where `depllist` is null;
-- SELECT * FROM business_device where `total24h` is null;

UPDATE business_device SET `online` = NULL WHERE `pingpai` not in ("Helium Inc","Nebra Ltd","SyncroB.it","Bobcat","LongAP","RAKwireless","Kerlink","DeWi Foundation","SenseCAP","Pisces Miner","ClodPi","Linxdot","COTX Networks","Controllino","Heltec Automation","FreedomFi","PantherX","hummingbird","RisingHF","Browan/MerryIoT","CalChip Connect","Milesight","Deeper","Midas","Dragino","Pycom","Atom","KS Technologies","EDA-IoT","embit","Mimiq","Dusun","Aitek Inc","Bobcat 5G","Helium Inc (Old)") ;