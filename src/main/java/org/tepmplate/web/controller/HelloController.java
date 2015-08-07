package org.tepmplate.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/{name}")
    public Greeter getCart(@PathVariable("name") String name) {
        return new Greeter(name);
    }

    public static class Greeter {
        public String hello;

        public Greeter(String hello) {
            this.hello = hello;
        }
    }
}
