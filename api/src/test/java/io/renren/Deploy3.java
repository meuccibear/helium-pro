package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.Location;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.Gateway;
import org.junit.Test;

import java.util.*;

public class Deploy3 {

    String filderPath = "F:\\tmp\\cz3_17__0_43_2\\";
    String fileName = "gateway_%s_%s.json";
    String logPath = filderPath + "%s-%d-" + DateUtils.asStr(3, new Date());


    @Test
    /**
     * 构建信息
     */
    public void run() throws MsgException {

        String groupStr =
                "85180cdbfffffff\t7\n" +
                        "851801a7fffffff\t7\n" +
                        "85180cd3fffffff\t7\n" +
                        "85180cd7fffffff\t7\n" +
                        "85182a6ffffffff\t7\n" +
                        "85180c9bfffffff\t7\n" +
                        "85182a67fffffff\t7\n" +
                        "85195113fffffff\t7\n" +
                        "8519518ffffffff\t7\n" +
                        "85195117fffffff\t7\n" +
                        "8518618bfffffff\t7\n" +
                        "85194e27fffffff\t7\n" +
                        "85187487fffffff\t7\n" +
                        "851874bbfffffff\t7\n" +
                        "8518618ffffffff\t7\n" +
                        "85186183fffffff\t7\n" +
                        "85194e2ffffffff\t7\n" +
                        "8539336ffffffff\t7\n" +
                        "85195b4bfffffff\t7\n" +
                        "851e8447fffffff\t7\n" +
                        "851e8457fffffff\t7\n" +
                        "851e1373fffffff\t7\n" +
                        "851e1377fffffff\t7\n" +
                        "851e841bfffffff\t7\n" +
                        "851e8443fffffff\t7\n" +
                        "851f0d0bfffffff\t7\n" +
                        "851f0d57fffffff\t7\n" +
                        "851f0d1bfffffff\t14\n" +
                        "851f668bfffffff\t14\n" +
                        "851f669bfffffff\t7\n" +
                        "851e6383fffffff\t7\n" +
                        "85196d97fffffff\t7\n" +
                        "851f326bfffffff\t7\n" +
                        "851f14a3fffffff\t7\n" +
                        "851f14affffffff\t7\n" +
                        "851f14a7fffffff\t7\n" +
                        "851f1523fffffff\t7\n" +
                        "851f028bfffffff\t7\n" +
                        "851f029bfffffff\t14\n" +
                        "851f0217fffffff\t7\n" +
                        "851f0207fffffff\t7\n" +
                        "851ec323fffffff\t7\n" +
                        "851ec327fffffff\t7\n" +
                        "851e137bfffffff\t7\n" +
                        "851ece53fffffff\t7\n" +
                        "851ececbfffffff\t7\n" +
                        "851ee84ffffffff\t7\n" +
                        "851ee843fffffff\t7\n" +
                        "851ee847fffffff\t7\n" +
                        "8539444bfffffff\t12\n" +
                        "8539444ffffffff\t7\n" +
                        "8519698bfffffff\t7\n";

        String deviceTableStr =
                "ip\taddress\tname\towner\n" +
                        "192.168.0.1\t11UBSBRqcHzpMzk64QNNpfgKNpojqrv1NfnNmpag1PTieRkBRw1\trecumbent-daffodil-giraffe\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.2\t11Pk5GJURyHnvuG4q3Qrs71pw9gW9y6ihuHSw9N8hVmDRkVvQcv\tbeautiful-syrup-woodpecker\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.3\t11iQQKNw955B3R8sdfbYqJcX21nN8hdNrmBqMwcFhrsQNpPYBBV\tripe-foggy-woodpecker\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.4\t1127P7Lw2bggsD9wja8Z7XtPRPUTe1VkC6WcPqwXkztH3PTFGoGh\tbubbly-nylon-hawk\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.5\t11DqGZ7xW6B6HZUUpkbEPLiqDKLXahRWF9AdEYmzeqWKG646wMo\tfaint-magenta-griffin\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.6\t11fnLBZk3ET4MfJuqUiJMgfrvnM47uTRPiu5MACzVG5ztvJmiiR\tfresh-vinyl-whale\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.7\t11fJXCyB3e56TSXRAf8yD4AfydbNMkc6C2AfHsTzzXx7gq16aqU\tglorious-pecan-flamingo\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.8\t112wHRALAQV1pMqv7m1hyHdZnwQXAKnZhoixgQcZKpCRWejkwyTj\thot-violet-porpoise\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.9\t11pqL1Tu7qK2vEpf2PGNZMS9Ei9AXLudF3tBEDPnf6MEBMF3uNj\tgorgeous-lipstick-zebra\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.10\t115uBZddxwhjnkqZ8prtkF4QzZqijqZ76wNB3tPkrAWa3P7YPer\tmassive-cider-frog\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.11\t11sENYAjSzetxtpA3rDq7fZCXL5ahXsT9LBpy6pMP6L3VLP5WgK\tlow-plum-rooster\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.12\t11mXnS6c4GBYggXNUu3Rd9KJYBzAhD1iDLDTAEquB1yfEHNNgZA\thandsome-amethyst-reindeer\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.13\t1125Xsnu8uZSK8jvzRULeqfj2UKYbx8TqrNCiSpUEkgEFXb3X2cA\tdry-brown-hamster\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.14\t112wRoAsTjQUxi2KpuzHJccKfit1EjZUkvz49oSHL3WEpiyk7NW8\tnoisy-pear-iguana\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.15\t112t7kPBSpwPRwTSBzpucz9L1sf1AaFYZjELzrzUxSgHuj2YfeMF\talert-alabaster-mantaray\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.16\t11U11X5jWhWvSm9xA1kKRffMozK9KRfgXjsMbcMoCffn9oKsvVV\tbumpy-sapphire-puppy\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.17\t112hnQk7HPGqhYwuvn6U5xC2R31chXxi8xZ4YdjsATFCmFo1zi6b\thollow-mauve-cougar\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.18\t112trrj1tWKUUCjUdXkgCBew6pXLFGACcLavEvpTuFQhEbzDFbXf\tgorgeous-amethyst-kestrel\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.19\t116S8wBJSKtjPf2o6yHH8EMwZiVrqYg2NyM9p4qXp2hLZGasVvf\tdelightful-neon-stallion\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.20\t11aWFLX8uEvJQRuxJkAiJeAyvAN5LGAozRto4c3EZXcBzaB4R4w\tsoft-shadow-hornet\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.21\t117YcAgDjFLyWwK45SWjmdXtjAPT3KxxEvswTdaZxCGjTrLTc1x\tdecent-rose-pangolin\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.23\t11cDfCVeb4oR7oTrz3bYfKrpNR97YRERFHM2diSpPnds694huWD\tmysterious-garnet-aphid\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.24\t11mqSMKCqVpv7Y4LzJZqnELz942WL8HAVGwD1xX4UPRZUzHATRF\thot-midnight-wasp\t14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\n" +
                        "192.168.0.25\t1124nS4FX9NL97bhcDmDe2BVoAuJxynNTcX8U3bxt6i85oMyh4mn\tshallow-tweed-hamster\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.26\t112QNEAoxabQJi2Y1uMHcBw8Ff4SjhLtwuLTVt3oFgQWCgJrEqDP\tbreezy-foggy-manatee\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.27\t112EN9bjFcJVXUUsXLWJNfhqs6mDRNdyxfv9gEV4arpeEo28atbc\tlarge-boysenberry-ostrich\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.28\t11ErDtRaLpK1R4pbsahwJ2mL5JiPkDupXk6FtDK62M31HvmkSrs\tmacho-infrared-bird\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.29\t112KQGmFWcQ9xsHDhGVYNC6tA3GUs1m27cFBjW2EUK8Bp3i3j7Mv\twarm-concrete-salmon\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.30\t11Xc3vtWtgvc1moqAXz48rt3MpBnpPChiobzLBGQGHvFtFvpo7y\tnice-opal-flamingo\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.31\t11PC28EqgMi64XnvCcAFARfubpXtLL4RmqeB9p5fz2tHqeRjNpY\tshallow-chiffon-leopard\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.32\t11J4dzRkN8orR2Kyxxeps1AjMtLXQyZMDsVZyNT9Y43Yn2i6Rzw\tmythical-vanilla-salamander\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.33\t11263XPvXU9gF34EkUHviMVPy7XPhsBRNoPvi33ggucRqpCDnm45\tmysterious-mocha-okapi\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.34\t11NCEwAsycxYJ2bkoVPsLB8NcP1fSmKgxmod46me83AJLQjH3s6\tlittle-crimson-opossum\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.35\t11zpAnbDfGSYkrxLox82qWaZQppX6dxcjY9sjhsjNRm5yMi9Dr2\tfaithful-gunmetal-kestrel\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.36\t11ad6w2mkjDhdPmcfCpakQM6AzrkgQCM7ru7FqfWwGzthyXEdAs\tradiant-laurel-pony\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.37\t112mS5aHp9ebvA8kgH6tjyanVqnhzT7E5dQ4u2WJE9APwkXmp2te\tkind-eggshell-jellyfish\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.38\t11k7joWXnW3aQy2jAH8LCaRwUWgKQ57dzRUFP8ELpnYqhyTia6V\tskinny-violet-yak\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.39\t11bLt72s26rUbKUyKgfrvK2JYatoB286NdqpiqpnwNBkcWCZjNH\thot-fiery-ram\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.40\t112phscaxUNhHNro9PQFcrE23vYfb8w2pY2KdjkSD2T5mtFqXyae\tdecent-hemp-crow\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.41\t112ojC1yuyBxrdieBdizm2Bv8279o1npSQ7dcS3gxFvfqzZrmyqS\tcold-cinnamon-bird\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.42\t112NkLNSGKg1wYCikAbrYE1T4mepeT8TPpz2pT4wqKpVV2qKe6MZ\tquiet-tweed-bobcat\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "112eRxXiFCp9KK2Ghykm4Y9yeSdmpX7pNDcvyk5wTciK1gBwaanb\t\t\t\n" +
                        "192.168.0.44\t1122YjSC6UPSKNW51uvgCA23y6pybLPMyDgQAJutyL12oNF2aLfi\trestless-macaroon-bull\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.45\t112pz3YfAwzcnEf2L3JF9wRcfamhManTEqF1vgSYZuhLZfbwA48D\tclever-iris-rhino\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.46\t1126UhHtA9FTSswcDuZXhA5U532GrwsPMfMYi258Wya2nzVBRdbn\tcheerful-rose-skunk\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.47\t1129c6LAK2odNRPvv7TXhq9B6i9gX1Uta7yt4Cv2gjyEDzZnVZbu\tradiant-lace-halibut\t14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\n" +
                        "192.168.0.48\t114gPqJPwUkxA6kCDG12MsBGgEfPEgQvotuyGRJsjRFPjLEAWJZ\tbald-chartreuse-cormorant\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.49\t116eeKaXwZM7JuUi1UFL5ktXUBuHytSkHkxTzspRPWMT5zNYH7V\tbasic-strawberry-monkey\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.50\t1128SQhETYRdr3CboTRedM3KtCXJhwFAu4dMpAoyYq72DaeTZ2My\tsneaky-peanut-reindeer\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.51\t112uF22hqy7aYJKjhjgJDgc3Pv844Mo8YpkzsVqHQakavSBKr8PJ\tdazzling-seaweed-cormorant\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.52\t112LySuuVVm4dahdGSGoeQAk2xyjZJ4okNLLoTyVQB5415oZjKBZ\tagreeable-carbon-loris\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.53\t112ajqMucnk7ns3DZME8zaNLp3CH7LyDF7Bg6DSY6AVgWMoyoVzr\tjumpy-gingham-oyster\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.54\t11V94CfFkeEsKwJUHZ3LWqwqMbHpMGvvpxkBKkHAoC8Kd41pdrC\trare-orchid-donkey\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.55\t11GaEJSEun7Fdg34kYpBFD5cuo6bYPvRNa6GeHKw4JfRftEiVKB\tmassive-mahogany-mandrill\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.56\t112mJ6H6bydccKH78sts87dxDBkvw9YSitimueMB8ctMXFmjrwBd\tsoft-graphite-tortoise\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.57\t11gkuUGvMH6iL2AfewviMeLhz3hG6oieeAYkCegGB79BParKxyX\tdamaged-gauze-caribou\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.58\t11xHxmpp3n8dAarpkRu4kjxbkNdHnkHQcWNJcB7Hb3zAnaYzNws\tclumsy-mango-crow\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.59\t111Nz7Apv8SAcXp7LsyzmRu7q73eM9j7T3UpA3yRxMS1CL2Zh2o\tbouncy-plastic-aardvark\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.60\t112G5LJ1p8rrdrTz7sjGYQvExrbi6s4khE19FJtiUtUEbU3gEW1N\tshiny-coral-fly\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.61\t11kRNAdxYSrpaegHjUJuQMrATEiMcoHuNs5hVQceHVa4xWsns3W\tfit-lemonade-chameleon\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.62\t112cFEx6Feup9Z4QJjKZs2sgGEah6ME5nhv2HSZpGaPEQYxoHHWa\tmicro-onyx-bison\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.63\t115xJBb11hiEfHLTcLWhk9v9Yiz2X32GrddjLBJpUQUD3GdJieu\tfaithful-pewter-haddock\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.64\t11cMz3kUdJUV8whnTaPW8ZmjxA4mcNxBpmAN8V4svWEJLi7w5yr\tcool-rosewood-dove\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.65\t11zQrW4RyqAPv4jqEoZLiDGZkHs1bJMTKYaDybZ3FWjYeA7E3Bd\tvast-foggy-hippo\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.66\t112KMYRPp5TvXenAmQyc9ZCums7vmgi2L8JypNamG1Agf6oTUVUG\tmelted-red-panther\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.67\t11Mh4RfvyYcyvZiVAfKLKVpCCfDgnQVrJ64A21jdbWrCdNXtx99\tsoft-currant-scallop\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.68\t112EQ9oQKqiMNcDn7wyu4h58emvkWGWNdGpdcSy1Gq1ioGAYRXh4\tsavory-sapphire-pig\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.69\t11NTqC4ZzvZ7dB4bFcGFkW4C8FnHy1x9T7e1oNrDUQJk4n9drvc\tdecent-misty-toad\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.70\t112DEUJ7QoZcix3f1SLaU5uMn2uJPsUiFsoRqcFVG6gLkvRdQsXM\tcurved-licorice-halibut\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.71\t11rDTTmnhgqdm7CpszL1UZbNqqPkeUF727UgjWJGGTrPbzURu6f\tsavory-licorice-mouse\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.72\t11kei9HwQKKgjhb26o2KUAh91Tvr1pTSbxuj6zx3f6dkuk9u6ii\tdancing-velvet-squid\t143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\n" +
                        "192.168.0.73\t11sJAm53drjss9Dxew2KVa2CjwKW5QzReyVBpfVot9QucpCYNMC\tcuddly-juniper-falcon\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.74\t112HFzWxgyJ3NMZRuoSa6xgbar8w7EuHVfQXBypsAwSfxDUS94Qa\tlong-pickle-scorpion\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.75\t11uDXMXsJ4n1V3dCNQGUqJRfFdzwKQjW2dT5SJWT8oH1GuEF77X\trestless-tiger-cat\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.76\t112G6VRMd1USN39wYFTZ11Yjv2CqEdhUa1zmegStNZZbJaCsCx4D\tyoung-mandarin-giraffe\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.77\t1122dqe7MiEM7cqBjNQhXuoY8zSSFwE4V7RXPPKMAxTnFMDnoU6r\tcool-crepe-lobster\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.78\t1125PEt8eMuvJTke9NXN398xLsukdyMz8qnf8nQRkVWPpaTN9bvr\tdandy-menthol-frog\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.79\t112hMiSV731via2wVApy6SFK2tc1U7WwpN3V6Qj9a6prhLsRXWaK\tspicy-cerulean-chinchilla\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.80\t112sngGkqzDHTGYZWyFigoHszcv5Mnr8kp6CeZRnKY44sRZcCjuz\tcurved-watermelon-dalmatian\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.81\t112MbcFYsNgp61CmoMDeyAeNcGUQ2eQGUbDFVGrV2yMXjiWoY6Rx\tpowerful-cyan-perch\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.82\t11pCmyHozYPjrxNm5bHz7CjcgGJUQVpxwSAPTusZ25zfDjRZ9CW\tcareful-basil-octopus\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.83\t119izHNBm7pGcRNfeJb3VTHTow89a4hXNDTu4wKojuYNcWBfeU4\thot-sandstone-grasshopper\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.84\t112bLse4GWt1q264yF81cE7A9K7aa7pB5a3QQyq77fLi12BUyURc\tacrobatic-canvas-canary\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.85\t11x2ps6Q278gLWnWkUa9yoJ9EkA4EB9kDgoA4ZFJTzrti4wWvtu\tfast-brown-shrimp\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.86\t112fNfST7YvMQTZHuZ86P1dCBdXShn3L2cGsYhVUkyDinNFQ8AV5\tunique-hickory-millipede\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.87\t112h528nqEaHZK4vXkWbUk9jK4GCkRjqyCuoqV65Qg7wR5Df2dUb\tacrobatic-chambray-giraffe\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.88\t11WoxneDuYFxFYiVc4ny2hnWUF2qFDHnBVhY4Lp3LBFtnCrqgz3\tcheesy-holographic-boa\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.89\t112daUkmWb4gRWD7rJEhWc2GDhTUqrVgLeWkrA5fcmFRfUpLJPHR\tinteresting-smoke-chipmunk\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.90\t112uysngfNTtW7PTQKu2cArfAfkVwLPhyTSpp4aXKo3rHpJBftB\tjumpy-brown-chipmunk\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.91\t1118fjm5HoAx5rKqZF9R9FvY3Dyzc3Yr7MK4FWyzLodpnD2xe7m\tpassive-velvet-starling\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.92\t1128XQK9TMygMEmnQeVghC3e41fZeTbScY5tC2qEQuM3fyDYpfbL\tharsh-denim-cod\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.93\t1145ormod239qQiHSoPX1oZTHP3wZ5UNGnmjrJShtWiSEQ3G1XV\tcurved-black-goblin\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.94\t1129ocZMtFJdfk2SdMj8vhEjsgBLBtgD7qara6ymr7Rsdjc4PWop\tspecial-graphite-jay\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.95\t11AZ1YGdDca2eWfbn2zyTSXVFCFf1DS19UyengiQ3JFwv5ykTx4\tpassive-glass-perch\t13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\n" +
                        "192.168.0.96\t112TkdHzcW5S7URjaqSbGKoNWDMHALzR3RyxaazicHk9bBxbgz6R\tpetite-khaki-goblin\t14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\n" +
                        "192.168.0.97\t112HZYD8hqtMnjh7vaHwapdhE7qXrefqfXQuCDCs7S8czaMntzMG\tfaint-cream-raven\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.98\t112oEYyjJ9MkTUk71gGm9yrSDHDf5CMcNzjdwYQCi6YsdQTz8xeH\twarm-vinyl-iguana\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.99\t11tuM1Zu1osxkBs767WiB8XT3qs49UMDH2eU1Xggk9vBNiNNBcB\tactive-citron-otter\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.100\t1126HXL5ZmfqTwSVkGEHi8qkJRhDsushzG5oSdYg3e72rUfQHQif\tstable-cinnamon-pheasant\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.101\t112Y2rzM2TeS8ZyY3MwgEp1kiYX5pc3u32eZCgQAvZGeaNB4Xsmn\trough-onyx-yak\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.102\t11w2KeWQ1Vxm7aYnCcxpCTA2hSug3oYyqcquRye7NwzqKHX1poH\thowling-basil-gecko\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.103\t11zmFsu9yKXLKyeqs2tewSuHpw8tfEZEaBRwXvBTKJy1YPFm2Qb\tupbeat-tan-condor\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.104\t112BEzhHo1VaPakqe7tvpq3Xa4AsxjVhwewvAAq41bJiXV1n32K\tzany-gingerbread-mongoose\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.106\t112Ui6vz8Q3dEgVPtGDBmP4wQQJrkUXAmq74ohx3h7Vq14a3SevL\tfierce-butter-lobster\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.107\t1123gHKPLuMGwH2c6iYU34yapMREqFWA13jgutUU2ji25aML4EcH\tacidic-burgundy-falcon\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.108\t11xMuFCikE3xGGXGXxZAtunbayhzfz934urpG7GBjAuXyQwP9fV\tsoft-gunmetal-perch\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.109\t112TPzvAJsifSuR3JjfAzaHHMDtb6K41hUh7rtfjAogcaneUkK2p\ttrendy-foggy-scallop\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.110\t1121FwmwCYawhvkc7oMq9An6rcEXKwfzLAc8g5okNRJayXFhnp3d\thot-seafoam-pigeon\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.111\t112kgHK5aLXBUhSPniXVPYTC6xVDvj26vdDHhBy7C18gmJb1meC4\tstraight-macaroon-boar\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.112\t112a5Uo5NWekh35dk3kD1rqg5geiovaSi7DvE4BTWaJNgtZr7zse\tmelted-ceramic-mallard\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.113\t112fAxXf19Db8ewUqNFrmRayJSZ1J3TDA2bcPm7PN6YzJvqPNTvF\tancient-menthol-sawfish\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.114\t112cAisUBtskGV29KmyjMx1eQhny6vqG1Tp1Y1a5NDzEohJjzVk4\tnice-clay-bull\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.115\t1126a7fF5EBvtJAsaTbJEJDHJ1Pc3g1cHub8NomMVVArauwvMq1M\tfast-garnet-goblin\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.116\t1184sHSqcbwtvodxzCqtXi8QNb1RTTY2JtzDvhsoyzPWfAnebbp\tdecent-cotton-tortoise\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.117\t11boL3q5cvDL6g8RkEsr8qyuv6rJQmaeQfVwCjxrdJjs5Ak6BeD\tsavory-wooden-octopus\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.118\t112oZAZTpq9bPeFoLoVcS1G5CDGFN8WoPwkvMUpyZr3hzvwpmmbG\tgorgeous-syrup-hornet\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.119\t11b6g2Wc5op53R4PuymRK5rDHPhjWAkgPEmndHgf6SMe893UKnN\tsunny-lime-okapi\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.120\t112AYSJx7HhCouFBqwGEMb1unxg2sHmTS5hTjUHKF42KjVbnK2c\tlarge-parchment-skunk\t14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\n" +
                        "192.168.0.121\t112sdy6Va6ywAD4AW56vBb6FpyWL6UrVugE7VSk47kaNTKKVZMsb\tmelted-wooden-raccoon\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.122\t112vHJnFLQjYTH5zSzqsyBc3v1FMwqhZ8KCudaxKjoDhmwUemCyG\tmicro-snowy-dog\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.123\t11r95hM6rvTuZUHuTnXSfdEQhQBq1fRsdzK9CrzH4iNYFWKKe6C\thigh-ocean-okapi\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.124\t112XLLF9j7p3eeEeCYCNLwwbzQC23FN4r3Wk125npgFSoqGeaDCx\twild-pink-guppy\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.125\t11cb4n1ihisfRLEs7Geud5WAqseFJkamqixBy1wy6LxZoETtQeX\toriginal-pine-goose\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.126\t11omDDB21c5rHSxNxzLqvEhA6nrvdvEtKpiAFQJroFvUwf6AhSH\tlow-green-pelican\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.127\t11LWRBjiNgoGqWoBPrNYx3C7VtjbV2jwgJD6rH7LZCwAWEkEtwy\tflat-ginger-mantaray\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.128\t117MzjFpSdxTxmN4DPR8ViFxvwnnvDQ5w4oL3PMtZaDUnWqPHEw\tkeen-mandarin-tarantula\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.129\t112Lg8UZTvF7Gpcue6ZemwmFyqdQvA2Lp8uSdYxddiv7GeXfmVrE\trare-satin-baboon\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.130\t11kfzjg9ceBy9kJNUJptHAEYL22iZoZGqJYPQyhXsjc6mSA4Tpx\thandsome-gingham-bull\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.131\t112fGU9z76SVkxA87PZoQ1G7YUatcoJ2agvYUXgFsnML51Tco7pX\tlarge-punch-albatross\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.132\t11yHMRWksRj1RpxZ4K1DGdGC9W7NPLAtJoaZQpgscjJ5i62MXd6\trestless-sand-wolverine\t14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\n" +
                        "192.168.0.133\t112i4PuS4MGN2yPy3pdmtjuW1j68z1DRXpRWADZDbjPcF7iQqNDf\tcool-pine-mandrill\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.134\t112qejhKqYSB2fcQQmbTHBPjEe7wKitVB6cruUTNm3myUViHTNNy\tbubbly-amber-koala\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.135\t112Rd7Eh7UFNbDfUiuwcVuusDAXCyi93vKSJrQScChfnz6gqrhUT\toblong-coral-cat\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.136\t112P9S22uMGYpsgzRGNLhh59CEteGbhGfp9UVVidjJT8FAjeBn8D\tcurly-ash-shell\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.137\t112gfHUAuU16LSTKtt5eykfSkrqDGyMuMD4ffy4xSzVJ9T5tS3bN\tdelightful-goldenrod-carp\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.138\t113eqg3vtaoek1pXb4RSK1uHPSgLZyms4gTy739jNLGD1a2Nfcn\tfancy-frost-mantis\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.139\t11hAhoWC7j69jiFquPnMEvVUeNWQCfru2htZLDX754yBxbpabB5\talert-mustard-nuthatch\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.140\t11TwwqMmyrcpgQVa2KmfxmpjyXHLkMucW4eChcynB68wxRmh4Y4\ttiny-silver-cobra\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.141\t1128Ju4icaVe3Fk7sYAWZLg15G38ACLK4py4KFbHhgsYVfbeWZTJ\ttame-walnut-chimpanzee\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.142\t11ZcWQASwG4KcvNugimNTxPaJ42fXHsMZN1fUcvTf5f6XhjP93A\tshaggy-shadow-otter\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.143\t113ctcEhYbv4XiAHiDUCcsQs7vNsd4ReQ75AHeA46y6VZDjScMw\tgenerous-blush-mule\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.144\t116CnRT7DDKjxeCdkJ5mJPpKgXs81jZjJsEWVUbZz53XR645A4H\tsunny-cedar-caterpillar\t144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\n" +
                        "192.168.0.145\t11gVxihBkbXjMT51nXyvxnb9MesLXC5zPPgAhMFhh1TSX77ktMH\tshiny-cream-parakeet\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.146\t11UeZQaiZ7ABdtoPTjBypC259ieqrfM3BoA4raWJVtMrWCuRxie\tamusing-mahogany-leopard\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.147\t112RaJDfUXJk7ay4cp3URSSfo1wm2eXd4SEQ7PMhTfh2zQeiPkoe\tjoyful-marmalade-mouse\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.148\t11BEg4gVNzvJJnqKMuyETn53yRFWcmjmXHLAfoxdUetAW96zp3p\thollow-snowy-chicken\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.149\t112Co2CqswAWYzKJgXyZ4iZ3SZ6V5ZViSS1GSTeLniJcRsxLjRDp\tacrobatic-lime-hyena\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.150\t112CxJFQK6HjLT58eVygMvdHCysQnkftjca24VtvfuHaCZWuRrEz\tflaky-macaroon-gazelle\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.151\t11F1pkthwNGwYGTuH6g9wFeizEmct8iBfXdpQBpqmQcmo6LyGZu\tsharp-saffron-octopus\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.152\t11k45x4QF7s8Ui1XJtQzMJMb1CspPy7ZtbwMo9HP2hxbFJHUSQ1\tfaithful-eggshell-tortoise\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.153\t112TKoFhc4Lh4CKxg2fwWdmjMeDK6QpPCz32cXmTcgMnG73r5gSN\ttrendy-mint-gecko\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.154\t112AwjbWA8CjB9KQewYxGFEWfJeJVXDL7btTFSd8TRDY3AqUkrvV\tfun-rose-scallop\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.155\t11jEWQGQ21TU2PsPqcqStx2QnbfWcVruwwicJat5xCDpgwmPAsM\tamateur-gingham-finch\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.156\t112H4nyAZevDKHm7NTu8dY5X8VfUjCH5Ka7Lug3UQxwgzufNRxx9\tgenuine-burgundy-chipmunk\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.157\t11yxrN6nvuFKBUT6s1t28XaZ8JrV43A2YHJji5iQ8j8KPSCKeae\tglorious-daffodil-lynx\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.158\t11yT9JbiBk1adk7LAzK5L3qSTEuuvnf7haEEvpggZQTCyFaUEvF\tmelodic-olive-tardigrade\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.159\t112SmXJZ9FJkqFdSwQKet5evc9YaWCfKc5myu5bD9NZ6jshZtcU3\timmense-violet-mammoth\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.160\t11EKFxW6HpoyL6wMvwd4m7TmjpoEAeytcPxryhzS18FySXovs8L\tsoft-banana-peacock\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.161\t11EaqNgvvBCpBF5FRM8h2wXiptMLWqBVdobSXJSZ7UiuSswRYpY\tdroll-fiery-pangolin\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.162\t112wUcvpMjDFov6V32RKg1bNeje21o2j16y24J8QaZA4qZ9m4uw2\tsoft-stone-pigeon\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.163\t112Pwc4jDEnAh7szMMyiotTppuRZ4wQ3zjj9WhAJe3yfwZ4ajP75\tmagic-slate-seagull\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.164\t11gc3NJTgUSQScZ8ErvqfQCYhBg21Sgu6Jzxwh5oxPe7Wtf6UGg\tfierce-black-weasel\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.165\t11ojPZxfVVkptTwz8sJN6yG4QH8UtfMxYZPUYNepAcUSC1izN2C\tshort-pink-sealion\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.166\t11obN1UXBMnQei3kbc1o7tPxrTxmnmmb6GmakpL5rxHXjrmPNGD\ttangy-plastic-lobster\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.167\t11ii31p5nnaJHk9CbEVGBj84L7DAP9auRPixmGr1AMucBrYG1fM\tcalm-coconut-llama\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.168\t11Uj3UHZsN6HM4xsSYC3EL1Rh75JYoaE5Vwv53h6rppXzg8z7fW\tglorious-cinnamon-crocodile\t145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\n" +
                        "192.168.0.169\t112p9n3pKosmuy2MiKEZmG5VjiHRtAyKUMvV9f2tYo3hSrDXjceS\tdroll-mint-tortoise\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.170\t112A6XzMLAZzGdFbpPHSE9gpGJw22A1MUWdMei91jUMUC7kxPQ8h\tgenerous-opal-yeti\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.171\t11PTjQsGAEXcE7v25uUQK1vmy9vNFcR3t3NCLk9xGahz6czzQZm\table-banana-vulture\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.172\t112tuikoz8FkJdT8jYVUKFfZbycKgExryLviz9WhbE4BPra1PTue\tfit-butter-tiger\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.173\t112R8gHkb2bGiHioaYwoxcYr8fEpcVuBJ2gXCNX6ow327tqLq9HN\tenergetic-saffron-mallard\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.174\t112RcUoxcJrEDEg2Gu9xgXBdsoWRN86zFFHv2Prfhq6j6JDBjaYo\tmain-pickle-capybara\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.175\t11o27naXh1x9CFBNoyZFGAgmxxumr8A4rGfbxNvehUWRbrknt3K\tharsh-gauze-opossum\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.176\t11gokxryymKYvLejmY1qXynpUbRNSzudp1kGjyJCLUF7RmyEGYg\tcuddly-marmalade-fly\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.177\t112iFNnAzDsTHwZafEn4QmVfQkC9KPGfuAGYyDxunsegae7Wh6NJ\tsilly-pear-armadillo\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.178\t11219Wv6rTfcg1YT55K8xpPuzsRY4RPsrNEW5ccUETSe8fkPqLvc\tbubbly-coffee-coyote\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.179\t11yy7uycMnN1oJ69WhViAAvjSCE3KffAsjUBGFnopjmhvmznTmd\tactive-fleece-moth\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.180\t11Vxizm46P7VbQHze1wfG1TNbaQ2J4ASsYGF43Nwb3x2L1XkcTX\tprecise-iris-reindeer\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.181\t112LoEXkaXyAbS9ig5kQmMK7MDFb9Pv1GBE2UcEHJj1gTqo4UMAu\tjovial-walnut-salamander\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.182\t11VMUHihXoorF9Ky6x6yFjPiyxNV9aQrcbTinbK91nMjeAtYL2m\tbumpy-cedar-blackbird\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.183\t112Kw1ZovbEVbPn72CqeJDK2pVx252VuaLVwkHLmV1esDPEh7WJL\tfeisty-pistachio-iguana\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.184\t11APtT1K2dsrohJMptLHefP9XuyKUrARzkTuwwNFDCpB98LV7oc\tdecent-aquamarine-puma\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.185\t11ykdyktPpXvg7s2ipgunwT1hVQeuBRN9QXPutW6SUPbLm5v6Ew\tfast-cinnamon-panther\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.186\t1124BEhY1HR2dx3495nesgq3UCwx68ynPH25BDJENJTQo5mMtqXQ\tpowerful-hotpink-koala\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.187\t112jGSHcXZCegzTrgmxVpmrbTDoRY6npNdvMJxMquqHKodGXiWJB\tmean-misty-lobster\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.188\t1129Jm3croRsRZoiRnb7edPkRqesSe9wPChegK8sUU1AR2cB43vK\tlone-taupe-griffin\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.189\t112F3RtTE57AigayQA3JJYGEXaNhATBVzFV8zXh7fKFNUcpvjfqs\tsharp-lipstick-wombat\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.190\t11b4vth3coBiZpyW7GEPtAYEhMzbkY26GA8kDXg6vkFy2xLiZn3\trare-admiral-cat\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.191\t112muGxUe55gCFT8MF3KAvoJtkrqnqxeDWKwts4sair7gW73ZsBD\tgenerous-garnet-huskie\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.192\t112cAgHx78G9uUzSWUW4cCm9UkDSoyMMwN7tfwjSJVfY1PGYXTco\ttart-wooden-urchin\t14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\n" +
                        "192.168.0.193\t112SUwRqEjmQ5RbBVDnb3tGp4kpUpNXBuQg2nEBVmghbqkMJKtXB\twinning-pebble-goblin\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.194\t11FiUAgKYZ1g7wKV2TaUm8S732vgGx34Ka7J5idL89jyfLe2hwc\tmini-goldenrod-seahorse\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.195\t1127YZm6ET8w4RF4gQ4fxuVbc7k3yze93Wo2SkzdGg69TzETQ1Gu\tslow-scarlet-octopus\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.196\t112PqCPpEG1r1vhnwN8DP9ysQwHJnqFF1wohPp6bsVBcSvZkcGRY\tdry-brunette-viper\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.197\t112q2wjRnGhdUNfKBefh2ZKFTbMc7XqtDHQku5rjXdSk57gazShY\tshort-fuzzy-mongoose\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.198\t11dthfvNxSKFZEBrH2sHJMnuEZJFjxVT4u7WDxbXKprFEiDzSgg\tsleepy-basil-hedgehog\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.199\t112AdeZ8umyW92uxEfcLenAAEqj66AaNKNUGtheCKUAvkzEsEcM1\tuneven-fiery-liger\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.200\t11gi5f3vWExe9NCGQBDm8V8NFmbd1q34oADTubfFZNUQqd4mDTt\tlively-marigold-jaguar\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.201\t112X9tPntPH1sURPwMwvHoNx6nVT1RJGsNR1PQCZV2kyGfdKmqmX\todd-infrared-bull\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.202\t11HTMrNpX4aCif5eZrr2N6iKD2qPmhozxf244qdUbouhenxZ1qj\tmacho-shamrock-hyena\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.203\t11iodkcFLB8RV4efBMhpp95a2mB7AgvZFGZDvegpaMPC96DqDrL\thowling-ruby-swallow\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.204\t112vU4n8Y1sUGim8LDHdhtvyfBQ2o1FqWUQRQJPKrSKbcN1zZzEV\torbiting-bronze-shark\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.205\t11gsFV1PYFNapjzxHH36X6vz1ptCUdcNu5856m7SBStm3XVZbEo\tbasic-beige-owl\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.206\t1128zxGtXgqELEf5asRmJRpBeHasab1srneu4BMubSVZEkN8RtuZ\tfluffy-inky-sealion\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.207\t1127v3Ny1Dxh2rSLsFZyggYZNZpa8pBSNqziHeNpKPkbUw9sties\tbubbly-satin-crab\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.208\t1121hPeCgLVDgjcFaELvoq91VSWxKiy4Qq6himPiSQGSFK314CPm\tabundant-blue-duck\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.209\t11YsfAm997yMqpLVTwvTyzDX92uB1FvcxFdMrXyDvH9SwrypCMa\tsoft-caramel-kitten\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.210\t112hKQYsBm7NpTGpiFNFQvMem5WrHe3jH3zmwMqoibjBvdpxp4Dn\tsharp-coal-armadillo\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.211\t11qxYX85q96fEZLk5BywLd22aAARv9323CWRXuoFUbWrPVehQqL\tthankful-cornflower-pony\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.212\t112txJFZp9YEWa6e3aGHpjJ53tY3GRPwihyYvLdfZSW2gbDiYTtq\tinteresting-cerulean-pike\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.213\t1123sTKwy8qdHZhxTB3PfSqwe6TKwf6Fmdb2vi8XDSFZsjcb6TTS\treal-strawberry-trout\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.214\t1128xLQooj8WtUPnvLy2VGL7GujgQdEHnn264hYhZJtVYmL3BkwF\telegant-navy-vulture\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.215\t11RQbhDuhTFAXqJaH7udbiXkj8QxprepBNzaQyM5b2QcrQiZ5qo\tpowerful-blonde-locust\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.216\t112AP9ymEdZWJ8TwdjwVC76Ws73TwCRHuvj45T3K7pfRDG1PemtG\tfuture-cream-pelican\t13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\n" +
                        "192.168.0.217\t112bLhhn37MTq6cNM7467rqfE6BtbzPfZfssEX64RqKaQxv8GmXw\tgenuine-brunette-hedgehog\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.218\t11KFYviac3cyXmsEuCQMcwTkMqnCSyiDUm8t6eNTLKhbCxECVDR\telectric-zinc-goat\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.219\t112McW4vuvJZLifMsPDGgUMNtPjmdzyWQ7YmRJ23pbzvRH9Vo8Qp\tswift-maroon-mink\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.220\t1129G4bNWDk4eMkWq9kbWSXEDXzFWMtDoxQHun8RJ1DB3E5DQCnF\tacrobatic-opaque-goblin\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.221\t11TnXA3CpCnQH9ZmscALe5zFujTQu2vNcD92wGSPj5eEZgoQ8B2\tbent-lava-tarantula\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.222\t11P6uMdcM1BiRrDuWNQkQTaz9scnWg3EvAvo3bbawgD1KiergQr\tobedient-flint-iguana\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.223\t112qQTxbwqa3sZ1eBrxupjApzSAiNFkCrpXY9cKhyDpV8AkzK11p\tzesty-amethyst-goblin\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.224\t112dzgm4GgVNFKTCYXH7V5gbqt4sUZ3FmrrMhnjVkmZGrfCmC8Cu\tgentle-goldenrod-cat\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.225\t112CBNjNxxHYjfUiW2fa4vmSJMwiKfVbuZmzDdPfPmYq6ATTJdQx\teager-blonde-griffin\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.226\t11L7RBee44YhvN7T7sy5Q2N9PX4axoUEQriDrdjwmHfegLcUS4K\tearly-eggplant-troll\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.227\t112sEv8jtmTJ9uRmYKqgJArZHeHjT2CpB7BkdBQ2XnRp5jv9D9XH\tfunny-cinnamon-orca\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.228\t11dbLwbfEp5eDrJyUFykoRo1Pb5GTEg6c9oQSYesC9vkicUK82g\tpassive-saffron-turkey\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.229\t11FARBycahR3paoDpMrjBb3XWfndkQPjxSN12uCba6fvj8Rwpfy\titchy-iron-raccoon\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.230\t112Nd6AkdpJyn29UxMMEsoHWtCwuvfvaZHwqrd6Egt35V4HJ8NrD\tcuddly-felt-gerbil\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.235\t11k3xtJLqQTyRnzFkbi9f5UhajCAyTbh3LXvZwWCGrHQygaY2xL\trapid-snowy-deer\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.236\t112cCNpZfCA5UuVbXccB9VoPug1B4rQTjkzajmWWFx5x4rg6tUsE\tmain-eggshell-orca\t143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\n" +
                        "192.168.0.241\t11FZ79L9CqaXMhSozisDhESfkbn5zBPHHNguXXJocE2Pws2sRzW\tlong-tangerine-mammoth\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.242\t11RpcvjcLAcMS1w3GAt5f95zBdrgoQcguXxz1LadZw8fgondMhJ\trapid-corduroy-gecko\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.243\t1125jDRyLXgGLUG82TyWXjVLEjzDrDeG3ptJ5d2RBXb93xzx8Cms\tpassive-gingham-rattlesnake\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.244\t116uVdcBt6JNt2nhDrvGLsSvK276vEs2CMaGYKgdJdNtojhd46X\tlong-ocean-wren\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.245\t11NPii4b8eXnr8KvPyBC3GUoaVSeheDw9TKCVRa9kcT4maXwfB7\tshort-rose-flamingo\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.246\t11KMwDDE5psewtb2oYAqp9Y7WzS9M3wDKzoAPPUKpMty5U7yZ52\tmelodic-bamboo-squid\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.247\t11sSZFG7UbnbgLK8tjrPxSv2ZTm8eg4fkEbKTfxFu4UpUBeWaQz\tenergetic-chrome-beetle\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.248\t112PCAD3tCw4esyQ3BS3YbC22rZdqsQUZJeiRmU6oVvvxEoffxi\tbumpy-opaque-otter\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.249\t11vBGmTrDNAtLcYYQrUCF63pMbtwmcCJfW8triW9PSbUrsvihJu\tsteep-onyx-mallard\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.250\t11nGthZKd7eLZEQNrc3dzv6f6wnBWYfbRNo4UZRbyGAUjU3YNK8\tbrisk-stone-boar\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.251\t1127WaHDePhALPZBBiQQKRTpPedziV9wfC3ChVeD4k3x3H1kfNCf\tsticky-amethyst-loris\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.252\t11WB1stQ3uKCXiTo8zptFBptxJZKe2J2gH4ybs6BFpfcdvSCgqw\tmagnificent-rusty-panda\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.253\t112j1Ak3jdCpqnx8Tq8Kxe5AznvtuEFjyVBBC1f6UUQ3ZbFqJmd5\tthankful-tangelo-chinchilla\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.0.254\t11twmTJBBcVC7MtSxm9kxmjGpH28BwHNUtCny1k3b5BY5SBBaFk\tgentle-pear-hare\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.1\t112SJpxYpffk4qCUdWrD6krCjDRMAZ95N3bsKrHe2vck54Qn2L5e\twitty-sangria-hippo\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.2\t112Jj2S1Nc6JcQCWjZJKHGkPAsjXxdS2sPZAERPyqqGyr3eCv7oM\tbrilliant-sky-badger\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.3\t112oBNKfMgmkE3BD3iQgaTQSFJPqkEnWkeiLxVi3EJm4jhZiS8w3\tmelodic-lipstick-squid\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.4\t11i7p3GvhLKkvpYLuQsNzb26Z81qdFtCZptfE87ET2Dr9bm3Zz6\tsmall-inky-hamster\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.5\t119gqub1n82P5ZhkhmRXBt7izJXdgn99FdC2TUKyxnSRsjFoqTx\tamusing-boysenberry-wolf\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.6\t11xugiFXztdfa2ievVcTbsAoWgFo3ZkFNWba7i9bfo12RVsCRGL\tcareful-navy-urchin\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.7\t112FCfBPhU8HNfdG2SKcwnNqdZkCEVg5hBrtkr3zwNMGiYgpb7mV\titchy-currant-eel\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.8\t111PPtZK96Mi39soUP6doTpM7dv2iSjiknEZ9ZrWjMnQJDjojHT\tthankful-navy-rhino\t13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\n" +
                        "192.168.1.9\t112e5PPvkGqc7vAJ2s7VksPhTqoNbUQLFPzaypvEXSFuzK55QMtn\tlucky-pastel-ant\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.10\t11oNi1yYf5YsRyc51gj2tBgyzrpupPBYmiNHFJZgsrdMpeEuZmL\teager-chili-seahorse\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.11\t11A6kAkX6fYU8DgvqAAhv2VWeb8vC1MrLsHSFUKQvhTDWEv6J3H\tdazzling-ivory-troll\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.12\t11cEbJBhrZYJxoDPYiygY6fajD4rf1s6kbYJokf8i9gv3cu6RZa\tbasic-foggy-oyster\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.13\t1123wr7SvQSm7HtjDzhez8GwGguvR9jWEJJ5NxPhu7XRWkpugmX\tshallow-paisley-wasp\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.14\t112omi3BcFWmmx6EYeXV83vb4eDWtDzpAQT8wUsFe31WCMpXjoP1\tsharp-onyx-chameleon\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.15\t11mKVysYPnPFDBoZGhvUbzcD6m2gKsU3GZLD6m6XufnLorjoUNy\tfast-snowy-mantis\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.16\t11YxNXP5dVCWjk2vkqMYEyUwVtf1gyorVm9fBSwgzTwZMeHF1kX\told-raspberry-rabbit\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.17\t112d99U7bucGCA4CTVqFGXv44h5qufPKmcy9hTHJUmdfANRxcFa1\ttrendy-beige-cod\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.19\t11Sk5ogxhCCQAmV5wgQge6NjYrsmokaJHAxii5cB2zvPfzMJNUG\tformal-champagne-alligator\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.20\t112EFaXDtAwRLbMYXKeLCHCxUeb1erETK1oCD1EctkasfHq7AzGr\tround-ruby-cricket\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.21\t11iQXTpAQWC2u93JJdRvwecWhjbwbeNezsiwKDDhMZeMbvnj28H\tdamaged-sepia-manatee\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.22\t11aqKp5c4HHVRNBtNnafpLXdASPLYtTcdZquGz7PcmAxYpUFN5b\tmacho-rosewood-bird\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.23\t112m7UDVjYwfrStHhouV6NmUGHMVAMUCixphcJXi92yQnTMCcfAA\telectric-raspberry-chinchilla\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.24\t11Noz2owwja9oqSUBJdF5puzRmsCsWwbucGoTpt4j9du6vZqCRL\tpowerful-inky-mule\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.25\t112LbiQ6Wjr3q3qW4yAuBoXMzZWZntbLqP1e88V9PN2LriWRyGAa\thollow-latte-copperhead\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.26\t11RdYXMqm6fiUhEevZKuRkTprni54m7Q8bYS5Hmz3wG3u2R2zyS\tcool-sage-dragon\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.27\t112d9x1y7LVc8VawQfcWaXuPjxHGboWiPGoiSm54SGDBT539PKDY\tinnocent-garnet-troll\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.28\t1127fZRtktFJYMhChTskYgE1mGMTVHPWW88b9epEqtzcSrL7t3Sx\tmammoth-coconut-mink\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.29\t11LPnzWPzHAZo36nrSQDvrKtYR6q6oCsHcxReiUYa1bkc75NiwM\tshort-teal-mongoose\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.30\t112G1pKbFthfGxCRMCjo6fuxPQ2dWocU8PHvi35XMPeBRdjiH8x1\tmammoth-obsidian-yak\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.31\t112sPc1jfUudsvXeKBsGmUWSy1AmdP2ckMvKzAg7iumCaDkjCjNt\tsharp-red-mantaray\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.32\t11aTT2YrKXTJJiZscPH46T3T1FFhH2Am7qT5oY6KVQgnRdu4t3C\tamateur-carrot-mockingbird\t14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\n" +
                        "192.168.1.33\t11275ZPjZNNEfXZ8x7u5b8zAUEmnDKuycMXrBTHM2XdfFMReBxZZ\tdroll-cherry-porcupine\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.34\t112FyWFp3fzVuAJbvmGTz5GYrYaryh11ywyzGfZxRxkW78t9SD3B\tfeisty-marigold-squid\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.35\t112LMUrQLam6Cy8uREcEjze77ijqHKrzYWVgNniCboEdMXnSYXxA\tbent-jetblack-orca\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.36\t11BCcyFj4C46Sy5mgvZyLPXGNtv69AH1APJ5d8pct3aQ1rksBVX\trestless-indigo-ladybug\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.37\t112EQj4pdQ9v7qsGQuaitqgkBVt5VodpogoSZADyThAPE1JTBcct\tfast-lavender-sparrow\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.38\t1121yiev6bS8JFqeCoUvwN8mujBzt3shCDT8ycGeiKBxd2DCNYxV\tacrobatic-amethyst-whale\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.39\t11iVdyUFBVM8zfoYZfpgA8tYSZq7GygrQQnPKd7EcLB2ZZq1ume\tmelodic-coal-donkey\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.40\t112Bn46VDtPR48W4wiVHfHKVbivb96YFfJDSHWKZR1JzVectQvRm\tcuddly-juniper-mustang\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.41\t112qwvTtKCjiF3uuAcJAPvNW2L8GqjfyaQSejTurHqyNaEwYUhrJ\tfunny-latte-narwhal\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.42\t11AdhuFHZAEcSujKDzv86187ezRx2AgQXWyMKfsvCJ4LTNBMuN1\tskinny-watermelon-boa\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.43\t11PS1g4NLrLESDhGnLzpJ761dHqCeesWddpfafUyVfUZ5T89uBW\thandsome-vermilion-flamingo\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.44\t11RX4AQA7hMRr1cywTUGe8Z59GECjnN5Gy1or5ax9EzL3EzQkyS\tlucky-sepia-aardvark\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.45\t11SX1iwY4kyVFnKtdAidHaq2GEEUYLfm2qdywbRKP2ZoJFpFXkW\tproud-snowy-lynx\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.46\t112W5txnCKkbD1Tq94La61cGwYrHEf2TTTSEPVt2udydUKqkSxrq\tdecent-peanut-fly\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.47\t11m9iqQCc3ATkqME57DKZuMBzM8wVkP9UFBoConWs9nTEvSReXi\tgentle-tawny-porcupine\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.48\t112kcRKtVRGfYBk8MQ1ZBqn2XnF6G873shZSZeWS2hZZmXsGWd9N\tovert-blush-dalmatian\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.49\t11Znp9TyvJH6LTMTwqJxDo9Sph6qtgXXKfkNWRYa3LR85iLrKit\tearly-cornflower-crow\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.50\t11LngonfbhoQp1h7cfWNkDd2ay5sRZpfJ32EnC4w537226iiAqM\told-seaweed-haddock\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.51\t112QiADs5xyqPD9EvJVaaSGBmCk6gLQJEMTxS8VC3zddSmuj8gof\tattractive-aquamarine-baboon\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.52\t112ghWFcmbhKGNwkZihyFLCYcz8DhocDmTaMX5nAa1jJeK4jw4XB\tskinny-silver-wren\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.53\t118LEPb4eBMkk2zVzV7xAiBRTnQj8ikQVFFuq5e3Fz9UcGZCEXJ\tjoyous-wintergreen-cricket\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.54\t112TWc8E4SS3rHR7c2gYaXWu1JveaWR8tNn1sL9mmga8PaXptpVp\tbreezy-bubblegum-chinchilla\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.56\t11fZCpe9kr3NfFWHYw4gdypt6pu3fmZCcxF32WUPuZ6WKngSBya\turban-juniper-starling\t14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\n" +
                        "192.168.1.58\t11LW4sAiHbZgdE97RAN5P2DnRbjhENq2aKPFafFRqLDWQ6yK7PV\tteeny-misty-shark\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.61\t112UhRCTiDmkUtA1gGKY6adKd3r8hkAKYspLNbexm6dhN1f2ruFa\tatomic-cotton-mockingbird\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.65\t11krSSBTB92YKjdVDz1asTUWC4xJeZVueHHGbWpP5y9fnz1e8x8\tsquare-myrtle-jay\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.66\t112BCpBoK1YsWbea6wkgJgmoVA8bUzS1ZWjYz62YwBAvUrtoEzN\tsour-viridian-lynx\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.67\t112QZDpifT2Xtz1h8W8XD9fmUutkxHAU8bL93cSRf9gjqupzn3PW\tmuscular-vermilion-duck\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.68\t112wCoALUd6dKJq7jJyd8PUzbLUDN1tMzDtof4ztjwBuspX7MqJT\tactive-pebble-turtle\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.69\t11N3EReoXVT19VK9zf4oeF6hSxxNuNJ9guk9b4w4WmFQvL35Jzv\tshaggy-hemp-halibut\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.70\t11iB9XP9L1H9Hb2zjErdxLu9VWToak5v3PGJes23wjjJQ3Knric\tcrazy-leather-ram\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.71\t11DcPson4UCCAxM4oDFGk1VvhTUigjSsTeTv3uKDJoAfPtST7Bo\tdapper-cotton-vulture\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.72\t112ZEG6km6uGZuEBzbxQvDL9PboxGMQ3N4pdBN9k9HfKLtRXYDCe\tquick-berry-viper\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.73\t11UrSLvB4HmP1pFqSezqJkrnxoQKYYxugozXtYthrV2iY7ZMGf9\tsavory-lava-raccoon\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.74\t11zJJwJdJ1Ciw9KnWqyTDevRH4mQhpFsaQfABCFaEZ6T6QfHNHw\tsuave-fern-grasshopper\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.75\t112bvbuJ9oQMjgmLjZDPo4faPhJQ1JisJCvPPLzuPrGgUNQazmGJ\texotic-raspberry-bull\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.76\t112q5zUBY3bnpRQbUQTDZXorTjNL5N2BJX8RPjHX21GHSFmS5NXq\tpassive-sage-hyena\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.77\t112rkUgugfgXkV2VDGhkzpvkKohoP3FBDtMj6FbLht143DJKUuAs\tcareful-latte-lizard\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.78\t112o7on53JpkNqZSQL8YPop6a47vemw4a9r78tRRvubh54iSyvHq\tquaint-nylon-unicorn\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.79\t1127rrtr7epTGNa64r8n7BUFWNCNXw6meNnqypYgPwcc1EnjPFF5\ttart-black-loris\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.80\t11mogWXuXc8W7FMoVs88ryQjwUvu9QadrpVeEyXpfmnWRrf3Mwg\tbig-amber-newt\t13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\n" +
                        "192.168.1.81\t11pxXSxJk8UVhWz2b6S9paE3enqjTjkgKR5YrNzdCvGxXiEgKsB\teager-paisley-worm\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.82\t112dBhTfUEk7ffs9UY1P228fvz4j2SiNAogp8eUWBwUkfxbjXWJm\tsavory-burlap-haddock\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.83\t11pePPPHqwcApnYSeg9kqDheZTscqQVhH8M5cYMGeihFv8WtBuL\teager-watermelon-bird\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.84\t112NtQ9YATMTNBVkgvJ7g9fVinunUoDXyaSbZNufJGSN65rdVi4z\tnice-canvas-porcupine\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.85\t11fkyJdndnhmBPnWPt76RygkhCGB7byNbFy8rtAbwU9f2rgg75Q\tshort-navy-worm\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.86\t112qJVYq2wN8pDq7v1BsnPbEiz5tXMh2p8ajhbXcRdoSjV2PiDh1\thollow-cider-salmon\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.87\t1122JgT6LfFYafCD3UxSWnox3D5qhM2GxkMoz9WQd6rHtnKr5QrQ\tfresh-opal-sloth\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.88\t11EUBRwHNrXVF7B8vbmM9BEAuYnwb25FHpeAoyiRhFPhRmKx6zm\tjoyful-seafoam-boa\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.89\t112QJiVYBxJYa2JtdB9ws2t1W5mJPfmLE4nAULnaHMRmLESKmMSh\trural-cornflower-urchin\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.90\t11tMfSLXLRErG214Jp1MvqKjk72GH9Anpec84ycXCdP5TChE2Vs\tdelightful-clear-lion\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.91\t112WBB7ipiaXiQ4J3uBwbteVkfCaZDcLzjxUD99gpKxLL5PQVFA2\titchy-blood-cormorant\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.92\t112Y9RgvjCsGDcJ4DUHiyL1k33NiFK4ZPck6ktNzYkYo1kgefYuw\tgenuine-metal-coyote\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.93\t112Nnpbjj1p9gYqBzoQTywG41DiEa4XYTCm1dyRN3L7c73ofLotY\tmammoth-macaroon-seal\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.94\t11A9DQRVKV66LvThUwMNKmyr9TWWa2abahcuPLzHDp7vWtnPHaJ\tcurved-amethyst-bobcat\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.95\t11tDpPhqMxSn4vvUKL7dY3P5ZDMKkieGkypmsiBR8QZKqAVHgxH\tlong-golden-nightingale\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.96\t1127NdUGdt8UmtNZH79a5GTeQiPHLjyXvKkPP3Z6BjykB53bsdXm\tmacho-pearl-llama\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.97\t112LFzhfpfQx99Yd9bncVWexM32et7dFGvrJiyeyoqPZmBAx2GzL\ttiny-crimson-fly\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.98\t112YBcb94zPa4F7bB4jtj3iKQD3neRySAmABZ5fk8wr31jJV4DUv\tlone-plastic-platypus\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.99\t11BTMNfWanAHt8Vg2ExswYrK7B1RcJnsQQhJde83hjDWRboZNyG\tfuture-pickle-llama\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.100\t11gDCQYimqabABAKC1kQ7TdfvMmAcL8aLWzDwPB1mJSkvNsrMUT\tfestive-hickory-crab\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.101\t112J9ed8i8NgpCAUNGejUsqYEHpT94DFdFq6XCHcHEfNmsECw2Kb\tactive-viridian-tadpole\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.102\t113Zo3iVJ3vJvGnKDWCaK3hDm9HA8Q3Dj29zWwtCJeEkE5LUaEp\tatomic-sage-peacock\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.103\t11vNkSTsgvqtjsTrRajZScMhhYbVw1EZZtMayiUrL5pUMjXQpyN\tpassive-marigold-sheep\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.104\t112gNiRmvPGY2rEUtwckjT8RbPUmMLZMbQ5KjvVJFn65Qp9bAS1F\tdizzy-wintergreen-cheetah\t143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\n" +
                        "192.168.1.105\t1121vdjaV1kZV1ACBaLYU22mVLCdwWNVokmjVE2ARpp1dJo7NnCB\tfit-rosewood-sheep\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.106\t11ghfQ7zcspcvw3KZLLbt1At1pGXsu52NqopkAdBmWqHkwfrRF2\tdaring-peach-mule\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.107\t112YZ7GYV5Ggi2ihCDF1STo7ddh8P7ovLdyHXDQXQMK2cBHMzfMj\tlate-holographic-tadpole\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.108\t112B4BtqV12qKRivG5LMWTuQiWhCqoKMeooFpGx5iFis3TTnewXM\tfeisty-gingham-ostrich\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.109\t112TknNTozTgq4AxD8T6JQBcykSHUh5cxHSExNTy2zf6Jm6gB6i\tproud-glossy-horse\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.110\t11C2N6SAEwGRhV9wmy6RtHfaJTXG4uhDKpCJExkkEZxU9sa44Pg\thollow-blush-ladybug\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.111\t11UGpqmQf93wAQ5wM31yu5nYPCVg4CTb4TSzzGEK9htPZcagBK3\tnice-brick-tardigrade\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.112\t11cdLRMDsAMVrq1vW1EcB1ne6zjsmhzjm3uS1fz9QxQbocTfSZu\tspicy-tawny-tarantula\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.113\t11XczZjuZZTetetJifcLNxLVCH6WSgPz3MCXrfm3D8zGsio5z3X\tfurry-marigold-worm\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.114\t11gY4MA6SngNrFsQtpDt71nZSyNpUx5nakAyAwXia3SmGPJFqk7\tdancing-ruby-cuckoo\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.115\t112wHCokvsBq8ZAb4wnF2nDu5pG9NcfFA93ePVX7JciXh1Bve1Pz\tmagnificent-khaki-sawfish\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.116\t112iWEgqsx1MWBJuGwep5rSYWi8tUjnFDShnVsck2tZyGgvmUYyC\tlarge-jetblack-barracuda\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.117\t11a9z9wxP4vF23124n9SPCuawQhyyNLgrQMQNDZo1mxhSopmWWS\tmammoth-paisley-tarantula\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.118\t1121q7DWNDRoJaYh1ouC2ECHUqqr1dEP6pRS7UKqYhcwKsFzspVS\thollow-boysenberry-sloth\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.119\t11ibQYKdc5o8agXPRu4NCpBhTyEQmBDAAjcJwmZRRFag18G6Hkf\tstale-mango-parakeet\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.120\t11Ab3StxLobxZZCaYpdeUdK8Y4EcHefURjYGRESX6ZnjMRsPFAU\tzany-seaweed-squid\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.121\t112WjoeY5cCVm7ipFSLWeqcRGfYqLSiKT1AQ7MPHSyrFgknuM93Z\texotic-heather-poodle\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.122\t1123yXL1F8vgSVnH6SCRDE519mmWKdpTiwQx1q2bsf2xqm3e3K7r\tmacho-sangria-mustang\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.123\t112ubzM6gYE1YGe3NeuvNChiK3wA4oFAuA8vT8zx21LQR8THoFkG\torbiting-currant-swift\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.124\t11WWSp5vFXidFvxVDNqAJdRnBcfm5WCevx1xkorT3o8oBPMAMzV\ttricky-emerald-dragonfly\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.125\t112T3D89SLyWGAmNvBDN9KGaAhkNLzCYqw5VhfDXjyA4ZAmGrKLf\tskinny-silver-camel\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.126\t1123fqRkTege9yPzhmjGr93EeKxxX4eJ8gBiuJ3xnjwrRHNR61mc\traspy-pewter-piranha\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.127\t112P1xvWFjEpT26GUAY8u5nn3A8dt1fCQzgMF4ENn6CK1gM13FwV\tfierce-tweed-meerkat\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.128\t11kXqJjxDWpn6LM4sBC119JzApFriHA1nyUXLVeVUZbtr3KwyZ4\tmagic-jade-lynx\t13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\n" +
                        "192.168.1.129\t11Wih2H7sGMaSiqiqYC6hdqG5ZrkHm3grAFxDjGMi74xi5UB2ok\tthankful-powder-ferret\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.130\t11BsVkkwXQschKgWv8wfkxFcFskbrjr8fBANjeMLiEvMrmPtiCc\tdapper-scarlet-dalmatian\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.131\t11o9xPHFUJ2kEnL5oQuvT15hW9U9hpDxTXkpuLPzHZJTATJdjfA\tradiant-sand-finch\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.132\t11GbRiDthADxUDynk8pZdxrKSxNdwXBQKV61tEbwxW68JwmARb2\tbumpy-carrot-pig\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.133\t11TiEuToe72zRbDmaFc6Eo9o4REQqjippGgQB4wrStKdSJizVyX\turban-teal-ram\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.134\t11217vnp1oGnQLjr9ZiUqeJL9x9TLfKNXx6iCPC9oPxuxGks4MZ\tvirtual-raisin-albatross\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.135\t113Sruj9CRHFqWafLvviwE3xhBpQuNSZ4GFzGuEdD4Ar8PPz7cr\tjumpy-aqua-deer\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.136\t112h346dWXdk2F97kSLqigP849EakgkVeqZFxRTN8oJCB5UHnZN6\tnice-seaweed-butterfly\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.137\t112jhoa2JFDQHYMTQMr61YXP7xY5Xu2ksDuUxt51rrodFox4U6dV\tdigital-onyx-worm\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.138\t117VLhC7ervQA4kChLeRLtL1xfidKRmchoSDm9wtkoC6Y8aWZtt\twide-pistachio-carp\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.139\t112GZsMSPhE3Fig6SEXsZBLFQogd5AGus7zxmuLDimpsrY8xHCvz\tstrong-licorice-panther\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.140\t112LSmCiN6CAmDtDURATVAgbcN2aSBrcCpDAT59oiHpuc3we48uQ\tskinny-corduroy-bat\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.141\t119dznd7mgA4t2RoEuRHMRYPCTUx38tPQafqKqRa6kZee5BN81k\tstriped-khaki-tiger\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.142\t11xMu6bPWKMzg5epmTm6rZbwT8w4wPfcVJf8jGrduzxWfoms12m\told-pistachio-sparrow\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.143\t112EAayBVcfuYrPm3oYX9jW6uWrPPXPCnFKvfLES5ghskb4XZdwp\tshort-vanilla-huskie\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.144\t11rZ5uaKDsd676SxDofbnfSwvErjdQFxiJS3Mjd6qL6fsTDxRHL\tlone-marmalade-gazelle\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.145\t112qz3uQCFJ22rCjHMRx5j1qebfoTA2DAAxnDSEG6V628o7kYh93\tswift-pewter-narwhal\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.146\t11NFZZTRCjpW5jiTDF4jZYtabJVe89jAfHE2Q8tB9yC33GsnXJW\tsilly-berry-tuna\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.147\t11nFKTqTQtP3SXBf9qkB9LZGG9NnQpfvnozP454LjPjQ6sq1t3p\tyoung-shadow-terrier\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.148\t1124KHx85zw9Lt9mkiHaDVuu9zx1c5V9BaCXqAEMCs3YzJuefJdT\tovert-shadow-ram\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.149\t11y8GQE7pPeThc4h2A2u3r7231u67NqyxUsaZAFwydCk5BUgSdr\tglamorous-metal-unicorn\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.150\t11y4mzEEUiQHgFV4tcgkZAhPwc5XBaSYA2crNPuzdfPhoT5NFnP\tclumsy-tortilla-rat\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.151\t112R4Lvj872FstL2trTgWt6owG5Fd6FrAN91ubBL4GHLTUz9PsbA\tstrong-vanilla-barbel\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.152\t1143wdNEFWCVkGMPaNyewFUVBBbQiCgsPSBxfe6LYKEZkfYoN8X\tsweet-lemon-bird\t13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\n" +
                        "192.168.1.155\t112Qr5M9Bmn1Gopzv9x63dUT8KG6eGmuSy9g37V4pNgXimfLqXeZ\tmicro-aquamarine-manatee\t13oQYMNSAKFk48UqbM168cY6w5RZHuf7S82Ls65dFLQjsA3MTT4\n" +
                        "192.168.1.156\t112JGav7Ssc4cBUXr32bDNDjTGph2E7kjymVEDGEkB2QV7mcEYA6\tcheery-shadow-rooster\t13oQYMNSAKFk48UqbM168cY6w5RZHuf7S82Ls65dFLQjsA3MTT4\n";

        String walletStr = "14pbpT7VVBPXjsQfbyZrKK5nzXsFLRUSnqweuE4RTSaSTBBE4HS\told-key1\n" +
                "14iLv4ftoL858TUFmESYknxDGpQiqdZbg335igHKbWnHW8FKdUv\told-key2\n" +
                "143dmuZyHLRYcPv35NJJaf14oYcVHjJd71XZGZxCdPneiLqvgbH\told-key3\n" +
                "13ZaRYoK6U5F19Ur4oaUzdDpJcCzLj1uqkMwjyT4M7CKtwoBvMj\told-key4\n" +
                "14Rxis1EBoiw2eZUuppVhyFg5wvajjRABEk9YygZBvQuLxcJwNj\told-key5\n" +
                "14YpRz62kn1wcGveZPLXCpsREnJYNe3siUzvGseCpoiuKKqtqfg\told-key6\n" +
                "14dzeqYBhrXz2HB7TVg2T9U7QnmvkPUg3x6Bzfq8vu8KMwagB7P\told-key7\n" +
                "144RHTiYv4vf7cFT27hWeGjDsosojbuh6xg4mn9M6wJ9sswRiot\told-key8\n" +
                "145butrmx5p6crVNdd8w83bkNiqsy8Sg5hGFznhehwiFMkZqUfa\told-key9\n" +
                "14dWoi3oBRVhiXugaqgUpt21Wd9p2JpEAAMWaqVF5PMLdBbnrR4\told-key10\n" +
                "13DTLhW9jb9rZNhQpEYKnBcXeChucwW3d17rvvwkBc1yYvmgk9Q\told-key11\n" +
                "143gzuc6J1djyv86ZqcXTfFk1JzuHcSz3Bb1XuUiWiFAEKn7CV1\told-key12\n" +
                "13Hrgk7F8JeeoZH9yr19vAZ9rC8VdnvjAAaZYQvYmqBwq9YRiRa\told-key13\n" +
                "14P2HCY8MPuxakD1WutsGZPqV3dJu2ZCyUDJXGiQnMG9VLFD6gb\told-key14\n" +
                "14ThUvBZouMrdiFYLLRP8N6HExrV7hNNzsUdpM2qH3SZ4vWqzff\told-key15\n" +
                "13oivJ9MBM6PiF4jRSL78RFP1saypSyQS66r42BwPJABwtdSeLa\told-key16\n" +
                "143SmUjEpCTD54p8Bacjctr8t43zzd4xXcg2VWrYmzSUHMMChwa\told-key17\n" +
                "13u8mbP4qodHtFwnjpcZrkYC5KLzkDMfzwu7w7sZxuECcA23Yy8\told-key18\n" +
                "13Qx9ztQpcfkpxJYQUXJxwRoSfxcUiaedYbSuLGMoNjeTr2FG6C\told-key19\n" +
                "13oQYMNSAKFk48UqbM168cY6w5RZHuf7S82Ls65dFLQjsA3MTT4\told-key20\n";

        // 山猫：1680 黑豹: 1681
//        structureInfo(groupStr, deviceTableStr, "./data/Hex.txt", 150, 27, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr,"./data/Hexs1.txt", 160, 29, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr, "./data/Hexs_shcz.txt", 416, 55, "shcz", "001616geae", 1680);

        structureInfo(toTableMap(walletStr), groupStr, deviceTableStr, 676, 91, "sh-cz", "001616eeae", 1680);
//        structureInfo(toTableMap(walletStr), groupStr, deviceTableStr, 706, 95, "sh-cz", "001616eeae", 1681);

    }


