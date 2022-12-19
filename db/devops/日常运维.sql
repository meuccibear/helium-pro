-- TRUNCATE TABLE data_http
-- TRUNCATE TABLE business_log
-- TRUNCATE TABLE schedule_job_log

-- TRUNCATE TABLE business_device_lzz
-- TRUNCATE TABLE business_device

SELECT
	two_level_name,
	public_ip,
	'' as 备注,
	manage_name,
	group_name,
	'' cj,
	'' cname,
	total24h,
	'' newTotal24h,
	height,
	disk,
	`online`,
	country,
	scale,
	loratm,
	hex,
	'' as Helium,
	address
FROM
	business_device 
WHERE
-- 	two_level_name = "汤总21" 
-- 	one_level_name like "%何%" 
-- 	one_level_name like "%明%" 
-- 	and two_level_name != "汤总22" 
-- 	and manage_name != "183.195.174.174" 
-- two_level_name = "山东黄总1" 
-- 	and two_level_name != "山东黄总1" 
-- 	and two_level_name = "李总2" 
-- 	and two_level_name != "陶总2" 
	AND total24h = 0  
-- 	AND
-- 	address = '112W1UsXz2wZNbyHVCHmutAAMDRxJD56RryTfJcAHDhnpHxyJKoS'  
	AND depllist = 0  
-- 	AND manage_name  is not null 
-- 	AND height = 0  
	AND `status` = 1
ORDER BY
-- manage_name,
	total24h desc ,
	two_level_name;
	
	
	
-- UPDATE `business_device` SET `status` = 2 WHERE
-- `address` in ('11YYekhomYssfk2856BbtSMVrymnHtPU7XmXDrpdNGwQS3Q69aG')
-- ;

	SELECT
	one_level_name,
	two_level_name,
	public_ip,
	manage_name,
	group_name,
	'' cj,
	total24h,
	'' newTotal24h,
	height,
	disk,
	`online`,
	country,
	city,
	scale,
	loratm,
	hex,
	'' as Helium,
	'' as 备注,
	address
FROM
	business_device 
WHERE  address in (
'11McKGXJqBcHD4WWHSQdp98M6biCTmEoB9sovTrh3J646BGH8ed');

