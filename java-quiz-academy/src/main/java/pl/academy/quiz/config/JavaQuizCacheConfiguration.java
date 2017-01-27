package pl.academy.quiz.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@EnableCaching
public class JavaQuizCacheConfiguration {

	@Bean
	public CacheManager cacheManager() {
		return new HazelcastCacheManager(Hazelcast.newHazelcastInstance(new XmlConfigBuilder().build()));
	}



}
