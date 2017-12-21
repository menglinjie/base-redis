import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        RedisManager redisManager = (RedisManager) ctx.getBean("redisManager");
        redisManager.flushDB();
        redisManager.set("string_test", "string_test");
        System.out.println("===string类型====：" + redisManager.get("string_test"));

        redisManager.sadd("set_test", "set_1");
        redisManager.sadd("set_test", "set_2");
        redisManager.sadd("set_test", "set_3");
        System.out.println("===set类型====：" + redisManager.smembers("set_test"));

//        redisManager.hset("Hash_test", "name", "kxl");
//        redisManager.hset("Hash_test", "age", "25");
//        redisManager.hset("Hash_test", "sex", "male");
//        System.out.println("===hash类型====：" + redisManager.hget("Hash_test", "name"));
//
//        Map<String, String> maps = new HashMap<String, String>();
//        maps.put("name", "xiaohong");
//        maps.put("age", "20");
//        maps.put("sex", "female");
//        redisManager.hmset("Hash_test2", maps);
//        System.out.println("===hash类型测试2====：" + redisManager.hmget("Hash_test2", "name", "age"));
//
//        redisManager.lpush("List", "3");
//        redisManager.lpush("List", "7");
//        redisManager.lpush("List", "1");
//        System.out.println("===List类型====：" + redisManager.lrange("List", 0, -1));
//
//        redisManager.zadd("sorted set", 10, "set1");
//        redisManager.zadd("sorted set", 2, "set2");
//        redisManager.zadd("sorted set", 3, "set3");
//        System.out.println("==sorted sett类型====：" + redisManager.zrevrangeByScore("sorted set", 10, 0));

    }
}