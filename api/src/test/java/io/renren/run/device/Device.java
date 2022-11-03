package io.renren.run.device;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.BasicBean;
import io.renren.modules.helium.domain.Geocode;
import io.renren.modules.helium.domain.Status;
import io.renren.modules.sys.entity.GlobalDevice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: HNTD
 * @ClassName BasicBean
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-01-27 17:14
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "device") //通过collection参数指定当前实体类对应的文档
public class Device extends BasicBean {

    private String hex;
    private BigDecimal lng;
    private BigDecimal lat;
    private Object timestamp_added;
    private Status status;
    private Double reward_scale;
    private String payer;
    private String owner;
    private int nonce;
    private String name;
    private String mode;
    private String location_hex;
    private String location;
    private long last_poc_challenge;
    private long last_change_block;
    private Geocode geocode;
    private int gain;
    private int elevation;
    private long block_added;
    private long block;
    @Id
    private String address;
    private double total;
    private int dbStatus;
    private String nextCursor;
    private String requestCursor;

    /**
     * 是否进入黑名单 0.正常 1.黑鸡
     */
    private int depllist;
    private Long createUserId;
    private Long groupId;

    public LocalDateTime getTimestampAdded() {
        if (timestamp_added instanceof String) {
            setTimestamp_added(DateUtils.asLocalDateTime(DateUtils.toDate((String) timestamp_added)));
        }
        return (LocalDateTime) timestamp_added;
    }

    @Override
    public String toString() {

        JSONObject jsonObject = BeanUtils.toJSONObject(this);
        List<String> WLV = new ArrayList<>();
        String[] clos = "index,blacklistedBatch,mac,privateIp,publicIp,network,name,total,lng,lat,nonce,owner,address,location_hex".split(",");
        for (String clo : clos) {
            switch (clo) {
                case "lng":
                    WLV.add(getGeocode().getLong_country());
                    WLV.add(getGeocode().getLong_city());
                    WLV.add(getStatus().getOnline());
//                    WLV.add(StringUtils.outStr(" ", getStatus().getListen_addrs().toArray()));
                    WLV.add(String.valueOf(getLng()));
                    break;
                default:
                    WLV.add(String.valueOf(jsonObject.get(clo)));
                    break;
            }
        }

        return StringUtils.outStr(",", WLV.toArray());

//        return StringUtils.outStr(",",
//                getName().replaceAll("-", " "),
//                getGeocode().getShort_country(),
//                getGeocode().getLong_country(),
//                getStatus().getOnline(),
//                getTotal() + "",
//                getOwner() + "",
//                JSON.toJSONString(getStatus().getListen_addrs()));
    }

    public GlobalDevice toGlobalDevice(String cursor) {
        getTimestamp();
        getStatus().getTimestamp();
        getStatus().getIp();
        GlobalDevice globalDevice = BeanUtils.mergeObjects(GlobalDevice.class, this, getGeocode(), getStatus());
        if (ObjectUtils.notIsEmpty(getLocation())) {
            globalDevice.setHex5(HexUtils.h3.h3ToParentAddress(getLocation(), 5));
        }
        globalDevice.setCursor(cursor);
        return globalDevice;
    }


    public String toGlobalDeviceSql(String cursor) {
//         insert into global_device (address, hex5, lng, lat, timestamp_added, `timestamp`, `online`, listen_addrs, height, reward_scale, payer, `owner`, nonce, `name`, `mode`,
//         location_hex, `location`, last_poc_challenge, last_change_block, short_street, short_state, short_country, short_city, long_street, long_state, long_country,
//         long_city, city_id, gain, elevation, block_added, block, create_time, update_time, `cursor`)

        String sql = "insert into global_device (address, hex5, lng, lat, timestamp_added, `timestamp`, `online`, listen_addrs, height, reward_scale, payer, `owner`, nonce, `name`, `mode`, location_hex, `location`, last_poc_challenge, last_change_block, short_street, short_state, short_country, short_city, long_street, long_state, long_country, long_city, city_id, gain, elevation, block_added, block, create_time, update_time, `cursor`)\n" +
                " VALUES ('%s', '%s', %f, %f, %s, %s, '%s', '%s', %d, %f, '%s', '%s', %d, '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d, '%s', null, '%s');";
        String sf = "'%s'";

        return String.format(sql, getAddress(), ObjectUtils.notIsEmpty(getLocation()) ? HexUtils.h3.h3ToParentAddress(getLocation(), 5) : "null", getLng(), getLat(), ObjectUtils.notIsEmpty(getTimestamp()) ? String.format(sf, DateUtils.asStr(getTimestamp())) : null,
                ObjectUtils.notIsEmpty(getStatus().getTimestamp()) ? String.format(sf, DateUtils.asStr(getStatus().getTimestamp())) : null, getStatus().getOnline(), getStatus().getIp(), getStatus().getHeight(), getReward_scale(), getPayer(),
                getOwner(), getNonce(), getName(), getMode(), getLocation_hex(), getLocation(), getLast_poc_challenge(), getLast_change_block(), ObjectUtils.notIsEmpty(getGeocode().getShort_street()) ? getGeocode().getShort_street().replaceAll("'", "") : null,
                getGeocode().getShort_state(), getGeocode().getShort_country(), getGeocode().getShort_city(), ObjectUtils.notIsEmpty(getGeocode().getLong_street()) ? getGeocode().getLong_street().replaceAll("'", "") : null, getGeocode().getLong_state(), getGeocode().getLong_country(),
                getGeocode().getLong_city(), getGeocode().getCity_id(), getGain(), getElevation(), getBlock_added(), getBlock(), DateUtils.asStr(LocalDateTime.now()), cursor);
    }


    public LocalDateTime getTimestamp() {
        if (timestamp_added instanceof String) {
            setTimestamp_added(DateUtils.asLocalDateTime(DateUtils.toDate((String) timestamp_added)));
        }
        return (LocalDateTime) timestamp_added;
    }

}
