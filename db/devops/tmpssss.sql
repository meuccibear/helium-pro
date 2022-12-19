-- SELECT pingpai,count(pingpai) FROM business_device WHERE pingpai like "%eda%" 
-- AND one_level_name = "陈益明" 
-- -- AND one_level_name = "李宛枫" 
-- GROUP BY pingpai ;

-- SELECT now(),DATE_SUB(NOW(), INTERVAL 540 MINUTE),DATE_ADD(NOW(), INTERVAL 420 MINUTE);

-- SELECT
-- 	`id`,
-- 	`one_level_name`,
-- 	`two_level_name`,
-- 	`manage_name`,
-- 	`public_ip`,
-- 	`pingpai`,
-- 	'' as '备注',
-- 	'' as '状态',
-- 	'' as '客户解决',
-- 	`group_name`,
-- 	`minerver`, `minerstat`,ver,total24h,
-- 	`ip`,
-- 	grpcfaild,
-- 	`remark`,
-- 	DATE_SUB(loratm, INTERVAL 480 MINUTE),
-- 	witnesstm,
-- 	muxtm,
-- 	update_time,
-- 	`address`,
-- 	hex
-- -- 	,DATE_SUB(loratm, INTERVAL 480 MINUTE),DATE_SUB(NOW(), INTERVAL 60 MINUTE)
-- 	
-- FROM
-- 	business_device 
-- WHERE
-- 1=1
-- -- 	remark IS NOT NULL 
-- -- 	AND remark != '' 
-- -- 	AND minerver = 'unkown'   
-- -- AND one_level_name = "陈益明" 
-- -- AND two_level_name != "朱强2" 
-- -- AND two_level_name != "泰国1" 
-- -- AND remark like "%维修%"
-- -- AND two_level_name = "汤总22" 
-- -- AND one_level_name like "%何%" AND two_level_name like "%何%"
-- -- AND two_level_name = "何巨彬2"
-- -- AND two_level_name != "汤总30"
-- AND one_level_name = "李宛枫" 
-- -- AND ver = '2.0' AND minerver = 'miner-arm64_2022.08.02.0_GA'
-- -- AND manage_name in ("106.75.174.251:3021","47.102.43.61:30003","47.102.43.61:30007","47.102.43.61:30008","47.102.43.61:30009","47.102.43.61:30011")
-- -- AND ver = '2.0' AND minerver != 'miner-arm64_2022.08.02.0_GA'
-- -- 50
-- -- AND ver != '2.0'
-- -- 10
-- -- AND DATE_SUB(loratm, INTERVAL 480 MINUTE) < DATE_SUB(NOW(), INTERVAL 60 MINUTE)
-- AND total24h = 0
-- -- 	238-147
-- -- AND address in ("112NGsPdQnZvSV9shDiYGuVtvDUXRkM63FWdH66gw9m3UjSSe9kx","11yr9ib9ANtNpuF4JbtTg1r85a3p4LBtmo93kjUGDQk6BqUQxsf","11by3dYKAQF4yiuAat9AxkKd1BFdupEfvnttAhkxLdhqt52bPwK","11nkL2XPezKSf66ENfGtu7KjSVt5Q3a8RmDPaSV7e6QW77NEAiU","11ArkH28hPeYyQDwBpL4rUhJpa7ix5zVyHQK9w1ou3zWo8h7Q6X","112PJsjmPStWdVNqtMpJvLNtfaHyRaYgCqnJL1y73Fss3oVAWJYL","112YNUNVkhgnwnF6iasgFRyWwB1xohjXwNFePLNTdjDdutZ3kcTX","11mYf5UZ2WsDjVNT8ic8vuxzG3JoDSaw1Dhid3D4dJUb2wKVaDx","11h6bqMM2oHgEoenxd64KYLJ6SYuNvoSUaF7GH9gMKG1wUR3Lbd","11RYivFF3xsSjLjjefTs2rsMuq8puCvDkZdP1T2BY8TV8Gvxftr","112mEj8pL5CLMnWAtVp6GpiNNfmA9hLMCSueVCRSrSndCTiE9ozo","11T4sSXMmFXyrKkpvC8skfyoJ8Ds6Moxdnxhr8b5S7XhPqa7pNm","112Zw4htTRxgjjWEGR9LSCV6SrXmaB7EC5vBCvBsJdNVLZq2Prvx","112QsoHfH2VrKJwVHbYCRND3cADUgN7hBWj9iajyp5EKHFDGhhHz","11xp1g5Rb2oYh3KmGF28e5WFwNRDgnij3sYiHgFkmJjugyRGYX2","11fbxEHHRtNHPmmqvQYHaP4BMkr9yh7V8VNB5M3L85LowpNoZTX","112X6ZKPdwSUt9puVXn65QDVSY3PuvUdqzXi9h1Ux8wDSBxEynrm","112dQqiznS4QU8vdvKQgQemxz1BSNvoLCABks11LDQpABLphwBNx","11fU5uisd3Vnf8ruzfBDZod8MwGaxfdLphtWMsyjeAVdXEZbHZ7","11d8FJkGrPYVmT3gAcyukxHTgEEzdZZu9mntpwMFdk5NJFCXbdL","11nabKzxNAi6SvAuSxwPs3TW6CgoShph4SiphbXu5X1N8xR9uqj","117gXYyXGzP8fgAraeLESRiLcf6TvssjSehvvJP87G3bFvcedNJ","112Y8jEy8Q34EhfpgqEAzbWMkNFpXXLJfF6MBoLYvdbdPRUxT4Y5","112YB2qKhLQoSvfHX7Q6CXJMPKyUsDKFR1KPuoNdaLoXrHxoGEAG","11VKRz2FJEUR1mf3j47KQMcBW4HMHh5Y9hg6Br5jgFWLvuaGY9A","112FCwxUw1h8FU2hAeJf58tt7qzXevDBP7J5hs3xP1XPFiTYEqkS","112jaZzt2pwABjtHu5AdFeE8BKe5WJmrrT93wXd8LU76M1fwB7uJ","11Use6GyMm7V34YaBUdQZ2PsHHQJ83JYoGsYuTtYShaWQoPUhkP","11ZND6ieyLQ7TpJPYkwtZayebYCoYeP9gkxqGQh8T1ceScXgPbT","116X6hz7wK7DiBeNq3tXiftiPvgiAkv4pVNvSjgg7A1daPTFWbG")
-- 
-- -- manage_name not in ("183.194.69.182","183.194.98.82") AND ver = '2.0' AND minerver != 'miner-arm64_2022.08.02.0_GA'
-- -- 56	7
-- -- manage_name in ("183.194.69.182","183.194.98.82") AND ver != '2.0'
-- -- 6
-- -- manage_name not  in ("183.194.69.182","183.194.98.82") AND ver != '2.0'
-- -- 156
-- --  manage_name in ("117.144.173.98","117.185.91.78") AND ver = '2.0' AND minerver != 'miner-arm64_2022.08.02.0_GA'
-- --  manage_name in ("117.144.173.98") AND ver != '2.0' 
-- --  179
-- --  manage_name in ("117.185.91.78") AND ver != '2.0'
-- --  199
-- --   AND pingpai = "PantherX"
-- -- 	284
-- --   AND pingpai = "hummingbird"
-- --   AND pingpai != "Midas"
-- --   AND pingpai = "EDA-IoT"
-- --   AND pingpai = "EDA"
-- 	AND depllist = 0
-- -- 	AND two_level_name != "朱强2"
-- 	ORDER BY manage_name
-- -- 	AND ip = '192.168.1.142';
-- 
-- -- 	
-- -- 	SELECT
-- -- 	`id`, `one_level_name`, `two_level_name`, `en`, `manage_name`, `group_name`, `pingpai`, `public_ip`, `ip`, `mac`, `name`, `address`, `owner`, `disk`, `total24h`, `total7d`, `total30d`, `online`, `country`, `city`, `street`, `depllist`, `scale`, `Hex`, `Hex5`, `active_time`, `location_address`, `date`, `re`, `devtype`, `loratm`, `witnesstm`, `muxtm`, `minerver`, `minerstat`, `ver`, `grpcfaild`, `beacontm`, `import_data_time`, `update_status_time`, `hearttm`, `status`, `err_status`, `update_time`, `remark`
-- -- FROM
-- -- 	business_device 
-- -- WHERE
-- -- 	remark IS NOT NULL 
-- -- 	AND remark != '' 
-- -- 	AND minerver != 'unkown' 
-- -- 	AND one_level_name = "陈益明" 
-- -- 	AND ip = '192.168.1.142'
-- ;
-- 

