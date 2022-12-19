


-- 设备

-- SELECT
-- `address`,
-- one_level_name,
-- -- `owner`,
-- manage_name,
-- public_ip,
-- two_level_name,
-- group_name,
-- disk,
-- pingpai,
-- -- height,
-- loratm,
-- total24h,
-- `owner`
-- FROM
-- 	business_device 
-- 	WHERE
-- 	(one_level_name LIKE "%明%" 
-- 	or one_level_name LIKE "%李宛枫%" )
-- -- 	AND total24h = 0 
-- 	AND manage_name IS NOT NULL
-- -- 	and pingpai="eda"
-- -- 	and address = '112L13oMKkf8mvQE4Sy4SNrtch5GaP89DGq5m2UoxDVwHaMP5QPH'
-- 	AND `status` = 1 
-- 	AND depllist = 0
-- 	ORDER BY-- manage_name,
-- 	two_level_name,
-- 	group_name,
-- 	total24h;
	
-- 设备1


SELECT
`address`,
one_level_name,
two_level_name,
-- `owner`,
manage_name,
public_ip,
IP,
two_level_name,
group_name,
disk,
pingpai,
loratm,
total24h,
`owner`
FROM
	business_device 
	WHERE
	(one_level_name LIKE "%明%" or one_level_name LIKE "%李宛枫%" )
-- 	one_level_name LIKE "%明%" 
	AND total24h = 0 
	AND manage_name IS NOT NULL
-- 	and pingpai="eda"
-- 	and address = '112L13oMKkf8mvQE4Sy4SNrtch5GaP89DGq5m2UoxDVwHaMP5QPH'
	AND `status` = 1 
	AND depllist = 0
	ORDER BY-- manage_name,
	two_level_name,
	group_name,
	total24h;
-- 	
-- 	
-- 	SELECT
-- `address`,
-- one_level_name,
-- two_level_name,
-- -- `owner`,
-- manage_name,
-- public_ip,
-- two_level_name,
-- group_name,
-- disk,
-- pingpai,
-- loratm,
-- total24h,
-- `owner`
-- FROM
-- 	business_device 
-- 	WHERE
-- 	1=1
-- -- manage_name = '117.185.91.78'
-- -- AND public_ip in ("192.168.1.116")
-- 	ORDER BY-- manage_name,
-- 	two_level_name,
-- 	group_name,
-- 	total24h;
-- 	