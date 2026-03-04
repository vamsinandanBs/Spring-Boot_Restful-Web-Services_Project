package com.vamsi.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path  = "/Rest_Service")
    @GetMapping(path = "/Rest_Service")
    public String helloWorld(){
        return "Hi Checking Web Service";
    }

    @GetMapping(path = "/Rest_Service_bean")
    public helloWorldBean helloWorldBean(){

        return new helloWorldBean("Hi Checking Web Service");
    }

}
