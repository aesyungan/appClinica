package com.ayungan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	//clase para configurar o proteger recursos
	@Autowired
    private ResourceServerTokenServices tokenServices;
	
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    //configurar urls aqui ponemos los urls q vamos a proteger
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .requestMatchers()
                .and()
                .authorizeRequests()                                
                .antMatchers("/consulta/**" ).authenticated()
                .antMatchers("/consultaExamen/**" ).authenticated()
                .antMatchers("/detalleConsulta/**" ).authenticated()
                .antMatchers("/especialidad/**" ).authenticated()
                .antMatchers("/examen/**" ).authenticated()
                .antMatchers("/medico/**" ).authenticated()
                .antMatchers("/paciente/**" ).authenticated()
                .antMatchers("/usuario/**" ).authenticated();
    }    

}
