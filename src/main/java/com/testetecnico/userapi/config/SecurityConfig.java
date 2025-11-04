package com.testetecnico.userapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Liga a segurança web do Spring
public class SecurityConfig {

    /**
     * Cria um "Bean" (um objeto gerido pelo Spring) do encriptador.
     * Sempre que o Spring precisar de um 'PasswordEncoder', ele usará este.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura as regras de segurança da sua API.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desativa o CSRF (não é necessário para uma API REST stateless)
            .csrf(csrf -> csrf.disable())

            // 2. Define a política de sessão como STATELESS (API não guarda estado)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 3. Define as regras de autorização
            .authorizeHttpRequests(authorize -> authorize
                // Permite acesso público a todos os endpoints em /api/users/
                .requestMatchers("/api/users/**").permitAll()
                
                // Permite acesso à consola H2 (para poder testar a base de dados)
                .requestMatchers("/h2-console/**").permitAll()
                
                // Exige autenticação para qualquer outro pedido (que não exista ainda)
                .anyRequest().authenticated()
            );
            
        // 4. (Importante para a H2 Console) Permite que frames sejam exibidos
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));


        return http.build();
    }
}