package com.example.LogViewer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {


    @Autowired
    TestRestTemplate restTemplate;



    @Test
    public void getApiCalls()
    {
        ResponseEntity<String> responseEntity=restTemplate.exchange("http://localhost:8182/api/dockerimages",HttpMethod.GET,null,String.class);
        Assert.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }


}
