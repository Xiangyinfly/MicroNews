package com.xiang.controller;

import com.xiang.pojo.Headline;
import com.xiang.service.HeadlineService;
import com.xiang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid) {
        Headline headline = headlineService.getById(hid);
        Map data = new HashMap<>();
        data.put("headline",headline);
        return Result.ok(data);
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline) {
        Result result = headlineService.updateHeadline(headline);
        return result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid) {
        headlineService.removeById(hid);
        return Result.ok(null);
    }

}
