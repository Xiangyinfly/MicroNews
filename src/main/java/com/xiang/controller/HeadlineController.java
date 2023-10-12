package com.xiang.controller;

import com.xiang.pojo.Headline;
import com.xiang.service.HeadlineService;
import com.xiang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("headline")
@CrossOrigin
public class HeadlineController {

    @Autowired
    private HeadlineService headlineService;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token) {
        Result result = headlineService.publish(headline,token);
        return result;
    }
}
