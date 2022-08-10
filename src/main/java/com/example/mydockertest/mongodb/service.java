package com.example.mydockertest.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.example.mydockertest.entry.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/2 15:38
 * @Version: v1.0
 */
@Service
public class service {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public void add(){
        Query query = new Query();
        query.addCriteria(Criteria.where("testname").is("123"));
        List<JSONObject> one = mongoTemplate.findAll(JSONObject.class ,"comment" );

        mongoTemplate.findOne(query, JSONObject.class , "comment");
        
        HashMap map = new HashMap();
        map.put("testname" ,"123");
        mongoTemplate.insert(map ,"comment");

        //System.out.println(mongoTemplate.findOne(query, JSONObject.class, "comment"));
        comment comment = new comment();
        comment.setUserid("1111111111111");
        mongoTemplate.insert(comment);
        System.out.println(mongoTemplate.findAll(comment.class));
    }
    
            
}
