package com.zo2ami.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
	private static final String ENTITIES_PACKAGE = "com.zo2ami.entity";
	
	@Value("${db.showsql}")
	private boolean showSQL;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String dbPassword;
	@Value("${db.maxIdelTime}")
	private long maxIdelTime;
	@Value("${db.minPoolSize}")
	private int minPoolSize;
	@Value("${db.maxPoolSize}")
	private int maxPoolSize;
	@Value("${db.hbm2ddl.auto}")
	private String hbm2ddlAauto;
	
	
	
	@Bean(name = "dataSource")
	public HikariDataSource initHikariDS() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setUsername(username);
		config.setPassword(dbPassword);
		config.setIdleTimeout(maxIdelTime);
		config.setMinimumIdle(minPoolSize);
		config.setMaximumPoolSize(maxPoolSize);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		return new HikariDataSource(config);
	}
	
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(initHikariDS());
		localSessionFactoryBean.setPackagesToScan(ENTITIES_PACKAGE);

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.show_sql", showSQL);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.use_outer_join", true);
		properties.put("hibernate.bytecode.use_reflection_optimizer", true);
		properties.put("hibernate.id.new_generator_mappings", true);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddlAauto);
		localSessionFactoryBean.setHibernateProperties(properties);
		return localSessionFactoryBean;
	}

	
	
}
