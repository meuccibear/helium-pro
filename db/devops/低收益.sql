-- 低收益
SELECT-- 	country,
-- 	city,
one_level_name,
two_level_name,
'' cj,
'' cname,
total24h,
'' newTotal24h,
`online`,
country,
city,
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
'' AS '30h',
'' AS '30h',
'' AS '30h',
address,
`owner`
FROM
	business_device 
	WHERE-- 	two_level_name = "汤总21" 
-- 	one_level_name like "%何%"
-- 	one_level_name LIKE "%明%" 
	one_level_name LIKE "%李宛枫%"
	AND total24h = 0 
	AND manage_name IS NOT NULL
		AND depllist = 0 
	-- two_level_name = "山东黄总1" 
-- 	and two_level_name != "山东黄总1" 
-- 	and two_level_name != "陶总2" 
-- 	AND total24h = 0
	
	 
	 -- 	AND total24h < 0.1  
-- 	AND
-- 	address = '112W1UsXz2wZNbyHVCHmutAAMDRxJD56RryTfJcAHDhnpHxyJKoS'  
-- 	AND disk = 100  
-- 	AND height = 0
-- 	 city = 'Tallahassee Florida'
	AND depllist = 0 
	AND `status` = 1 
-- 	AND address NOT IN (
-- 		'111NoNVhNfaymDtzJSP78qV9kvdgsUDHVPH1bhd6vGSG6JFoqxG',
-- 		'11TweWkWF6spqwCgrwJQ5FKfAWPryAoGavDKn6ZwFtadyj8YYs8',
-- 		'11gg3eLpHugdva88K1hTnBi11ugMbkWqQpZ5BuNe17hkW4qw7se',
-- 		'112SjNLMhUSPuw1hJJZNhCNdhKcqSQvNoyYGw1fuvYLpXF1V767v',
-- 		'11JwfjwKG5AttgPhzAi6m39Va5neuphYTy9d4wVoUMekAkhsVQG',
-- 		'112p4z2Djzdki4Fqhu2i2XXkJSDiXdKEEmgNvrb4EvddKEKfnoFB',
-- 		'1126ARDbJvcnuiS1nVfpUFE94nsSBhvjXjqnoLn5Y9thP7jxt3Zi',
-- 		'1125o7FRU7QpamH6VQn9bDsj2oXb4aMn6q1xUPT9KE1B3ad8QpxL',
-- 		'11bb9XYseyk31PPjhnY49mPyMA65fBJLNdppttnvorGm4mwRgcm',
-- 		'112cAAmYxKs88DWaz5evcdEgEsekajqiUxvubGrKH26ZPMRvmkZ',
-- 		'112dQqiznS4QU8vdvKQgQemxz1BSNvoLCABks11LDQpABLphwBNx',
-- 		'11uxz5RocwUGAXZ8jxWVzRQqhvsw4X4vbYVHpz9oRZukzKBvYG1',
-- 		'11fU5uisd3Vnf8ruzfBDZod8MwGaxfdLphtWMsyjeAVdXEZbHZ7',
-- 		'11nabKzxNAi6SvAuSxwPs3TW6CgoShph4SiphbXu5X1N8xR9uqj',
-- 		'117gXYyXGzP8fgAraeLESRiLcf6TvssjSehvvJP87G3bFvcedNJ',
-- 		'112L1ybv56ajpSdnbvGrDYy337WDaPAg36HvvKY3KhoaE4aLtjxi',
-- 		'11VKRz2FJEUR1mf3j47KQMcBW4HMHh5Y9hg6Br5jgFWLvuaGY9A',
-- 		'112FQZmGzHPLoVG8oWL2aMkFU8w8TMYTmvUt32SxoDoQ4d3sMgrU' 
-- 	) 
	ORDER BY-- manage_name,
	two_level_name,
	group_name,
	total24h;