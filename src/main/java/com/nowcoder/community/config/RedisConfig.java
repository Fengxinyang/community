package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 配置工厂，才能连接redis数据库
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置普通value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置hash的key序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置hash的value序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        //让配置生效
        template.afterPropertiesSet();

        return template;
    }
}
