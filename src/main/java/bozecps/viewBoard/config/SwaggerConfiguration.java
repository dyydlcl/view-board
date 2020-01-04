package bozecps.viewBoard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfiguration {
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("bozecps")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("Title")
				.description("Description")
				.termsOfServiceUrl("")
				.contact(new Contact("", "", ""))
				.license("")
				.licenseUrl("")
				.version(" xxx ")
				.build();
	}
}
