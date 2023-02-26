//package numble.bankingserver.security;
//
//import numble.bankingserver.global.jwt.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
//
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .httpBasic().disable()
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler)
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/questions/manage", "/api/questions/user-page", "/api/answers/manage", "/api/answers/user-page", "/api/comments/manage", "/api/comments/user-page", "/api/users/profiles/:nickname").authenticated()
//                .antMatchers(HttpMethod.POST, "api/auth","/api/questions/**", "/api/answers/**", "/api/comments/**").authenticated()
//                .antMatchers(HttpMethod.DELETE, "/api/questions/**", "/api/answers/**", "/api/comments/**").authenticated()
//                .antMatchers(HttpMethod.PUT, "/api/questions/**", "/api/answers/**", "/api/comments/**", "/api/users/profiles").authenticated()
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//        // JwtAuthenticationFilter를 UsernamePasswordAuthentictaionFilter 전에 적용시킨다.
//    }
//
//    // 암호화에 필요한 PasswordEncoder Bean 등록
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