-- two_level_name='汤总14'
-- AND `country` = 'Turkey' AND `city` = ' Antalya '
-- 	address in ('112cLy6BA3QN1nMj4TFzzymX2KrZvmbDfZncMrCysXJzVfWyQvP5'
-- ,'112F2aGCF8stnoYmZsQ7gDhcc3L5H53aFqX6SnUKfGy3Yg2vYhWr'
-- ,'11VR1dH9YEYfudjvk1x4UkgGa1cyYZ4boQxJK9r4uzxTJPdFkXq'
-- ,'1129gN4kBrEjWgrxXRc51GoeAjzBsKkr7NtVq9kED7YThH4W6a7Z'
-- ,'112BXoBGGnCDiVAonwmhkbLvbhRJK7N3hTweaHWRtbsbPPgVWr7p'
-- ,'115gc3wbp3CnFkS5iqP5MtQKF6PdzqwxpaJ15psWu1c6oguSR7J'
-- ,'112CGvwFoLe2biM21uF6NXUhAQeCRzS5rakXGW4vRyKHcdWNS5qf'
-- ,'11qmtGMBs5xAxXM3VMiunRBTmFWKXrMQaFxQpQT1p9bkVMWQws'
-- ,'11gajvrEBThURLuw9roA4uai8fbfgr85d4wasAMuo5daqde7hQ2'
-- ,'112dQqiznS4QU8vdvKQgQemxz1BSNvoLCABks11LDQpABLphwBNx'
-- ,'11nabKzxNAi6SvAuSxwPs3TW6CgoShph4SiphbXu5X1N8xR9uqj'
-- ,'112L1ybv56ajpSdnbvGrDYy337WDaPAg36HvvKY3KhoaE4aLtjxi'
-- ,'11nicwZKUvWsuxnSYCpFbfSZHdffKccUqXgFfTjjhwQ2anBjjGD'
-- ,'11bDJ89TRWCqVuV2DQznak7t2zkJDtCNgVMvumVc3KU2RPzf4Aq'
-- ,'11UBetMJoYADwAHo2SpYmu6nX985boNbELKUkRWG7wgdNzNhZg4'
-- ,'112FbGzBNZ6RWtdxbkdpqs1MFwXey3RA4tQtoh9SMUYPJtyE7LiU'
-- 
-- )
-- 
-- 
-- hex in ('881949a401fffff','881949a40dfffff','881949a405fffff','881949a407fffff','881949a403fffff','881949a40bfffff','881949a409fffff','881949a461fffff','881949a46dfffff','881949a465fffff','881949a467fffff','881949a463fffff','881949a46bfffff','881949a469fffff','881949a421fffff','881949a42dfffff','881949a425fffff','881949a427fffff','881949a423fffff','881949a42bfffff','881949a429fffff','881949a431fffff','881949a43dfffff','881949a435fffff','881949a437fffff','881949a433fffff','881949a43bfffff','881949a439fffff','881949a411fffff','881949a41dfffff','881949a415fffff','881949a417fffff','881949a413fffff','881949a41bfffff','881949a419fffff','881949a451fffff','881949a45dfffff','881949a455fffff','881949a457fffff','881949a453fffff','881949a45bfffff','881949a459fffff','881949a441fffff','881949a44dfffff','881949a445fffff','881949a447fffff','881949a443fffff','881949a44bfffff','881949a449fffff','881949a701fffff','881949a70dfffff','881949a705fffff','881949a707fffff','881949a703fffff','881949a70bfffff','881949a709fffff','881949a761fffff','881949a76dfffff','881949a765fffff','881949a767fffff','881949a763fffff','881949a76bfffff','881949a769fffff','881949a721fffff','881949a72dfffff','881949a725fffff','881949a727fffff','881949a723fffff','881949a72bfffff','881949a729fffff','881949a731fffff','881949a73dfffff','881949a735fffff','881949a737fffff','881949a733fffff','881949a73bfffff','881949a739fffff','881949a711fffff','881949a71dfffff','881949a715fffff','881949a717fffff','881949a713fffff','881949a71bfffff','881949a719fffff','881949a751fffff','881949a75dfffff','881949a755fffff','881949a757fffff','881949a753fffff','881949a75bfffff','881949a759fffff','881949a741fffff','881949a74dfffff','881949a745fffff','881949a747fffff','881949a743fffff','881949a74bfffff','881949a749fffff','881949a501fffff','881949a50dfffff','881949a505fffff','881949a507fffff','881949a503fffff','881949a50bfffff','881949a509fffff','881949a561fffff','881949a56dfffff','881949a565fffff','881949a567fffff','881949a563fffff','881949a56bfffff','881949a569fffff','881949a521fffff','881949a52dfffff','881949a525fffff','881949a527fffff','881949a523fffff','881949a52bfffff','881949a529fffff','881949a531fffff','881949a53dfffff','881949a535fffff','881949a537fffff','881949a533fffff','881949a53bfffff','881949a539fffff','881949a511fffff','881949a51dfffff','881949a515fffff','881949a517fffff','881949a513fffff','881949a51bfffff','881949a519fffff','881949a551fffff','881949a55dfffff','881949a555fffff','881949a557fffff','881949a553fffff','881949a55bfffff','881949a559fffff','881949a541fffff','881949a54dfffff','881949a545fffff','881949a547fffff','881949a543fffff','881949a54bfffff','881949a549fffff','881949a581fffff','881949a58dfffff','881949a585fffff','881949a587fffff','881949a583fffff','881949a58bfffff','881949a589fffff','881949a5e1fffff','881949a5edfffff','881949a5e5fffff','881949a5e7fffff','881949a5e3fffff','881949a5ebfffff','881949a5e9fffff','881949a5a1fffff','881949a5adfffff','881949a5a5fffff','881949a5a7fffff','881949a5a3fffff','881949a5abfffff','881949a5a9fffff','881949a5b1fffff','881949a5bdfffff','881949a5b5fffff','881949a5b7fffff','881949a5b3fffff','881949a5bbfffff','881949a5b9fffff','881949a591fffff','881949a59dfffff','881949a595fffff','881949a597fffff','881949a593fffff','881949a59bfffff','881949a599fffff','881949a5d1fffff','881949a5ddfffff','881949a5d5fffff','881949a5d7fffff','881949a5d3fffff','881949a5dbfffff','881949a5d9fffff','881949a5c1fffff','881949a5cdfffff','881949a5c5fffff','881949a5c7fffff','881949a5c3fffff','881949a5cbfffff','881949a5c9fffff','881949a481fffff','881949a48dfffff','881949a485fffff','881949a487fffff','881949a483fffff','881949a48bfffff','881949a489fffff','881949a4e1fffff','881949a4edfffff','881949a4e5fffff','881949a4e7fffff','881949a4e3fffff','881949a4ebfffff','881949a4e9fffff','881949a4a1fffff','881949a4adfffff','881949a4a5fffff','881949a4a7fffff','881949a4a3fffff','881949a4abfffff','881949a4a9fffff','881949a4b1fffff','881949a4bdfffff','881949a4b5fffff','881949a4b7fffff','881949a4b3fffff','881949a4bbfffff','881949a4b9fffff','881949a491fffff','881949a49dfffff','881949a495fffff','881949a497fffff','881949a493fffff','881949a49bfffff','881949a499fffff','881949a4d1fffff','881949a4ddfffff','881949a4d5fffff','881949a4d7fffff','881949a4d3fffff','881949a4dbfffff','881949a4d9fffff','881949a4c1fffff','881949a4cdfffff','881949a4c5fffff','881949a4c7fffff','881949a4c3fffff','881949a4cbfffff','881949a4c9fffff','881949a681fffff','881949a68dfffff','881949a685fffff','881949a687fffff','881949a683fffff','881949a68bfffff','881949a689fffff','881949a6e1fffff','881949a6edfffff','881949a6e5fffff','881949a6e7fffff','881949a6e3fffff','881949a6ebfffff','881949a6e9fffff','881949a6a1fffff','881949a6adfffff','881949a6a5fffff','881949a6a7fffff','881949a6a3fffff','881949a6abfffff','881949a6a9fffff','881949a6b1fffff','881949a6bdfffff','881949a6b5fffff','881949a6b7fffff','881949a6b3fffff','881949a6bbfffff','881949a6b9fffff','881949a691fffff','881949a69dfffff','881949a695fffff','881949a697fffff','881949a693fffff','881949a69bfffff','881949a699fffff','881949a6d1fffff','881949a6ddfffff','881949a6d5fffff','881949a6d7fffff','881949a6d3fffff','881949a6dbfffff','881949a6d9fffff','881949a6c1fffff','881949a6cdfffff','881949a6c5fffff','881949a6c7fffff','881949a6c3fffff','881949a6cbfffff','881949a6c9fffff','881949a601fffff','881949a60dfffff','881949a605fffff','881949a607fffff','881949a603fffff','881949a60bfffff','881949a609fffff','881949a661fffff','881949a66dfffff','881949a665fffff','881949a667fffff','881949a663fffff','881949a66bfffff','881949a669fffff','881949a621fffff','881949a62dfffff','881949a625fffff','881949a627fffff','881949a623fffff','881949a62bfffff','881949a629fffff','881949a631fffff','881949a63dfffff','881949a635fffff','881949a637fffff','881949a633fffff','881949a63bfffff','881949a639fffff','881949a611fffff','881949a61dfffff','881949a615fffff','881949a617fffff','881949a613fffff','881949a61bfffff','881949a619fffff','881949a651fffff','881949a65dfffff','881949a655fffff','881949a657fffff','881949a653fffff','881949a65bfffff','881949a659fffff','881949a641fffff','881949a64dfffff','881949a645fffff','881949a647fffff','881949a643fffff','881949a64bfffff','881949a649fffff')