    /**
     * @param groupStr
     * @param deviceTableStr
     * @param hexPath
     * @param startIndex
     * @param groupStartIndex
     * @param groupName
     * @param gateway_ID
     * @param port
     * @throws MsgException
     */
    public void structureInfo(Map<String, String> wallet, String groupStr, String deviceTableStr, int startIndex, int groupStartIndex,
                              String groupName, String gateway_ID, int port) throws MsgException {
        List<JSONObject> deviceTable = ExcelUtils.readTxt(deviceTableStr);

        for (JSONObject jsonObject : deviceTable) {
            System.out.println(jsonObject.toJSONString());
        }

        List<Location> locations = BeanUtils.toJavaObject(FileUtils.readLine("./data/loca.txt"), new TypeReference<List<Location>>(){});
//        List<Location> locations = structureInfos(groupStr);

        logPath = String.format(logPath, groupName, deviceTable.size());
        List<Gateway> gateways = new ArrayList<>();
        Gateway gateway;
        int ipIndex = 0;
        for (Location location : locations) {
            ++groupStartIndex;
            for (int i = 0; i < location.getGeoCoords().size(); i++) {
                if(deviceTable.get(ipIndex).size() > 2){
                    gateway = new Gateway(++startIndex,
                            location.getHex(),
                            deviceTable.get(ipIndex).getString("ip"),
                            deviceTable.get(ipIndex).getString("address"),
                            (groupName + groupStartIndex),
                            location.getGeoCoords().get(i),
                            deviceTable.get(ipIndex).getString("name"),
                            deviceTable.get(ipIndex).getString("owner")
                    );

                    gateway.saveExcelFiles(logPath, wallet);

                    gateway.saveConfigFile(filderPath, gateway_ID + "000000", port);
                }else{
                    gateway = new Gateway(++startIndex,
                            location.getHex(),
                            " ",
                            deviceTable.get(ipIndex).getString("address"),
                            (groupName + groupStartIndex),
                            location.getGeoCoords().get(i),
                            deviceTable.get(ipIndex).getString("name"),
                            deviceTable.get(ipIndex).getString("owner")
                    );

                    gateway.saveExcelFiles(logPath, wallet);

                    gateway.saveConfigFile(filderPath, gateway_ID + "000000", port);
                }

                ipIndex++;
            }
        }

        if (deviceTable.size() != gateways.size()) {
            System.out.println(StringUtils.outStr("数量不对 ", deviceTable.size() + " " + gateways.size()));
            return;
        }

    }

