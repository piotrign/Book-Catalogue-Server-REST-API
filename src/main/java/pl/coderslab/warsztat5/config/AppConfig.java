package pl.coderslab.warsztat5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages	= "pl.coderslab.warsztat5.exercises")
public class AppConfig extends	WebMvcConfigurerAdapter	{
}
