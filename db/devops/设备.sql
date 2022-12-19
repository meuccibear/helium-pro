-- 客户品牌
SELECT
	pingpai
FROM
	business_device 
	WHERE
	1 = 1
	AND one_level_name LIKE "%明%"
	AND manage_name = '183.194.69.182'
	GROUP BY pingpai;

-- 低收益
SELECT
	one_level_name,
	two_level_name,
	manage_name,
	group_name,
	public_ip,
	IP,
	pingpai
FROM
	business_device 
WHERE
	1 = 1
-- 	AND one_level_name LIKE "%明%"
-- 	AND one_level_name LIKE "%李宛枫%"
-- 	AND manage_name = '183.194.69.182'
	AND depllist = 0 ;

SELECT 
*
-- address,ip,public_ip
FROM business_device 
WHERE
1=1
	AND one_level_name = '陈益明' 
	AND `status` = 1 AND depllist = 0 
	AND address in ("1126nQBWiu3CS5sfkKWzwGg1NU8ynbGphGuEHgDJiyEXYNRr97bQ"
);
