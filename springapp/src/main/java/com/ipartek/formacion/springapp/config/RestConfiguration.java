package com.ipartek.formacion.springapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		var classes = entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new);
		config.exposeIdsFor(classes);
	}
}