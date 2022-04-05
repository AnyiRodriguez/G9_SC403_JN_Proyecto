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
                    .roles("ADMIN", "EMPLEADO", "USER")
                .and()
                .withUser("empleado")
                    .password("{noop}123")
                        .roles("EMPLEADO", "USER")
                .and()
                .withUser("user")
                        .password("{noop}123")
                .roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/empleados/nuevo", "/empleados/ver", "/empleados/guardar",
                        "/empleados/modificar/**", "/empleados/eliminar/**", 
                        "/factura/nuevo", "/factura/guardar", "/factura/ver", 
                        "/factura/modificar/**", "/factura/eliminar/**", 
                        "/menu/nuevo", "/menu/ver", "/menu/tabla", 
                        "/menu/modificar/**", "/menu/eliminar/**", "/menu/guardar", 
                        "/orden/todo", "/orden/eliminar/**", 
                        "/reservacion/todo", "/reservacion/eliminar/**",
                        "/finanzas/ver", "/finanzas/corte", "/finanxas/guardar",
                        "/finanzas/eliminar/**",
                        "/platillos/nuevo", "/platillos/guardar", "/platillos/ver", 
                        "/platillos/modificar/**", "/platillos/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/empleados/ver", 
                        "/factura/nuevo", "/factura/guardar", "/factura/ver", 
                        "/factura/modificar/**", "/factura/eliminar/**", 
                        "/menu/tabla", "/menu/ver", 
                        "/orden/todo", "/reservacion/todo")
                .hasRole("EMPLEADO")
                .antMatchers("/orden/nuevo", "/orden/ver", "/orden/guardar", 
                        "/orden/buscar", "/orden/modificar/**", "/orden/eliminar/**", 
                        "/reservacion/nuevo", "/reservacion/ver", "/reservacion/guardar", 
                        "/reservacion/buscar", "/reservacion/modificar/**", "/reservacion/eliminar/**", 
                         "/menu/ver")
                .hasRole("USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
