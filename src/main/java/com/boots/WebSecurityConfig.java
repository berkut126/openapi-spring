package com.boots;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.ReferrerPolicyServerHttpHeadersWriter.ReferrerPolicy;

@Order
public class WebSecurityConfig extends
WebSecurityConfigurerAdapter {

@Override
protected void configure(HttpSecurity http) throws Exception {
	http
	.headers()
		.httpStrictTransportSecurity()
			.includeSubDomains(true)
			.maxAgeInSeconds(31536000)
			.and()
		.contentSecurityPolicy("default-src 'self'; script-src 'self' cdnjs.cloudflare.com; style-src 'self' 'unsafe-inline' cdnjs.cloudflare.com")
			.and()
      .xssProtection().and()
      .frameOptions()
			.sameOrigin();
}


@Bean
SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http
        .headers()
            .referrerPolicy(ReferrerPolicy.STRICT_ORIGIN);
    return http.build();
}
}