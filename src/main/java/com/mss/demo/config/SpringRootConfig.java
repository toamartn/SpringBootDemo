package com.mss.demo.config;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mss.demo.entities.EmployeeMapping;

@SpringBootConfiguration
@ComponentScan({"com.mss.demo.service"})
// @ComponentScan({"com.mss.demo.dao", "com.mss.demo.service"})
@EnableAutoConfiguration

@EnableJpaRepositories(basePackages = "com.mss.demo.dao")
@EntityScan(basePackages  = {"com.mss.demo.entities"})
@EnableTransactionManagement

public class SpringRootConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "create");
		props.put("hibernate.use_sql_comments", "true");
		props.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		
		lsfb.setHibernateProperties(props);
		 // lsfb.setMappingResources(new String[] { "Withdraw_decl.hbm.xml", "Deposit_decl.hbm.xml" });
		lsfb.setAnnotatedClasses(new Class[] {EmployeeMapping.class});
		return lsfb;
	}
	
	/*@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate hibTemplate() {
		return new HibernateTemplate();
	}*/
	
	
	
	
}
