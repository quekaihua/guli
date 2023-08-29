package com.qkh.gulimall.order.dao;

import com.qkh.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author qkh
 * @email qkhforstudy@gmail.com
 * @date 2023-08-28 07:31:56
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
