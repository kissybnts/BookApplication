package book.application.config

import book.application.service.AuthorityUserDetalisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

/**
 * .
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
open class WebSecurityConfig() : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit private var userDetailsService: AuthorityUserDetalisService

    override fun configure(http: HttpSecurity?) {
        http?: return

        http.authorizeRequests().antMatchers("/css/**").permitAll()
                                .antMatchers("/js/**").permitAll()
                                .antMatchers("/image/**").permitAll()
                                .antMatchers("/signUp").permitAll()
                                .anyRequest().authenticated()

        http.formLogin().loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/main")
                        .usernameParameter("loginId")
                        .passwordParameter("password")
                        .failureUrl("/login?error")
                        .permitAll()

        http.logout().logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                     .logoutSuccessUrl("/login")
                     .deleteCookies("JSESSIONID")
                     .invalidateHttpSession(true)
                     .permitAll()
    }

    @Autowired
    fun configAuthentication(auth: AuthenticationManagerBuilder) {
        // BCryptでハッシュ化した値でパスワード認証を行う
        auth.userDetailsService(userDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }
}