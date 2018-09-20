package com.weidai.data;

import com.alibaba.fastjson.JSON;
import com.weidai.data.model.TExample;
import com.weidai.data.service.MapperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @Description: TODO
 * @Auther: tonglianghong
 * @Date: 2018/9/20 19:46
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ShardingJdbcTest {

    @Autowired
    MapperService service;

    @Test
    public void testMutilpeDataSource() {
        TExample tx = new TExample();
        for (int i = 200; i< 300; i++) {
            tx.setId(i);
            tx.setAge(new Random().nextInt(300));
            tx.setName("asdasd" + i);
            service.insert(tx);
            System.out.println(JSON.toJSONString(tx));
        }
    }
}
