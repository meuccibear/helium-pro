
SELECT
	manage_name, count(manage_name)
FROM
	business_device 
WHERE
1=1
AND (one_level_name LIKE "%明%" or one_level_name LIKE "%李宛枫%" )
AND pingpai = "Midas"
-- AND total24h = 0
AND `status` = 1 
	AND depllist = 0
	AND minerver ='unkown'
GROUP BY manage_name
;




SELECT
	`id`,
	`one_level_name`,
	`two_level_name`,
	`manage_name`,
	`public_ip`,
	`pingpai`,
	'' as '备注',
	'' as '状态',
	'' as '客户解决',
	`group_name`,
	`minerver`, `minerstat`,ver,total24h,
	`ip`,
	grpcfaild,
	`remark`,
	loratm,
	DATE_SUB(loratm, INTERVAL 540 MINUTE),
	DATE_SUB(loratm, INTERVAL 480 MINUTE),
	now(),
	witnesstm,
	muxtm,
	update_time,
	`address`,Hex
-- 	,DATE_SUB(loratm, INTERVAL 480 MINUTE),DATE_SUB(NOW(), INTERVAL 60 MINUTE)
	
FROM
	business_device 
WHERE
1=1
-- AND (one_level_name LIKE "%明%" or one_level_name LIKE "%李宛枫%" )
-- AND pingpai = "Midas"
-- AND total24h = 0
AND `status` = 1 
	AND depllist = 0
-- 	AND minerver ='unkown'
-- 	ORDER BY grpcfaild desc 
;
