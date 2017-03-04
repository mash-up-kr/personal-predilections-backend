package kr.co.mash_up.config;

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

@Configuration
@EnableSwagger2  // /swagger-ui.html 로 접속
public class SwaggerConfig {

    @Bean
    public Docket newApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("kr.co.mash-up.personal-predilections")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())  // 현재 RequestMapping으로 할당된 모든 url 리스트 추출
                .paths(PathSelectors.ant("/api/**"))  // '/api'로 시작하는 것만 문서화
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("개인의 취향")
                .description("Mash-Up 3기(2017-1) Hackthon")
                .termsOfServiceUrl("https://github.com/mash-up-kr/personal-predilections-backend")
                .contact(new Contact("opklnm102", "https://github.com/opklnm102", "opklnm102@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("2.0")
                .build();
    }
}
