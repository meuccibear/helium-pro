package io.renren.abandon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.dao.BusinessDeviceDao;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @program: helium-pro-new
 * @ClassName DBHelium
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-11 17:33
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBHelium {

    @Autowired
    BusinessDeviceDao deviceDao;

    public void updatelocation(String groupStr, String walletStr, String device) throws MsgException {
        String path = String.format("./data/%s/", DateUtils.asStr(6, new Date()));
        System.out.println("path: " + path);
        System.out.println(path + "script.txt");

        Map<String, String> stringStringMap = toTableMap(walletStr);
        List<String> rows = BeanUtils.toJavaObject(device.split("\n"), new TypeReference<List<String>>() {{
        }});

        Map<String, List<Location>> mapLocation = new HashMap<>();

        for (int i = 0; i < rows.size(); i++) {
            pull(mapLocation, rows.get(i).split("\t"), null);
        }

        List<String> keys = BeanUtils.toJavaObject(mapLocation.keySet().toArray(), new TypeReference<List<String>>() {{
        }});
        System.out.println(rows.size() + "\t" + keys.size());


        String locationNum = "";
        String[] split = groupStr.split("\n");
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "\t" + split[i] + "\t" + mapLocation.get(keys.get(i)).size());
            locationNum += (split[i] + "\t" + mapLocation.get(keys.get(i)).size() + "\n");
        }
//        saveLocation(String.format("%s/location.json", path), locationNum);
//        Map<String, List<GeoCoord>> geoMap.json = BeanUtils.toJavaObject(FileUtils.readLine(String.format("%s/location.json", path)), new TypeReference<Map<String, List<GeoCoord>>>() {
//        });
//
//        String script = "./change_position_core.sh %f %f %s %s";
//        Location location;
//        for (int i = 0; i < keys.size(); i++) {
//            List<Location> locations = mapLocation.get(keys.get(i));
//
//
//            for (int i1 = 0; i1 < locations.size(); i1++) {
//                location = locations.get(i1);
//
//                location.hex = (String) geoMap.json.keySet().toArray()[i];
//
//                StringUtils.writeList("\t",
//                        i1,
//                        JSON.toJSONString(location),
//                        JSON.toJSONString(geoMap.json),
////                        geoMap.json.get(location.hex).get(i1).getLat(),
////                        geoMap.json.get(location.hex).get(i1).getLng(),
//                        location.address,
//                        stringStringMap.get(deviceDao.findOwnerByAddress(location.address)));
//                FileUtils.writeln(path + "script.txt", String.format(script, geoMap.json.get(location.hex).get(i).getLat(), geoMap.json.get(location.hex).get(i).getLng(), location.address,
//                        stringStringMap.get(deviceDao.findOwnerByAddress(location.address))), true, true);
////
////                System.out.println(String.format(script, geoMap.json.get(location.hex).get(i).getLat(), geoMap.json.get(location.hex).get(i).getLng(), location.address,
////                        stringStringMap.get(deviceDao.findOwnerByAddress(location.address))));
//            }
////            for (Location location : locations) {
////
////            }
//        }
//
//
//        System.out.println(JSON.toJSONString(mapLocation));


