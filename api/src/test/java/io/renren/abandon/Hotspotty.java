package io.renren.abandon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.*;

/**
 * @program: helium-pro-new
 * @ClassName Demo
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-21 11:20
 * @Version 1.0
 **/
//@Ignore
@Slf4j
public class Hotspotty {
    /*@SneakyThrows
    public static void main(String[] args) {
        List<JSONObject> jsonObjects = ExcelUtils.readFile("./data/hotspotty.txt");
        JSONObject jsonObject;
        boolean de;
        String filePath = String.format("%s\\%d.txt", "./", System.currentTimeMillis());
        String address;
        String ip;
        Device hotspotsByAddress;
        for (int i = 0; i < jsonObjects.size(); i++) {
            jsonObject = jsonObjects.get(i);
            address = jsonObject.getString("address");
            de = HeliumUtils.denylist(address);
            hotspotsByAddress = HeliumUtils.getHotspotsByAddress(address);
            double hotspotsTotal = HeliumUtils.getHotspotsTotal(2, address);
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", ip, address, de, hotspotsByAddress.getStatus().getOnline(), hotspotsByAddress.getStatus().getIp()), true, true);
            FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, hotspotsByAddress.getName(), hotspotsByAddress.getStatus().getOnline(), hotspotsByAddress.getStatus().getIp(), hotspotsByAddress.getGeocode().getLong_country(), hotspotsByAddress.getGeocode().getLong_city(), hotspotsTotal), true, true);
//            FileUtils.writeln(filePath, StringUtils.outStr("\t",  address,  hotspotsByAddress.getGeocode().getLong_street(), hotspotsByAddress.getGeocode().getLong_city()), true, true);
        }
    }*/

    @Test
    public void getHotspotsTotal (){
        try {
            System.out.println(HeliumUtils.getHotspotsTotal(2, "112CPndQ3JPQf6o8qG9pLf1zWeAYkebK6AGe8UFd74Z2JUEXVm6p"));
        } catch (MsgException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void dash() {
        List<JSONObject> jsonObjects = ExcelUtils.readFile("./hotspotty.txt");
        JSONObject jsonObject;
        boolean de;
        //8531600bfffffff
        //853171dbfffffff
        //853109d7fffffff
        //85311b07fffffff
        String filePath = String.format("%s\\%d.txt", "./", System.currentTimeMillis());
        String address;
        String ip;
        Device hotspotsByAddress;
        for (int i = 0; i < jsonObjects.size(); i++) {
            jsonObject = jsonObjects.get(i);
            address = jsonObject.getString("address");

            FileUtils.writeln(filePath, StringUtils.outStr("\t", ""), true, true);
        }
    }

    @SneakyThrows
    @Test
    public void updatelocation() {
        String groupStr = "85405e8bfffffff\t7\n" +
                "8530b06bfffffff\t8\n" +
                "8531aaa3fffffff\t8\n" +
                "8531aaabfffffff\t8\n" +
                "854194dbfffffff\t8\n" +
                "8540919bfffffff\t7\n" +
                "8530a51bfffffff\t7\n" +
                "85319e07fffffff\t5\n" +
                "8531a877fffffff\t6\n" +
                "85411dc7fffffff\t6\n" +
                "85309c6bfffffff\t6\n" +
                "85408a0bfffffff\t7";

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
                "13Bz7AGW1AMPDZtisL4goXw5VE1keXZPTv3MVpZeSTKvby2Lnju\twallet45\n";

        String device = "";

        String path = String.format("./%s/", DateUtils.asStr(3, new Date()));
        saveLocation(String.format("%s/location.json", path), groupStr);
        Map<String, String> stringStringMap = toTableMap(walletStr);
        List<String> rows = BeanUtils.toJavaObject("".split("\n"), new TypeReference<List<String>>(){{}});
        Map<String, List<GeoCoord>> geoMap = BeanUtils.toJavaObject(FileUtils.readLine(String.format("%s/location.json", path)), new TypeReference<Map<String, List<GeoCoord>>>() {
        });
        Map<String, List<Location>> mapLocation = new HashMap<>();
        for (int i = 0; i < rows.size(); i++) {
            pull(mapLocation, rows.get(i).split("\t"), (String) mapLocation.keySet().toArray()[i]);
        }
        List<Location> locations;
        Location location;
        for (Object o : mapLocation.keySet().toArray()) {
            locations = mapLocation.get(o);
            for (int i = 0; i < locations.size(); i++) {
                location = locations.get(i);

                String script = "./change_position_core.sh %f %f %s %s";
                FileUtils.writeln(path + "script.txt", String.format(script, geoMap.get(location.hex).get(i).getLat(), geoMap.get(location.hex).get(i).getLng(), location.address,
                        stringStringMap.get(location.owner)), true, true);
            }
            System.out.println();
        }
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
        if (null != row && row.length == 3) {
            if (ObjectUtils.isEmpty(mapLocation)) {
                List<Location> locations = new ArrayList<>();
                locations.add(new Location("", row[0], row[1], row[2]));
                mapLocation.put(row[1], locations);
            } else {
                List<Location> locations = mapLocation.get(row[1]);
                locations.add(new Location(hex, row[0], row[1], row[2]));
                mapLocation.put(row[1], locations);
            }
        }
    }

    @AllArgsConstructor
    class Location {
        public String hex;
        public String address;
        public String groupName;
        public String owner;
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
}
