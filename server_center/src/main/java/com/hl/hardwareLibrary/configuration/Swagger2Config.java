package com.hl.hardwareLibrary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {


//    static List<Parameter> getParameter(){
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
//        pars.add(tokenPar.build());
//        return pars;
//    }





    @Bean
    public Docket createRestApi() {
        //List<Parameter> pars = getParameter();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hl.hardwareLibrary"))
                .paths(PathSelectors.any())
                .build();
                //.globalOperationParameters(pars);
    }

    @Bean
    public Docket createRestApiForcontroller() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.hl.hardwareLibrary.controller"))
                .paths(PathSelectors.any()).build().groupName("接口").pathMapping("/");
    }






    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("deepcore RESTful API")
                .description("展示先做基础功能，后面再添加业务")
//                .termsOfServiceUrl("https://www.ahdeepcore.com")
                .version("1.0")
                .build();
    }

}
