package com.firstSpring.restApiTutorial.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import com.firstSpring.restApiTutorial.DB;
import com.firstSpring.restApiTutorial.DevDB;
import com.firstSpring.restApiTutorial.ProdDB;
@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty( name = "project.mode", havingValue =  "Development")
    public DB getDevDataBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty( name = "project.mode", havingValue =  "production")
    public DB getProdDataBean(){
        return new ProdDB();
    }
    @Bean
    public ModelMapper  getModelMapper(){
        return new ModelMapper();
    }
}
