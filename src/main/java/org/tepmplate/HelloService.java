package org.tepmplate;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @PreAuthorize("hasRole('USER')")
    public String hello(String name) {
        return "hello " + name;
    }
}
