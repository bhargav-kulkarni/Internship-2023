package com.example.ElasticSearchDemo.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.lilium.elasticsearch.repository"})
@ComponentScan(basePackages ={"com.lilium.elasticsearch"})
public class ElasticConfig extends AbstractElasticsearchConfiguration {



    @Value("${elasticsearch.url}")
    public String elasticSearchUrl;
    @Bean
    @Override
    public org.elasticsearch.client.RestHighLevelClient elasticsearchClient() {
         final ClientConfiguration configuration=ClientConfiguration.builder()
                 .connectedTo(elasticSearchUrl)
                 .build();
         return RestClients.create(configuration).rest();
    }
}
