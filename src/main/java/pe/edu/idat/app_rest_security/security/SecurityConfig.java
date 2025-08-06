package pe.edu.idat.app_rest_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.idat.app_rest_security.services.DetalleUsuarioService;



@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers(
                                                "api/v1/home/public")
                                        .permitAll()
                                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return  http.build();

    }

    @Bean
    public DaoAuthenticationProvider authProvider(
            DetalleUsuarioService detalleUsuarioService){
        DaoAuthenticationProvider daoProvider =
                new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(detalleUsuarioService);
        daoProvider.setPasswordEncoder(passwordEncoder());
        return daoProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
