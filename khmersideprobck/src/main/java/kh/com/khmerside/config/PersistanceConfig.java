package kh.com.khmerside.config;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import kh.com.khmerside.khmersideprocomm.crypto.assyncronous.KhmerSideRsaCipher;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "kh.com.khmerside.auditws.model"})
@PropertySource({ "classpath:persistence-${persistenceTarget:dev}.properties" })
public class PersistanceConfig {
	@Autowired
    public Environment env;

	@Autowired
	public KhmerSideRsaCipher khmerSideRsaCipher;
	
    public PersistanceConfig() {
        super();
    }

    @Bean(destroyMethod="close")
    public DataSource getKhmersideBckDataSource() throws IOException, GeneralSecurityException {
    	
    	/* Datasource Configuration */
    	HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/localdb");
        config.setUsername("postgres");
        config.setPassword("123");        
        config.setConnectionTimeout(Integer.parseInt(env.getProperty("hikariCp.connectionTimeout")));
        config.setIdleTimeout(Integer.parseInt(env.getProperty("hikariCp.idleTimeout")));
        config.setMaxLifetime(Integer.parseInt(env.getProperty("hikariCp.maxLifetime")));
        config.setMaximumPoolSize(Integer.parseInt(env.getProperty("hikariCp.maximumPoolSize")));
        config.setValidationTimeout(Integer.parseInt(env.getProperty("hikariCp.validationTimeout")));
        config.setLeakDetectionThreshold(Integer.parseInt(env.getProperty("hikariCp.leakDetectionThreshold")));
        config.setPoolName(env.getProperty("hikariCp.poolName"));
                
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        final HikariDataSource  khmersideAuthBckDataSource = new HikariDataSource(config);
        return khmersideAuthBckDataSource;
    }
    
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws IOException, GeneralSecurityException{
    	return new NamedParameterJdbcTemplate(getKhmersideBckDataSource());
    }
    
    @Bean
	public JdbcTemplate jdbcTemplate() throws IOException, GeneralSecurityException {
		return new JdbcTemplate(getKhmersideBckDataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws IOException, GeneralSecurityException{
		return new DataSourceTransactionManager(getKhmersideBckDataSource());
	}
}
