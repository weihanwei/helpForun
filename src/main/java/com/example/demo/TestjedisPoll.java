package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/redis")
public class TestjedisPoll {
	 @Autowired
	private JedisPool jedisPool;
			
	 /**
	  * http://localhost:9394/springbootDemo/redis/getRedis
	     * @auther: zhangyingqi
	     * @date: 16:23 2018/8/29
	     * @param: []
	     * @return: org.springframework.ui.ModelMap
	     * @Description: 执行redis写/读/生命周期
	     * ModelMap
	     */
	    @RequestMapping(value = "getRedis")
	    @ResponseBody
	    public String  getRedis(){
	  	
	    	Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
			//	jedis.select(indexdb);
				 jedis.set("20190429", "redistest");
				 jedis.rpush("a", "1");  
				          jedis.lpush("a","6");  
				          jedis.lpush("a","3");  
				          jedis.lpush("a","9");  
				          System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]  
				          System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果  
				          System.out.println(jedis.lrange("a",0,-1)); 
				          jedis.close();
				          return "1";
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			} 

	    	
//	    	Jedis jedis = new Jedis("localhost",6379);
//	        jedis.lpush("13724049458", "266f8a84f80f42189fea003dbdf306d9");
//	         List<String> list =jedis.lrange("13724049458", 0, -1);
//	         System.out.println(list);
//	    	return "";
//
//	        redisUtil.set("20182018","这是一条测试数据", 0);
//	        Long resExpire = redisUtil.expire("20182018", 60, 0);//设置key过期时间
//	        String res = redisUtil.get("20182018", 0);
	    }

	
}
