package org.xunmeng;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
// @EnableScheduling
@EnableDiscoveryClient
public class Application {
    // private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        ApplicationContext ctx = app.run(args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.err.println(beanName);
        }
    }

    // 其中 dataSource 框架会自动为我们注入
    // @Bean
    // public PlatformTransactionManager txManager(DataSource dataSource) {
    // System.out.println("=========>" + dataSource);
    // // logger.debug("==========" + dataSource);
    // return new DataSourceTransactionManager(dataSource);
    // }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        System.out.println("=========>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}