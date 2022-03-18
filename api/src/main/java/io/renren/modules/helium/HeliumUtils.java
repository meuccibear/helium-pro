package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
//import com.uber.h3core.util.GeoCoord;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.HotspotsProfit;
import io.renren.modules.helium.domain.Location;
import io.renren.modules.helium.domain.Result;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro
 * @ClassName HeliumUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-08 14:27
 * @Version 1.0
 **/
public class HeliumUtils {

    static String WWW = "https://helium-api.stakejoy.com/";

    /**
     * @param typeId   天
     * @param hotspots 24小时
     * @return
     * @throws MsgException
     */
    public static double getHotspotsTotal(int typeId, String hotspots) throws MsgException {
        String url = "v1/hotspots/%s/rewards/sum";
        url = String.format(url, hotspots);
//        System.out.println(url);

        Map<String, String> parameter = new HashMap<>();
        switch (typeId) {
            case 1:
                parameter.put("min_time", "-30 day");
                parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
                parameter.put("bucket", "day");
                break;
            case 2:
                parameter.put("min_time", "-48 hour");
                parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
                parameter.put("bucket", "hour");
                break;
        }

//        System.out.println(JSON.toJSONString(parameter));
        JSONObject jsonObject = getJSONObject(url, parameter);
        JSONArray jsonArray = (JSONArray) JSONUtils.getObjectBycol(jsonObject, "data");

        List<HotspotsProfit> hotspotsProfits = BeanUtils.toJavaObject(jsonArray, new TypeReference<List<HotspotsProfit>>() {
        });
//        System.out.println("------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ");
        double total = 0.0;
        LocalDateTime date = hotspotsProfits.get(0).getTimestamp();
        date = date.minusDays(1);
//        System.out.println(DateUtils.asStr(4, date));
        for (HotspotsProfit hotspotsProfit : hotspotsProfits) {
            if (date.compareTo(hotspotsProfit.getTimestamp()) < 0) {
                total += hotspotsProfit.getTotal();
//                System.out.println(DateUtils.asStr(4, hotspotsProfit.getTimestamp()) + " " + hotspotsProfit.getSum() + " " + hotspotsProfit.getTotal());
            }
        }
//        System.out.println(total);
        return total;
//        System.out.println(progressBar((int) (total * 100)));
    }


    /**
     * @return
     * @throws
     * @title 根据设备地址获取设备信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:18
     */
    public static Device getHotspotsByAddress(String address) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("v1/hotspots/%s", address)), new TypeReference<Result>() {
        });
        Device device = BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
        return device;
    }

    /**
     * @throws
     * @title 根据钱包地址获取钱包设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:21
     */
    public static List<Device> getWalletByAddress(String address) throws MsgException {

        get(String.format("v1/accounts/%s/hotspots", address));

        Result result = BeanUtils.toJavaObject(null, new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }


    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public static boolean notIsDevice(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("v1/hotspots/hex/%s", hex)), new TypeReference<Result>() {
        });