    public List<List<String>> toTableList(String groupStr) {
        String[] vals;
        List<List<String>> table = new ArrayList<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
            table.add(BeanUtils.toJavaObject(vals, new TypeReference<List<String>>() {
            }));
        }
        return table;
    }


    public List<Location> structureInfos(String groupStr) throws MsgException {
        List<List<String>> groupTable = toTableList(groupStr);
        List<Location> locations = new ArrayList<>();
        for (List<String> lines : groupTable) {
            locations.add(HeliumUtils.getLocation(lines.get(0), Integer.parseInt(lines.get(1))));
        }
        FileUtils.write(""+System.currentTimeMillis()+".txt", JSON.toJSONString(locations));
        return locations;
    }

    public Map<String, String> toTableMap(String groupStr) {
        String[] vals;
        List<List<String>> table = new ArrayList<>();
        Map<String, String> resultMap = new HashMap<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
            resultMap.put(vals[0], vals[1]);
        }
        return resultMap;
    }

    @Test
    /**
     * 显示表格
     */
    public void showTable() {
        String groupStr = "192.168.99.9\t11YoHxPnH14y6QoyM8nYKnh8gzpSDFVnDNmXyo1eFk7ak7fyH53\n" +
                "192.168.99.6\t112DNL9uZV31t1RMv47worRKHM7reLvPTSHy9in9CZev6abmE6xw\n" +
                "192.168.99.13\t112b59GHotCp7YffkdWvorRL2hXvSSCgiBggtYZmDK4T3C6vUSPy\n" +
                "192.168.99.7\t112efYYTU2rPsZcwRG8MWVRKwSeZJP66Es4AjKeo2VcXdDEA1rdp\n" +
                "192.168.99.10\t112aKEDCuqnrQ2j3epfvzLx1RmumjcypfFXupfaAy5Zw9xnbxW6T\n" +
                "192.168.99.5\t11HVpageFBUaAKsFehWAXfBY7hhABMTJb5m8VH7Bpqm41VNGYD2\n" +
                "192.168.99.11\t11ce8SK6TGW769LG9iYmi7sLQKFZrcXspSkM4hPJz5aN9zS2XhV\n" +
                "192.168.99.4\t112G5wD2AwAiVUiB8tjCvS2KhztUDGykcTrs7z55Kb1BRw9jmaBV\n" +
                "192.168.99.12\t112Dsfytc4UYj39QCLaQFiV1qPfNG8mVGWiSHhtkGrFijcU6jBy6\n" +
                "192.168.99.8\t11htcJGGWcKrA5QqXrRXFHiFUT9NVjCH7GPDRoWJsRrZbeKixrX\n";
        String[] vals;


        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
        }
    }

    /**
     * 随机设备【递归|单用】
     *
     * @param completedRewardsBean
     * @return
     * @throws MsgException
     */
    public Device getRandomDevice(CompletedRewardsBean completedRewardsBean) throws MsgException {
        if (ObjectUtils.notIsEmpty(completedRewardsBean) && ObjectUtils.notIsEmpty(completedRewardsBean.getHotspotIds())) {
            String id = completedRewardsBean.getHotspotIds().get(NumUtils.intervalRandom(completedRewardsBean.getHotspotIds().size()));
            completedRewardsBean.getHotspotIds().remove(id);
            Device device = getHotspotsById(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            if (ObjectUtils.isEmpty(device) && device.getStatus().getOnline().equals("")) {
                if (ObjectUtils.isEmpty(device.getReward_scale())) {
                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
                }
                return getRandomDevice(completedRewardsBean);
            }
            return device;
        }

        throw new MsgException("没有可以使用的位置设备了 " + completedRewardsBean.getHex());
    }

    /**
     * 获取设备信息
     *
     * @param id
     * @return
     * @throws MsgException
     */
    public Device getHotspotsById(String id) throws MsgException {
        HttpResultData httpResultData = HttpUtils.get(String.format("https://helium-api.stakejoy.com/v1/hotspots/%s", id));
        Result result = BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<Result>() {
        });
        return BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
    }

}
