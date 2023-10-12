package com.xiang.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiang.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiang.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author chenwentao
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2023-10-10 20:37:33
* @Entity com.xiang.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    IPage<Map> selectMyPage(IPage page, @Param("portalVo") PortalVo portalVo);

    Map queryDetailMap(Integer hid);
}




