package com.how2java.shiro.test;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        if (jedis.ping().equals("PONG")){
            System.out.println("服务正在运行: "+jedis.ping());
        }else {
            System.out.println("服务没有启动");
        }
        //查看服务是否运行

    }
}
