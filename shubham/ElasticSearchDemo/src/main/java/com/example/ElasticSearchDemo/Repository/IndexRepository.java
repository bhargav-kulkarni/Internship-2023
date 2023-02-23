package com.example.ElasticSearchDemo.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import com.example.ElasticSearchDemo.Entity.Person;

@Repository
@EnableElasticsearchRepositories
public interface IndexRepository extends ElasticsearchRepository<Person,String> {
}

