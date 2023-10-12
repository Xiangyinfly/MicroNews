package com.xiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiang.pojo.Type;
import com.xiang.service.TypeService;
import com.xiang.mapper.TypeMapper;
import com.xiang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chenwentao
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-10-10 20:37:33
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result findAllTypes() {
        List<Type> types = typeMapper.selectList(null);
        return Result.ok(types);
    }
}




