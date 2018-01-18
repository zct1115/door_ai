package com.zct.door_ai;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DoorAiApplication extends WebMvcConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(DoorAiApplication.class, args);
    }


    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Autowired DruidDataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }


    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     * 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


    /**
     * 阿里巴巴的数据连接池
     *
     * @return
     */
    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/aidoor?useUnicode=true&characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("123456");

        ds.setInitialSize(0);
        ds.setMaxActive(20);
        ds.setMinIdle(0);
        ds.setMaxWait(10000);

        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        ds.setTestWhileIdle(true);

        ds.setTimeBetweenEvictionRunsMillis(60000);
        ds.setMinEvictableIdleTimeMillis(25200000);

        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(1800);
        ds.setLogAbandoned(true);
        return ds;
    }

    /**
     * 跨域CORS配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }


}
