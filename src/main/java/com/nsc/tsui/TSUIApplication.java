package com.nsc.tsui;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.AdminServlet;
import com.nsc.tsui.config.CacheConfig;
import com.nsc.tsui.config.HttpClientConfig;
import com.nsc.tsui.config.SecurityConfig;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

@Import({CacheConfig.class, HttpClientConfig.class})//, SecurityConfig.class})
@EnableMetrics(proxyTargetClass = true)
@PropertySource({"classpath:nsc-external.properties"})
@SpringBootApplication
public class TSUIApplication extends MetricsConfigurerAdapter {

	@Override
	public void configureReporters(MetricRegistry metricRegistry) {
		// registerReporter allows the MetricsConfigurerAdapter to
		// shut down the reporter when the Spring context is closed
		registerReporter(Slf4jReporter
				.forRegistry(metricRegistry)
				.build())
				.start(1, TimeUnit.MINUTES);

	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new AdminServlet(),"/metrics/admin/*");
	}

	@Bean
	public HealthCheckRegistry newHealthCheckRegistry() {
		return new HealthCheckRegistry();
	}

	public static void main(String[] args) {
		SpringApplication.run(TSUIApplication.class, args);
	}
}
