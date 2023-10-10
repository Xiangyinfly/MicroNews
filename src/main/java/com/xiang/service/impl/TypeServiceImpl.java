package com.xiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiang.pojo.Type;
import com.xiang.service.TypeService;
import com.xiang.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author chenwentao
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-10-10 20:37:33
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




