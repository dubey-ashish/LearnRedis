package com.api.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig 
{


    @Bean
    public RedisConnectionFactory connectionFactory()
    {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate()
    {
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();


<<<<<<< HEAD
        //Configurations
        redisTemplate.setConnectionFactory(connectionFactory());;

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;


        
=======
        //3-Configurations of redisTemplate
        //* ConnectionFactory
        //* KeySerializer
        //* ValueSerializer

        //for linking the RedisTemplate to the Redis server
        redisTemplate.setConnectionFactory(connectionFactory());;


        //Converts keys into a string format before storing them in Redis.
        //Why? Redis stores everything as a string; this ensures consistent and readable key formats.
        //Because we are returning RedisTemplate<String,Object>, so we have to convert key into plain String
        //Without explicitly setting a serializer like StringRedisSerializer, the key would be serialized into a binary format, making it unreadable in Redis CLI.
        //...because by default, RedisTemplate uses JdkSerializationRedisSerializer for both keys and values. This means keys could end up as serialized binary data, making them unreadable on our side (redis client)
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //Serializes values into JSON before storing them in Redis.
        //This allows you to store complex Java objects in Redis in a human-readable JSON format.
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //in the above two configurations of converting key and value in human-readable format, we do this. Remember we are using Redis as a data-store/database where you can store different forms of data in key-value form
        //...because it makes it simplifies maintenance & debugging
        //Binary formats are hard to debug or inspect without specific tools.
        return redisTemplate;

        //Other info
        //Redis SERVER runs intentionally in-memory(RAM) to achieve high performance
        //This Spring Boot program is client wrt Redis, which plans to use Redis for high speed data retrieval
        //The redis server, as soon as it is started, starts listening on its default port of 6379
        //...irrespective of, whether your program is running or not. You can use redis service provided by redis server by redis-cli command from terminal, without launching your program
        //when your program runs, that is also connected to 6379, establishing a connection with your program
        //From the terminal, you give whatever type of data as key and value as you want to give, the real project will have its own type of data like say performance aggregation DTO type thing to store in Redis (forget the terminal)
        //Redis only supports basic data types (e.g., strings, lists, sets, hashes), but not complex Java objects directly, so serialization helps store and retrieve complex real world-y java objects
>>>>>>> dfe82be (Comments added)
    }

}
