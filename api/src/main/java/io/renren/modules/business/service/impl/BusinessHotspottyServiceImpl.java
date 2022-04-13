package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.modules.business.dao.BusinessHotspottyDao;
import io.renren.modules.business.dao.OwnerHotspottySelect;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.entity.HotspottyEntity;
import io.renren.modules.business.service.AssociationService;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("businessHotspottyService")
public class BusinessHotspottyServiceImpl extends ServiceImpl<BusinessHotspottyDao, BusinessHotspottyEntity> implements BusinessHotspottyService {

    @Autowired
    AssociationService associationService;

    @Override
    public boolean insertHotspotty(BusinessHotspottyEntity businessHotspottyEntity) {

        if(ObjectUtils.notIsEmpty(businessHotspottyEntity.getAddress())){
            Long id = baseMapper.findHotspottyIdByAddress(businessHotspottyEntity.getAddress());
            if (ObjectUtils.isEmpty(id) || 0 == id) {
                businessHotspottyEntity.setStatus(-1);
                baseMapper.insertSelective(businessHotspottyEntity);
                id = businessHotspottyEntity.getHotspottyId();
                System.out.println(" insertHotspotty :"+id);
            }

            associationService.goupHotspottyInsert(businessHotspottyEntity.getGroupId(), id);
            if (ObjectUtils.notIsEmpty(id) && 0 < id) {
                return true;
            }
        }

        return false;
    }


    @Override
    public PageRRVO getAll(HotspottyDTO hotspottyDTO) {
        return PageRRVO.build(hotspottyDTO, baseMapper.findAllByOwnerAndCreateUserId(hotspottyDTO), baseMapper.findAllByOwnerAndCreateUserIdCount(hotspottyDTO));
    }

    @Override
    public void addHotsPotty(Device device) {
        System.out.println(device.getAddress());
        Long id = baseMapper.findHotspottyIdByAddress(device.getAddress());
        BusinessHotspottyEntity businessHotspotty = new BusinessHotspottyEntity();

        if (ObjectUtils.notIsEmpty(id)) {
            System.out.println("修改");
            businessHotspotty.setUpdateDevice(id, device);
            updateById(businessHotspotty);
        } else {
            System.out.println("新增");
            businessHotspotty.setAddDevice(device);
            businessHotspotty.setHotspottyId(null);
            baseMapper.insertSelective(businessHotspotty);
        }
    }


    @Override
    public void addNewHotsPotty(Long groupId, Long createUserId, String address) throws MsgException {

        Device device = HeliumUtils.getHotspotsByAddress(address);
        if (ObjectUtils.notIsEmpty(device)) {
            device.setTotal(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
            Long id = baseMapper.findHotspottyIdByAddress(device.getAddress());

            BusinessHotspottyEntity businessHotspotty = new BusinessHotspottyEntity();
            businessHotspotty.setCreateUserId(createUserId);
            businessHotspotty.setGroupId(groupId);

            if (ObjectUtils.notIsEmpty(id)) {
                System.out.println("修改");
                businessHotspotty.setUpdateDevice(id, device);
                updateById(businessHotspotty);
            } else {
                System.out.println("新增");
                businessHotspotty.setAddDevice(device);
                businessHotspotty.setHotspottyId(null);
                baseMapper.insertSelective(businessHotspotty);
            }
        } else {
            FileUtils.write("addhotspotty.log", address);
        }
    }


    @Override
    public List<Select> findOnlines(HotspottyDTO hotspottyDTO) {
        return baseMapper.findOnlines(hotspottyDTO);
    }

    @Override
    public List<OptionBean> findHotspottyIdAndNameAndOwner(Long userId) {
        List<OwnerHotspottySelect> hotspottyIdAndNameAndOwner = baseMapper.findHotspottyIdAndNameAndOwner(userId);
        Map<String, OptionBean> selectMap = new HashMap<>();

        OptionBean optionBean;
        for (OwnerHotspottySelect ownerHotspottySelect : hotspottyIdAndNameAndOwner) {
            if (selectMap.containsKey(ownerHotspottySelect.getOwner())) {
                optionBean = selectMap.get(ownerHotspottySelect.getOwner());
                optionBean.pull(new OptionBean(ownerHotspottySelect.getHotspottyId(), ownerHotspottySelect.getName(), null));
            } else {
                optionBean = new OptionBean(ownerHotspottySelect.getOwner(), StringUtils.omitMiddle(8, ownerHotspottySelect.getOwner()), null);
                optionBean.pull(new OptionBean(ownerHotspottySelect.getHotspottyId(), ownerHotspottySelect.getName(), null));
                selectMap.put(ownerHotspottySelect.getOwner(), optionBean);
            }

        }
//        ownerHotspottySelect.setOwner(StringUtils.omitMiddle(8, ownerHotspottySelect.getOwner()));
//            select.add(new OptionBean());

        return BeanUtils.toJavaObject(selectMap.values().toArray(), new TypeReference<List<OptionBean>>() {
        });
    }

    @Override
    public List<HotspottyEntity> getHotspottyToGroup(Long groupId) {
        return baseMapper.findAllByGoupId(groupId);
    }

    @Override
    public void dataRefresh() throws MsgException {
        List<BusinessHotspottyEntity> hotspottyEntities = baseMapper.dataRefresh();
        Device device;
        for (BusinessHotspottyEntity hotspottyEntity : hotspottyEntities) {
            if(ObjectUtils.notIsEmpty(hotspottyEntity.getAddress())){
                device = HeliumUtils.getHotspotsByAddress(hotspottyEntity.getAddress());
                if(ObjectUtils.notIsEmpty(device)){
                    device.setTotal(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
                    addHotsPotty(device);
                }
            }
        }
    }
}