//        List<Location> locations;
//        Location location;
//        for (Object o : mapLocation.keySet().toArray()) {
//            locations = mapLocation.get(o);
//            for (int i = 0; i < locations.size(); i++) {
//                location = locations.get(i);
//                String script = "./change_position_core.sh %f %f %s %s";
//                FileUtils.writeln(path + "script.txt", String.format(script, geoMap.json.get(location.hex).get(i).getLat(), geoMap.json.get(location.hex).get(i).getLng(), location.address,
//                        stringStringMap.get(deviceDao.findOwnerByAddress(location.address))), true, true);
//            }
//        }
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

    void pull(Map<String, List<Location>> mapLocation, String[] row, String hex) {
        if (null != row && row.length == 2) {
            if (mapLocation.containsKey(row[1])) {
//                System.out.println("row[1]\t" + row[1]);
                List<Location> locations = mapLocation.get(row[1]);
                locations.add(new Location(hex, row[0], row[1]));
                mapLocation.put(row[1], locations);
            } else {
                List<Location> locations = new ArrayList<>();
                locations.add(new Location(hex, row[0], row[1]));
                mapLocation.put(row[1], locations);
            }
        }
    }

    @AllArgsConstructor
    static class Location {
        public String hex;
        public String address;
        public String groupName;
    }


    /**
     * @param groupStr
     * @throws MsgException
     */
    public void saveLocation(String filePath, String groupStr) throws MsgException {
        List<List<String>> groupTable = toTableList(groupStr);
        Map<String, List<GeoCoord>> locations;
        Map<String, List<GeoCoord>> geoMap = new HashMap<>();

        for (List<String> lines : groupTable) {
            locations = HeliumUtils.getLocations(lines.get(0), Integer.parseInt(lines.get(1)));
//            locations = HeliumUtils.getLocations(lines.get(0), 20);
            if (ObjectUtils.notIsEmpty(locations)) {
                geoMap.putAll(locations);
            }
        }
        FileUtils.write(filePath, JSON.toJSONString(geoMap));
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


    @Test
    public void huangshuai() throws MsgException {

        String groupStr = "85319e07fffffff\n" +
                "8531a877fffffff\n" +
                "85411dc7fffffff\n" +
                "85309c6bfffffff\n" +
                "85408a0bfffffff\n" +
                "85411887fffffff\n" +
                "85415b77fffffff\n" +
                "85411103fffffff\n" +
                "85159dd7fffffff\n" +
                "853181bbfffffff\n" +
                "8540c457fffffff\n" +
                "8540e3affffffff\n" +
                "8540e0affffffff\n" +
                "85400837fffffff\n" +
                "85411dc7fffffff\n";

        String walletStr = "13We8MN4gzrCT53uzY72JPwb4KExvpYry32vWDUgM889hqY4oPi\twallet1\n" +
                "12xX8STNcZaUPCkdgBGcFfPfacXM9gkELx2FnCTyy2xpKQivCVP\twallet2\n" +
                "13VNTsUeWerzqT7u71GEtv6qABxr2bKuiTRA8vE9BFYVAAFRUFC\twallet3\n" +
                "12yqNMxzLNPQzhijsW43g1eHNL8NYsvEpmgfRprRX2grtL6PyP1\twallet4\n" +
                "13LmSPN99K2QZGzgjv5JUM6JP6fbvDvR4SUq4NkkkS6AxHaneaZ\twallet5\n" +
                "14ZjeTtLvc2c55PK8ChBcTNKpqKWh582W49FENSs1Vn6Brrqu7k\twallet6\n" +
                "13mnjYHaVKdQX6SHs4VaZqkTU7Jt5xVre6UokdzFVvJmEdSPUfV\twallet7\n" +
                "137vXvhUsPjf1drbGu3eUYvmFxMWVrqTbeLnQqH2PW5fGCS97Dy\twallet8\n" +
                "13QRKVcz1NpsgMPS3KnSA2iGRhVYFq8qUzFnifXWVSXftQWsAjK\twallet9\n" +
                "12zsT2Ji6wjcPs6axeUfP7hvics6nWcY6HLvQoVPSAKbMnSC4cH\twallet10\n" +
                "13T1yVo8qaFvGWMcaumpbwmLuG6oAZ8emrh87rya6EQVrR2TWFK\twallet11\n" +
                "13JBzkvBC9FRZUiQDeVDq1CiWfs4BQGeL8idLiJHn2WCLwSExMF\twallet12\n" +
                "12zFfhwtU6v74VDfbJyWANPFMr2twre3q9N9eKMwZmiNG1wBC3T\twallet13\n" +
                "13japDocgJbTCqJr7kacxbbzEuDc5UN5T4qYr6pXyhEDGWAbJ7W\twallet14\n" +
                "14Y8EAqGhGTJQcXgy1aQjGsP7bb6Ez9PR7Hxx9P5AyhpFnjBwe3\twallet15\n" +
                "13tuoNQuKUwxAMpEdm1n1vEz3ALSRDcEVWk3Vvy2MLeRJeFqppA\twallet16\n" +
                "13kj1pJgovvXakyQSqJX4DKTVmNXRqo4fUX9ww2EEcbq53pVrf7\twallet17\n" +
                "13GK19wrQjb6puMDnxfTRStzoQB6PL5kmn6ttZeSa52pqeqhiaC\twallet18\n" +
                "139NjFoPsSkCs6qgjMBV7oAZiEvZsHqEEVKuBbcgjDvjrXKWqGN\twallet19\n" +
                "14LHf3wfYfmYUvQsaHMTJwxhFvHAgVpJnujp211cMpJC48zHYWp\twallet20\n" +
                "134ek2zND2boMc6KUtsKe1buzA5KAEbGC5THvTCKJ4GNuARRs8f\twallet21\n" +
                "13ADTv9zSH8R5gwdqSMLzqTGMdfMdK7GyL9cUbrWpBNd1aPwkGr\twallet22\n" +
                "14VxPJKmDLoSnjkKmwD3S424JC6Jqf9JYCzvyfdunP5hwT9z9ey\twallet23\n" +
                "13ZWj1RgsvfHpR9aM6CU136gUcQzfDmiNnuGwSydw6X4L718Guc\twallet24\n" +
                "1376B4UnTQcpFoaE1SkHo1SACbRjwfDGkMLM6xveGQGaqNNJXNp\twallet25\n" +
                "139mgFYCTp17TUcDozRqNCPjNhp1cNLqb4Qj2vBp3cogc7khRQ1\twallet26\n" +
                "13c6zYf1kDcRBQpZ5uakvtc1UZ8Nu2JD3SaNcBP9uCzLZSRRNCV\twallet27\n" +
                "13PDxnBUKNH2vj1zCpGdMbdGWPpTNzfWzuErL36rvjMmF9Q6sVU\twallet28\n" +
                "145S3KkV6icnbqp4659bGzimHjnkEVWQ5Jmzzg7JqsBACoL18Ym\twallet29\n" +
                "13EJx4tZzA4qD8PXzwi2yUTy9jhkPjqDWeLL2LqssExE6HbyRmR\twallet30\n" +
                "13f7C9i1Unkj443HaNKS2Z4WqyFXVhufAykqBcLeNGyUqtSgLa6\twallet31\n" +
                "143cKDq8QykQo3qYAisehoFCJyPPe9Ci1Kg7k2HkPbhB8CEfBRp\twallet32\n" +
                "14XtNLJyfsTjakjxSfov6ny6vF4jrLXuSDBtktiGz1YNdgVSwPG\twallet33\n" +
                "13MsbfzHvby4kuFemydpaKNHQx94rPug47zN5mfDo8KbyEHWW5s\twallet34\n" +
                "13eAK5sEwqxX5TLpkwXejovwmLAXTNoKfXoCxqXzTEMWz4ajoq1\twallet35\n" +
                "13i8cYZASdkYZ32ucQNc2pkShHdQcGRgHN57ja7Z6pdVRm1Jo8M\twallet36\n" +
                "149fDdZ5oNTycs5CeqbrNp6bdFXJRdpZrzVfP97sxWuHeR7e3XX\twallet37\n" +
                "149hSPRK3wnThox8mvg1PQ6n7VngtnJGVE2ay6fKRn7oPuG1g18\twallet38\n" +
                "13nyz29qdZrt2EqDnwf4NfiDs6aa9jn46VN3YELK1B1Bgppdj8p\twallet39\n" +
                "14R9fx1Ee1RPEXsHG3EG5NrLattfrcHxciXNiRg9hPCXWbNhKjP\twallet40\n" +
                "14LVSjJyjZ5VZ5MLbPJj4QtB284AUWayb2XWjCYrNSLwYD3i7CS\twallet41\n" +
                "13Hg3YiK4QLTdJ5e55h4DaisEHdnqvCHyUvwMw9vuXbe9WzCrEc\twallet42\n" +
                "14t6ER6xL2nK97yMyf7KyJ1zqQSobima2BWKHZjVY7BnSzazKx1\twallet43\n" +
                "1368kjsjf5T4nDA2QJneGYucZeJNn7tMumx48W2wM4btWpWLdE1\twallet44\n" +
                "13Bz7AGW1AMPDZtisL4goXw5VE1keXZPTv3MVpZeSTKvby2Lnju\twallet45\n" +
                "14DRdf175h5SWN3Exs5F8WEVxhWnAVoVywbbtnUYVoKS3wVeS9Z\twallet1\n" +
                "13zWdr7LjseTkxeobPuscS8JTNX9Yd6XKxwgA1AWjTMcbZBZUxd\twallet2\n" +
                "13SRwDZJyci6GREN9Wb3MJDp9YRTA1eTadYe9diGfK2sGCAdsRf\twallet3\n" +
                "13tzwJ1t2f5pGAEBxKV6X1otV7U8ArDzRuGorodeKoa1trzhRLk\twallet4\n" +
                "148SkX7Kk5emyJWLednhKKw1zwqbC9msGpjCYyPvGZ8imzbURGr\twallet5\n" +
                "14PMqD6ASLP2aBPWdtwGB7sKWtq5yZvk4ycSMcKZo2aCjzZLcia\twallet6\n" +
                "13f2gX27xNA9ANSTGgQZyDXDXGmJUmW25rJ2snR29VmSbciYJgj\twallet7\n" +
                "13LpMDWEyLYAUofFw5ypYjUGXQjygkA3kfTpG1bz57s1xQ5y2bw\twallet8\n" +
                "14JmVLFM3vsdWB82eBf1gYj7m2AuXnGjkX3WitYkNpR2ZbRzSBh\twallet9\n" +
                "13xnZ1LwRPrX5vuUE92X3X4iBYbhrpFeGY2Mca7qKBpfmkf6kGY\twallet10\n" +
                "14Emw6wFgj7nM4mzBSZZUjtVLgj9szDnv7CPyNY7XG1SSwQsV2g\twallet11\n" +
                "14gKUt41XiGAecV4atHD1dZqcL2RtAeHWbKUFbEX1SEuYQPVcmF\twallet12\n" +
                "14MxuRVN5nX2EbsHtWqaAZWJovTv9NiJc5YMwDWPBuGs9Q3GgQL\twallet13\n" +
                "13aFcLdfChnpMnzB8oAfbgNFFm8KXnLNt9LFFcD14hERzNHpAdz\twallet14\n" +
                "14r2nsAFeQPggvBrbMhdvcHNwda11dGkaVjJbGrpyWyRjAU3DAA\twallet15\n" +
                "13L4vhTD56jnXEJ2c6sB5Q6VDnYSXp4twEMV431KNTaEJL9vwAf\twallet16\n" +
                "14Y1zvikeD4MhvumePagb3HZQmaVMap1QXvSzpGeTZwemQvKUbF\twallet17\n" +
                "13nNdcVZb7uJejk7FjxSEfEQEHpmohwgE9K9xCZB4RmBJrkdB5q\twallet18\n" +
                "14izaZhoE1JmCdUZvDF9kfysNYsYtWEfKpAszrZCBv3yjpD5Na5\twallet19\n" +
                "14UyGc2ptShRNpigRaRaZpb8zav8hvzZLQQTXzmdDMZZhSVLpah\twallet20\n" +
                "13E18sMVPCC7379nz33SGze2e6DUXtx6gSkERrsxPqaBXnaZRmK\twallet21\n" +
                "14pJXuPJ55uWiM26iqjHXwnmtCvU22SWDYpUsn1CpmsDVM7sfyi\twallet22\n" +
                "13ayfJBzUbzpx7BwGtGKdDb9Y6Gv1Cux2AouCXA4sctM7j4vsPE\twallet23\n" +
                "13K9geYJt7USzVSueKJmXdLQxW71eEwrbG6aftfv1eB125Lv7cv\twallet24\n" +
                "14sSdMD5buFosJmzTQNjN5uJ6hKG4DcWzTRAhRmBKDXWEyXhVN7\twallet25\n" +
                "13BX4fxoseZBaUtwaiDz9tdxZbQDQjmzW1TuAJ2H6vVKtgRV15n\twallet26\n" +
                "12xFrbgpsjiStg4VvDJsSYkh7UbA5A9vfcGy2scswwhpvrFb64o\twallet27\n" +
                "14ETLWdxXsdFkavMvALTRJxtZMbcQq2hSoaiTgRuFy81YXf8RbZ\twallet28\n" +
                "137fb46SZbbDPyuCVXBTuP5yfKaYkTPHsaSeThyqUBLLueztctB\twallet29\n" +
                "14NB7JvRGYkQSajxZHNDRUmFRhcGux3MecrLNNM7Qwvsek9Rem1\twallet30\n" +
                "13mB1FpouBWxmF3o2hNNnSniXyyerbiPrWGhySce1W5So3bcv6d\twallet31\n" +
                "13seapbh3QEfJFuVYuZep1ypGBaUPtmg9UoWzVRf862UikNXkpC\twallet32\n" +
                "13b6qWcNUrXXv773Noii5bhpFEcdpMEXmyw8yeWvbtANRBeRn29\twallet33\n" +
                "13zvdvWxrZJyYmBkpChuKiheW6mxpyqwBJRgwWm8RjdHHRMJB3K\twallet34\n" +
                "13R6KHDtVKpEzi4NDy9me7jas3FYnGCq8wHM17s2T4Tdc6p4nFo\twallet35\n" +
                "133LRAknApLvnGUUMcNbFrjtBudEKjf9GQQT1r3gnZVeVbepjEb\twallet36\n" +
                "14cVzDLh7VgCQvP3FeYgmvGWrEDqoL4W7XGQu6JRsiSxpDCYsZL\twallet37\n" +
                "14HQQD58Ty2Ez1d3U7zWQgrBgxfpo2bTXE41WgVL2vTt58KLwC7\twallet38\n" +
                "13kvxHLhTAK27gKdkM1TeJtDmR9aLCuPRSUv3hsyqERAQaCnMZW\twallet39\n" +
                "145qwfhu8T3FaUVtFC8t8CChYWQEQmqUgVxkn4yTR7yumEgzv6j\twallet40\n" +
                "144hLbeKmonxgqvefrLNvqirj6gLh6wXUNmudTbEi5xCLtykDBV\twallet41\n" +
                "13H36mMnxsEjzrNqYf6LPuQmpUMoULMgEJeWxdeQbARA5vWeCSE\twallet42\n" +
                "13Eo8T89JzsiQWzXBL63Dg87uycSnt6H9PRkMWMk1bSsdxpf2h8\twallet43\n" +
                "13WdHgSKDJjKaGosiVov3wGPpGps3wW2Z4bqiLeBpqQfjg4qck3\twallet44\n" +
                "143TQjSRptHDdvWx6Jcs1KVHNV8BrAj9cGVuQxc9BfNZFs69QZb\twallet45\n" +
                "12znL6MLCJ3bJV5woHt6ncZXPet2wFpjaHsAiRb9Z6bPjxNZVQc\twallet46\n" +
                "138umzCyEBePxCTHGHUUhEmFTrYH46krZnffBZrcDbinUFTmEuF\twallet47\n" +
                "131RRvbKSDE3NoPE86sYqfRPdD2MHh6iP62BJb2mYip7Sw47qxu\twallet48\n" +
                "14qkRom5qVf46QSjjx3K4fYoXGxGz2zNReSLdM8Jg5s2etW1vL9\twallet49\n" +
                "13YUAvnSXMxPByYJGSd6isx6jT2gNRpxQQcn5QbTpg8jbzhh4XR\twallet50\n" +
                "144QBrVNJMoDf4K1GGX3t1738VpP1jctezDMPdk74nXyR2YSZps\twallet51\n" +
                "13NfgbvbWtE1GkUZNnMKFWQA8CXsbQtLhNfFXbBtx9p1AtYVJMw\twallet52\n" +
                "13RL13LBux9DQU2vntjaEgAPuM65fpGUcbb2sERWBbA5MCQ4JWu\twallet53\n" +
                "13eUpbQ65VyDgzya2U1Kub3m9aqTXdkD6ptmKDn8y9PMGPkSafj\twallet54\n" +
                "13jZ5rDg5C54YnC4fJAK2jvcHUGxSXPNUq3eWbrbM1yEzD7zWrK\twallet55\n" +
                "14TaHUYp3aPBwUeMn2JzFiGeBxPLyDpsS3LgnX9NE2qVnPZMAf7\twallet56\n" +
                "141EzbzV2FAkdeqA6PKCzVTTVedNWzuffQR7zhhch1k6zzuK1JT\twallet57\n" +
                "135i57ZFSHi8J83dydXdVJsYJwFwSbobv6BFMp2sifXWEaDF7tn\twallet58\n" +
                "13hBtSTPN4YvVtNi8hkrTYjMUdTgRNUWJwwg6ni1hspVVSySZAD\twallet59\n" +
                "14ERQponNwG7eSo8ta2YhEGVvpYyrGUnMDBvDz1NGS1qknLMXXb\twallet60\n" +
                "14tDCtgFj9MF3X3vDMrCUVPYPtTAyBXojqSBviVbMuvw1YP8tcZ\twallet61\n" +
                "14LaFfXdrE4KEPcxWQZ3faQYGbXB5BNU47fkE1xjfpUS3Ge5HHx\twallet62\n" +
                "147tgGnHqD7961LyfmKvQVHk3zADj9SSc1D4gLoETeV6YzcBots\twallet63\n" +
                "14dP5Tu444jyWm5WzUFLMTvu4wwjibyDJECsWuXe5VWay6dHBi1\twallet64\n" +
                "14Hkw7nV9ShB5zFdtQFUKYVWd51shYVNJGf5i789ukAn1aTZCmu\twallet65\n" +
                "14tCysovBCw3y5aJq8FW4ZfnP67SweCPsN8fzijg5xe1nb44v8M\twallet66\n" +
                "13N4QALw8bh29zEKtE5pDqhykFisc4pp46ZZNSn8QDkY5Wdno82\twallet67\n" +
                "14Gv5YyazqDsmQ3RSKnYvwKHk8NTJRsqqHpMjTrNmduR8a9YJZ4\twallet68\n" +
                "14HDhBHLNji5ZDsuUiBtykxoqMeH62NJu6WctVA8gG3UciGBngD\twallet69\n" +
                "14QAjc2NfNhTrtc3rsER43oVnhhAitUk7bY8LRL5MCkVoJb8hiw\twallet70\n" +
                "13GHqvDnn8o2xX7DfWkrdWhYQMb82Sh3eeTQ4ZvtSby6RMUiiEE\twallet71\n" +
                "14qwC5vH4C8pQBHpCP7UL1n9pCM4GeSGBmjUWXmrbdxjYPKEUzr\twallet72\n" +
                "13djBu4GyQc84ZX8TExsNCDotBQvcmbSRKvxzeg72U64HPhRfQh\twallet73\n" +
                "14GQJBE286b9jc97as3vuVdCER6iRN8nxXhPRKRBXz38kMEKuVN\twallet74\n" +
                "138LvWoRt4nUWibFzwDWaDZqyZT1wfGZix9v8e8DvR3i5Dcnv4Q\twallet75\n" +
                "13xqLwgVivrNmpaEQHF9qsiwgLDXewyzfyMwX2RRrwbmBY2qK4P\twallet76\n" +
                "14NrM9T8cZFe88h3FMeorpkKqfVoknRYLBMesATzhYx6kTpbMR1\twallet77\n" +
                "13tgLS78WXYMd7NTS1a49vXbxGNGZCV2EHK5D8EF2tENLMLePzD\twallet78\n" +
                "13ac3NuBuPmj64N8fa3M6a21EH1BEd4KJwE7JYksFK8iXKkSphx\twallet79\n" +
                "13SggtX2vdmUReAMwW4eWd68bh7UXRwdNzAdSfweae7W55hLpEv\twallet80\n" +
                "132Th6RRq5ZRnnEffMNETZRKMjyDZQVFmHiuEv2citF75kwCgYY\twallet81\n" +
                "13Lo5uyi7cZV5qeXyJgjwiqLFbUr4HEXNjtDDvu53SyPstkhEmc\twallet82\n" +
                "14LpRcLfsrFAPR5XGmwPeHxBdW9Gcas8f2JF7w7jKH7MB9JGuLo\twallet83\n" +
                "13oAWjRPEaZEHgyuNbRjg6174mqACwpxSwKj64cpjUHXWrYrKCL\twallet84\n" +
                "13x1LJtCf5oa4XPYsvFmYkLkqDb5975FYU2DfWMkf7oPhwZrNmc\twallet85\n" +
                "14B2QGa3JqijVN3hztN6vfkMwALUpxMo8k3t9zny84tAUwRVRow\twallet86\n" +
                "13HqcurnY5KZYJFjpFvNjMCTcHD2mAxV3jkof6P7NS9wrpoRPEX\twallet87\n" +
                "13vbCDyHvt8R8wW8whFyQagDn1u8pXfG2BXXbsCGLV4qbWVAJgR\twallet88\n" +
                "13EaS5DbBLXnSrwa3W7YjcD9oT2XkkXGVQU9X1JpwifBFh4W46c\twallet89\n" +
                "14mRyDBiZAapjvucoMpm7y4xouZg2M7Sa9FDPHHD3eapLhzwMVL\twallet90\n" +
                "1496UnNuLxiJEK1KSiwVyxFTtBp6t9XA5LCB8qxeKLo3sdV53t5\twallet91\n" +
                "13A6YMwvXTu86VYTTegEBcHkByd2h2g5uyrURK1D8noeEW99ScL\twallet92\n" +
                "14MmKk77XNYP5AwW3iST65SSQQiesewSvYtBfMWyP7SMvvHNiR5\twallet93\n" +
                "13zmcRjDgafTzGBPg6jMB1y8hAyvbBQf1gEks6ZvK1JtsaCTkKM\twallet94\n" +
                "12y3ebQt6d976wgPfeZuwBK9oYJQydeM3xbJFHAFUbi312Gnxi5\twallet95\n" +
                "14HCvd1swuNoUPP9cUpV2gvJ5cU2wtZFrjjA74LhfmSWenbJcds\twallet96\n" +
                "13CnFSzcqb8Q2dHTCk74mPxok2qUHh4sPXYZdfZUiGKMVeTpP1d\twallet1 \n" +
                "14RueXMUFfyKmzPDkZp3uiGBEFkqGBpnwM7BNSGC9Mhcuh2SLN8\twallet2 \n" +
                "14nRPyCUEr4Mnid7HAwdxWTX3K8qSHiZ8AFqd36pQkz7TEgSzjQ\twallet3 \n" +
                "13cJzRZA33RKYFSLvToVjymTb9mv3Anjaex9styyK6i8gX3ofDJ\twallet4 \n" +
                "144XUzFmDuS9KsJfb6T265R2Kzg5Y5YMhejSQaGkYWQaaxMEEL9\twallet5 \n" +
                "13ydhpddFRyEwd5ipMwShaec56VBKaPsX8C5Xs6yPEn5T17WDpY\twallet6 \n" +
                "14tQM9YrthbH33hupi4t5opXLf17jJKQMVtB524ZBWKKPdBij6P\twallet7 \n" +
                "13mt1PAf4orxrtceWuorNZfsb1RnGdeXK1Uf3wyw21kPhy3YYPi\twallet8 \n" +
                "13tXNDVhR5Jzv6YPEa9m5A84Mw3aQhsxPy1xzP6MuZcLgEjGSbv\twallet9 \n" +
                "149F8c3U9vPRgtDwNWAAEWKxV7Aq2zvpJj2kQqxBdT4ug8RZG7i\twallet10\n" +
                "13ASDCrXVeyorPP9GeHEJVZ876mbQuHJQGKG1Ewq7FufqNXFYJP\twallet11\n" +
                "13kN53pFVtRa2q4eL7CFFcEWDgqMUkCCnrf2SMS8oxTzeQPJEwF\twallet12\n" +
                "13JfpwsAMuDFCVFGqLQmCZEzNVfxQ6vJ3468DDVkCgi543gBjaT\twallet13\n" +
                "13ZTtot5aSZ9JceeejQKy8gZDM87SJRd9vj7MRwKJQKnzwgUUDZ\twallet14\n" +
                "145XpQQQNFMwLWdE34jvKQArpQDdgVvHzW54c8baoURAfiWrYuc\twallet15\n" +
                "12yC97Ze37DkW1uoYficBNdhCHKnq6S7gu6HaaGwTSErZgde8De\twallet16\n" +
                "13Ak6pF9KXGmcWzqwnFJwqgmqRvCe2B64TiGiNc3pEssNx6qMxy\twallet17\n" +
                "14TsVPUUvDbDnBjHNZXcFRHiYcxmLmX4BoaxAtspN3wsFpvgRAe\twallet18\n" +
                "12xaDaFksf424nL74xKwSgAqmwFboopjNvp2kr5gJxwskqPsdRR\twallet19\n" +
                "14ACseSkLB6WiAYSPZQ81tVd74oh6fb2gjYYyc1ixPY6Rgpydzy\twallet20\n" +
                "136seX4koaCCbYU6RXjN5mC1rKw5A4dexJH5B2ZgrpmV3jZKYYz\twallet21\n" +
                "142s3DzAWQNCwZiPVaB83dCJ3GiAcDJy9F2HuEbcSp7NbSoGMXY\twallet22\n" +
                "13W83D19JQnkRD6qzVYNWkt8P2goDcqna7i5uHZntHqSwT6iN36\twallet23\n" +
                "13A6i58Nm3RUKVTH78SvDwR8L9YTAYkL9PxVjrdrX9qzqHYdbSa\twallet24\n" +
                "13SdjVZPV5ZxaiR6BtF6s5HkQ2ymyyFeRFpW2af5PHvpemrHxFb\twallet25\n" +
                "14WsdpRuPZxq1QzpnxJYfFx2MJaR3nFtcDXL5q1R14bACHpD6KS\twallet26\n" +
                "14i9AXBPmSLxLBUzFc7XBMyA26udMK8979M7R28qghxS5We58LW\twallet27\n" +
                "13q3fXrMEMHWuzaXhoEKkCP94Yzfjd8SHY2mchhpUQKSsvVUNPY\twallet28\n" +
                "135WwoWrvfFAup1AxBoaaeZGmuKYySG6pGFZTUqpji7HKtxXVwz\twallet29\n" +
                "13tfQN1KwTDSmymeYYJPv3A8RwmuH1k4CfCHn8zVENMhYrhYZGc\twallet30\n" +
                "14o2z2m5mFwojQ1AojmpBGh1YMPcuhTQLuCBuffAHbNzhnJmiQU\twallet31\n" +
                "14jnQQo3aEyiQk8zgYy6ZdCzmS9daDK21UL13aTHdEWffMbZeb8\twallet32\n" +
                "14XHHuUZz31S2N55J7nRUNFxwqoQTfSgW9ma1RYpZr4ZaXHXJys\twallet33\n" +
                "13eSm6Tk44PwBCY7jk17zSiBnaGKM1qb2QdonCqkQCxgmrdfNpt\twallet34\n" +
                "146qHzjMnXM9V4SixDrB1uPsHfLbZ9d8GE4fYQAwtCRQo4c4VqE\twallet35\n" +
                "13ZUNF4WH47edSadb1wmdpaL1ezJy8vAtopt4R9Z2cKsn2HUgZ1\twallet36\n" +
                "14mZwRPYqbD8NAdP36JsjV9JFS1wtHNHcBdTRTy4u6kdy3ofM1u\twallet37\n" +
                "14hRNpL4kmqh56796upMVfKYhw5dhdB3mVeG5PChYBxf5rVUmfP\twallet38\n" +
                "14fRakZ4HQNi7i485mjquP9jBfciBqhcMRViZDr8oxy63XgHH5Q\twallet39\n" +
                "14CjmWwdepd7ZN6M9TovGhd9AUaVhCqSMUjXU2vKPQFPB86Jxca\twallet40\n" +
                "14qFcZdbhstmL2QwskcmNqhwrxxxbwKf226GMoKX7DwKzfArg91\twallet41\n" +
                "14QPMM1m5d4RtET3z7GWKEKLYRdFaDfYziT1qZv16hYkTevK2Z8\twallet42\n" +
                "14kmuMEhoQpeo3E2ojSxa195MvsYs3unXWktd15X9ypDtCAxNd1\twallet43\n" +
                "13q4fscDwFG3egxaxD5iUxZqBCc5upF9aHUVk6nKALMuqJHbgxu\twallet44\n" +
                "14DHLP4FivkYaTGghkY3rgMbfy4Rw3zjog1edHqJ2k1JJhWbCmZ\twallet45\n" +
                "14hqz3GR5eDZzEakB4eT3VAheD4TzqjM4mCLBWEPnBJ78xPu4Y5\twallet46\n" +
                "13mVCLBejsehzQnLkoLcauj1KzuQQM4gG16ivhLwCNa76BJjbrj\twallet47\n" +
                "143E9Ddd9rXughRLo43Ex2DFA4qQBtfqtBHykqH7Tvbg3wSG9pp\twallet1\n" +
                "13vTYadSUNJyj7Z88VAPJMkXHpaPPXr8ruCSR3AAGAZKsptyPAg\twallet2\n" +
                "13Hf57Wt9s4BbecZrpEM4PJt8u5RR5ft885ces4pAwk6zR41NS8\twallet3\n" +
                "14URxX3CZ4a2CbV82bz9sTXcYBaf7eHH15EvpVF4hvFrWmKbcHc\twallet4\n" +
                "14se4n2FkNvrKJ5TaWi9L7k6KpiygBxG7g7eQovbx8L3vg3bCUV\twallet5\n" +
                "14Y131G4hqknhYMGWYcYW8hYggKm1ocgB9g4oxwoCc1Jiwm4Fpz\twallet6\n" +
                "14gGm4PJTz2bebVrjcNfQkXD4CiRZqUMhvri7jrfLxckgFyLe4M\twallet7\n" +
                "13KwoA7FHr9PbeFLP6WpkC4P3JW1LmJL99f95GUMCTG2DBk9FSk\twallet8\n" +
                "133EnWeSGZ8ZcTk6YWNvJdE3iM4RQ7mxJFmaj4hrk2zVrJbmjHV\twallet9\n" +
                "13YQiw4SrGFNz1pymVxj8yM5PAWfNxqWPB8y3wsKjpoREL443hv\twallet10\n" +
                "13kQkNQDXs1kK5x4wFuShxsMqMJ65JtskPbH3TT6vnr6UHmtZL3\twallet11\n" +
                "13oJxqF3dGQpikGXf8UBFtYtNDJq6438uiiuhcKU3mj8sgbGbfS\twallet12\n" +
                "13z77kzPbDWrN4Ta1kv1DcAavpiuyfrYdwqVJbhCgf9hKpHSgVv\twallet13\n" +
                "13DwAEbcsUqBAxqrhg2b9xSUn5SqmJfGLh1AFBYKUCGKYhWPNtn\twallet14\n" +
                "14fJktEcNZ3B1VDtD44JfrY1qiiFygcyRyVPNE52swzYKbATEyd\twallet15\n" +
                "13yy4yaTYKcGkX2y2AUcRPo3H19w1DMgZKvkLWe6z2tji8xYUd6\twallet16\n" +
                "13fUGCyHCXHKFFpuHDgE7HAJEd95g4Lws35ksuPbxjfSA9PDe9D\twallet17\n" +
                "14PvLoumFbg4iWqYtEsUiR9BqrF6SzS7S9frwNebZGxV4VxoVpK\twallet18\n" +
                "13rw9WiddJwuQaLBoXHagYmAdEwyzXmKE2kNR8MAGm9GMTVGiCa\twallet19\n" +
                "13Qdr731uzXzbKwQjQuAEHYMTXTdBev5EWR7VrrEgLJrMtmT4e9\twallet20\n" +
                "14TVA6UmHmpD4uzn6BAPdQaCxNwamXCvawUXCGwEn5tGhvpdwSj\twallet21\n" +
                "137Fx5gPVhDX9NAnb8YSigJmjQirTSnL9e9ZmtqKxXbrXFxGdkE\twallet22\n" +
                "13xuCEjKh8DEoefxu2ztchds8xz3bJvTSEMGxKB9Y8rTca5qcd8\twallet23\n" +
                "13WVK5jdoyNgXuEReqVqA7dFRqvwt5aeY9DNyx7GeMBvRzHpJF5\twallet24\n" +
                "147ZxYDF7kmEQDyU92pdgQ1ANZgCS46EeqKdn8fvFaNhfmgmgaW\twallet25\n" +
                "13KarXbTAdLKzP4kLGqbBG4kmCALhPsn731h1qe6EJX4bvzBg1K\twallet26\n" +
                "13CoBv5R6qnhB28ZHSRpWJhoyQV3CYmmQQ2AZaUYWYqzZa2DP6C\twallet27\n" +
                "13UtikbqAUAJLkk6gFRv2yXj3zajm7SrH2msciEAcmTqLZpMtCc\twallet28\n" +
                "14kQKgR4xXHbNvXQSZfGSXfT6RqKi5VWJgEr8ctfHGAnf2C3ze3\twallet29\n" +
                "13BER5qzGm5GkBfBgMuBuMujj2NrCJeNhyFowF5AxZtmSvVTU2K\twallet30\n" +
                "13MAEs8Sd3hFH1E3pLeptevme4Cvod8rHMKhmWi31gGSEBdNz97\twallet31\n" +
                "14kvwPCaivBFjArGVDeW5tGTtnUhYF1XnrTwayUUXW7dSN3MXHH\twallet32\n" +
                "13YDRuraEKhaFWLaP5MKRxv4T7PLmWxFgmk41SSVDfngE5tbZ94\twallet33\n" +
                "135fKFtNoMuZep2Cw3Sy6M77L3oy861Q57U5A2Kg951Yg1cFUhB\twallet34\n" +
                "1334YKmYjXZWzkwg3YhHhS9hA8XBNAznAKXC9sMERUiNXwZgGUj\twallet35\n" +
                "13m313cJVNWFNY2AXvMGx42NRfhTVhRupTWzSWJHcdESNWgLNyW\twallet36\n" +
                "13zxGzmuHSYpyJc7Zhsw6beZqy9XA6sYfy97gSsGSu6rqXYSot4\twallet37\n" +
                "13VcUUNKQ9YxZw7jYHwz7yu18UpQEBoG6xVErD2qoeei5WRH3GR\twallet38\n" +
                "12yeYdiZ6vdBRroYUqhLHxPJaFguKoRV7pRRqG8TjLqK3iMmSBJ\twallet39\n" +
                "142wCQnQrK5bbdFHo1HPE7tRn9jmiuuXpTcPCk114qvB4RjfexA\twallet40\n" +
                "13t2t574awGLJVvZX75hkC6oNf7HXG6gqwjvYnHfWhBVSjgxhdL\twallet41\n" +
                "1449Y2vKBP6Cu1FFBt6zmXp2t3Cu7guxx5NHjLs9RepBfeHQ8Wtv\twallet42\n" +
                "14DUzNvp3DAU1s7y8swEcNVau2MMGqKB2TrGYyadeASj2YikmF8\twallet43\n" +
                "13R2VK27ACcWRhEQaoT1ZkTvY1j4GkWQqQ2JkQVZHMNEcAZBRGZ\twallet44\n" +
                "1464KqeoiBYTRVKKgDm9VwHC61XUyzVfnbZYZKvkVjPzTHBi1PY\twallet45\n" +
                "146MNFxTFNCfiBXNSvtTKv5TPaicvrjCsGp78Z32Pva8VGEDi2P\twallet46\n" +
                "13v6erCqzi5Co3faYx4ViJMwRsnXLZZJtqZMF14z4N3Nxe5pX1S\twallet47\n" +
                "13bJXysHvhYNjQgX9eemv3mX8RZH7JQYPFLiQ2PuLRFPT3UZW8F\twallet48\n" +
                "14RSof14p5YdgSbfvqLF64ezsGVYrFA2Bgr4qJHjkNp7cLeHso8\twallet49\n" +
                "13hcSdDvxksExFShxsXE3hLTZgqGvPGY3AzGdq1LX8E2rW39Xdp\twallet50\n" +
                "13WkioTEdXMGN3kzpqFynRKeZken9aGZBd3EZa1d8ajTVrgzW1s\twallet1\n" +
                "148D99wWov17GUfXDM7JqtZDKJniASejP7VVqSkKWZw7ce1CZdJ\twallet2\n" +
                "14MSBAFag2sPpckZgeHsFbjNtbPJksgnqxQdxK1KXg9C5MMNoNc\twallet3\n" +
                "14HgfnkDZVfVDquVpNwy1mV9CnaM4N4m3TNV9bSFi7K2AtaRGhE\twallet4\n" +
                "136nFrf8XsipBhhngouZJyNkV4r5RNQdSViXpczG2jDB6bTsnK5\twallet5\n" +
                "14nmTkcSD7A6HPp6BS7nsAf5LJQ5DgMU8wFt8gY4cv4HcyXa6b8\twallet6\n" +
                "13xWdqyqLue8SnYY7yu2PMtpkFF4bMEzcs6WCVpakdDv9VB2LGy\twallet7\n" +
                "14j35fHWvG1y86muSdTLTLSfFpYC9MNcZ83Ez4wz64zL5Vm9Jde\twallet8\n" +
                "14s3wQQrksS1vZm2UwKW3b4v6GkS7yDYZckb9msmjwbEZu1zPqr\twallet9\n" +
                "1457bmnztV4Hm6CWpRZGh6zuEdKT4LQXvjMHzrtjT7fovf5X2fX\twallet10\n" +
                "14R3RJ3Q4znyTs8JkkNgNi54EoR1vcemucsWWvWubfeBNS1DF7V\twallet11\n" +
                "137F1wubT2dmnMHzoEw4Vx3t4hsaeraqerEyZ9RdnoAmirUdMxb\twallet12\n" +
                "145PNzap54cGR6TdHABZ17F585xyJc2EEHXSFUAZeXY6T7mAvKE\twallet13\n" +
                "12xuufX3DVHHC3g5bpj5uoDjeoojfuopFGfFNs9fvFuyvHCvWHw\twallet14\n" +
                "13VQPuBPkS6ccA2PwMxQjUwxzVUAjp8jSDc82e1Zo5WF6CgfJFg\twallet15\n" +
                "13r5acjSxzVo8rXpS6RfiKpKDbpvD62YJhEXhxpMRQMvxPsXUhp\twallet16\n" +
                "13i3zF5MJB88EyZqPHdXmphYvhJ5xg22oBzJg3kRRMo8EfXRcow\twallet17\n" +
                "14LJXfm3pbeQzcv7nQEKuXzh3tw5LREBHCGC1MiuQxkAWjkZsmY\twallet18\n" +
                "14e3TBbbZUC1p7bAScBsJXjVFq6qmfyiRDnPeYR3BHhK94zTiiH\twallet19\n" +
                "1391PEresAF6ytoT5sg8eRvgmxQqfifYtoi1jcB7V4iVALtX6S6\twallet20\n" +
                "1496pzNmQG5dcJ1DFgoFQmSH7RcYgDfvAVCjg9hBtA3X9rW2Tyy\twallet21\n" +
                "13nJEHRRJRrNxBDYSZNtj89qvkrU4jzPfdWPBGVJWdiUqULDrwU\twallet22\n" +
                "133VRftFnXgCGaTwHaxrp6UD2ELwXyZ6aekNReXRsHb1xc8AqyN\twallet23\n" +
                "13yH6WSzayRuQPpXgaekahuFJzob4LYZNz1geb7oujM5TE6XmYP\twallet24\n" +
                "13cPWZbFatHW6JHox3msRUvsyRMqg5r3jYXYRBDtEMCPB9yzzDf\twallet25\n" +
                "13HZ2ZrGPBogNLrU49VvDFqjAX2fGoiWMo4V2zMsu5LmSL3DKKV\twallet26\n" +
                "14JfPm8LLKu69PLrHHCMkAZrrf5dhd2DmJcbvccyfiSS4SeTQW4\twallet27\n" +
                "14mb6eNRqgq7sWkxDp1SFXAw2rittw7F2MA8sNQGn4bRadRnAWi\twallet28\n" +
                "14rtfDR2mFLPYzjRatWAh8AmYzrL1h1NrgRMDK9UfKEEMSrJgro\twallet29\n" +
                "14nn2iboBN7KwWmHNhLZfeBTD22fprf5ScZpvfLWXB9CDgaXpYn\twallet30\n" +
                "13M3iPSsWC3EBLkTHeRTcTZVi5gZG2FZPgmxx7gPbqwV8fixNiS\twallet31\n" +
                "13ta5YeMANfZrRW7TKs9Z8mZBJZm9qajkUjyKfLZF5LXtAqBZo1\twallet32\n" +
                "13PEzakWyua31aF4R95uLtprVMKy62nf9zC19vR45iibyX9yStA\twallet33\n" +
                "13w4Hhby6njtDdAknxADXwNwbkww6R5BMBapyReot4iwVoDV2K4\twallet34\n" +
                "14e6icPHPxxfiEisuAymH4iLKaA5MsDZyD8drmhYvGtUooU7ZsE\twallet35\n" +
                "14CJ1FbTWJNJcJJovRn57NBhVb1tAGWEpnvnPBikY85NQsBQHDN\twallet1\n" +
                "1443Y2SSQd8nG1MMaBXm8veSoufWM9mxJQvM6nLbqF1S88NpYY9\twallet2\n" +
                "14RyifEJvCR9iGN41EofdcGisrv6eVsAZvhdfUvW1L9VaMRhBe4\twallet3\n" +
                "14szw5xeY7XFRPypMjP1VAUVh8WLZJDK9SD7EfUBkCtksr7sPkw\twallet4\n" +
                "14sbtnLrndxoqFKXwQ2ZmABuJdNwYX5aiBZUSJiDr71R7x7UHbn\twallet5\n" +
                "14otUBqLwhi2zp9KokfTk44rcumv9fn7As6x3SUkBamQonpNGfr\twallet6\n" +
                "14pvYyLEseu5TaJG1vtUMuihfuz9fzyTevQgfXKrg4JdbRRJeM6\twallet7\n" +
                "14Te8h3bbsF2jg7tSSyJAskDofeyH3M33iL3FGz3FCAGT2WC56m\twallet8\n" +
                "12xWgvnuP6bWrrCbbrvTcCHDE3nHC3bcvCTF7dBiWpRsJc4pzKp\twallet9\n" +
                "14Y1CfsoCTeQLj6RKbFSpgbnXVUCYFaYUotjnwrf9QKjuGhk4MX\twallet10\n" +
                "14QXsnDSaKgLmzpqFabzFpRmxmJUuXizxYpitsAuCWeMhpr8wdD\twallet11\n" +
                "14Y8fXfLn5ZEytWvmqzoxBYiTkrnLPdiYTCWGCMiu6U6qprm77b\twallet12\n" +
                "14ah5sGTorvKbDu13VWyMWHCCQLFqYbAZBqJo9MQigUTGFv15pA\twallet13\n" +
                "14HWSKXZeyanTgZukyWos2iYED7eVcuytLftXksmJuMoyxU8Z5q\twallet14\n" +
                "14gLPQsrq5QQyTuJSvTsFrama1XLGjiNNDqWCWRJcJjNXq3KJFQ\twallet15\n" +
                "14AidaWqwckQgHd6rw9KWN2FcY9opkdiULVHDhhLLTan3mRLFWF\twallet16\n" +
                "13e6NbZbx8HXPe6sQuHYtxQwD8JwtbvcLKDoVPi7LXsQAzwqHj1\twallet17\n" +
                "14hChw4tu2vpK7fu111jpCVBxDfVSDScfpzYjAGq3UoZuBqdza9\twallet18\n" +
                "13HMDrwDTz5RazhoGVD3iRFkeUsMu1FZ3i9wy4mGiuiE5WWb2pD\twallet19\n" +
                "137qjZV8Jj2F2bGPXzQzvqzNJwmAMyKGVEM4CK6nWCw29cqRorn\twallet20\n" +
                "13LUdgi3dnvxxhdx7VT9cz4Q3xHkQQWZ5cdtszCCq2NxknvSfdF\twallet21\n" +
                "13SpgHQLaPLUG2J9CznrFXHckxGrRzuPrqXWMnKS6BYFivy9oJp\twallet22\n" +
                "13cQAvbVPB3PKsgeygvKYkgPnhYpcDndFdH1r9eDQXKzDotWv5f\twallet23\n" +
                "13KAzXRQeeU9RoFeyfjPXdALB29UYLrbgFKuUgGGS8LDhLPaL2n\twallet24\n" +
                "13TGTPhyahQZzPYopY6SRnotqMCmaiQchPghvqYHtnv5qfsdeUf\twallet25\n" +
                "14Jq31aNJsy8T1zWCDRnHCSZtzMZFtdYPyKyu3hgLZM2X8hN6jk\twallet26\n" +
                "14sGFvKTxqwjPbHRF2bnuS5AL6SVKAhvQHgercmhKemce1N1RiY\twallet27\n" +
                "14iCYbUwG42AjzLo34Qa1627wF74Wm4V8xtVnfTT8yXZ6vQiVB9\twallet28\n" +
                "14kTSopBmJfxPd7v29nk6UFzMdpx6Vc4htNYdhicjFCKxdPEu6H\twallet29\n" +
                "13WU3T2uchyMQVBA2HYV2uqgjK6z1yerHQZXDGPZ5QCMKRVUMEz\twallet30\n" +
                "13mukavZps246s9aGCZzb5HQjTs1eCZwGdEbTDwERQRXJRuVyvh\twallet31\n" +
                "14C69TzAoegYM6HrUAVXfvJhFBEFEuCZu8MnZavzWvqEzs5oUvF\twallet32\n" +
                "13EMUnzafCFbebzvL5AmXQ5g1BR7LtmEN84h67z4YFjUjV3Jcbn\twallet33\n" +
                "134KMqXPDAVvTQd18owxRAvnHfDt3RZoirEKmzvhQoQfk7A1NWX\twallet34\n" +
                "13qeVjW69twj1Q5fcWFnXz8BQkJqcPLhw1wWeSfQwgajDJsusRF\twallet35\n" +
                "12y8ggKysEaqHHcNAXYvX8hPowoqSLWr6pjnv79vVs8ozVx6AZi\twallet36\n" +
                "14LLtKFiRK5xEepbhEqyu8qLoEmS4ePww1fQSF5DSbKcPYVFk6b\twallet37\n" +
                "14XwzAeXzAfwQwLg8XhGHBbaj158afdP51CsRMrrXFA2UrBFgab\twallet38\n" +
                "13WW5NJHjN4DKm3X9MeMU14ud7TA5rKHcmFAWmDs4M5LwuZrwzq\twallet39\n" +
                "142nxVuWg4CfsdqM1NDVNxp2ojdVFZu2ieEMigqdFzXDFGtxgv1\twallet40\n" +
                "146L32xqEMU8QvFGYyJeEnqxkfBAdb51GrTcYQp6U9pnyWeJgEc\twallet41\n" +
                "13w3uGsCKsAmKYadCgEieDh1fB4Pf5qiX1se9CoTN4wsQk3Pqtk\twallet42\n" +
                "13iWwQAro3LxSLtwd3eHAFQCVacyj7LZN4ULY1J4mAyqNkdL6Fe\twallet43\n" +
                "14ep2QGgxwoJBpf1oWtuuYBoHKvh9nhNC6u4UtJ2fiAaHbvoJio\twallet44\n" +
                "13SEQgePH3jvytHJYWE67vqdzfUHysaoA7aaF1Pc76LzwKhGi1p\twallet45\n" +
                "13CT7uvD5dCajK5SukfKNMyNHkA4jYhTpjK7fuNf1MFuUHLtxxL\twallet46\n" +
                "13MfN1mSQy9qh5wsyGTqJ3n1DmLDBwEsXpaJ6RhmNk3BHNVKMub\twallet47\n" +
                "13LdXGKo9xgPf9LJh3bZ7M6hJZ7ACYDvCzwdSSCCRKKKsjut3ob\twallet48\n" +
                "14AnP6JLaK1bttKdt8iPfuMB8fD9B1jbmzztLEUmM1iVExqDy6Q\twallet49\n" +
                "14p8DPk5A6QftesW4nAS7RYKeWafznUboyhxi2FbPnqDwu85aW3\twallet50\n" +
                "13RYj1WN7fa1buhWu5g7mGZUQ9XvDwcTxDZVuifjgB8K7hdrXqS\twallet51\n" +
                "14n4s8gy6VcSynj27Wkp8jZjzuAHGKsGhQA7JMqc3qPkRt29gbV\twallet52\n" +
                "13GjP957mpAQtRCTZqr2jTaQUemNCqELm2yuFuHZGPqUSznJb8p\twallet53\n" +
                "13trKqHWFXyfTiGM9ZrFCX4ZsN1P3wpo2MdxBe7aWCj1LW2UfR7\twallet54\n" +
                "14S8sMm3cHm1NrbTrgsPKjTL1DP34rNv42XuKPQy6kKPgoNRAct\twallet55\n" +
                "13oWgZv7Bcs8xAvKHQfjEaGhY9ZReh1s1FFyuJ8rLRtAzQU1bqe\twallet56\n" +
                "13qwzeLDkwWueBisaBWuABXKYAshqMUgLyXm8cYPUWGSHriFESP\twallet57\n" +
                "13h49xhfNq4BnYcU15d3AJzYTYCDbRpVfQ4RCisAbQFEtdfRMVU\twallet1\n" +
                "13yLJUP6jB3MkiVzv4MQhBpoz2Reva8vKRWMvvDa1DTteJfREmK\twallet2\n" +
                "14D8n4kKpCNxswpRSqCQYE7fa7YYc1T1heWLs62V2NNXLBUsRoT\twallet3\n" +
                "14Rg9NGDwt55dTAdWKYaM8w7nmCxiPjWCZoWDBEhi5X5fDD3K8d\twallet4\n" +
                "13vm2UqAAp61NV6yXozYkciVsmGjZGtJXL2253Rai1iGN15t6JK\twallet5\n" +
                "14dmmxRWV3srNrLcMFVfYHpCtRfpGYSaG83CzdhjfU9tgZeBxfJ\twallet6\n" +
                "14t84tGXQqcSieTy1cSx3PiLiccTj1CAUAoEWRmkmzuYjoPaEXn\twallet7\n" +
                "13uwz2JXbUfZqEw11EXBxibRZXTSLhLm96ghEKPsqCBLiRxipqC\twallet8\n" +
                "13cBm85EKqB67G8TADUC9CywFHF6cwWSNA18Hr5ZJrQSwSM8RSz\twallet9\n" +
                "13Lik5RmqDvc2TD1tx3PygnbkDB5xshcn7KiMWE3fTNezGmsv3z\twallet10\n" +
                "13pE7SppCoRJr6zb9ct3VmpPXvyYSyjPmVTpN94vsA8hHBqja7q\twallet11\n" +
                "13ciSdXN1oQQJWJxMRmLv1WtKSQ9KoFcEKytdUv2Xsx1X8HFrCi\twallet12\n" +
                "14iSMzNLZH48j9JFmwcjStxrnrPeMfuY4vQibyLE7EwkRnx15Q2\twallet13\n" +
                "1466cBKKeMotFtBAx4xgcv9oqJTUgjT4C6ywwrFRCasmQnXt5xo\twallet14\n" +
                "14WHS56uvDoXDqkyaKJoaVydMVwiLXbTmfShLTAnfrVVWi9kBWu\twallet15\n" +
                "13jtNWaNABC7y6hpSRoeLHEhY1fqgvkxPemBGRvPUoMbEuRgPQK\twallet16\n" +
                "1312nY9SgUre2SyLBfeJBNMNXrvF2KikescwgGSAGWrNH2c15fn\twallet17\n" +
                "13GPPdrtH9ZUEtemoZRTMR1pZf1Y5H2gDWBUTZQ3Mz7W5Ji3eUC\twallet18\n" +
                "14TJUubmtkreusFkcUzyTU66ypWGZnY4f8T8DtR9PcdqRTd2QJq\twallet19\n" +
                "13dcqQcS4np2Rtyoj1UweQNZLXsqftZgZiX5oULuVhZxkM4RBqr\twallet20\n" +
                "14RkwgpkcAXojVGqCrP84ebYPeHZcVZ923R6w2GH7D6sWJRgaoM\twallet21\n" +
                "14QdwYVquuyyXztWT5r4qQJuGQgzC83Bdc1YhoLVseZQwmVUifX\twallet22\n" +
                "13GviikMfFwbTU7zgRFRgMWbGQNut85rrpr9Nb9cctKiZHScRe1\twallet23\n" +
                "14kdv5HqgTuQWTAJ24jim2tWqNvsAyL8UtdhCTRi8NFQU8vm9oL\twallet24\n" +
                "14kCuZ7HVmMc8QtboxooEN8brko8k2L7CkzRi9nQ5WSyAyragee\twallet25\n" +
                "14p9EMor8PGnCgz9NGjKeXP1PgbPwkHuFFLhNnp3MPRxT4qxbTM\twallet26\n" +
                "13wT814VYrPwQCruu9PfJXy7ijBzUXqcXn7XVbxiiDzocfAsXp3\twallet27\n" +
                "14f6eKDLxpaDNjqyLjxUxSVBcJ87HpxxEypiJEqoSj8jXZQ8ZP3\twallet28\n" +
                "13kfdbrk7AWbBK6yPfCBwg4FrpaFwQfnhrt8EADveCwPnw4JiCv\twallet29\n" +
                "13RqBA77zEBeURVYwTqJ9QLvZGMjGHSGX5PRiFS4UdQPmsZSTCF\twallet30\n" +
                "143KcQ5KsrRUmP4AP5fc42bB3y8zigUExbjTPsESJ17njDPCxFu\twallet31\n" +
                "14Astu4tXNYStiAjfYpawTVfuLnkMnAy9S8thkPUxWhNuUx9xcG\twallet32\n" +
                "13F5PZ4Rp6WQiTRtdqkTW2ZEyKZiXgSkEjFskA7gncvQzHWbmqQ\twallet33\n" +
                "13snefszYSd8zuKtzuRhhSkzPT2ZEffPTzqVHe8yaPY8SPhrk6j\twallet34\n" +
                "13nWDzoGwdUSYM9HpLgd6XvNMVeaEdJKyvZKaJdBEzQZcfMAQ6E\twallet35\n" +
                "14WtQRAkfMsSzESrqZ25thejmoUa4e4hgZxGu7dwtFpo5SjnHoP\twallet36\n" +
                "12wqeHWNTtoyzjGihBZ1KzQkZeNy9Upg1czUjH4eTuXe6nudA2B\twallet37\n" +
                "13faE9hU6tGQ1cLcB8VFcNbkZP8ujg4ksmhqgydeHD4DeXXC5Bs\twallet38\n" +
                "13YfDfw1233BiLBH5Eufy8kQoGbBST9EnXi1jQpQdBYWT8aKYxA\twallet39\n" +
                "13FMBP4W8LRWR1DvgyZRKF6hMuEtdcTBUmx7aNScK7ZDfrzcwqb\twallet40\n" +
                "133iASqQHpVnedpMwPb9RUGw8vJxWUu9Uvd5PT7ttpwwyavnubB\twallet41\n" +
                "13L4io19feJxx2w7x3ophYbbLqtSs1Atf4yNzjHr1jZQW18ndB7\twallet42\n" +
                "14sMyD3ZgqaTeiCrkkkKnonFSRzi4hdg3TNz2pa8MWYWgBqwAWy\twallet43\n" +
                "13d1MwrgTAbDgSgCLGTd2KMdhbqAqqQ6Fb3mwtTuc5wW7gNmaMs\twallet44\n" +
                "135z1bmjhByGpG77ToGqray7d3Agu6Rt9gYnB8Vsj4cdsQ4EB8D\twallet45\n" +
                "138ekczqkzoh7yDdorWxPqXzbpQfWS84U4y5CyhjYntp8qB65pU\twallet46\n" +
                "14i2syV3jccjh8EQhqDUGMavAbFbv3Sxdo5he2Mis4rVQWd2aSA\twallet47\n" +
                "145WxcjmGnfHbW2BcVr5pQStTkVmr9yDmUqc1uccKvf7bXwecyD\twallet48\n" +
                "1475weYE81qe8HVAJLz5tgBFAe9j3cgrKBLBx9A7JAoWBqQgvHs\twallet49\n" +
                "13iVxAz3tD7PRpzPaTRCHwHdRV1pJunStWgm9srD8GuFK54KzKf\twallet50\n" +
                "13dGRUKM6wECvmxYE5xF2VLDT26TyY95opah82nPXTGgfSBdXDb\twallet51\n" +
                "13xKUFGt57WJqJd1g79hrs2s6jHvwP3EYjABmXnNEgzGqtvyPQW\twallet52\n" +
                "14Ud6abxWVuoeYrv5VHWpNLET7mxwLgJLCmfgrbDK4kWASBe9EZ\twallet53\n" +
                "13BgGzBSMu41rQA2NB8jqB7swsYAoV1FMTNPR1p4BoYZgSXTtTP\twallet54\n" +
                "13L61BBbkW3D2peYmJXEGRaqm6tAgD315WtXt1KKPiRpKrcWukJ\twallet55\n" +
                "13R2TP5kK5apaBPvz3BoA1tPEjKMKnurwJ3gK9rCs3pMV3Vsdep\twallet56\n" +
                "13jTsbXEK23HiMvWX9bDtZ7BENBRoKur3oUbz2tEZQZveAZjk1F\twallet57\n" +
                "14C6eXvgzWzDy6Mp8t93PMLJXUmzAxnPEBRiao9PS1GCiNmqcdw\twallet58\n" +
                "13AaseoKrZhCutAyo8sLfdSA79PkAnLEh5PgvQT2ygr2stZ5HW5\twallet59\n" +
                "14qshxmBzUMmgso1eT4e8RT2eRSoKRd4dsGQeybLsywys9EJ6mL\twallet60\n" +
                "13G7G7b7pa22FPK9dmYrS49aWVrciUE5qLCHTyxYzDtTSwDAF3i\twallet61\n" +
                "14VtNx1rTuffmAU5rNC3tjnHwE5NdC1X7BJeJEccKJ3qpH61qjA\twallet62\n" +
                "13489PpimgxyP9q23gw7JjHdXo74FDKK13mPrRhwgXNVnDaNqWC\twallet63\n" +
                "138PMt5CUtD7QCQJMTJxs4KVbMHrCTCqpAnoLHwbqZ4nuKk8pNi\twallet64\n" +
                "14AHpobsfT9DRLffBhDsZz7jXQQbPNY84a7NwPRzaiiNA7GsFnk\twallet65\n" +
                "14pros6EfTD4UmHWR8JWft5s3AvX8xH6SBqYeMNYGTSUw7EzsEz\twallet66\n" +
                "13tv1y4LjggoNY6jptahakWmwUc53zPkv76Qbky6kVKbvGSZK9Z\twallet67\n" +
                "13VkmuG36sHXmUfCa5ziwr6Ww36um52Yw8xAG3mrjvBgHoqWSQt\twallet68\n" +
                "14UYfipQHVfsMowDBcXsA3mCuSzVVmvgnXMccUPNpVJTRL2Hrfc\twallet69\n" +
                "13VBRvERd8r2Z3RKBwmjFjVQCB4xc5vDCp9qyxb3DxFvCy5VVjo\twallet70\n" +
                "13XZqgeih2CHSEVDtUmBWAsnSH2bENjmsyNzLtsmD23UdYaXZVv\twallet71\n" +
                "14FBWvBFTCqS9jRvLJ5BtbDKbLKdKJbxQ8QBkfjae1oavtBvfQJ\twallet72\n" +
                "14AbPDM2L2XtQeXm6QgfhGwxPCnpmjbBYAda4jA9bKFe5nUD8M2\twallet73\n" +
                "13js1MrHxyqtvsPLHNqLKxhGeNoLMPhS2tRhY6zXZmUH7fMMYUj\twallet74\n" +
                "13gpBnmsqihzLVU3JVePtXAXSuCC8twJFKhX3jgN4VGc1bnKGSc\twallet75\n" +
                "12yVrTiUEPQhLep4nu95G63posBrG6zd3WFWr6DQNnkZ76gDhkm\twallet76\n" +
                "14dmZP3KmikDZDvGrnreAoMrEejY97A6kYB4WtkCEQjDT2px6pL\twallet77\n" +
                "13bEp6hTJ3AMyxo7T2UnFdfGNWZmA6k9bchoputdjoinuWrpvKt\twallet78\n" +
                "13svGTK4PVuLynqxh6SyDmkjfZFt1UGNDsg3rHYGGt3LsMaRuf6\twallet79\n" +
                "13g8SQczjBgfMGh635oJ7s7JLvucUz2QykM3jxqsw782AgPvPcf\twallet80\n" +
                "139cz4QKVnNhWdtVE2BGcuQTvSXUEtZ4S7LQvjCwkNFbnreABnJ\twallet81\n" +
                "135QzSkk79wQBKDqe7tjnyDrGXFYBdNnuB6mx6mKAfUFDvJ37HK\twallet82\n" +
                "13FcWYBM6TzRf28zBKhQcYgCqyAuGB27LjUVh2533edWYN3JYN9\twallet83\n" +
                "14UijHYq16qiQEGJ8JHUqgMNvaJ5uVH5xzoAPt71TCE9wqrZABC\twallet84\n" +
                "13ZLuXQX49mekZXiG8TBV8XyucbfveJe35zsZ7VAtRTCoRE3a4k\twallet85\n" +
                "13vDMs8VTw1d5xZdzRkS3CT7ptjNVA1uTjYQnCEyJptcMVEnEKH\twallet86\n" +
                "12z8ZjE3wQyMZj9NWovAGtMKWUhY85dY5mrHLdnTyncBNWJ9Vz3\twallet87\n" +
                "13yufZji77q63u3uqopnAMm9z8c1nnHVskevXBvb2oeX6d1gvRX\twallet88\n" +
                "14UA231f5sHkGKUPmBJ9iqGqZ8hGNSL3zpLudoBRyfNg9SGNXh5\twallet89\n" +
                "13LXBm7opXnJ421WjshUd2ZVNKo7caUCJ1Q6dWWfxhQosydmZN8\twallet90\n" +
                "13oWyEY17JtcNEwJs9ELV4MBE9FPU5oqEbpYSNnPqMVucugzozR\twallet91\n" +
                "13oLhQXnoytE6XbpwhjFgA8mzkZh4YSaBGFQJQWX1iYthH8Rx9z\twallet92\n" +
                "14QvZinQgy8CRDH7oCyrTSRWAuQFjQZekuwbme9vyL66bucYqLv\twallet93\n" +
                "14mxGLdLSEA5MHYaAK7bpeGMVcBc4C5QBZKBUbiTX1Af5DaoKKa\twallet94\n" +
                "13TNDPC7HxcUr1AaQKJQKJw2dzksVLCffjAdfe6KQxNB7vC6wTk\twallet95\n" +
                "13SQmMqVBrPchmtpz1aKmdJ21awhH6LB7YoWRHU7uWFcNLPfMMn\twallet96\n" +
                "13TScXHe9KuiEZ3yPyVBTP1YCP3WqqKe9rrCmPR8qGqzP1Vc9qK\twallet97\n" +
                "14mj5ygwjq7hgQdrs2NNS8RfqyUqaVaHh3HxvR1M9pTSCKUTTeK\twallet98\n" +
                "14WHzfhMvvxgUmRi6ZSEeUt5GEFjeXnfPyWSvLYGQHqG8YMsrxz\twallet99\n" +
                "14JGGk5J39C7ifkEizoMw1iLwz1k7cWLLx1VA6pm2AFz8TyJfXS\twallet100\n" +
                "132obzdZJ6EjCYGnrMi8NSRqWSrmUmkQ5MZhXihLU6kdBNutUyv\twallet101\n";

        String device =
                "192.168.38.33\thncz1\n" +
                        "192.168.38.34\thncz1\n" +
                        "192.168.38.35\thncz1\n" +
                        "192.168.38.36\thncz1\n" +
                        "192.168.38.37\thncz1\n" +
                        "192.168.38.38\thncz1\n" +
                        "192.168.38.39\thncz1\n" +
                        "192.168.38.40\thncz1\n" +
                        "192.168.38.41\thncz2\n" +
                        "192.168.38.42\thncz2\n" +
                        "192.168.38.43\thncz2\n" +
                        "192.168.38.44\thncz2\n" +
                        "192.168.38.45\thncz2\n" +
                        "192.168.38.46\thncz2\n" +
                        "192.168.38.47\thncz2\n" +
                        "192.168.38.8\thncz4\n" +
                        "192.168.38.9\thncz4\n" +
                        "192.168.38.10\thncz4\n" +
                        "192.168.38.11\thncz4\n" +
                        "192.168.38.12\thncz4\n" +
                        "192.168.38.13\thncz4\n" +
                        "192.168.38.14\thncz4\n" +
                        "192.168.38.15\thncz5\n" +
                        "192.168.38.16\thncz5\n" +
                        "192.168.38.17\thncz5\n" +
                        "192.168.38.18\thncz5\n" +
                        "192.168.38.19\thncz5\n" +
                        "192.168.38.20\thncz5\n" +
                        "192.168.38.22\thncz6\n" +
                        "192.168.38.23\thncz6\n" +
                        "192.168.38.24\thncz6\n" +
                        "192.168.38.25\thncz6\n" +
                        "192.168.38.26\thncz6\n" +
                        "192.168.38.27\thncz6\n" +
                        "192.168.38.28\thncz6\n" +
                        "192.168.38.29\thncz7\n" +
                        "192.168.38.30\thncz7\n" +
                        "192.168.38.31\thncz7\n" +
                        "192.168.38.32\thncz7\n" +
                        "192.168.39.15\thncz10\n" +
                        "192.168.39.16\thncz10\n" +
                        "192.168.39.17\thncz10\n" +
                        "192.168.39.18\thncz10\n" +
                        "192.168.39.19\thncz10\n" +
                        "192.168.39.20\thncz10\n" +
                        "192.168.39.21\thncz10\n" +
                        "192.168.39.22\thncz11\n" +
                        "192.168.39.23\thncz11\n" +
                        "192.168.39.24\thncz11\n" +
                        "192.168.39.25\thncz11\n" +
                        "192.168.39.26\thncz11\n" +
                        "192.168.39.27\thncz11\n" +
                        "192.168.39.28\thncz11\n" +
                        "192.168.39.29\thncz12\n" +
                        "192.168.39.30\thncz12\n" +
                        "192.168.39.31\thncz12\n" +
                        "192.168.39.32\thncz12\n" +
                        "192.168.39.33\thncz12\n" +
                        "192.168.39.34\thncz12\n" +
                        "192.168.39.35\thncz12\n" +
                        "192.168.39.43\thncz14\n" +
                        "192.168.39.44\thncz14\n" +
                        "192.168.39.45\thncz14\n" +
                        "192.168.39.46\thncz14\n" +
                        "192.168.39.47\thncz14\n" +
                        "192.168.39.50\thncz20\n" +
                        "192.168.38.49\thncz20\n" +
                        "192.168.37.38\thncz20\n" +
                        "192.168.39.48\thncz20\n" +
                        "192.168.38.48\thncz20\n" +
                        "192.168.37.37\thncz20\n" +
                        "192.168.37.36\thncz20\n" +
                        "192.168.38.58\thn-cz70\n" +
                        "192.168.38.60\thn-cz70\n" +
                        "192.168.38.61\thn-cz70\n" +
                        "192.168.38.62\thn-cz70\n" +
                        "192.168.38.63\thn-cz70\n" +
                        "192.168.38.64\thn-cz70\n" +
                        "192.168.38.72\thn-cz72\n" +
                        "192.168.38.73\thn-cz72\n" +
                        "192.168.38.74\thn-cz72\n" +
                        "192.168.38.75\thn-cz72\n" +
                        "192.168.38.76\thn-cz72\n" +
                        "192.168.38.77\thn-cz72\n" +
                        "192.168.38.78\thn-cz72\n" +
                        "192.168.38.93\thn-cz75\n" +
                        "192.168.38.94\thn-cz75\n" +
                        "192.168.38.95\thn-cz75\n" +
                        "192.168.38.96\thn-cz75\n" +
                        "192.168.38.97\thn-cz75\n" +
                        "192.168.38.98\thn-cz75\n" +
                        "192.168.38.99\thn-cz75\n" +
                        "192.168.38.100\thn-cz76\n" +
                        "192.168.38.101\thn-cz76\n" +
                        "192.168.38.102\thn-cz76\n" +
                        "192.168.38.103\thn-cz76\n" +
                        "192.168.38.104\thn-cz76\n" +
                        "192.168.38.105\thn-cz76\n" +
                        "192.168.38.106\thn-cz76\n" +
                        "192.168.38.107\thn-cz76\n";
        updatelocation(groupStr, walletStr, device);
    }


}
