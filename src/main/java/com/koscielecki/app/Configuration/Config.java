package com.koscielecki.app.Configuration;

import com.koscielecki.app.Converter.LocalDateConverter;
import com.koscielecki.app.Converter.LocalDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(localDateConverter());
        registry.addConverter(localDateTimeConverter());

    }

    @Bean
    public LocalDateConverter localDateConverter(){
        return new LocalDateConverter();
    }

    @Bean
    public LocalDateTimeConverter localDateTimeConverter(){
        return new LocalDateTimeConverter();
    }

}
