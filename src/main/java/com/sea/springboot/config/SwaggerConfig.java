package com.sea.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * http://localhost:8080/swagger-ui/
 * http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sea.springboot.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot整合Swagger3")
                        .description("API 描述")
                        .version("1.0")
                        .contact(new Contact("大海","https://github.com/seasharpgit","18912387311@163.com"))
                        .license("The Apache License")
                        .licenseUrl("https://github.com/seasharpgit")
                        .build());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBoot整合Swagger3")
                //创建人
                .contact(new Contact("大海", "https://github.com/seasharpgit/", "18912387311@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }


}
