package com.techleads.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.techleads.app.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		
		return new LettuceConnectionFactory();
	}
	@Bean
	public RedisTemplate<String, Employee>  redisTemplate(){
		RedisTemplate<String, Employee>  template=new RedisTemplate<String, Employee> ();
		 template.setConnectionFactory(redisConnectionFactory());
		 return template;
	}
	

}
