package com.jaggi.tickit.config;

import com.jaggi.tickit.filters.UserProvisioningFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            UserProvisioningFilter userProvisioningFilter,
            JwtAuthenticationConverter jwtAuthenticationConverter) throws Exception {
        //lambda function -: params -> operation(on params)
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(HttpMethod.GET, "/api/v1/published-events/**").permitAll() //no auth required
                                .requestMatchers("/api/v1/events").hasRole("ORGANIZER") //no auth for organizer role
                                // Catch all rule
                                .anyRequest().authenticated()) //all other reqs must be authenticated
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //expects Authorizaton: Bearer <some token type shit> it authenticate that and extracts claim in jwt object
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)
                        ))
                .addFilterAfter(userProvisioningFilter, BearerTokenAuthenticationFilter.class);
        //1. Bearer Token extract from header
        //2. user provisioning filter apply
        //3. csrf check skip
        //4. make server stateless
        //5. auth checks -> if get req on /api/v1/published-events no auth needed, if ORGANISER on /api/v1/events no auht otherwise authenticatino needed

        return http.build();
    }

}

