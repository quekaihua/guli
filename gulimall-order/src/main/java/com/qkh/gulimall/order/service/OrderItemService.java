package com.qkh.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qkh.common.utils.PageUtils;
import com.qkh.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author qkh
 * @email qkhforstudy@gmail.com
 * @date 2023-08-28 07:31:56
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

