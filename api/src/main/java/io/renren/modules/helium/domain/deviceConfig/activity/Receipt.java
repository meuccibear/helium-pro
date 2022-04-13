/**
  * Copyright 2021 bejson.com
  */
package io.renren.modules.helium.domain.deviceConfig.activity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Auto-generated: 2021-11-17 10:40:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    private int tx_power;
    private long timestamp;
    private int snr;
    private int signal;
    private String origin;
    private String gateway;
    private int frequency;
    private String datarate;
    private String data;
    private int channel;


}
