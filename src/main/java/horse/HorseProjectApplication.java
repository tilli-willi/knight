package horse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HorseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HorseProjectApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean horseServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new HorseRidingServlet(), "/horse/servlet/count");
        bean.setLoadOnStartup(1);
        return bean;
    }

}
