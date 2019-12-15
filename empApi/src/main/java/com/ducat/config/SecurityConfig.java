package com.ducat.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter()
	{
		return new JwtAuthenticationFilter();
	}
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	 .authorizeRequests()
        	 	  .antMatchers("/token")
        	 	  		.permitAll()
             	 .anyRequest()
             	 	.authenticated()
             	 		.and()
             .csrf().disable()
             .addFilterBefore(jwtAuthenticationFilter(), 
            		 UsernamePasswordAuthenticationFilter.class);
             
             	 
                
    }

   
    
   

}
