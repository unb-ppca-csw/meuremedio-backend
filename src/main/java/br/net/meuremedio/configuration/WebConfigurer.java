package br.net.meuremedio.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {
	private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

	private final Environment env;

	public WebConfigurer(Environment env) {
		this.env = env;
	}

//	/**
//	 * This bean is only needed when running with embedded Tomcat.
//	 */
//	@Bean
//	// @ConditionalOnMissingBean(NonEmbeddedServletContainerFactory.class)
//	public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(getHttpConnector());
//		tomcat.addContextCustomizers(new TomcatContextCustomizer() {
//			@Override
//			public void customize(Context context) {
//				// add configuration from web.xml
//				context.addWelcomeFile("index.xhtml");
//
//				// register additional mime-types that Spring Boot doesn't register
//				context.addMimeMapping("eot", "application/vnd.ms-fontobject");
//				context.addMimeMapping("ttf", "application/x-font-ttf");
//				context.addMimeMapping("woff", "application/x-font-woff");
//			}
//
//		});
//
//		return tomcat;
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		log.debug("Configurando CORS ...");
		registry.addMapping("/**");
	}
	
//	private Connector getHttpConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}

}
