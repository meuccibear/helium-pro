-- INSERT INTO ``
-- INSERT INTO `business_device`

-- `manage_name`, `public_ip`, `pingpai`, `address`
-- `ms_host`, `host`, `payer`, `alias`


-- ``(`one_level_name`, `two_level_name`, `manage_name`, `public_ip`, `pingpai`, `address`)
-- `business_device`(`one_level_name`, `two_level_name`, `ms_host`, `host`, `payer`, `alias`)

-- SELECT * FROM business_device WHERE address = "1125xqFcQVUcM7CDhNqhgjTxvyD6fVAMz8nNMX2pgQgu1da48Jdw" ;
-- SELECT * FROM business_device WHERE address = "11ErknsbocztDnJC9BcHpFB7tiMPfTQ1JW3uYWrkSP786iRzCN2" ;
-- SELECT * FROM business_device WHERE address = "112f9ygbPWBR7kpk5cmcYcMM2HeTS9xJLSNfGtyvhD6H2zt5ZR2o" AND depllist = 0;
-- SELECT * FROM business_device WHERE manage_name = "167.114.49.123";

-- 192.168.0.58	Midas	11aqzvMZqu8Eeg9KDQwQFPUmqctQV6LRCiiWT3YpWaKvHN9ArwC
-- 192.168.0.60	Midas	112ExfgbxyHcKhSDu5bhvPHwzZMK4LPgVNHW2th98YY8yt6YLj8F
-- 192.168.0.89	Midas	11S8oCdpuHLHmhS1CHpVaXrMSwJ6TzeXakZ7sUyxciToPcrZVD1


SELECT
	`one_level_name`,
	`two_level_name`,
	manage_name `ms_host`,
	public_ip `host`,
-- 	ip `host`,
	pingpai `payer`,
	`address` as alias
-- 	,group_name
-- 	, grpcfaild
-- 	, hex5
-- 	,`total24h`
FROM
	business_device 
WHERE
	1 = 1 
-- 	AND total24h < 0.1
	AND total24h = 0 
	AND `status` = 1 
	AND depllist = 0 
	AND one_level_name = "陈益明"
	AND two_level_name != '朱强1' AND two_level_name != '朱强2'
	AND two_level_name != '山东黄总1'
-- 	AND two_level_name != '汤总8'
	AND two_level_name not like '%宁波%'
	AND two_level_name not like '%刘1%'
