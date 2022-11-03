package io.renren.modules.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "WholeNetworkDevice") //通过collection参数指定当前实体类对应的文档
public class WholeNetworkDevice {
    @Id
    private String address;

    private String hex5;

    private Double lng;

    private Double lat;

    private Date timestampAdded;

    private Date timestamp;

    private String online;

    private String listenAddrs;

    private Long height;

    private Double rewardScale;

    private String payer;

    private String owner;

    private Integer nonce;

    private String name;

    private String mode;

    private String locationHex;

    private String location;

    private Long lastPocChallenge;

    private Long lastChangeBlock;

    private String shortStreet;

    private String shortState;

    private String shortCountry;

    private String shortCity;

    private String longStreet;

    private String longState;

    private String longCountry;

    private String longCity;

    private String cityId;

    private Integer gain;

    private Integer elevation;

    private Long blockAdded;

    private Long block;

    private Date createTime;

    private Date updateTime;

    private String cursor;
}
