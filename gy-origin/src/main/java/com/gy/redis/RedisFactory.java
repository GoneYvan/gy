package com.gy.redis;

import com.gy.common.ApplicationLogger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class RedisFactory {

    private final static Jedis jedis = new RedisClient().jedis;

    //    private final static Jedis jedis = RedisClient.jedis;
    private final static Integer defaultTimeOut = 7200; // 默认超时时间

    /*****************************************************************
     *
     * key 部分
     *
     *****************************************************************/

    /**
     * 设置一个key值(create new KEY|modify old key)
     * @param key
     * @param value
     * @param timeOut
     */
    public static void setKey(String key, String value, Integer timeOut){
        if(key != null){
            // 存在有效KEY
            if(value != null){
                // 添加永久key
                jedis.set(key, value);
            }
            if(timeOut != null){
                // 添加时效key,如果key存在则替换，不存在则无效
                jedis.expire(key, timeOut);
            }
        }
    }

    /**
     * 获取key的剩余时间
     * @param key
     * @return -1 永久KEY
     *  -2 不存在key
     *  >0 时间戳，单位秒
     */
    public static Long getKeyTime(String key){
        if(key == null){
            return Long.valueOf(-2); // 不存在KEY时的返回数据
        }
        return jedis.ttl(key);
    }

    /**
     * 获取key的值
     * @param key
     * @return
     */
    public static String getKeyValue(String key){
        if(key == null){
            return null;
        }
        return jedis.get(key);
    }

    /**
     * 根据校验规则遍历key，参数为空时全查
     * @param pattern
     * @return
     */
    public static Set<String> listKeys(String pattern){
        if(pattern == null){
            return jedis.keys("*");
        }
        return jedis.keys(pattern + "*");
    }

    /**
     * 删除key
     * @param key
     */
    public static void delKey(String key){
        if(key != null){
            jedis.del(key);
        }
    }

    /**
     * 获取key的类型
     * @param key
     * @return none 不存在key
     */
    public static String getKeyType(String key){
        if(key == null){
            return null;
        }
        return jedis.type(key);
    }

    /**
     * 判断KEY值是否存在
     * @param key
     * @return true 存在
     */
    public static boolean checkExist(String key){
        if(jedis.exists(key)){
            return true;
        }
        return false;
    }


    /*****************************************************************
     *
     * string 部分
     *
     *****************************************************************/

    /**
     * 增加string
     * @param key
     * @param value
     */
    public static void setString(String key, String value){
        if(key != null && value != null){
            jedis.set(key, value);
        }
    }

    /**
     * 一次性增加多个string
     * @param group
     */
    public static void mSetStrings(String... group){
        if(group != null && group.length > 0 && group.length%2==0){
            jedis.mset(group);
        }
    }

    /**
     * 获取string
     * @param key
     * @return null 值为"null"，或者不存在string
     */
    public static String getString(String key){
        if(key == null){
            return null;
        }
        return jedis.get(key);
    }

    /**
     * 根据key截取下标值字符串（前后包含，全部end=-1）
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static String getIndexString(String key, int start, int end){
        if(key == null){
            return null;
        }
        return jedis.substr(key, start, end);
    }

    /**
     * 一次性获取多个string
     * @param group
     * @return
     */
    public static List<String> mGetStrings(String... group){
        if(group != null && group.length > 0){
            return jedis.mget(group);
        }
        return null;
    }


    /**
     * 追加字符串
     * @param key
     * @param aStr
     * @return
     */
    public static void appendString(String key, String aStr){
        if(key != null && aStr != null){
            jedis.append(key, aStr);
        }
    }

    /**
     * 删除string
     * @param key
     */
    public static void delString(String key){
        if(key != null){
            jedis.del(key);
        }
    }

    /**
     * 一次性删除多个string
     * @param group
     */
    public static void mDelString(String... group){
        if(group != null && group.length > 0){
            jedis.del(group);
        }
    }


    /*****************************************************************
     *
     * hash 部分
     *
     *****************************************************************/

    /**
     * 新增hash
     * @param key
     * @param field
     * @param value 当value为数字时，直接传输字符串型数字
     */
    public static void setHash(String key, String field, String value){
        if(key != null && field != null && value != null){
            jedis.hset(key, field, value);
        }
    }

    /**
     * hash字段值为数值时，累加value
     * @param key
     * @param field
     * @param value
     */
    public static void setPlusValHash(String key, String field, Integer value){
        if(key != null && field != null && value != null){
            jedis.hincrBy(key, field, value);
        }
    }

    /**
     * 获取hash表内字段值
     * @param key
     * @param field
     */
    public static String getHash(String key, String field){
        if(key != null && field != null){
            if(!jedis.hexists(key, field)){
                return null;
            }
            return jedis.hget(key, field);
        }
        return null;
    }

    /**
     * 多段读取hash内元素value
     * @param key
     * @param fields
     * @return
     */
    public static List<String> listFieldHash(String key, String... fields){
        if(key == null){
            return null;
        }
        if(jedis.exists(key)){
            return jedis.hmget(key, fields);
        }
        return null;
    }

    /**
     * 获取hash内所有value
     * @param key
     * @return
     */
    public static Set<String> listHashKeys(String key){
        if(key == null){
            return null;
        }
        if(!jedis.exists(key)){
            return null;
        }
       return jedis.hkeys(key);
    }

    /**
     * 获取hash内所有value
     * @param key
     * @return
     */
    public static List<String> listHashValues(String key){
        if(key == null){
            return null;
        }
        if(!jedis.exists(key)){
            return null;
        }
       return jedis.hvals(key);
    }

    /**
     * 获取hash内所有的字段和字段值
     * @param key
     * @return
     */
    public static Map<String, String> listAllHash(String key){
        if(key == null){
            return null;
        }
        if(!jedis.exists(key)){
            return null;
        }
        return jedis.hgetAll(key);
    }

    /**
     * 删除hash内字段
     * @param key
     * @param field
     */
    public static void delHash(String key, String field){
        if(key != null && field != null){
            jedis.hdel(key, field);
        }
    }


    /*****************************************************************
     *
     * list 部分
     *
     *****************************************************************/

    /**
     * 添加list
     * @param key
     * @param value
     */
    public static void setList(String key, String... value){
        if(key != null && value != null){
            jedis.lpush(key, value);
        }
    }

    /**
     * 根据key值获取下标索引部分（前后包含）
     * @param key
     * @param start
     * @param end -1表示到尾部
     * @return
     */
    public static List<String> listIndexList(String key, long start, long end){
        if(key == null){
            return null;
        }
        if(checkExist(key)){
            return jedis.lrange(key, start, end);
        }
        return null;
    }

    /**
     * 删除制定数量的重复value
     * @param key
     * @param count
     * @param value
     */
    public static void delItemList(String key, Integer count, String value){
        if(key != null && count > 0 && value != null){
            jedis.lrem(key, count, value);
        }
    }

    /**
     * 删除指定下标值的value
     * @param key
     * @param start
     * @param end
     */
    public static void delIndexList(String key, long start, long end){
        if(key != null){
            if(checkExist(key)){
                jedis.ltrim(key, start, end);
            }
        }
    }

    /**
     * 移出首位元素
     * @param key
     * @return
     */
    public static String popList(String key){
        if(key != null){
            if(checkExist(key)){
                return jedis.lpop(key);
            }
        }
        return null;
    }

    /**
     * 根据下标值修改list的value
     * @param key
     * @param index
     * @param value
     */
    public static void modifyIndexList(String key, long index, String value){
        if(key != null && value != null){
            jedis.lset(key, index, value);
        }
    }

    /**
     * 获取列表长度
     * @param key
     * @return
     */
    public static Long getLenList(String key){
        if(key != null && checkExist(key)){
            return jedis.llen(key);
        }
        return null;
    }

    /**
     * 获取制定下标下的元素值
     * @param key
     * @param index
     * @return
     */
    public static String getIndexList(String key, long index){
        if(key != null && checkExist(key)){
            return jedis.lindex(key, index);
        }
        return null;
    }


    /**
     * 返回排序后的list
     * @param key
     * @param index 起始下标索引
     * @param count 统计数量
     * @return
     */
    public static List<String> sortList(String key, int index, int count){
        if(key != null && checkExist(key)){
            Object o = getIndexList(key, 0);
            SortingParams sortingParams = new SortingParams();
            sortingParams.alpha();
            sortingParams.limit(index,count);
            return jedis.sort(key, sortingParams);
        }
        return null;
    }


    /*****************************************************************
     *
     * set 部分
     *
     *****************************************************************/

    /**
     * 添加Set集合
     * @param key
     * @param value
     */
    public static void setSet(String key, String... value){
        if(key != null && value != null){
            jedis.sadd(key, value);
        }
    }

    /**
     * 查询Set全部
     * @param key
     * @return
     */
    public static Set<String> listAllSet(String key){
        if(key != null && checkExist(key)){
            return jedis.smembers(key);
        }
        return null;
    }

    /**
     * 查询Set下是否存在value
     * @param key
     * @param value
     * @return true 存在
     */
    public static boolean isExistSet(String key, String value){
        if(key != null && value!=null){
            return jedis.sismember(key, value);
        }
        return false;
    }

    /**
     * 删除Set下的value部分
     * @param key
     * @param value
     */
    public static void delSet(String key, String... value){
        if(key != null && value != null){
            jedis.srem(key, value);
        }
    }

    /**
     * 计算两个Set之间的交集
     * @param key1
     * @param key2
     * @return
     */
    public static Set<String> interSet(String key1, String key2){
        if(key1 != null && key2 !=null && checkExist(key1) && checkExist(key2)){
            return jedis.sinter(key1, key2);
        }
        return null;
    }

    /**
     * 计算两个set之间的并集
     * @param key1
     * @param key2
     * @return
     */
    public static Set<String> unionSet(String key1, String key2){
        if(key1 != null && key2 !=null && checkExist(key1) && checkExist(key2)){
            return jedis.sunion(key1, key2);
        }
        return null;
    }

    /**
     * 计算两个set之间的差集：Set1有，Set2没有
     * @param key1
     * @param key2
     * @return
     */
    public static Set<String> diffSet(String key1, String key2){
        if(key1 != null && key2 !=null && checkExist(key1) && checkExist(key2)){
            return jedis.sdiff(key1, key2);
        }
        return null;
    }


    /*****************************************************************
     *
     * zset 部分
     *
     *****************************************************************/

    /**
     * 新增ZSet
     * @param key
     * @param score
     * @param value
     */
    public static void setZSet(String key, double score, String value){
        if(key != null && value != null){
            jedis.zadd(key, score, value);
        }
    }

    /**
     * 根据下标值查询ZSet
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> listIndexZSet(String key, long start, long end){
        if(key != null){
            return jedis.zrange(key, start, end);
        }
        return null;
    }

    /**
     * 删除ZSet下的匹配项
     * @param key
     * @param value
     */
    public static void delZSet(String key, String... value){
        if(key != null && value != null){
            jedis.zrem(key, value);
        }
    }

    /**
     * 统计ZSet数量
     * @param key
     * @return
     */
    public static Long countZSet(String key, Double min, Double max){
        if(key != null && checkExist(key)){
            if(min != null && max != null){
                // 权重下统计
                return jedis.zcount(key, min, max);
            }
            // 无条件统计
            return jedis.zcard(key);
        }
        return null;
    }

    /**
     * 查询value在ZSet下的比重
     * @param key
     * @param value
     * @return
     */
    public static Double scoreZSet(String key, String value){
        if(key != null && checkExist(key) && value != null){
            return jedis.zscore(key, value);
        }
        return null;
    }


    /**
     * 清空数据
     */
    public static void flushDB(){
        addApplicationLogger(jedis.flushDB(), "clear redis DB fail");
    }

    /**
     * 清空所有数据
     */
    public static void flushAll(){
        addApplicationLogger(jedis.flushAll(), "clear redis ALL fail");
    }

    /**
     * 校验redis下的结果是否成功
     * @param res
     * @return true 成功
     */
    public static boolean checkResult(String res){
        if(res != null &&
                (res.equalsIgnoreCase("ok")
                        || res.equalsIgnoreCase("true"))){
            return true;
        }
        return false;
    }

    /**
     * 添加失败结果日志
     * @param res
     * @param msg
     */
    public static void addApplicationLogger(String res, String msg){
        if(!checkResult(res)){
            ApplicationLogger.applicationLogger.info(msg);
        }
    }
}
