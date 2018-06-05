package kh.com.khmerside.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import kh.com.khmerside.config.PersistanceConfig;
import kh.com.khmerside.config.ServiceConfig;
import kh.com.khmerside.config.ServletConfig;
import kh.com.khmerside.config.WebConfig;
import kh.com.khmerside.init.ContextInitializer;

@SpringBootApplication
public class BackEndApp extends SpringBootServletInitializer {
	private final static Object[] CONFIGS = { // @formatter:off
			ServiceConfig.class,
			ServletConfig.class,
            PersistanceConfig.class,
            WebConfig.class,
            BackEndApp.class
            
    }; // // @formatter:on

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(CONFIGS).initializers(new ContextInitializer());
	}

	public static void main(final String... args) {
        final SpringApplication springApplication = new SpringApplication(CONFIGS);
        springApplication.addInitializers(new ContextInitializer());
        springApplication.run(args);
    }
}
