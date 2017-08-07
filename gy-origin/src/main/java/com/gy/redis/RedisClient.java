package com.gy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class RedisClient {

    private static final String host = "127.0.0.1";
    private static final Integer port = 6379;

    public static Jedis jedis; //客户端连结
    private static JedisPool jedisPool; //客户端连接池

    public RedisClient(){
        initPool();
        jedis = jedisPool.getResource();
    }

    /**
     * 初始化连接池
     */
    private void initPool(){
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, host, port);
    }

}
