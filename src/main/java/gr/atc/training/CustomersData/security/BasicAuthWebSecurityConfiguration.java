package gr.atc.training.CustomersData.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
public class BasicAuthWebSecurityConfiguration
{
  @Bean
  BasicAuthenticationEntryPoint basicAuthenticationEntryPoint() {
      BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
      entryPoint.setRealmName("CustomersDataBaseService");
      return entryPoint;
  }
  
  @SuppressWarnings({"removal" })
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, BasicAuthenticationEntryPoint authenticationEntryPoint) throws Exception {
    http
    	.csrf().disable()
    	.authorizeHttpRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint);
    return http.build();
  }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User
        .withUsername("user")
        .password(passwordEncoder().encode("password"))
        .roles("ADMIN_ROLE")
        .build();
    return new InMemoryUserDetailsManager(user);
  }

    @Bean
    PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(8);
  }
}