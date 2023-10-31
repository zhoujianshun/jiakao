package top.imono.jk.common.cfg;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 使用方法参考https://zhuanlan.zhihu.com/p/638887405
@Configuration
public class SwaggerCfg {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info().title("zjs驾考平台")
                .description("zjs驾考平台api文档")
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