SELECT
	`id`,
	`one_level_name`,
	`two_level_name`,
	`manage_name`,
	`public_ip`,
	`ip`,
	`pingpai`,
	'' as '备注',
	'' as '备注',
	'' as '备注',
	'' as '备注',
	'' as '备注',
	'' as '备注',
	'' as '备注',
	'' as '状态',
	'' as '客户解决',
	`group_name`,
	`minerver`, `minerstat`,ver,total24h,
	`ip`,
	grpcfaild,
	`remark`,
	loratm,
	DATE_SUB(loratm, INTERVAL 480 MINUTE),
	witnesstm,
	muxtm,
	update_time,
	`address`,Hex
-- 	,DATE_SUB(loratm, INTERVAL 480 MINUTE),DATE_SUB(NOW(), INTERVAL 60 MINUTE)
	
FROM
	business_device 
WHERE
1=1
-- AND one_level_name = "陈益明"
AND one_level_name = "李宛枫"
AND two_level_name = "server7"
-- AND (one_level_name LIKE "%明%" or one_level_name LIKE "%李宛枫%" )
-- AND pingpai = "Midas"
AND total24h = 0
AND `status` = 1 
	AND depllist = 0
	
-- 	AND minerver ='unkown'
-- 	AND now() > DATE_SUB(loratm, INTERVAL 540 MINUTE)
-- 	AND remark like "%no signal%"
-- 	238-147
-- AND manage_name = "183.194.69.182"
-- AND address = "11Ys4LbocoxVaP8Jor1FviRBtZv91kfVitSxyNGEFGEFJ7ceJF6"
-- AND  address in ("11jo5F13SReDzEUJcjw1E7sYzieLphdeMVJimUhvvHdAsnNfDYR","112UDr49Rewrj7Xysa5hRCDcJNnN6YbZE1aQudNUEoNnqQUzUFTT","112M5zptD7WwJDcjp7LoAAbki2kreswxWit1gHB9Lucm7m1hNpXu","11ouPcLctoPtJ12eY7a9n816LGa8B7Y1ZwErtKc2LTqryU7QVNr","112SjNLMhUSPuw1hJJZNhCNdhKcqSQvNoyYGw1fuvYLpXF1V767v","112dM9abK3tTebg2zDFapGJHRGe1aM7tQHoTEaQx7o56a6LNJ4AW","11JwfjwKG5AttgPhzAi6m39Va5neuphYTy9d4wVoUMekAkhsVQG","112p4z2Djzdki4Fqhu2i2XXkJSDiXdKEEmgNvrb4EvddKEKfnoFB","11w4vaM4AeC3CwuSqTTQ7aXZsP686ukDm6tZCtaZwRoWuX6xyft","11a1gbWEpmX9V8ritXeFnNoaEqQYzj94Dd3A8cAu9q2NQ5FN6Un","112T6jZ5ZG1twtNVu24eULj1rGuEKpGgxyALMFYyZM5hwCn19LTk","11VQqmeAWBgKQoEV1RNTn6sR5y5yobZ6rTj5w6n8ZMT9sssifWZ","112MiM1yvtEqUoSkPaYpDBTrysWyUQsEt3EUK47PhC5c55vmaBkT","11Ca622pezvFigoyeVUBiXcqJUWW2dxR4T2Qog7EV1jDV7oVZn3","11tmJFsQ2XE6WNvfAqGDycrAJHmgmcDJvWZbegFKCBFKKxtCW5f","112kGYqM1hosqQGLMwQSjo64nrQFBNBuytmyc2oL7DufyuPNex8w","112c4mNR9SdFV9hyjnxqMstt4PnRfD6NZkjv5kPvtNXJ6bftZ4A2","112HuKvBoHL3nAnDhwAZAEBF1AfFy7MAFVqU5pz4jZmngQjSP1dK","11vdW7edNACMJyiiNDHkCJaQC2R6mqBWcD7N9EmiN5JZedZoYdD","112uJrYETtHSSLZGZtQsYKRDCD4vkxQQ1dXMgWD1GhXFfbqfRhKG","11AdTCJwezZRy1GBLn5wgDxtSJBPVvZaRoeVqevYD4oEL7iVXeZ","11xGKcPM19LkM4pUhqef5LCoUXLPtFXvfCosuWnKZ81UQmaxyy5","112uPM1HsXptZp7tzUm3yQmS1Ngz3Gg84dYZYs2M3FaxxedLqbzh","11Q2EnVYkjuWKnS8v8sLeDWy7R8a3QEnFNBZ7GFRuzjAHjjs8E2","11VuwKMxwZGnH3gTSTvP6zPDKPcBCeZ3EMjK2kB56d6DSoVeKa7","11roUf113H7ebg687ZeJTqQR8ioEXrSaQGAaPxj6vZHcAexVvQn","11g4uer1bPfgN9Py1zW7pf82GgXZSwGB4n3bUtA6tbABqzSifz9","112n3frtCFvwjvtJKKV7nUrURxWT3PgdYy9vqjHXBVFbe4NrUryD","112EMyxfTcM4Zv8BWsQDfLvpiLeuAZoy5nAQA69raZwE8SgZM2R2","11ZpVycovTr2b4vN2oxCALchxuw1HnPuDyUjzjnUmCrdmZHtFrx","112PcjNdemu4LmxtaFcN5Ni4EGov6ik3uZ5DYETHXtkbZK6fc6sv","112GG8QuLcgea4w7uxNaJnQUC2ySPUjFi1DnTTVgNALfJdkP7o1Y","11qzLrX6XAAVKEyR53tSei9eA6aoWtGxy1KVzJQRXDa9bCwQNoh","11zJJgFxnEnuon9zapRXkEny7WpBLSBFmA48fCYsF4tcBucmyk1","112bkAVtwwEvwBqXAxFqZTKwPwscvQhiypMDXdZzdXitseYVEST7","11nPDBwDDg2iP6SP8RReju4ZoN9NWZJjqqfJa3giUrGSsFkGYA","11JM47fxNyiDUMH9TFLRsU2vz2oh32gjeDTyc4bajXdfb5AdCk4","11dBf3og7fnnKjMacAuChTHqej16YDsNPV8E7db9A13fCV7psjN","112KSCHXYhSK3myCKDjKDcnWPnpNR1XVviCVg8CRPqSY1dxhAtRj","11tKAtodbLCMuKtGCK28pXn2xn5neHCkyiYHBtxKNCNHrFTy4sU","11YuJktk5iS7Hv1rrapfutFLrRwmpkoBdhzxLv8adxRKdQmjpcJ","1123LSyhM134Lw5TKrboAxXPjgyVf2KPLBCBnKUc4MXNrog5HBV2","1128e3z5oApMjyTP6wqAbdaHz3QE1V4jW5FEmMoLjoGLjWR42ukv","11hrCtbgE7BAPkL4vWDfkYGu99oGKBrmtWosHERK1iyGAuNCFQe","11cJT5RQWZBj7Xx1nP2fe74EtiWqXVwK6w25b8kUWLAE78vQWq4","11E4P5EpBmNbh17oftNX8Wiv7v2u3Eu7PLr29wcaqZPkLdH6UbG","112pJRbzwW6d7oyGsETR8bH3fMBmywVqE2TZSxUvU7YkxQJz3DnC","112tXqQx6VJ3PunG9UkdNVHCNguks8BLa3ZJPz3VwqztehFKxiEo","112r5SL3ngk7VS9HGz47G2rAbJvcUtfzTnWM5MWswXex8iQN3BK2","1166fpdJFkt6cPYppojfsUxwQNcb3V6sNwWnrcXseCdUo2WTX2M","118irr5ERk8bCFv6PX6VAJLHiEUuXz75yXL1RjKGsKExCpTKLea","11vd3FzFkQtJo74sEQRkvETECCcZdco6CWkx9sPRZ2rQPPqSYbG","11yw8JuGi9LmLk6DEWwEpkwBm1B1BtqLL4srwX1SfYaBacQCdW2","11jGdbtCSM9dzJn7ETGexcPKv7XZiQz4keRd9yaDuQK2X3BKZ7K","119KYenARrvhL52Nv9Y6cUQbX1fJbNUhYgSy6Va76FvntMpUzu4","11gMMJizTUzBejFMFhzYEAXJyLNYBJbe2fk6FyxWvEVYTJ4SKkT","1125FyQ3oZbTND3ipbnSTJzZ8XTzUie2ASKh3XDPezXv5SeD75RM","11fzAp4ToBzVRvN8vputBBWWTTkzJG3aWXoRgFnUjDYHc7pYwxu","112NXqxoXTrRmJ3rfj9uQnjsd6MnNE3SGyEhrrXrVuLZjDnETZPy","112u2ma8GrUErTbBKET6pGTQP9P9SdZ6qgpmy9GiHAuKmgzvWQQ5","11XDMXy8hG1uDAvKGUN9i41QyRxZqsUxxyRwjBuu9MjXVaUJ2xc","1121n2yX9FEUshJ8ERcomdNjz6T5FVohH6Z6nyXUzdHsBsh7c7gL","118edkM7LXwdaf4osV4JeZ3XoW5VzPuE3yZRKhLkq2NiKBTG8P5","112qZG8dvqayZN1NYL7w6AReBUtG2iy4oT22f8ANrNf4E2en6LgZ","112ZJMhJtDYhLYgZ5cMhEDQe1ELunaXBPXteCuTVFUnLesC4ezzM","112qENKHDrJyzsjpvqjMv1iMND9utpgRH6YaWfYTeYT4t24UX1Rc","116k3odMDLbXqfVm2RWJCBcBezg4sP6trDypqjtrMtnLESTVj7v","112oJf3xvc2LrS25EnvRNHuxn5xYxG51AF7CYBa8S4psRwsfC7p","11p31L6RfBAZs3dhW1wK4jF7HXFqihkDsATZqvTBgd7kjEmAFC1","11YZZUfZjJpHjUviWB8npNGBbGvjKhrF2UjrbWJHh6T18sqR1ZC","11xRH7T2wwUa4zoauW1QFB8DwBkXtKAdW9FevriHAH5mUCH4At4","112bR7CfVD5jxdAZ2wUMu22AZqkwvkYQBrU8u5yKoiwNLWkfderr","112SeWKxMa5cuZtsF5PNjxaF1h6g26aUCtddqKmJAZYHj4USyXsR","11xuHnD3pCr1jA8eotBMXvsfnQij93myJDpPeBqseXnEQARuBit","112NUjvheZ3VMVMbyVSErfHvHe87TTQxsjcYu6wJtSgDU12CNedC","112BYfdQzEbqPDAKkgPQ4XgeZTA2YhRfZK6qfWn4XDphHv3NmAhx","114r21tGTM1oud6YPu1HpNotY5KvbXkuQWau6xVi65jFwEsWxkx","11y2wjtt6vqnNQ8QpfaS5FMphywr9pb5WyLKg2oEtk8UVvBD5Bg","11sUxpFprYBir99ZefXJtQezPzU8nsFNXanp7y5CYjDbnb9ZF6X","11FuaqiXiZDHc57c8sSH7nrBKaXzpbBGuoderBurXBLB6RRVKxM","11TnNgzxESAJxod9hV9DZaLAz5vWFMqU5AhdP72Gfs5RaAiVySd","11Lgpf5M3MvBQrAWXyaypaWU5rWmCDf5uKnMWcFAKdVLUka7cZQ","112n68RmphgxZtr2BbPnECiBt3PC8uHVRh9BD1dLH8oUtxgA86cu","11YDLxhvaZia5bNTvRtdj7x77crerw7o5r7piQmBpMjHhZ7Po1V","1123SRpV3gMqcqkiym5qNj6uyfYwCiTPt6SGh8TG3qD6RhL7dxms","11oPGc11G4LYLuyStvx1dUs5DH5AyW25dSoXzPVk72ahcekmyyF","11h5dsXmtcn6aKCii8GQxxZDGjBDb8NeXAjYnMGCaWn9kf1ReU5","112NSvb3nuSCTqTUUFDxjc7TNGczJA3ge4oEKRWhzx5iBipHvSVt","112rYw2J6HssxniehMkej6fgNA1GJMEUVU2G8FxauVn1Zr1zM3Mu","11WK2oMnTXxaqPB459HiRbmisyhm1UPVjQZeBeqLzYfJo5qzxUm","112HmUe3yNmQtxs3WyKM5rP5NSwmjhsaBP9AfL7AucJpt2ZwSTgW","1125yoyUKh3C4XBe95q8ifCrbov2qmEsnL91ar5FY3ZKP1Kp3jPY","112juvwHY8Kf6v6KfiLKLWPoTTJY6y8VeVtTg8KuPgyywKK4mS1J","112cxFAg61WbCuvm5o918y89HQJysA5Yjxama9DaXxf37zFS8q5J","11Vbms8Ys2KSKZELZaSAzv3J5qL7U73M9BkJsbofgxkejDhrDDf","112TUdPT8XXxiEn7qQtpXEpjE8EFrxStz2CqfPJAMXK4HLzW6d7i","11ZE5WF1QrwEG2URioYtALYuBBn9op668xnFNoPY9jui7Y8nGMU","11svYs9VRX9wsLXU7JLamQPcJPSYPK8FV6Rgm9yP2aH5wUMNm7c","11gsAyP4gM6yTaLjhdGoBBdLM1PqMMuuFiZdzKmB7sAPgRBbfd","1123XbrffymVcwM1LzPxuBhG4XmMN8SDo7oYJVUyjGmTuK7cryeb","11r4f4mhQKVLfYChsSknJkcz5hpjdAU7umEQZwRdDix8zqe2MvK","1137czEC92x5n3Pez4L117XeVhxmCro3gVkEBiPnQZgGkUH2iwz","11MCoUjBHXT7bxk5P9L8o7XhW7ZyZub36PcRwJ1PwCESwcVB1Rr","11r3rk3Fxs14SKmYTYy2baFMnDfonBLUwwxLWNZNBrfwH9u9zML","11bjTx1BEsu4KZ361cXmq5bkGKkwfpwAkhvzowdqvrWgTGgcbvv","11fhtPzknVLxJCXy6oPt4gPy7yZxxzB4AM9Bw6rGZnKzY9vS6Dp","11d8gmS92qhFchkkwzwfjdAYB4EZdrForeJWp2tWa5untKgwsdg","112Kk93M6sSgbePbbgQ3Rmb3LbhNN7Dq4fi5DKoVChjYQjPFFUuX","11wf38Z43i4D2VU1cxPyLZP79k9dUinLAp5rPYMZQtT7d9xxJNF","11bVjo8fF323mf93Fc5vQeXA4decyovkGihXxzeyNyPeK588NNg","11eicir5dpdhvgtKcWr8xUNRvYgmA1L77W7RFmVxyfCpNU72rnN","112JHXjaKbFaecKX5GbMWGb8cZNy97nzX4oXh23639TEZhyQg4zm","112E5BR8UkGUqU17g4G3Bk47zdQg2jyb386AD5qFnfvepKjnxAJf","11xVYZweJMujBqj1fxxYMaZR2rSUB6dQ8Hgo6Uu8wFbN79R8pH5","112iosNXayqpmKB8cJtArFNB1eXruqFaqt46D81bfV72uZrMk2Ed","112JMWVhEYmMJnsFinMjMaVb6Y8EGmoZq8m8WXkRxg8oGTdLF8GQ","11S3P8QVHT9Ardsf9XxbT1hZvBvP7xkBddD8ZShiyk8vHxfWueu","11c5Kn5J2UpefDuPueTT6yuenRUHcq6ht6nNWADgRB3gLuXTinw","1128cGs6cyDLeyDvKqCJsbS33hdC8vrgHUKj5MH3Ut9y26JVyxFG","112VqNd1GLcagpGVw3izrjaeWWHhK1oqWDRCU25UcXndYQ3HiyKH","112ThRkozzgUDNTyMEnLXafxJ3BFNp2Acx3kFoeUzeMHcZKekdVU","114jtb93uBwaFRaRnTksnfxgBtubqkPpT37CN7jLdTFQ6qKDGTd","11eUQSBvGcftfSWekn4MYJ8aju5GAHX8DdLicRHhc42ASrrK2SX","112NGsPdQnZvSV9shDiYGuVtvDUXRkM63FWdH66gw9m3UjSSe9kx","11uZby8DVHwdtapF22haNDnaMyfN3kGs5V8X4BwA5UVyD9NN9nD","112aRCBikY1weakr6tt5rMgQw18RhePEQxiKJJ4g76vhXFR9mSxh","112wRK7Me5mEgPfe7jD64Khy1CWoeEHQHSpgAYSV8kzdUyPipLGr","117EiruT6oyeziJcqZHAuNkVhKd47dpvbxUW9Pz8Rs7NmU8bYnu","11RYivFF3xsSjLjjefTs2rsMuq8puCvDkZdP1T2BY8TV8Gvxftr","11yKfpmSo1PVevGDaGeU78CoQPF1BdSiQMTbQ38cepKft1CWKKZ","1127CZPNCE8sQffcNH6aet2UZfgLru1CoRFRUcbvd7cC52rz5WMR","11XFQjveijsu4X5NCViBR6DdbYyymfsPE3KoZurjfASob47JNGW","112tfN99HSCBDorkzXiUtRjaNPuGsZaRc8AfM5ye8Rp7Q6nVKe3C","111NoNVhNfaymDtzJSP78qV9kvdgsUDHVPH1bhd6vGSG6JFoqxG","11TweWkWF6spqwCgrwJQ5FKfAWPryAoGavDKn6ZwFtadyj8YYs8","11y3xUiGgTXgwdHoXtDSVkpA7MRBvfFdQDHPWma8trPhtZgw92Q","11GGF3z81Cd14tr3bYuTNJnMNEPr2RUgrv1CwBXWQVSpp2RSaSc","1129hbKNYv1iw8WUW4qFrBYDibtYBJWmZbmDM9FnNFgsBLC8GaVm","112ChDomJvHKxtwYZicCtKuPdJqzbXYSVnJHi9o3Mff8H87weQhN","112b5UrcVhmjqUhY15vyXTiDdXzy8H9wSZ8Zx9kity9rohrMtw62","11KaqeBtRHRLHbeYS5W5L5jGZz9rM1n8jk6FbSt6h2nZHC3sDKy")
;


