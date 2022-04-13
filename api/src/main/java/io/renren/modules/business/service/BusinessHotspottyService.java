package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.entity.HotspottyEntity;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.helium.domain.Device;

import java.util.List;

/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessHotspottyService extends IService<BusinessHotspottyEntity> {

    void addHotsPotty(Device device);

    void addNewHotsPotty(Long groupId, Long createUserId, String address) throws MsgException;

    boolean insertHotspotty(BusinessHotspottyEntity businessHotspottyEntity);

    PageRRVO getAll(HotspottyDTO hotspottyDTO);

    List<Select> findOnlines(HotspottyDTO hotspottyDTO);

    List<OptionBean> findHotspottyIdAndNameAndOwner(Long userId);

    List<HotspottyEntity> getHotspottyToGroup(Long groupId);

    void dataRefresh() throws MsgException;

}

