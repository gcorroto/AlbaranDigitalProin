//package com.proin.albaran.configuration.database;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@EnableJpaRepositories(basePackages = {"com.proin.albaran.repository"})
//public class DataSourceConfiguration {
//	
//	   @Bean
//	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	      em.setDataSource(dataSource());
//	      em.setPersistenceXmlLocation("classpath:persistence.xml");
//	      
//	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	      em.setJpaVendorAdapter(vendorAdapter);
//	      
//	      return em;
//	   }
//	   
//	   @Bean
//	   public DataSource dataSource(){
//	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	       dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	       dataSource.setUrl("jdbc:sqlserver://85.215.195.246:1433;databaseName=conex.modelos.transporte;encrypt=false;trustServerCertificate=false");
//	       dataSource.setUsername("albarandigital");
//	       dataSource.setPassword("BXZgi6QipRzfSg725QVQwT");
//	       return dataSource;
//	   }
//	   
//	   @Bean
//	   public PlatformTransactionManager transactionManager() {
//	       JpaTransactionManager transactionManager = new JpaTransactionManager();
//	       transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//	       return transactionManager;
//	   }
//
//	   @Bean
//	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//	       return new PersistenceExceptionTranslationPostProcessor();
//	   }
//
//	   Properties additionalProperties() {
//	       Properties properties = new Properties();
//	       return properties;
//	   }
//}
