package admin.config;

import admin.service.HRRepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/test").hasAuthority("HR_USER")
                .antMatchers("/employee/*").hasAuthority("HR_USER")
                .antMatchers("/employee/*/*").hasAuthority("HR_USER")
                .antMatchers("/employee/*/*/*").hasAuthority("HR_USER")
                .antMatchers("/hr/*").hasAuthority("Admin_USER")
                .antMatchers("/corporation").hasAuthority("Admin_USER")
                .antMatchers("/").permitAll()
        .and().formLogin().loginPage("/").defaultSuccessUrl("/test",true)
        .and().logout().logoutSuccessUrl("/");

        http.headers().frameOptions().disable();    //允许分页
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
