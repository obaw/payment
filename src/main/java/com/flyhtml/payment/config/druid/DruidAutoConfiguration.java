package com.flyhtml.payment.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author xiaowei
 * @time 17-4-6 下午3:09
 * @describe DataSource配置
 */
@Configuration
public class DruidAutoConfiguration {

    @ConfigurationProperties(prefix = "datasource.druid")
    @Bean(name = "datasource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
