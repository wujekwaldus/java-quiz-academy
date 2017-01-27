package pl.academy.quiz.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@EnableCaching
public class JavaQuizCacheConfiguration implements CachingConfigurer {

	@Override
	public CacheManager cacheManager() {
		return new HazelcastCacheManager(Hazelcast.newHazelcastInstance(new XmlConfigBuilder().build()));
	}

	@Override
	public CacheResolver cacheResolver() {
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return null;
	}

}
