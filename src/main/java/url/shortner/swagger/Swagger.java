package url.shortner.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openApi() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info().title("Open Api Documents").description("by suman"))
                .servers(List.of(new Server().url("https://localhost:8080").description("local host")))
                .tags(Arrays.asList(new Tag().name("LoginDetails"), new Tag().name("RedirectUrl"), new Tag().name("controlers")));


    }
}