ORDER BY loratm 
;





-- 山东黄总1 刚上
-- 朱光2 192.168.11.109 192.168.11.101

-- 查询收益最高的 
SELECT two_level_name, gap, disk, public_ip, group_name, total24h, `online`, hex, country, depllist, scale, loratm, date, manage_name, address FROM business_device ORDER BY total24h desc, two_level_name limit 100;



SELECT two_level_name, gap, disk, public_ip, group_name, total24h, `online`, hex, country, depllist, scale, loratm, date, manage_name, address FROM business_device 
WHERE group_name = 'United States' 
ORDER BY total24h desc, two_level_name ;

-- 条件查询
SELECT two_level_name, gap, disk, public_ip, group_name, total24h, `online`, hex, country, depllist, scale, loratm, date, manage_name, address FROM business_device 
WHERE depllist = 0 AND group_name = 'United States' 
ORDER BY total24h desc, two_level_name ;




UPDATE business_device
SET `id` = 1,
`one_level_name` = '',
`two_level_name` = '',
`manage_name` = '',
`group_name` = '',
`name` = ''


-- `en` = 'cd_cxy',
-- `pingpai` = 'PantherX',
-- `public_ip` = '172.16.11.10',
-- `mac` = NULL,
-- `name` = 'clever fuzzy nuthatch',
-- `address` = '11nYuYc88J5vq1eXoch3L4Gafig229B6qdT4gDJEmPXEiEqtSJu',
-- `owner` = '13BXNbXMQwEzUgehCgnmbo5NRMNXjy2ADwQPBFmTbvWUFcBjFnT',
-- `disk` = NULL,
-- `total24h` = 0.2680,
-- `total7d` = NULL,
-- `total30d` = NULL,
-- `online` = 'online',
-- `country` = 'China',
-- `city` = 'Suzhou Jiangsu',
-- `street` = 'Xiangcheng',
-- `depllist` = 0,
-- `scale` = 1.00,
-- `Hex` = '883098c725fffff',
-- `Hex5` = NULL,
-- `active_time` = NULL,
-- `location_address` = NULL,
-- `date` = NULL,
-- `re` = NULL,
-- `ip` = NULL,
-- `devtype` = NULL,
-- `loratm` = NULL,
-- `witnesstm` = NULL,
-- `muxtm` = NULL,
-- `minerver` = NULL,
-- `minerstat` = NULL,
-- `ver` = NULL,
-- `grpcfaild` = NULL,
-- `beacontm` = NULL,
-- `import_data_time` = '2022-08-16 13:11:41',
-- `update_status_time` = NULL,
-- `hearttm` = NULL,
-- `status` = 1,
-- `err_status` = 1,
-- `update_time` = '2022-08-17 12:03:18',
-- `remark` = NULL 
WHERE
1=1
-- 	`id` = 1 
-- 	AND `one_level_name` = '程小燕' 
-- 	AND `two_level_name` IS NULL 
-- 	AND `en` = 'cd_cxy' 
-- 	AND `manage_name` IS NULL 
-- 	AND `group_name` = '成都-程总1' 
-- 	AND `pingpai` = 'PantherX' 
-- 	AND `public_ip` = '172.16.11.10' 
-- 	AND `mac` IS NULL 
-- 	AND `name` = 'clever fuzzy nuthatch' 
-- 	AND `address` = '11nYuYc88J5vq1eXoch3L4Gafig229B6qdT4gDJEmPXEiEqtSJu' 
-- 	AND `owner` = '13BXNbXMQwEzUgehCgnmbo5NRMNXjy2ADwQPBFmTbvWUFcBjFnT' 
-- 	AND `disk` IS NULL 
-- 	AND `total24h` = 0.2680 
-- 	AND `total7d` IS NULL 
-- 	AND `total30d` IS NULL 
-- 	AND `online` = 'online' 
-- 	AND `country` = 'China' 
-- 	AND `city` = 'Suzhou Jiangsu' 
-- 	AND `street` = 'Xiangcheng' 
-- 	AND `depllist` = 0 
-- 	AND `scale` = 1.00 
-- 	AND `Hex` = '883098c725fffff' 
-- 	AND `Hex5` IS NULL 
-- 	AND `active_time` IS NULL 
-- 	AND `location_address` IS NULL 
-- 	AND `date` IS NULL 
-- 	AND `re` IS NULL 
-- 	AND `ip` IS NULL 
-- 	AND `devtype` IS NULL 
-- 	AND `loratm` IS NULL 
-- 	AND `witnesstm` IS NULL 
-- 	AND `muxtm` IS NULL 
-- 	AND `minerver` IS NULL 
-- 	AND `minerstat` IS NULL 
-- 	AND `ver` IS NULL 
-- 	AND `grpcfaild` IS NULL 
-- 	AND `beacontm` IS NULL 
-- 	AND `import_data_time` = Cast(
-- 	'2022-08-16 13:11:41' AS BINARY ( 19 )) 
-- 	AND `update_status_time` IS NULL 
-- 	AND `hearttm` IS NULL 
-- 	AND `status` = 1 
-- 	AND `err_status` = 1 
-- 	AND `update_time` = Cast(
-- 	'2022-08-17 12:03:18' AS BINARY ( 19 )) 
-- 	AND `remark` IS NULL 
-- 	LIMIT 1
;
SELECT
	* 
FROM
	business_device;


