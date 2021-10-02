package com.lushidea.evetools.controller.demo;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {
    @GetMapping(path = "/echo")
    public String echo(@Param("name") String name) {
        return String.format("Hello %s", name);
    }
}
