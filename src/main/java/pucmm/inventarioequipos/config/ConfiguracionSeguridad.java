//package pucmm.inventarioequipos.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import pucmm.inventarioequipos.service.UsuarioServiceImpl;
//
//import javax.sql.DataSource;
//
//@Configurable
//@EnableGlobalMethodSecurity(securedEnabled = false)
//public class ConfiguracionSeguridad  {
//
//
//    //Opción JPA
//    @Autowired
//    private UsuarioServiceImpl usuarioService;
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/","/css/**", "/js/**","/static/**").permitAll() //permitiendo llamadas a esas urls.
//                .antMatchers("/usuarios/**","/agregarUsuario/**").hasAnyRole("ADMIN")
//                .antMatchers("/Users/**").hasAnyRole("ADMIN")
//                .antMatchers("/h2/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//        http.headers().frameOptions().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //Cargando los usuarios en memoria.
////        auth.userDetailsService(inMemoryUserDetailsManager());
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("usuario")
//                .password("1234")
//                .roles("USER");
//    }
//
//        //deshabilitando las seguridad contra los frame internos.
//        //Necesario para H2.
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
//}
