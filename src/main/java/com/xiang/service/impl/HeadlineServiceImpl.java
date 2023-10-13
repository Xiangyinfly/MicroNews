package com.xiang.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiang.pojo.Headline;
import com.xiang.pojo.vo.PortalVo;
import com.xiang.service.HeadlineService;
import com.xiang.mapper.HeadlineMapper;
import com.xiang.utils.JwtHelper;
import com.xiang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author chenwentao
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-10-10 20:37:33
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public Result findNewsPage(PortalVo portalVo) {
        IPage<Map> page = new Page(portalVo.getPageNum(),portalVo.getPageSize());
        headlineMapper.selectMyPage(page,portalVo);

        Map pageInfo = new HashMap<>();
        pageInfo.put("pageData",page.getRecords());
        pageInfo.put("pageNum",page.getCurrent());
        pageInfo.put("pageSize",page.getSize());
        pageInfo.put("totalPage",page.getPages());
        pageInfo.put("totalSize",page.getTotal());

        return Result.ok(pageInfo);
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map headlineMap = headlineMapper.queryDetailMap(hid);
        Map data = new HashMap();
        data.put("headline",headlineMap);

        Headline headline = new Headline();
        headline.setHid((Integer) headlineMap.get("hid"));
        headline.setVersion((Integer) headlineMap.get("version"));
        headline.setPageViews((Integer) headlineMap.get("pageViews") + 1);
        headlineMapper.updateById(headline);

        return Result.ok(data);
    }

    @Override
    public Result publish(Headline headline, String token) {
        int userId = jwtHelper.getUserId(token).intValue();

        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result updateHeadline(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);
        return Result.ok(null);
    }

}
