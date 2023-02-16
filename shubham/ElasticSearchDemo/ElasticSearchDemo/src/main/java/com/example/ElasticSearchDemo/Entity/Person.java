package com.example.ElasticSearchDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.client.erhlc.ReactiveElasticsearchClient;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName =In)
public class Person {


    private  int id;
    public   String name;


}
