package com.example.SwaggerApiDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDao {



    private  int id;
    private  String name;
    private  int phoneno;
    private  String  Address;
}
