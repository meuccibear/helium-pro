package io.renren.modules.helium.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
