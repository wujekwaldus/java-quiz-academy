package pl.academy.quiz.config;

import java.util.Properties;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.academy.quiz.auditor.QuizUserAuditorAware;
import pl.academy.quiz.model.QuizUser;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("pl.academy.quiz.repository")
@EnableJpaAuditing(auditorAwareRef = "quizUserAuditor")
public class JavaQuizPersistanceConfiguration {

	@Bean
	public AuditorAware<QuizUser> quizUserAuditor() {
		return new QuizUserAuditorAware();
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		driverManagerDataSource.setUrl("jdbc:hsqldb:mem:java-quiz");
		driverManagerDataSource.setUsername("SA");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("pl.academy.quiz.model");
		entityManagerFactoryBean.setJpaProperties(hibProperties());
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.hbm2ddl.auto", "validate");
		props.put("hibernate.hbm2ddl.auto", "create-drop");
		props.put("hibernate.hbm2ddl.import_files", "data.sql");
		return props;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
