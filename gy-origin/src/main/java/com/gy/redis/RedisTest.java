package com.gy.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class RedisTest {

    public static void main(String[] args){
        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+ jedis.ping());


        // 测试包装类的初始化
//        System.out.println("服务正在运行: "+ new RedisClient().jedis.ping());


        // key
//        RedisFactory.keySet("key2", "key2",null);
//        RedisFactory.keySet("key2", null,100000);
//        System.out.println(RedisFactory.getKeyTime("key2"));
//        System.out.println(RedisFactory.getKeyValue("key2"));

//        System.out.println(RedisFactory.listKeys(null));

//        RedisFactory.keySet("key3", "key3",1000);
//        System.out.println(RedisFactory.getKeyTime("key3"));
//        System.out.println(RedisFactory.getKeyValue("key3"));
//        RedisFactory.removeKey("key3");
//        System.out.println(RedisFactory.getKeyTime("key3"));

//        System.out.println(RedisFactory.getKeyType("key"));


        // string
//        RedisFactory.stringSet("string", "null");
//        RedisFactory.stringSet("string1", "string1");
//        RedisFactory.stringSet("string2", "string2");
//        System.out.println(RedisFactory.getString("string"));
//        System.out.println(RedisFactory.getString("string1"));
//        System.out.println(RedisFactory.getString("string2"));

//        RedisFactory.mSetStrings("string3", "string3", "string4", "string4", "String5", "string5");
//        System.out.println(RedisFactory.mGetStrings("string3", "string4", "String5"));
//        System.out.println(RedisFactory.mGetStrings("string3", "string4", "String5", "string6"));

//        RedisFactory.mRemoveString("string4", "String5");
//        System.out.println(RedisFactory.mGetStrings("string3", "string4", "String5"));

//        RedisFactory.stringAppend("string", "1");
//        System.out.println(RedisFactory.getString("string"));

//        System.out.println(RedisFactory.getIndexString("string2", 0, -1));
//        System.out.println(RedisFactory.getIndexString("string2", 0, 2));
//        System.out.println(RedisFactory.getIndexString("string22", 0, 2));

        // hash
//        RedisFactory.setHash("hash", "hash0", "hash0");
//        RedisFactory.setHash("hash", "hash1", "1");
//        RedisFactory.setHash("hash", "hash2", "hash2");
//        RedisFactory.setHash("hash", "hash3", "3");
//        System.out.println(RedisFactory.getHash("hash", "hash0"));
//        System.out.println(RedisFactory.listHash("hash"));
//
//        RedisFactory.delHash("hash", "hash1");
//        System.out.println(RedisFactory.listHashValues("hash"));
//        System.out.println(RedisFactory.listKeys(null));

//        System.out.println(RedisFactory.listHashValues("hash"));
//        System.out.println(RedisFactory.listFieldHash("hash", "hash0", "hash1", "hash2", "hash7"));

//        System.out.println(RedisFactory.listHashKeys("hash"));

//        System.out.println(RedisFactory.listAllHash("hash"));


        // list
//        RedisFactory.setList("list", "list0", "list1", "list2", "list3");
//        System.out.println(RedisFactory.listIndexList("list", 0, -1));

//        System.out.println(RedisFactory.listIndexList("list", 0, -1));
//        RedisFactory.setList("list", "list1", "list1");
//        System.out.println(RedisFactory.listIndexList("list", 0, -1));
//        RedisFactory.delItemList("list", 1, "list1");
//        System.out.println(RedisFactory.listIndexList("list", 0, -1));

//        RedisFactory.popList("list");
//        System.out.println(RedisFactory.listIndexList("list", 0, -1));

//        RedisFactory.setList("numberList", "1", "3", "3", "5", "6");
//        System.out.println(RedisFactory.sortList("list", 0, 2));
//        System.out.println(RedisFactory.sortList("numberList", 3,2));
//        System.out.println(RedisFactory.sortList("numberList", 0,20));


        // set
//        RedisFactory.setSet("set0", "set1", "set2", "Set3");
//        RedisFactory.setSet("set1", "set4", "set2", "Set3", "set5", "set5");
//        System.out.println(RedisFactory.listAllSet("set0"));
//        System.out.println(RedisFactory.isExistSet("set1", "set4"));
//
//        RedisFactory.delSet("set1", "set5");
//        System.out.println(RedisFactory.interSet("set1", "set0"));
//        System.out.println(RedisFactory.unionSet("set1", "set0"));
//        System.out.println(RedisFactory.diffSet("set1", "set0"));


        // zset
//        RedisFactory.setZSet("zset", 1, "zset1");
//        RedisFactory.setZSet("zset", 1.5, "zset2");
//        RedisFactory.setZSet("zset", 2.1, "zset3");
//        RedisFactory.setZSet("zset", 1.3, "zset4");
//        RedisFactory.setZSet("zset", 1.8, "zset5");
//        RedisFactory.setZSet("zset", 1000, "zset6");
//        System.out.println(RedisFactory.listIndexZSet("zset", 0, -1));
//
//        RedisFactory.delZSet("zset", "zset6");
//        System.out.println(RedisFactory.listIndexZSet("zset", 0, -1));
//
//        System.out.println(RedisFactory.countZSet("zset", null, null));
//        System.out.println(RedisFactory.countZSet("zset", 1.0, 1.5));

//        System.out.println(RedisFactory.scoreZSet("zset", "zset4"));

//        RedisFactory.flushDB();

    }
}
