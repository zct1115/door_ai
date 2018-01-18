package com.zct.door_ai;

import org.apache.catalina.filters.RemoteAddrFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author zct11
 * 过滤器
 */
@Configuration
public class WebConfiguration {

    /**
     * 将代理服务器发来的请求包含的IP地址转换成真正的用户IP
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }


    /**
     * 中文字符串过滤器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding("utf-8");
        filter.setForceRequestEncoding(true);
        filter.setForceResponseEncoding(true);
        return filter;
    }

}
