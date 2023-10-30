package kr.co.ihab.speechear.api.component;

import kr.co.ihab.speechear.api.enums.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Order(0)
@Log4j2
public class SecurityConfiguration {
    private final UserDetailsService userDetailsService;
    private final JwtTokenComponent jwtTokenComponent;

//    private final AuthenticationSuccessHandler authenticationSuccessHandler;
//    private final AuthenticationFailureHandler authenticationFailureHandler;

    @Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/favicon.ico",
                "/resources/**",
                "/error",
                "/css/**",
                "/js/**",
                "/img/**",
                "/font/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
//        configuration.setAllowedOrigins(List.of("http://localhost:8088"));
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(HttpBasicConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors((cors) -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/actuator/**", "/swagger-ui/**", "/api-docs/swagger-config").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/","/login","/signUp").permitAll()
                        // USER, MANAGER, ADMIN
                        .requestMatchers("/function/**","/home/**").hasAnyRole(UserRole.USER.toString(), UserRole.MANAGER.toString(), UserRole.SYSTEM.toString())
                        // MANAGER, ADMIN
                        .requestMatchers("/system/**").hasAnyRole(UserRole.MANAGER.toString(),UserRole.SYSTEM.toString())
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                        .anyRequest().authenticated()
                        .anyRequest().permitAll()
                );
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenComponent), UsernamePasswordAuthenticationFilter.class);

//        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    /*
    //        http
//            .authorizeHttpRequests()
//                .antMatchers("/","/login","/signUp").permitAll() // 누구나 접근 허용
//                //나중에 user권한 관련 부분 추가
//                .antMatchers("/function/**","/home/**").hasAnyRole(UserRole.USER.toString(),UserRole.MANAGER.toString(),UserRole.SYSTEM.toString()) // USER, MANAGER, ADMIN만 접근 가능
//                .antMatchers("/system/**").hasAnyRole(UserRole.MANAGER.toString(),UserRole.SYSTEM.toString()) // MANAGER, ADMIN만 접근 가능
//                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
//                .and()
//            .csrf()
//                .ignoringAntMatchers("/function/**")
//                .ignoringAntMatchers("/system/**")
//                .ignoringAntMatchers("/home/**")
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/loginFormData")
//                .failureHandler(authenticationFailureHandler)
//                .successHandler(authenticationSuccessHandler)
////                .defaultSuccessUrl("/home/FunctionSelect",true) // 로그인 성공 후 리다이렉트 주소
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
//                .invalidateHttpSession(true) // 세션 날리기
//                .clearAuthentication(true)
//                .and()
//            .exceptionHandling()
//                .accessDeniedPage("/AccessDenied")
//                .and()
//            .sessionManagement()
//                .maximumSessions(1) //최대 세션 개수지정
//                .maxSessionsPreventsLogin(false) //false 일경우 먼저 접속한 사용자 LogOut 처리
//                .expiredUrl("/login?expire=true"); // 만료시 이동 페이지
     */
}
