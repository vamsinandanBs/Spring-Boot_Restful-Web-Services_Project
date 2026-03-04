package com.vamsi.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/Rest_Service_bean/Path-Variable/{name}")
    public helloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new helloWorldBean(String.format("Hello, Hi Mr. %s ",name));
    }
}
