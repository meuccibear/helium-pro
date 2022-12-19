-- UPDATE `helium_pro`.`business_device` 
-- SET 
-- `total24h` = NULL,
-- `online` = NULL,
-- `depllist` = NULL;
-- 


-- SELECT * FROM business_device WHERE depllist != 0 or depllist != 1;
SELECT * FROM business_device WHERE `total24h` is null;
SELECT * FROM business_device WHERE `online` is null;
SELECT * FROM business_device WHERE `depllist` is null;


-- 1680 2885	504