//        System.out.println("notIsDevice:\t"+JSON.toJSONString(result.getData()));
        return ObjectUtils.notIsEmpty(result.getData());
    }

    public static GeoCoord lookAround(String hex) {
        String resultHex = "";
        boolean sw;
        for (Object o : HexUtils.hex8Offset.keySet().toArray()) {
            try {
                resultHex = HexUtils.offset(hex, (String) o, 8);
                sw = notIsDevice(resultHex);
                StringUtils.writeList("\t", "【hex】 ", hex, o, resultHex, sw);
                if (sw) {
                    return null;
                } else {
                    return GeoCoord.build(resultHex, H3Core.newInstance().h3ToGeo(resultHex));
                }
            } catch (MsgException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Device> getHotspotsByWalletId(String wallId) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("v1/accounts/%s/hotspots", wallId)), new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }

    public static String get(String url) throws MsgException {
        return get(WWW, url);
    }

    public static String get(String qUrl, String url) throws MsgException {
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtils.get(qUrl + url, HttpUtils.getHeadres(headersStr));
        return httpResultData.getResult();
    }


    /**
     * @return true 黑 false 白
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/18 20:06
     */
    public static boolean denylist(String address) throws MsgException {
        JSONObject jsonO = JSON.parseObject(get("https://denylist-api.herokuapp.com/", "api/hotspots/" + address));
        return jsonO.getJSONArray("denylists").size() > 0;
    }

    public static JSONObject getJSONObject(String url, Map<String, String> parameter) throws MsgException {
        HttpResultData httpResultData = HttpUtils.get(WWW + url, parameter, new HashMap<>());
        return JSON.parseObject(httpResultData.getResult());
    }


    /**
     * 随机设备【递归|单用】
     *
     * @param completedRewardsBean
     * @return
     * @throws MsgException
     */
    public static GeoCoord getRandomDevice(CompletedRewardsBean completedRewardsBean) throws MsgException {
        if (ObjectUtils.notIsEmpty(completedRewardsBean) && ObjectUtils.notIsEmpty(completedRewardsBean.getHotspotIds())) {
            String id = completedRewardsBean.getHotspotIds().get(NumUtils.intervalRandom(completedRewardsBean.getHotspotIds().size()));
            completedRewardsBean.getHotspotIds().remove(id);
            Device device = getHotspotsByAddress(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            GeoCoord geoCoord = lookAround(device.getLocation_hex());
//            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
            StringUtils.writeList("\t", "【reward_scale】 ", device.getReward_scale());
            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
//                if (ObjectUtils.isEmpty(device.getReward_scale())) {
//                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
//                }
                return getRandomDevice(completedRewardsBean);
            }
            return geoCoord;
        }

        throw new MsgException("没有可以使用的位置设备了 " + completedRewardsBean.getHex());
    }

    /**
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public static GeoCoord getRandomDevice(List<String> cHexs) throws MsgException {

        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size()));
            cHexs.remove(cHex);
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord)) {
                return getRandomDevice(cHexs);
            }
            return geoCoord;
        }

        throw new MsgException("没有可以使用的位置设备了 ");
    }

//
//    /**
//     * @throws
//     * @title 极速随机Hex
//     * @description
//     * @author Mr.Lv lvzhuozhuang@foxmail.com
//     * @updateTime 2022/3/15 7:10
//     */
//    public static GeoCoord getRandomDevice(List<String> cHexs, int num) throws MsgException {
//        List<GeoCoord> geoCoords = new ArrayList<>();
//        Map<String, String> keys = new HashMap<>();
//        GeoCoord geoCoord;
//        while (keys.size() != num) {
//            geoCoord = getRandomDevice(cHexs);
//            if(geoCoord.){
//
//            }
//            geoCoords.add();
//            keys.put()
//        }
//
//
//        throw new MsgException("没有可以使用的位置设备了 ");
//    }


    /**
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public static Location getLocation(String address, int num) throws MsgException {
        List<String> cHexs = getCHexsByHex(address, 5);
        Location location = new Location();
        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0), 5);
        if (ObjectUtils.notIsEmpty(cHexs)) {
//            if (num < cHexs.size()) {
//                throw new MsgException(String.format("该地区不够%d个位置~", num));
//            }
            System.out.println(cHexs.size());
            List<GeoCoord> geoCoords = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                geoCoords.add(getRandomDevice(cHexs));
//            System.out.println(String.format("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
//            System.out.println(String.format("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
            }
            location = new Location(hex3, address, geoCoords);
        }
        return location;
    }


    /**
     * @return
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public static Map<String, List<GeoCoord>> getLocations(String address, int num) throws MsgException {
        List<String> cHexs = getCHexsByHex(address, 5);
        Location location = new Location();
        Map<String, List<GeoCoord>> geoMap = new HashMap<>();
        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0), 5);
        if (ObjectUtils.notIsEmpty(cHexs)) {
//            if (num < cHexs.size()) {
//                throw new MsgException(String.format("该地区不够%d个位置~", num));
//            }
            System.out.println(cHexs.size());
            List<GeoCoord> geoCoords = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                geoCoords.add(getRandomDevice(cHexs));
//            System.out.println(String.format("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
//            System.out.println(String.format("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
            }
            geoMap.put(hex3, geoCoords);
//            location.json = new Location(hex3, address, geoCoords);
        }
        return geoMap;
    }


    /**
     * 根据设备地址及分辨率获取设备
     *
     * @param address 设备地址
     * @param res     分辨率 1-9-c
     * @return
     * @throws MsgException
     */
    public static List<String> getCHexsByAddress(String address, int res) throws MsgException {
        Device device = getHotspotsByAddress(address);
        //获取该CHex的父级分辨率
        String parentHex = HexUtils.h3.h3ToParentAddress(device.getLocation(), res);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<String> cHex = new ArrayList<>();
        for (String hex : HotsPottyUtils.getHotspotHexByCHex(device.getLocation())) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(hex, res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(hex);
            }
//            StringUtils.writeList("\t", "【父级】", HexUtils.h3.h3ToParentAddress(hex, res));
        }
        return cHex;
    }

    /**
     * @param address 设备地址
     * @param res     分辨率 1-9-c
     * @throws
     * @title 根据设备地址及分辨率获取设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/16 15:32
     */
    public static List<String> getCHexsByHex(String parentHex, int res) throws MsgException {
        //获取该CHex的父级分辨率
        String sonHex = HexUtils.h3.h3ToCenterChild(parentHex, 12);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<String> cHex = new ArrayList<>();
        for (String hex : HotsPottyUtils.getHotspotHexByCHex(sonHex)) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(hex, res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(hex);
            }
        }
        return cHex;
    }

    public void saveLocations(String text) throws MsgException {
        List<List<String>> groupTable = StringUtils.toTableList(text);

        Map<String, Location> locationNums = new HashMap<>();

        for (List<String> lines : groupTable) {
            if (lines.size() >= 2) {
                locationNums.put(lines.get(0), HeliumUtils.getLocation(lines.get(0), ObjectUtils.toInt(lines.get(0))));
            }
        }

//        FileUtils.write("./data/locations", JSON.toJSONString(locations));
    }

    //筛选 空的位置
    //        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
    //        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
    //        GeoCoord geoCoord = getRandomDevice(completedRewardsBean);
    //        System.out.println(geoCoord.toString());

    @Test
    public void asd() throws MsgException, IOException {

        //        System.out.println(JSON.toJSONString(getHotspotsByWalletId("14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob")));
//        h3ToParentAddress
        H3Core h3Core = H3Core.newInstance();
//        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
//        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
//        Device device;
//
////        device.getLocation_hex()
//        for (String hotspotId : completedRewardsBean.getHotspotIds()) {
//            device = getHotspotsByAddress(hotspotId);
//            StringUtils.writeList("\t", "【父级】", h3Core.h3ToParentAddress(device.getLocation_hex(), 5));
////            HexUtils.
//        }


//        List<String> cHexs = getCHexsByAddress("112b5iBRmR5ps5eWpCbB6CoqyDimWDZgDjVMCvbigKDiUmTghJUn", 5);
//
//        System.out.println(cHexs.size());
//        System.out.println(getRandomDevice(cHexs).toString());


//        String hex5 = h3Core.h3ToParentAddress("8c180cd8c8e35ff", 5);
//
//        Device device;
//        for (String hex : getHotspotHexByCHex("8c180cd8c8e35ff")) {
////            device = getHotspotsByAddress(hotspotId);
//            StringUtils.writeList("\t", "【父级】", h3Core.h3ToParentAddress(hex, 5));
//        }
//
//        StringUtils.writeList("\t", "【hex】", hex5);


        //8c180cd8c8e35ff GeoCoord{lat=51.552836, lng=-9.507861}
        //88180cd8c9fffff GeoCoord{lat=51.555244, lng=-9.507171}
//        System.out.println(HexUtils.h3.h3ToGeo("88180cd8c9fffff").toString());


        String str = "112b6Tv1EkwnPps6kxAoXkU7nF8hz9SLUnvTxFk3MTNU3fFjn8cU\n" +
                "112wGciWJtTGyaZrscj6EU6iEuHMc5LqkEd2FTFSQd2CuSxAGhKs\n" +
                "11d5k791uj6KxAUgfYWuCYgWkC6RWjXeH7rh9PisBDie6Qet8Uh\n" +
                "11gRVmUxETzjQv3kVpALAusCkM3Wb1xgwBTSZQzCBkNJuKvS1NT\n" +
                "112QyJZzYBayzs7oSoovdz5ecewQxEsuTATxDxkGYiF6q68Megxd\n" +
                "112EEG9Pn8E7LFwbQB7hr43f5PuHFPm8khcbj8eMARazqkZkgArc\n" +
                "11CfCnw7epNTUsykK1HwbrbyQxZbFnn9Djh5Gx6go7zkvdnNRPb\n" +
                "112GzV1SPoRYwsLkyvRY6YeGPBt9bMrbrX9ksp8QUJuRNtM9FtMz\n" +
                "11ctdQc4kHruxXDAJFJtQbcquzcFWR7mXGgZbcLnatXWDf4vKdp\n" +
                "11peQY3B3U4Qa1NfGP3xW7U2QhRW9LVuH8GdLKwBac12jkZqEFV\n" +
                "11Y9xYGj73HhmHFRWGszJYiTxUgtVG2YG4aEbfbzo5KW5DMw2DR\n" +
                "11MpLpgmQsZcZFgToCymuPp4sG971UVJxauSPkzRU3VAAnJgfzB\n" +
                "11Cp9ad7AjUjgBLfXWpmAHCUBnABy2ZqUnDdE4HFno1VwUdxbKK\n" +
                "112rZpXnXProRmk9PpQGBNZHd99YFCwKFotke284gvgd2qg64KZ5\n" +
                "11amCizSAjd1knV3mDDvkeFLBAJmfGngyz9UCSP5B3DLGdoQHCg\n" +
                "1122SQfbhKaXYH6zQXD6vi5296V4kFeg1Kq18v937udJv4QZQ5hs\n" +
                "112PAyp1utsnwkkCM1nZNzizvNQeW3uaVKPDY6EGWn4broE7dNCf\n" +
                "11YudaZ5cB5Nzd6Pu6XuYEPmMMimT6nzHHfUuSmkJF1m7d8d8dV\n" +
                "112QLy1XhjwUtVgjCr9J3kGzKmkzCrPPQoB6r9kfu31AxuTjRCcY\n" +
                "114iEXvtNJZeKyjek3bRQv5qrGiAqYodt9pMPs9z1Gajn3SZBh9\n" +
                "11mdZNqvZxsbr5cmyGQ9X8FY6J7wkzgnGeJGPYbZWNT9jULgrRV\n" +
                "11nwhDiUuZHu776ZxqsuFv9xQ35zAzumwdUsHf1w9ixvvaDiciG\n" +
                "112BCPJCR94YM32swhXyJUa6FAoJq44CSQoj5FcVWi5rdCtreLJ3\n" +
                "112FYoQG7XrrGUwQiV9wrNUR5vDWU7McKNfdCRiRBEUUp877gTEr\n" +
                "1129TQimyzwrAyqYTsuvfrPNrqAZBq4KUf5vLF4Xfbg1nDsbV3kC\n" +
                "11cG96KSAqNPPrSXwPzCngSLWSGzkkAaRGFqHopAmchxQjrcvrZ\n" +
                "114Jrmtm43moWFPmvYRUMa7KNTtZypdzMJUkJmgmEQeVK986Wau\n" +
                "11JEWFEUokHpkEEpPeyvt37RvbD7vQkEJ9tkP3YaVzDqnfmfn4w\n" +
                "115LMV7RHTaTUcXRhXUTGndXLS94hpkD3QzfgoK5SWefwFBZA41\n" +
                "11qhs29oEFf9Q8RM4LAbo6jxeM6imdJAmbSRr6RNLCWGFZuy2WW\n" +
                "11nuPTY6Gr69u9Z2wrdjPGzHdHVXoZHhZFGpvo8BiMD2xrkUx5f\n" +
                "11GD2J2SUi2jW9vHgB2Sojs2zVZDhYoWKrg2UhY8FHhS3Cv2u7m\n" +
                "112DDzs32xEiEp5LfM3vjsRNK8uQiQk3KZqhMhLNvZhkh6GTqTe2\n" +
                "11wB47Csj1zLuCD6hVjVDMknJa1zR1A6PycUdatQgTE9PLNqHTh\n" +
                "112qYNDrHD3DWC3USUip2ux6z28hgAeS46HDb1sSRC8u8ZrPUofo\n" +
                "112pdebSQ55TZdSbtUCBF7bGSzciCdWUhPHJ9onrN2Razzj6Qcep\n" +
                "112k8bEK2ynJX3qLnuX6P7jnbVj2pdeYf24xtoPrQCZfimCC57c8\n" +
                "112YJMAS7WBi8YCx5uZeZqHksn1jfohdyMiks8BJHcfx7z5iTdyD\n" +
                "112XseSK2bPok6fMkEMNaCA1abFvTV5kNLys58MAPxshTkExBU2p\n" +
                "112wahKY1zMd7536mJQJQy5U2pB9BWPuwh7cQ2j1UUaHrrAqNXeV\n" +
                "112AtFCVvQRhUA4oHjceTt5BBFhY1stVZ9Atdu3SY9hfN2iZX9Yx\n" +
                "118QsxBeZDKu1HPc1kUzwVNP4oAEnZaCPM9TooW3gn8zz25PJfe\n" +
                "11hnS9bry7C2bzaxWaboapn51MkgBkE2fvw1BWif4WBzLRThtvQ\n" +
                "112RWTNX1WhFnNuAkcngfLimgEfayDGKwPk69s5yYSdJwrpxXpyD\n" +
                "11BYU7svTmKPoZErVCsyt6urk6QAzkc8DAUEzCR6CPtGtJmPePs\n" +
                "112PRLYHb668rod6SqU8ak924ZZjAkGYeoF7SwGznC3d6Prhdu7R\n" +
                "112mevXWronhE2T5qpGnt4HWv2MgXADKJu2PM8YbGDXhTftBqYJG\n" +
                "11LBQfYkA38Fx7JpJr9pQWVjZzKPezFcrSnCRykNYJqKH6a4BCf\n" +
                "112fBszvZdMf8QPRV2ax5png2cDSTdMw1LHJUk9G8bWQ5WFuExb5\n" +
                "11Fwsz2D8hXNVHbFFBrqMgJmDNBJdyERyr2fsZR3jQDyj59J1gw\n" +
                "11HzzufbW7FGJ6SRptMk8aRkATKc6R1AR1dv9W3N53AWBMd4FKG\n" +
                "11Eo6eAuQFFgsQFdsy9zpm4etpewAQDd7FBV2qkya8a6MUaPw3U\n" +
                "112AhjanqeNg1SqZ6cPuZAAG2ecqydU3bCpFnMstSoi8XGgYDaQr\n" +
                "11xYWnyuVzm2Kp3NnniUZ6sSyQ6Dk1ve3SGSg3hr5zFq3XLe6WV\n" +
                "112E6kxVhSxTAKUfDZSZ3axrBPTzjzZ4Foc8eC1zoyUWo6sJzCHy\n" +
                "112sP7h4spLMKmN9EzDuaRzSUGciJFDXjDGEYCYVuW2hKwsQccUr\n" +
                "11xjMPLvZjXBzmcYZQHPi78L79KNb7zwJpAzULAsYHTwv8kFHPM\n" +
                "11PamnjAYk31j6TkF9oxZJ8Cwz227sfUC9G6KBUYiBJbHivjUof\n" +
                "112PYp7PFK6e6XSzBi4yQybkZTGZyMPo16MGJTLrAFN4bfdi8djm\n" +
                "11ZfrVanoCxs6VExi9fzYWCuLgcBke8MESdygqZTQdKGVGW9Zgt\n" +
                "11SHFt9AonGghLCrCndFkQZUEt5LdNa4kJhT9pypa6sYpbL73oZ\n" +
                "112gSvxzxKYwju5k8ctuiuDV2MQr4RQLUwqJd8EvSXKjDK6KvA6e\n" +
                "11d6dYBujxZoy53AewLAjbsiUgMBrvhVkB7Eo7oHYBPGaUGrdoX\n" +
                "11cukv8w8Gx3z8FfBd96SejTUr8MFPcK9PxbNh42AwBTD6zK3tS\n" +
                "112PLs2e3zigU8xkXHPW5Pa9xZRSB3NYGR8Fr9snwScAuTSjA1WD\n" +
                "112V7F5CW5iKU1Byaw4c8AezvkcXYvPeb8LCXAsM8G57b5VDTy9B\n" +
                "112GCTc1wnhfzmu6iQo3MPswX7tezH4gBUKCHy1TVZP5FtMvZMAy\n" +
                "112eeTStgUVVTEvtiYvbnuAQiX6vteNPa1xQtF1dUShKNSzzxfQ5\n" +
                "114pbMZwaBTSC15K3wgBGrpFD6PRMqSWcG2bp83upmhQBqLTWLn\n" +
                "112qjXRXrUTnRaVwAJKtvf2u2ETGR43E6EVdWJuxeZNxv2FiePmE\n" +
                "11YSVNKFdwkkbvXFygvMNLu4NZnneCcoiyUbtfDoyksiniUVxf9\n" +
                "11NqytNBBY8JDULQzGhikA3aToaarJHnY985qafz7WsfFQiin5A\n" +
                "112CxDYmCiz5gLvggLZbgdFBfgaTmbqKatdGhh3ST1yD4HzBR2Jf\n" +
                "11qu7XAnxxbBbC4hW8Acxv8qAiLKKp1VZyJwD52hcYjxNTb6nTq\n" +
                "112dbCm4DiwtovnjgBUNKJpiSLa13LbuLV9hQGJyPVdj1x2Wtkhe\n" +
                "112SL6Mi2aQhvyzMv7xteoTnbm5HSA99hPXpXvfAudRzY7w1hUfR\n" +
                "11kjjEspys1bstDSRq4CzvhECCdJYRhTedreaDPxZ1GcJwMTcBf\n" +
                "112HGpFvAVhpbbpUPTfQLxv7roGTfgBEP9HedeXXauJJgdhVYzM5\n" +
                "11QFWkm9fjY6T8R6HjrZei2cjSKjEkLAe83T79xs8RqeiWwmjH8\n" +
                "11skdxBYu8ZjSrjTyFBWrv8e4HxWiQHbvjCwzDajQHqwueH4bxx\n" +
                "11DhXHX4wD5UqpNg9uXo3pNNQFmjq4Q617bGNs7xCW1qujWHc4i\n" +
                "11KMHbyShtGERFzWTPRQiemCwRzCW3MEKPMiMsTNbR8vn84T6Qg\n" +
                "112wPxJsqJ1Wk565pbP4EX2vXgm4HME2RmT5ZWmMgvmcLV4mthmz\n" +
                "1124rw7FTB2f58coGQZTZ28DqkELGnpnwjPrs1wRjrojTNv4AFvs\n" +
                "11bSvrPtb4suhVaC5rZSqYoVykRYQ72Gj1AuyFPhb6o77GnkUjN\n" +
                "11nAGGQH3P8LRaaCt1Qgbh29TgnoHQToqgDq9Ero4vJ7oYt8Skv\n" +
                "112dr2SnDHfkJYGkFSnhdjatqPZSZcSeA3ExzsfZviYkWYkv6NFH\n" +
                "112Bm8XbZBBk99CiWW75jPbwuu1B2BEnwjbN1LujSkaJfvKsUCwn\n" +
                "1126Sio9jWU4EvXX9mDqcCkrcKJNragg5pPWjsfkhNh9RjzxodD9\n" +
                "11PPDkoRhZbhVzYGmGtSZK7g75dzxH6b1GsfDnoS7izDXKem8Zz\n" +
                "112XWEbQ5w4jebUbkFxiahhWgsMd5SDk36hDpAW5VAAEsjcy9SAa\n" +
                "118Zo9jsxSWo7Q8h8tHhMZAXzn51Ms2BRGoJ8xVbZjK9HdRHsiT\n" +
                "112u5NCii7oUFveXr1ouEBcPcLMtYT9xkGMvaQCFDys6f3gvGQKk\n" +
                "112AQ5TBPLExnoq4yHgCAdPf2PAkysySUv5kvMtkkv18Ha8qLJkx\n" +
                "11261NQcaS7h7HPK1eDW9HcfiiTTsEErjo45FfwYXwkvM8KV2Wms\n" +
                "1128UG42W3c7Ug2dXtVzsrWt5ZKjtZ78ST6SpYume5B5ffSiHeDp\n" +
                "1126Z8hHWNENyfViGjgEHSsGeCrpkhWuztqyndWV32wNzoE2Sn7m\n" +
                "112WEpqReJxrKmGVwEwUFoCZskF3iBBAAheVNUscCwd7wQrudbmf\n" +
                "112eGXZi3totpUgrQSRkx1R6LvnvjqpfbxHGx9omUpggS377aMX3\n" +
                "11jGxhCDW6SdLWsd9K952SHGj4BWzXsBvSMEy6K6CjuiqUB6MNV\n" +
                "112S9FF6a6Wd5qUNYUmi4yYfQhH2ef5E3a59PWCz9XmeXfshZAcv\n" +
                "11fGiQ6yBb1ab13cVsb72Naw3szjfpe7cvv43jxA6ieL2LMbVeL\n" +
                "11VqRJKigG1jdmpw6UPKdHfKLBhqbJyF6sTn4cg56hTf11RJp1n\n" +
                "112CZNPyPBnALuvFaMu9fyhhQXzGWzC5kQMwCA4miKVNUcbKeDve\n" +
                "112nYGDPzwxcPHnrsHHHexEoN1i28dA2UAd8dyGi4F4WhuDDYp4h\n" +
                "11sdKZ5QhjEmPHYVU257EweFoyWpRh8vdHm9GjoyFSxHovGA1ep\n" +
                "112TqAGBkDUrfQeukiDRhBVVhXEBNBv1iU1nWufviRDrkjX9ofMN\n" +
                "11dkBJWY5hsyTFCyQd9eC3Ejnd4D98decrYzKYBVW4TkntpZsuF\n" +
                "112BeSfWyty1TU8tQu3f7NFP5FDpRwyNRwaM6T56BGgx459782Cs\n" +
                "112mJsbjoPbM7SJNKTcWLFCWaVLtefoV9d9uPD7cwA6TuUYy85AG\n" +
                "112NzRweLwnQhxr8sgQwMxRUg19L96PWekbkAnrAZntwxYPzscwu\n" +
                "11Vjny5SGVDMEJwotLoLiMJ7mGdYkQe8Z3EyFJHDouo2Yv9ouk1\n" +
                "119gTCaVWdRw1hxtieQfw8j6BALHikuFn6QdbjJF5KrG8XjKPvu\n" +
                "112LXxoUo7FxnyrBvkKPL1TbFuY5UMg7N6kNKnhDs4pG1GcUBYRE\n" +
                "11GGsv9XBCN8VScyFd5e4L7hL3VWZza2bFimTM2rKTQz7uBPnAB\n" +
                "11MJwvrcwseTJixL14snRRaVYhStFvSUHHADLpVrKoMPhvk7jBh\n" +
                "112pS8scoZMUj9PNjJBXNbfzaUypSTXzStfZ5VHdNmJFYxC4asxT\n" +
                "114kee5s2Wco6rzHCvEGKDsZHuoF3VfwvYERGzsGUTaCAL4ZVxx\n" +
                "112EKHufAn51j5V2k7uYF8voXryWxzsb3t9F3FYRsNjts3Q8JLrV\n" +
                "1127o1HwueHE7Qe5oNRkaoV5byxtRJLVWmVA1ANxEZRJFpiqWG9o\n" +
                "112QRK6xocYsgexfMNaEdrTPQpRxQm1sM7qcvDaQjpovXwa9s2ti\n" +
                "112quNW6ak9J16Gcr44mHbajSaz15TEbx4RguxXU6uBmgDNTVKNp\n" +
                "11Mw7SJS8h297ZUwLNNQpdGfk84zZYAJzmSDYfTmUBdriGqLqSz\n" +
                "112WsyGBHyPWgadjVZQMkCZgFP5XXAEWSNGgspmM7GVbdfF41ZEh\n" +
                "11ms8SwjXnA1x26KwwHdkoxZNxoNLB94CzjoV4bHiHikHoR6tG3\n" +
                "11DX3sPmGxa67pyL7wyQPvkVX6Jmu574A2tqUa6Qr2B3v2sSqFN\n" +
                "112by4J1eHGBz13mGMKJ5V2iFYXg7gerj9BKD4P9fLh7Nzct9i48\n" +
                "112kDpwTHAk62q3Dt5tRUyBHu4Qoa9ocspNvSEi9tYaigaSpqPSD\n" +
                "112FHEgE4t7RukeLwJ9enu3mQmz9VPFkvDGc2BuR9BL9eDbLbgL2\n" +
                "11aBVhPuGkto4JULBLc3MLRC7ip8b8NwmKCnBsUzfGKeR6rTAuR\n" +
                "1128NkHzxwc5yR7DQEvTgPETYUqYx8zHhTtUkKLoB3931zXv9WQC\n" +
                "11PgM1Z2FaTAGsuScotouYD6ovDwrMyKc7quj8C4P2J7VeyZMrS\n" +
                "112FZTm6tBjS2xQZdLajrNScmM6GkWaupjt25GFJdV74MVqa5kA1\n" +
                "112RLRuJY4j6RFEFUpnFFxFVQebxQHAwM3pwSDsxBLX8LdzGDAnE\n" +
                "11zhTFvvJ1WQJ4KekfmzJbLwMXSVjqbFsbDdZqojvp98oec9iC3\n" +
                "11z2t5fkjs64JaaT6kFHFVSsmtxS1xRz1wKmHVhAutAfNAy3ZSs\n" +
                "11FarxDue18H4kij2TaiYA75Ar7EZGuEZZpJ2ZDtxV8Q8evWpvz\n" +
                "112DdHxvzn6QWrhwybEUUifrFtfZFZdyorNGp9jX8478ygoTHpFS\n" +
                "112vdrnMBBYSGP4mfcbSKhExiZ1TvJirDwfAqsevReAsxHwb6UTS\n" +
                "112bQPZxjQNbNnDWUwHxyJaBGW5ghPCgCDv8FgiaWMw3HzhGsAQ6\n" +
                "112puKU32U6FLgJfAhA7NcnMFd8FE3R7eQNCe54Kgb8YfxsNvuXa\n" +
                "112vSW9HF3fJF5K5biH5afmFZYzAj3dmEV6kKvw95861w2jfYdkU\n" +
                "11BbrSUtPe3pMKh64KuLPNpmCdRweLyMY2m4uJZmWtB4KfDJNoT\n" +
                "11VUpaBET8PnxBbi2eiM9EDAKTpzCACQZrPgRRhEpQgY1mZisYA\n" +
                "112BySgRk4j3MvXWsKSekqkv1JRkDzD2Db327Eap15MTyN1Legaq\n" +
                "11ivpV7eDfREenmcmRj95D5PdvsR6mitXGY9MrVV3UTB7g3KT62\n" +
                "1127gqkUmHkKo5GjMx585BLgXhLTTuz1HzJfx98ggVyKrnQx6jVp\n" +
                "112Aofm74wpGyV4w1pqXA1bXTsdR7wrfh53MGyAgBu6tfPw6C3KB\n" +
                "119MQzCp3tjVrzEpunu26DFBhZ7N4i1mD8totXo6aJkELzEK2DF\n" +
                "11xFLMiYWm1aurrVcU6u4hc6bhPuksi2igqpiY73qNzwmHZsEYp\n" +
                "114QVNuRSeXXZkKBzVujG8GJuHhTNGaGBWVSoRMQi5T4LXZRcVT\n" +
                "1127aE3jaC9Ta6hykoYJwUaCKEtufH4n3Ym2Yx3x1vTyjq2bwewA\n" +
                "112FmJZ5xoA9dQEb7bU5DC926x6ajgynN6ZCj75JmKCatECXre9z\n" +
                "11iybLi8tvNvVz6xd4Mn8MfoXQoAG4sXxPHi9QUNsCyf65JrXTZ\n" +
                "112v8ntmNG7cCMUzzU2hYsYNmRfBNBqUMNRQR6CEMcVEvA2uMn81\n" +
                "112RotrYqyFfeEbYsCfmhQezjjahm5FfVBQSmX9e5gnD8edqjfca\n" +
                "112nGEtTBf3uK8VPktUDpWbjDsGzjJG4142ggcWsPGYwfNtuDJ6i\n" +
                "11fRgnjhciUQUcVoin4HgZAmGCcp5g87cz2khYuQyXuRYwJEi8S\n" +
                "11XB2tDwxgp19joa4C1ikKNYuBPAigsY1jGAEerxi2HUXFtghVw\n" +
                "112Y4En3EqKG8QgeWNjrz5aEYGmLZP7eziqpv9yx1YWdL7g54bxU\n" +
                "112kykxSHR4RERtHmPmU9t75tiqKTURw8c9ueMCD7EPCBWdtZ1SU\n" +
                "112F9vomV4QCv7DryrBixwRuuTCZ12rq3E4NRRBufxGH9KXr7Y3m\n" +
                "112Jphf4PbZ3VFm532igAZaVjS9oEr7XkGnZa4VL1k9hFHwizXi5\n" +
                "112dXorF8kXvHNgKrDiP5fw2wcvw4MgHWQVUsWFpWTRNAng6dK4w\n" +
                "11RNN2xye29d8HSiqw8fnMnroi3UadpdRdmpvV36n3mXmBWap9E\n" +
                "112mqx4ZjQ6TYoyHm7RXdr7Ump6J3UydR9zqWz8qCnQh5VtLkGZW\n" +
                "11kwt19mFwXvdjjfSGawcr5ApqnjAFRXR63MD5FckZfCq5KxqRV\n" +
                "11Ur8ULHHg9LNk95P6k7NtjDGyNzoXqZRQigiq8svnxht8bR5sJ\n" +
                "112mSzq3jhSNS59vFrBwyNX9beGpPkEqLDZ9HYcZwBysnzdNL3rB\n" +
                "112h1XUMMZ1LMDnBkwc4CGSbvR42uVBigeG5h1VZAKcZ7KnbSKjC\n" +
                "11GAXTZmqyhvuDXgEvxtCm6hzVoa9EAU7JYfeMCAEAeNCgDAsUP\n" +
                "113P63qtSJQihp2GJyXoN164skxqoQDzFPGG1vhHyDpox8LzxEt\n" +
                "11exQf87MxEFB7BHFKjCr42XTfPRvhBXE8yJkQiyNDv2EiJgU9q\n" +
                "112mq2qGckygcUoWHgP9WvbMoZeAEQbBvPzyaRBt3f26V5ChFhLL\n" +
                "113vtYydDAjMKYkS3RkeoQTYHasPMQZFmLwHTqQQ9MdrL4o4WSK\n" +
                "112ti7Vwvsgujecxbc3ReCDLDb1TtbCXd7NWRy6LaohMS6DNPsBE\n" +
                "112vbmQ3KyCfHcRoVAM9W711AURvdU3HjauT4g6VwArMDex14Rf9\n" +
                "11JGQCjkFCchaMurwXAZLMEDNTbnbUd8XB2nxnCuzggPBU93Yon\n" +
                "11p8fZNinhR93zKfxteUHJeMoJrMuty5XsWaE58Y5omFTLARMAL\n" +
                "112ChYTH6LjgyRqE9hFysc5cjfKYgovCDTwnwWebcpuzKpuGqfvQ\n" +
                "11LdZvnfRQF9Pv77pm84DuX8nLV7MReri72BEM13KZCMB77ckxk\n" +
                "112mu7ovp3Udd1EtVZddLSDCZBHCwDkXvDDxq4LdTdU6gbCc9LrS\n" +
                "112dfdkWfmxevLCFyCZx2JAxeapkhW3eUGXtTLAuvCrCWp5od5PK\n" +
                "112S1ygaQGJZ68FNfJXbh79BRsLLbUa2WdGAwMzsb9HTfnjccyJV\n" +
                "11RVQVXLLLpq3NkbUv16adpHyJcbcmEq36JzWCBkC4Jn4xC4Pv6\n" +
                "11sGfkQFdJtX7Z4NZv57ZhQn8XYp3d8V1FNq6zWZhSNi1zPe1f1\n" +
                "1123VAYShgYkT6JEe4hJekSoewZnjb9CtTGVbWek4DgvoZwfd9JF\n" +
                "112d5Twci28zv78S26hLDFbeYGkSQecQ6NGdqygTXeSMfENPVyAB\n" +
                "112XGJ89n83rixghzJsTJFcSx7mD5M7LdP3AYYDmcVUDYUXU16aF\n" +
                "11Rz7pcLawxJHwZsdxZzGCoK5NAH1fPQ3g5hTqppnXd4zDECwU9\n" +
                "112qik4sFsE2CtxRdnFL6PZ2V3CetQwg8PgnAUbJk8SD5h4ZyhXa\n" +
                "112v7T5hB8znDAnyei5aPeWwDCGRp4cPUE1Swjq7baT78H8Qcinm\n" +
                "11NqRnZ4xdCUoqLCdarLbyEHdk3gwC77T3fixSEgtBcKFYWi1BD\n" +
                "11duHFtoKK1ABek2HSBQQTHsRvmPxtwzPDhtAW3sEUmn9sBorLU\n" +
                "112FSx6xeGeA2mGaQgp8aocX8fYv2uBSmsdKdNJFGfTYQwbnshd9\n" +
                "11SkcqMhvdStv4828i68iHf8bik1sLBYQadpdCZK4XGfsPn9uwu\n" +
                "112dZXWVvdmemHWTXsxT1KpcmnzbntfsydBsNxeGJLCpaMgZKjqP\n" +
                "11mbisBCK88iqmDV6q5mAtCGNAZRfW7EBMmBrA1NsaMZdaAJ4Rn\n" +
                "11KKS8gop4YBDVYzCfVw4PaN3eTYoZ3DM1wq1QLXiDvkdFxXgve\n" +
                "112Y7dpeN2M7QTP6bR2UWHKENg8sj5Qeyn7sAX34tSxBv3jRvVeS\n" +
                "11BcmEK7dzbBk7MsUKZwgG5q6XJf3QJ5X7jTCh2iZtQFaBjiRB1\n" +
                "112C8d2bR7j8TYzxJ76rri1vrKhVQfKwZjXczjXeMTMdQgpp6K3r\n" +
                "112e4wcnXwD7iMB4rCJwUUPQFmtkMCZZaV4dATSJe56ZybbR9DdV\n" +
                "112ux9fejVYJ52ytsKwvcSgmfNgMyXry7moC8sRDFZx5geAgqorU\n" +
                "112AEmrJLWKuer4iA4mxNa5tQyzkNYQGNtzwLEJKUcuM464yW9b4\n" +
                "11dDqvGc8pipgFDQcdLCeF5jNpzCcwy7ADm8Sqd8exVEdGgevtP\n" +
                "11gr3MxsCLkuQatxWehoYRwEmuvSNRMsvnewHann8uZzwypHBnf\n" +
                "112pJsS7Nnqr3uPCcTA9JqCWP7eWB8koRt4MNPaJhkckgVVazDi1\n" +
                "11M5NNhPkZDDxqPjskydhoQjhSNCe5Ucfb8wuKj6hyFvnFhToYb\n" +
                "11FkVsrTxXTwqcozYN5PqxJPUdAr4uErVvPZadqRgUUvaDcBykX\n" +
                "112PDLQ9nYxB5zRpFWS4zV1JmLtTA6km7dFcZX7ft3KEeH1VakD5\n" +
                "112oAt69WMJnMbipmESZeQ88sZSzRWi8t3AiDecdSuXnzkyBrfoh\n" +
                "112GeTr7jbKzsK5c7NVSYBXGDfYHkT1XbaH1B7vzCygNxJgGM7E3\n" +
                "112oP463uu4WKAbLzucvWhENw9crcWG6AK7aXDNMBqnAx47acB8d\n";
        String time = String.valueOf(System.currentTimeMillis());
        for (String s : str.split("\n")) {
            FileUtils.writeln("F:\\tmp\\denylist" + time + ".txt", String.format("%s\t%s\t%s", s, denylist(s) ? "黑" : "白", getHotspotsByAddress(s).getGeocode().getLong_country()), true, true);
//            System.out.println(String.format("%s-%s-%s", s, !denylist(s) ? "白" : "黑", JSON.toJSONString(getHotspotsByAddress(s))));
        }
    }
}
