package com.qkh.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qkh.common.utils.PageUtils;
import com.qkh.gulimall.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author qkh
 * @email qkhforstudy@gmail.com
 * @date 2023-08-28 07:31:56
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

