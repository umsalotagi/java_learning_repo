package com.example.multipledatasources.product.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.multipledatasources.product.entities.Product;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory",
transactionManagerRef = "productTransactionManager",
basePackages = {"com.example.multipledatasources.product"})
public class ProductDataSourceConfig {
	
	@Bean(name = "productDataSourceProperties")
	@ConfigurationProperties("spring.datasource-product")
	public DataSourceProperties productDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "productDataSource")
	public DataSource productDataSource() {
		return productDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}
	
	@Bean(name = "productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean 
	productEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		HashMap<String, String> properties = new HashMap<>();
		// commenting following line when we are using mysql for product database.
		//properties.put("hibernate.hbm2ddl.auto", "create-drop");
		// able properties can also be added from properties file, but adding it in code.
		return builder.dataSource(productDataSource()).packages(Product.class)
				.persistenceUnit("productDataSource").properties(properties).build();
	}
	
	@Bean(name = "productTransactionManager")
	public PlatformTransactionManager productTransactionmanager(
			@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
	
	// to automatically create and drop table
	

}
