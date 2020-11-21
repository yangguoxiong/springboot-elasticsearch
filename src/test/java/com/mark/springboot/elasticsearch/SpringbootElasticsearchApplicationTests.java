package com.mark.springboot.elasticsearch;

import com.mark.springboot.elasticsearch.common.Result;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void contextLoads() {
        // 创建index
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("twitter");
        try {
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            String index = createIndexResponse.index();
            System.out.println("创建成功的索引: " + index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exists() {
        GetIndexRequest getIndexRequest = new GetIndexRequest("twitter");
        try {
            boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
            System.out.println("获取是否存在索引成功: " + exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        GetIndexRequest getIndexRequest = new GetIndexRequest("twitter");
        try {
            boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
            System.out.println("获取是否存在索引成功: " + exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
