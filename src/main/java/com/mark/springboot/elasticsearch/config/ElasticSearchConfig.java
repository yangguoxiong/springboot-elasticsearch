package com.mark.springboot.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ELsearch配置类
 * 2020/9/2 17:51.
 */
@Configuration
public class ElasticSearchConfig {

    /**
     * 读取配置文件
     */
    @Value("${es.host}")
    private String host;
    @Value("${es.port}")
    private int port;
    @Value("${es.scheme}")
    private String scheme;

    /**
     * 获取es主机和端口
     * @return
     */
    private HttpHost getHttpHost() {
        return new HttpHost(host, port, scheme);
    }

    /**
     * 获取builder
     */
    @Bean
    public RestClientBuilder restClientBuilder() {
        return RestClient.builder(getHttpHost());
    }

    /**
     * 获取客户端
     */
    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder) {
        return new RestHighLevelClient(restClientBuilder);
    }

}
