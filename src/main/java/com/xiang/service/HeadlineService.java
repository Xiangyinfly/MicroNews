package com.xiang.service;

import com.xiang.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiang.pojo.vo.PortalVo;
import com.xiang.utils.Result;

/**
* @author chenwentao
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-10-10 20:37:33
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline, String token);

    Result updateHeadline(Headline headline);
}

