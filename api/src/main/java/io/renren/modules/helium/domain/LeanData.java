package io.renren.modules.helium.domain;

import com.alibaba.fastjson.annotation.JSONField;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.sys.entity.GlobalDevice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Auto-generated: 2022-03-31 15:38:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeanData {

    private String id;
    private long bh;
    private long ba;
    private String p;
    private Boolean r;
    /**
     * 每天收益
     */
    private long lpc;
    private double lt;
    private double lg;
    /**
     * locatioin
     */
    private String l;
//    @JSONField(name = "l")
//    private String locatioin;
    private String n;
    private int no;
    private String o;
    /**
     * reward_scale
     */
    private Double rs;
    private long ss;
    /**
     * online
     */
    @JSONField(name = "on")
    private Boolean online;
    private long ta;
    private int d;
    private int e;
    private int g;
    private Boolean s;
    private long lu;
    private String en;
    private long la;
    private String pa;
    private String r9;
    private Boolean dl;
    private int tru;
    private int rru;
    private int prs;
    private int tsrxru;

//    public GlobalDevice toGlobalDevice() {
//        GlobalDevice globalDevice = new GlobalDevice(getId(),
//                HexUtils.h3.h3ToParentAddress(getL(), 5), getLg(),getLt()
//        ,new Date(getTa()), null, getOnline()?"online":"off", null,
//               null, null, getPa(),getO(), getNo(), getN(), null,
//                null, getL(), null,null,null,null,null,null);
//
//
//        return globalDevice;
//    }
}


//      id: hotspot.id,
//      block_added: hotspot.bh,
//      entity: hotspot.en,
//      last_poc_challenge: hotspot.lpc,
//      last_update: hotspot.lu,
//      place: hotspot.p,
//      lat: hotspot.lt,
//      lng: hotspot.lg,
//      location: hotspot.l,
//      name: hotspot.n,
//      online: hotspot.on,
//      owner: hotspot.o,
//      payer: hotspot.pa,
//      relayed: hotspot.r,
//      reward_scale: hotspot.rs,
//      timestamp_added: hotspot.ta,
//      last_assertion: hotspot.la,
//      elevation: hotspot.e,
//      gain: hotspot.g,
//      nonce: hotspot.no,
//      deny_list: hotspot.dl


//ba: 943978
//bh: 1209708
//d: 48
//dl: false
//e: 0
//en: "hotspot"
//g: 12
//id: "112M4KnnayrBMRHCmBBfhg2FuBa1DVqQhP8Q3vgbBKo9HTPnSaQ7"
//l: "8c25b02002063ff"
//la: 1627816082
//lg: 87.57197241810492
//lpc: 1317072
//lt: 43.8091402687474
//lu: 1650338132
//n: "best-metal-tadpole"
//no: 1
//o: "13QtWM7KdmC2rZKp7SG6Y2YDM9yEDr7SCEmRj5ncdaiAHePMLUZ"
//on: true
//p: "Wulumuqi Shi, Xinjiang Weiwuerzizhiqu, China"
//pa: "14sKWeeYWQWrBSnLGq79uRQqZyw3Ldi7oBdxbF6a54QboTNBXDL"
//prs: 12.0907823865715
//r: true
//r9: "8925b020023ffff"
//rru: 0.22195529874285716
//rs: 0.9293670654296875
//s: true
//ss: 1643856241
//ta: 1627607673
//tru: 1.8926258176
//tsrxru: 0.20627794464921875


//id: e.id,
//block_added: e.ba,
//block_height: e.bh,
//entity: e.en,
//last_poc_challenge: e.lpc,
//last_update: e.lu,
//place: e.p,
//lat: e.lt,
//lng: e.lg,
//location: e.l,
//name: e.n,
//online: e.on,
//owner: e.o,
//payer: e.pa,
//relayed: e.r,
//reward_scale: e.rs,
//timestamp_added: e.ta,
//last_assertion: e.la,
//elevation: e.e,
//gain: e.g,
//nonce: e.no,
//deny_list: e.dl,
//tx_reward_unit: e.tru,
//rx_reward_unit: e.rru,
//poc_reward_score: e.prs,
//witness_score: e.tsrxru
