package br.scodewr.integroq.infrastructure.config;

import br.scodewr.integroq.application.ChatClientInteraction;
import br.scodewr.integroq.application.port.ModelPortOut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {

    @Bean ChatClientInteraction chatClientInteraction(ModelPortOut portOut){
        return new ChatClientInteraction(portOut);
    }
}
