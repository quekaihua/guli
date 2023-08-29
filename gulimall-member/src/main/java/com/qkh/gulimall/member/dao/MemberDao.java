package com.qkh.gulimall.member.dao;

import com.qkh.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author qkh
 * @email qkhforstudy@gmail.com
 * @date 2023-08-28 07:55:34
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
