package user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import user.controller.UserController;
import user.conveter.UserConverter;
import user.exception.handler.UserExceptionHandler;
import user.repository.UserRepository;
import user.service.UserService;

@EnableWebMvc
@ComponentScan(
    basePackageClasses = {
      UserController.class,
      UserService.class,
      UserRepository.class,
      UserConverter.class,
      UserExceptionHandler.class
    })
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/views/");
  }

  @Bean
  public InternalResourceViewResolver setupViewResolver() {
    final InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }
}
