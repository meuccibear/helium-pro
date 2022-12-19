-- 磁盘检测
SELECT-- 	country,
-- 	city,
one_level_name,
address,
`owner`,
'' cj,
'' cname,
total24h,
'' newTotal24h,
height,
`online`,
scale,
loratm,
hex,
'' AS Helium,
'' AS 备注,
manage_name,
group_name,
two_level_name,
public_ip,
disk,
'' AS '30h' 
FROM
	business_device 
	WHERE
	1 = 1 
	 -- 	AND total24h < 0.1 
	AND disk = 100  AND depllist = 0 AND `status` = 1 
	ORDER BY
	manage_name,
	two_level_name,
	group_name,
	total24h;