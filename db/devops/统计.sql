-- TRUNCATE table data_http;
-- TRUNCATE table business_log;
-- TRUNCATE table business_device;

SELECT status,count(*) FROM data_http GROUP BY status ;

SELECT err_status,count(*) FROM business_device GROUP BY err_status;

SELECT `status`,count(*) FROM business_device GROUP BY `status`;

SELECT * FROM business_device where `err_status` IS NULL;

SELECT err_status,count(err_status) FROM business_device 
-- AND one_level_name = "李宛枫" 
GROUP BY err_status ;


SELECT * FROM data_http where 
url = "https://denylist-api.herokuapp.com/api/hotspots/11MmMJLFEDBhhwDTovzdnGicBZDwDw4gLmHeE9bZttxRWiuGt99"
-- url like "%11MmMJLFEDBhhwDTovzdnGicBZDwDw4gLmHeE9bZttxRWiuGt99%"




SELECT * FROM business_device where address in ("112EUdUyyJ8jtKjk9o4D8uygnaKkbmBSG9UfbkdWYeG2pNCytY4P","117JzbcZLvc9M2evdJmDtsUXnFuaGrb1XGTEMDyfxNAqWPZT86Q","112R8TrbKVUBiuqF74KabtT2kVsk6P9SFVKTW5tFku6NNSbWbAwE","112osVQyNA6GYJ3UsneauVdQefbsR7Ni7qMyvzg8kCjtoofosRpU","1122VEjWjFgacMHugHfd4VjbAWNEmn4GHL5enEQS41b6ehoWrUmw","112kU92Aj8nkvUHgNRrw5u58dpTGDhBwUw5YqNGpmVCX14BgSrgd","112J2biYuQMgj841fVQNYYsJCSYwfsnwneh67Z5ssv66RfsF3SUt","11eE7YZYLMrXuUYnv7RJsh1h3avWzEDrqYcNCHWymFELftH4cjY")