-- 	AND two_level_name not like '%黑转白%'
-- 	AND two_level_name !="加拿大"
	AND address not in ("11SHLbxErUgm8AAiN3fTiK6PgTLqHSfaQxkNoFsCy3zVUjuic72","11xmCyN3bV1559HRsKXQexJAJwwQv9woXSdhrQEyauMdFFYkvKs","112Qw5ZNPsMUD34w19BSsKfhwvxX6mMs7msR2vyQrdQ5MhXosJ8g","1125fpkPeAiojWvkjS2usqS4YKWdtzahgRtNAvpNx7QNTUzxrrN7","11v9E453i1VdxqXMkHFpiqgVSxhGsoxJTg9SAm6S9w43VZS2ire","112SjNLMhUSPuw1hJJZNhCNdhKcqSQvNoyYGw1fuvYLpXF1V767v","112p4z2Djzdki4Fqhu2i2XXkJSDiXdKEEmgNvrb4EvddKEKfnoFB","112T6jZ5ZG1twtNVu24eULj1rGuEKpGgxyALMFYyZM5hwCn19LTk","112LWbuDrMh1ojeWcrESQ5ZY5gVxba8T1bRs9jnA2os8gDSkV7n","111NoNVhNfaymDtzJSP78qV9kvdgsUDHVPH1bhd6vGSG6JFoqxG","11y3xUiGgTXgwdHoXtDSVkpA7MRBvfFdQDHPWma8trPhtZgw92Q","112ZTwWnh8GCbzdikhpTunaNskx4PUH1JL4J79nFTHnuD1XnQuKL","115ZWMLgQz24wtf9ib2QhpopueHc3vkH6uvV3iDXuUi68x5RJ2j","11czaRRfq4vf2p4oMfSZY28njGdATNLjnbK8LVXYWXUE7Q1nUz8","112WPHhfP24sZFqb65ZdazZj93cdFtdLjrTA5duyQ5jGdh6oHTNv","117av4NaAcPdQesmnUmJXNbWT64tvHY8TqwQLBaPan7WEM1jpMy","11WWSp5vFXidFvxVDNqAJdRnBcfm5WCevx1xkorT3o8oBPMAMzV","11eNwjcdyF8sXkhCfFRwMfQjhaTwYM7Wmo8a2PHX55am7nPJ1oe","11cjqHCnjCGy3azSd3d2SMsKfLARp1LpopQYAydyQrHEthZPyBe","11HKJqLA5YRiKoiy6UgMCVXK9PLwYN5BhCwaB6Auq5EaeTEqkUM","11sh63St4mcAtZHWBkPfdoV4HJMNQo9hvcJUXoj19PyJyisyVUi","112mS5aHp9ebvA8kgH6tjyanVqnhzT7E5dQ4u2WJE9APwkXmp2te","112A2r1WtZvYJc4yY1ALQDQHywTV4t8rB8eTPXCeVigLwmDEjZ2H","112ry5g2mxej4CenC7VLGtNTGHqPvu47EeExP6rtY7uAQQvbejzT","11Tpho6fttMLKKNQgfbrzuQWJJLFFsCTqqGMKwdf9uKbbxKL6SZ","1157kBEFrRNbiBQttNey2sVEjJYm1WqhxhMpfvf8uHfmDniFhXo","11JAAckJ6P3pvJjRgaftg3ThJK3b8kiztNZpKMn8wCWcdv5MNk4","112NGsPdQnZvSV9shDiYGuVtvDUXRkM63FWdH66gw9m3UjSSe9kx","112h55pyJfjQ3s8Ho1M1ByH43BW2U6VxqCWm9WkBeP7jt4f9dz8V","11BAjT2xz53rAfQPmyt9tKK6AQ6Mudxst1y7UypJ3YxruUYG2Xw","112T1ExyyUDjyFQWJAKm6qm17WGTE1uhJqdDFTZysjo8xTseH31c","112eifG7ZKkcY2tSurZEwmMCBbTZHG95MtznX4YGpL233KcbsGKC","112mDFwHrY2ZZvxzSUdvUpd4fitnH7wUYT43L7ZULbBG9FkE39Ep","1123DM32mDQdaSyGocFgciHCtyBEVLSHB6h6tuVBQAnt84pCKD4R","11UaBxJWJEFcQaCRgk4GWUYoHiCvsRtMptcSWEEsYkGY6aaRmo2","112NKVw8XMFQsjwAv2KfTJRfiphBhnzWLrF4ac7WT4E5R59XpmZo","11j17gSMg8HymgbUV29tbsL7ceEXj8yvHagjgwDWmoXahwwwP2z","11MrSN7gfsBET9RKm74SNxB4WoPXJ6wADacGHSgSV6pzt2M2fMX","112pEZq52RyeicJWJrrywweAj3sF8QdxGpvQq65QQcKzNVzXxjVi","112Le7pvswjN2ELQL57Fa3UwNa7xeSPG6jkzwTLj6XdfXpbkLN4N","115FgMxxbdrRceZfzsoFwy6DSZtirkH583mrVUT1bFKy3qE5g1b","112gpdMte8RqfaeAE2wmKZe4r4VMvFFj8UUTznQA1PT2Tp9TLc4C","11nNRV3pZiwXp1Q1Y5iGuGTCoFwZjWGwwowdN73f627kN2Ncdex","114bdABPacQjdoDJhGhFp43vVPfYgTvsFKgrEKgGSMK9uhRNbXe","112mperSFU2MFZq4JAA8yUeek48XgjFofpbAWC212JMppQjEnHZN","112Eq1AcVXaEQBU4rmQxUzKWajHyPCpCVcEk3dCgt64t69qVSeWa","11pTAt9tj79SMi8cp22taF5YeXCrfnpKCVoUg7969NThiMATdiB","11KhPge8gDLAap9zuGw1mSzfPUZPCyye8ADaPcQVdp7DfRD5kyd","112ChDomJvHKxtwYZicCtKuPdJqzbXYSVnJHi9o3Mff8H87weQhN","112FosCaqynGzBpr4suaeFff7es8PTMxadUuksRccFaVjUhftVYv","112RcMGZeHfDmqc6g7zvBP8Uo4TEj2smwfLuCbUNjoTjvCKha8Xp","11ZHjH3YQUbcw9WWu5d5RNfs5vp9xeYNSuZeSADbJfTT7p5h7ry","112wPYJ36n6qyFKD7y7mpzCWs6X6DbABnu9VUZtQSeZcmr4pdMGL","112NQUoTamcvLKnU9C5BLLZRMGa93jFNCuYvAuVF4vGNB11BsNeP","117os5DZ52G2SdDxPt3wZPkcd48tPSMwQt3ShpFQQYrYXY5tB6E","11GbSsqe8GJnt3fPhTbW4vuh8xgUtgESUWSwPWUhzZShfyHxDCm","11Rsp6Ljjbb7szvtbcCb9Zy7cRJbXGYpsY5DB2qUMVMP7M6d4VM","1125DYf1j9kRZP63yu8wAs9PNKzmCseUE9XU3T1Zuw7Vq7eFdrpp"

,"11jAyTHdJ1QidQxUj66tYhtV658QhsGCLGeG1eg54ipjPnanJXE","11SP391otXmnijxvXhtwLTBWJcCkzHQt6tP8zxshLcgVvoWwkbL","112M8x2B2mzqt2X3xmNESn3dk3kL8vakzsqcp3SVHqhJc6trv7Aj","1129z1JwLAVtiTmREVNWgovxBBrhiRQdebKndyX3vHNFQn6MFenG","11X8wMLa26CrWLACbDga48yJyHh5xhcyvs8ASXWtJxtvRJciXLC","11nfxNujYYE6Jtp9jroH7pmwfK1MgS6AaxKug8aYUCQY7jCBGZF","112Bq2j1kYBcQ1DyGSihBQUW6ynQ6pgoMzvsxMVzQUXqax14N5r7","11rgAuNaPQ4ffJdEHsC5asitLgXXFrSozrZjX3mwpSRj5rYw7MU","112RQocm4VLvJNxNuzbV7QJiirh3oDWHtEyJSH6ffS3JzxaCc5Uk","11264tzdGTkxVkZYQnSQnNpu6q3TNp74AUSaqRnCRgbCV8jDv674","11vyjWCnb6TvkJCDChbBkreKm6BmYDZfefJmKdZ3uMtAkRYBTqL","11vh3tmDa2KmcUc2pryin1QQANY457ZqagiQ2kcSNVPnyxDtQt5","112nj1FWkBky2rZr9CXmK3e8UY74UPevRRe2rnMqEaTvpey3hX8i","112gHFMTKT6kK6EmZeibupWrnt2URkJdyTXmbKJNnnvSar1UKNDn","11f2U9MbrKrp9c3y442yz3ah7pfDhPW4oqWCoKX4Neh2c1LHh4i","112KywUSieCVHRQU26AvvXPudyjcsiN4HRRRhM5Mgtgt5Wv1HNE1","11xmCyN3bV1559HRsKXQexJAJwwQv9woXSdhrQEyauMdFFYkvKs","1125fpkPeAiojWvkjS2usqS4YKWdtzahgRtNAvpNx7QNTUzxrrN7","112LBQCJrdBjSVBDijZchoqEg3BM3om12rXP8hQsDWBoB4CCNg8N","112VUzHh7pwx7R9pwzf8wXdpHecMHtSkNhPoSJVTZe5tjJqUZ91P","11mkXpQhLqF6zTGmuqoaByDGaNmk2TTs65WRS5jByWVX6j7YMwJ","114tcKyaEQRJW5okXes3sjd3xUNWZ2kUYweW5Z2uSdA9z8swoNt","11sT9W37qE5NEsQ6VKTa6i7R5H6t7DvSK65zA7vdXypQML1vh8e","112mUDgHMtowx5Scqo35oMtpVbVwtiF3VBSpr9G5NCGmN2TqooCG","11ANe7i1ycZgQ34KUmn7fudq5qxXiaBXiovaXJaKPLBEdfSEUhM","11mUKuau3R2qxx43KtXWtVHcoKgJpDnEj8HBFwM3LFp58JFsehr","11nEZ8pDLrifmPSgKVvTNXqqBF47tmwQKb3Tr2e585WdQyb8GsC","11HMhEdWdMxwQkwR8XKqTxsjx9PGZhZhS5NTnicuwtWD4X6DsMV","11DFtrG3YkgSkp85uRKchscTVK2bzVLUxgpv5rFRsC423mkSjcz","11sqArBT3t33EdHYeSfagt1E5dYZPzvyBvjN9avrpkrsYu8nWfQ","11F6v798RUKBW8h4j2pYkCsE3zrSRy1BxdXcNWYM12z3NNxKaBt","112abq1A22VFf6jHydYcDt6kiRmksH2SpYC8sW8wPNQB22NpcL7R","112ghnPJqnCWW7FTWwf6AMdjwv6YNWK4TvtKiLNPGi3sjf1UTsaw","1125E7EwZpHcQPY5kzS3R5NoRiBpMA1wvYkaogbP3fchXnNVAWg7","11hrCtbgE7BAPkL4vWDfkYGu99oGKBrmtWosHERK1iyGAuNCFQe","112NKVw8XMFQsjwAv2KfTJRfiphBhnzWLrF4ac7WT4E5R59XpmZo","117os5DZ52G2SdDxPt3wZPkcd48tPSMwQt3ShpFQQYrYXY5tB6E","11GbSsqe8GJnt3fPhTbW4vuh8xgUtgESUWSwPWUhzZShfyHxDCm","11e3Fqm4yxF1reAoZ95vR2XGTDjmvBKtpebebHHSyoKdA8TkoKW","1124hrr53MfBR1tTsQirviZ1LYXkTs1JWfkmxbwchAhitDzN37fx","11s5CxkJ18v7FFTJ7hXSetX1VD7s1necfwqYyBFPB8ZV88m2iZz","112hiJgP2nhdbNg87xAF5RMfDc8aQbdE9vBk9NKoHMFHVhQBd7fY","11JSrSy1hR8sLJa3HUKZHJPyCopTdCiCyHwBmwAwnDkQtoRAUGa","11ysiWJnireDiey7bezqe5bd2tEUV47Q3aRZgU7xtTkWy5KhZwQ","11KBkDK2657CWp5PRzt5XAG7er5vxe26YG8CAez6fFyzH25XBkF","112RyaPxLQYJ8dBjfZqmictcTvgJJyGiZHnSjwLHaSo6CPJ4vWeQ","11KXPiQL3MvDdrPS2xgxjDyzwDCbb93Yx5evUNd5YWEmJQyJ6Nd","112f5xQkwpaEcyag4ZpYnkxcFRJ6tEmMV3FqQ9biQH5YrAXPF2mE","112wUVPHS6L9CzuEkb4B5swTkLts4QxDQqYwadABb7akxt2aKgBP","112cgmphBBTWyLPP24fiX9Ex1wqRPdEwM1fskjPFPmfUkW1WwdwN","11f7FK49nYhh4AqdLhNuMPHHExWuvZj2ErzTv6YUYNKDMEFn388"
	)
