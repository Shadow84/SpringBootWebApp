package com.khomenko.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*
Настройка БД
http://localhost:8080/console/

По  API (MVC)
Сделал несколько страничек для CRUD операций,  стартуют вместе с spring boot
http://localhost:8080/                            -  home
http://localhost:8080/products                -  get all
http://localhost:8080/product/{id}             - get one
http://localhost:8080/product/edit/{1}       - edit one
http://localhost:8080/product/delete/{1}    - delete one

По REST API
Сделал  отдельный контроллер,  тестил SOAP UI
http://localhost:8080/rest/products           GET      - get all
http://localhost:8080/rest/product/{id}       GET      - get one
http://localhost:8080/rest/product/{id}       POST    - edit one
http://localhost:8080/rest/product            PUT       - add one
http://localhost:8080/rest/product/{id}      DELETE  -delete one
*
* */

@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
