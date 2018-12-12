package cn.sxh.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	@Test
	public void testConn() {
		String host = "127.0.0.1";
		int port = 6379;
		Jedis jedis = new Jedis(host, port);
		System.out.println("连接成功！");
		//查看是否正在运行
		System.out.println(jedis.ping());
		String strKey = "testString";
		System.out.println(strKey+"============="+jedis.get(strKey));
		String hashKey = "testHash";
		System.out.println(hashKey+"============="+jedis.hget(hashKey, "fldname"));
		System.out.println(hashKey+"============="+jedis.hgetAll(hashKey));
		String listKey = "testList";
		System.out.println(listKey+"============="+jedis.lrange(listKey, 0, 10));
		String setKey = "testSet";
		System.out.println(setKey+"============="+jedis.smembers(setKey));
		String zSetKey = "testZset";
		System.out.println(zSetKey+"============="+jedis.zrange(zSetKey, 0, 3));
		jedis.close();
	}
}