-- 	AND minerver = "unkown";
-- 	AND total24h < 0.1 
-- 	AND one_level_name LIKE "%何%"
-- 	one_level_name LIKE "%明%"
-- 	and pingpai="eda"
-- 	AND ( one_level_name LIKE "%明%" OR one_level_name LIKE "%李宛枫%" )
-- 	AND one_level_name = '张龙' 
-- 	AND manage_name != "112.29.98.233"
-- 	AND one_level_name = '陈益明' AND two_level_name != '朱强2' AND two_level_name != '汤总38-高淳' AND two_level_name !="汤总37-南京"
-- 	AND two_level_name = '汤总40'
-- 	AND two_level_name = '美国15-宁波' AND group_name = '组7'
-- 	AND one_level_name = '陈益明' AND two_level_name = '汤总17'
-- 	AND one_level_name = '陈永波'	AND two_level_name = '毕涛'
-- 	AND one_level_name = '李宛枫'
	ORDER BY-- manage_name,
	two_level_name
,grpcfaild DESC,
	group_name,
	grpcfaild,total24h;
	
	
	
	
	SELECT
	`one_level_name`,
	`two_level_name`,
	manage_name `ms_host`,
	public_ip `host`,
	pingpai `payer`,
	`address` as alias
FROM
	business_device 
WHERE
	1 = 1 
	AND total24h = 0 
-- 	AND manage_name IS NOT NULL 
	AND `status` = 1 
	AND depllist = 0 
	AND one_level_name like '何巨彬'
	ORDER BY-- manage_name,
	two_level_name,
	group_name,
	total24h;

-- UPDATE `business_device` SET `pingpai` = 'MDS' WHERE `address` = '11bVjo8fF323mf93Fc5vQeXA4decyovkGihXxzeyNyPeK588NNg';










	
	