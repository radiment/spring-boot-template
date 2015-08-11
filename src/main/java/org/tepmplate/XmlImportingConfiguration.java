package org.tepmplate;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:myApp.xml")
@EnableGlobalMethodSecurity
public class XmlImportingConfiguration {

}
