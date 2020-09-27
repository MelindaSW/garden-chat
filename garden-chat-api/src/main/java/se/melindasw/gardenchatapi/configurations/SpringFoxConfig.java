package se.melindasw.gardenchatapi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }
}
// import com.google.common.base.Predicate;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import springfox.documentation.RequestHandler;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.Contact;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
// import java.time.LocalTime;
//
// @Configuration
// @EnableSwagger2
// public class SwaggerConfig {
//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .directModelSubstitute(LocalTime.class, String.class)
//        .select()
//        .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
//        .paths((Predicate<String>) PathSelectors.any())
//        .build()
//        .apiInfo(apiEndPointsInfo());
//  }
//
//  private ApiInfo apiEndPointsInfo() {
//    return new ApiInfoBuilder()
//        .title("garden-chat-api")
//        .description("Saves and returns messages from the chat")
//        .contact(new Contact("By:Melinda Sandström-Wagner", "", ""))
//        .version("0.0.1")
//        .build();
//  }
// }
