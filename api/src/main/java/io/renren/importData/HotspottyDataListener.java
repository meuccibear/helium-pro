package io.renren.importData;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.business.service.BusinessDeviceService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class HotspottyDataListener implements ReadListener<HotspottyData> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<HotspottyData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
//    private HotspottyDAO demoDAO;

    //insertOrUpdate
    private BusinessDeviceService businessDeviceService;

//    public HotspottyDataListener() {
//        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
//        demoDAO = new HotspottyDAO();
//    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     * @param businessDeviceService
     */
    public HotspottyDataListener(BusinessDeviceService businessDeviceService) {
        this.businessDeviceService = businessDeviceService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(HotspottyData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        List<BusinessDeviceEntity> businessDeviceEntities = BeanUtils.toJavaObject(cachedDataList, new TypeReference<List<BusinessDeviceEntity>>() {});
        businessDeviceService.insertOrUpdate(businessDeviceEntities);
        log.info("存储数据库成功！");
    }
}
