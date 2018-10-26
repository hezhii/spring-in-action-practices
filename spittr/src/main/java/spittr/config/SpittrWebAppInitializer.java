package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将一个或多个路径映射到 DispatchServlet 上。
     * 这类映射的是 "/"，表示它会是应用的默认 Servlet，它会处理进入应用的所有请求。
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
