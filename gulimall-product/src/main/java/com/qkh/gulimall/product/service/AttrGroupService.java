package com.qkh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qkh.common.utils.PageUtils;
import com.qkh.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author qkh
 * @email qkhforstudy@gmail.com
 * @date 2023-08-27 13:50:31
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

