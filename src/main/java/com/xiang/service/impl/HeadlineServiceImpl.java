package com.xiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiang.pojo.Headline;
import com.xiang.service.HeadlineService;
import com.xiang.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author chenwentao
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-10-10 20:37:33
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




