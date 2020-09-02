package com.mark.springboot.elasticsearch.controller;

import com.mark.springboot.elasticsearch.common.Result;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * es控制器
 * 2020/9/2 17:58.
 */
@RestController
@RequestMapping("/es/prodduct")
public class ElasticSearchController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/get")
    public Result getProduct() {

        return Result.successData("");
    }
}
