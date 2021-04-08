package com.imposto.api.dao.datasource.stur;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@formatter:off

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "db2EntityMgrFactory", 
		transactionManagerRef = "db2TransactionMgr", 
		basePackages = {"com.imposto.api.dao.datasource.stur" })
@EnableTransactionManagement
public class DataSourceSturConfig {
	
	@Value("${spring.db2.jpa.hibernate.ddl-auto}")
	private String hbm2ddl;
	
	@Value("${spring.db2.packages}")
	private String packages;
	
	@Value("${spring.db2.jpa.database-platform}")
	private String dialect;
	

	@Bean(name = "datasource2")
	@ConfigurationProperties(prefix = "spring.db2.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db2EntityMgrFactory")
	public LocalContainerEntityManagerFactoryBean db2EntityMgrFactory(final EntityManagerFactoryBuilder builder,
			@Qualifier("datasource2") final DataSource dataSource) {
		
		final Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		properties.put("hibernate.dialect", dialect);
		
		return builder.dataSource(dataSource)
				.properties(properties)
				.packages(packages)
				.persistenceUnit("sturDB")
				.build();
	}

	@Bean(name = "db2TransactionMgr")
	public PlatformTransactionManager db2EntityMgrFactory(
			@Qualifier("db2EntityMgrFactory") final EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}

//@formatter:off
