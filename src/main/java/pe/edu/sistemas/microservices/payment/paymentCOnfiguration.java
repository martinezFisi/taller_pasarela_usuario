package taller.pasarela.microservices.payment;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@ComponentScan
@EntityScan("taller.pasarela.microservices.payment")
@EnableJpaRepositories("taller.pasarela.microservices.payment")
@PropertySource("classpath:db-config.properties")
public class paymentCOnfiguration {

	protected Logger logger;

	public paymentCOnfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		logger.info("dataSource = " + dataSource);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> payments = jdbcTemplate.queryForList("SELECT id_concepto FROM CONCEPTO");
		logger.info("System has " + payments.size() + " payments");

		

		return dataSource;
	}
}