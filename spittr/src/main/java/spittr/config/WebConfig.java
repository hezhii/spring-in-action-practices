package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // 启用 Spring MVC
@ComponentScan("spittr.web") // 启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); // 配置 JSP 视图解析器
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true); // 应用程序上下文中的所有 bean 可以通过请求属性访问
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        /*
         * 配置静态资源的处理
         *
         * 要求 DispatchServlet 将对静态资源的请求转发到 Servlet 容器中默认的 Servlet 中，
         * 而不是 DispatchServlet 本身来处理此类请求。
         */
        configurer.enable();
    }
}
