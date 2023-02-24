package com.example.ElasticSearchDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.example.ElasticSearchDemo.helper.Indics;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = Indics.PERSON_INDEX)
public class Person {


    @Id
    @Field(type = FieldType.Keyword)
    private  int id;
    @Field(type = FieldType.Text)
    public   String name;

}
