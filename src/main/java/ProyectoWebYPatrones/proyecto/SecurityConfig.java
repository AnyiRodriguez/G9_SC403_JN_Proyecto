package ProyectoWebYPatrones.proyecto;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN")
                .and()
                .withUser("empleado")
                    .password("{noop}123")
                        .roles("EMPLEADO")
                .and()
                .withUser("user")
                        .password("{noop}123")
                .roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/empleados/nuevo", "/empleados/guardar",
                        "/empleados/modificar/**", "/empleados/eliminar/**", 
                        "/facturacion/nuevo", "/facturacion/eliminar/**","/menu/nuevo", 
                        "/menu/modificar/**", "/menu/eliminar/**", "/menu/guardar", 
                        "/finanzas/ver", "/finanzas/corte", "/finanxas/guardar",
                        "/finanzas/eliminar/**", "/menu/tabla",
                        "/platillos/nuevo", "/platillos/guardar", "/platillos/ver", 
                        "/platillos/modificar/**", "/platillos/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/orden/nuevo", "/orden/ver", "/orden/guardar", "/orden/modificar/**", 
                        "/reservacion/nuevo", "/reservacion/ver", "/reservacion/guardar", 
                        "/reservacion/modificar/**")
                .hasRole("USER")
                .antMatchers("/", "/menu/ver", "/reservacion/buscar", "/orden/buscar")
                .hasAnyRole("USER", "ADMIN", "EMPLEADO")
                .antMatchers("/reservacion/eliminar/**", "/orden/eliminar/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/reservacion/todo", "/orden/todo", "/facturacion/ver",
                        "/empleados/ver", "/facturacion/modificar/**", "/facturacion/guardar",
                        "/facturacion/nuevo", "/empleados/buscar/**", "/empleados/resultado",
                        "/facturacion/buscar/**", "/facturacion/resultado")
                .hasAnyRole("ADMIN", "EMPLEADO")
                .and()
                    .formLogin()
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
