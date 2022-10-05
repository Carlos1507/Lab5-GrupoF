package com.pucp.lab5gtics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfiguracionSpringSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin();

        http.authorizeRequests()

                .antMatchers("/empleado/buscar").authenticated().hasAnyAuthority("admin","employee")
                .antMatchers("/empleado/guardar").authenticated().hasAnyAuthority("admin")
                .antMatchers("/empleado/editar").authenticated().hasAnyAuthority("admin")
                .antMatchers("/personaje/nuevo").authenticated().hasAnyAuthority("admin")
                .antMatchers("/empleado/lista").authenticated()

                .anyRequest().permitAll();
        ;

    }

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)

                .usersByUsernameQuery("select email, password, enabled FROM usuario WHERE email = ?")

    }

}