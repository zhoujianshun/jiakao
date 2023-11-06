package top.imono.jk.common.cfg;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
// 使用方法参考https://zhuanlan.zhihu.com/p/638887405
//                .components(new Components().addSecuritySchemes("authScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).bearerFormat("JWT").scheme("bearer")))

@SecurityScheme(name = "authScheme", type = SecuritySchemeType.HTTP, scheme ="bearer", in = SecuritySchemeIn.HEADER)
@Configuration
public class SwaggerCfg {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("authScheme"))
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .title("驾考平台api")
                .description("驾考平台api文档")
                .version("v1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));
//                .externalDocs(new ExternalDocumentation()
//                        .description("外部文档")
//                        .url("https://springshop.wiki.github.org/docs")

    }

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder().group("Public").pathsToMatch("/**").build();
    }
    @Bean
    public GroupedOpenApi dictTypeApi(){
        return GroupedOpenApi.builder().group("DictType").pathsToMatch("/dictTypes/**").build();
    }
    @Bean
    public GroupedOpenApi dictItemApi(){
        return GroupedOpenApi.builder().group("DictItem").pathsToMatch("/dictItems/**").build();
    }
}
