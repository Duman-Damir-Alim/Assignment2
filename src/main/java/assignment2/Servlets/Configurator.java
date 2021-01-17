package assignment2.Servlets;


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Configurator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        FilterRegistration.Dynamic registration = context.addFilter("Auth", new AuthFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null,false, "/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
