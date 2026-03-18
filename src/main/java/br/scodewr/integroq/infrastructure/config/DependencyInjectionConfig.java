package br.scodewr.integroq.infrastructure.config;

import br.scodewr.integroq.application.port.ReadFilesPortOut;
import br.scodewr.integroq.application.usecase.ChatClientInteraction;
import br.scodewr.integroq.application.port.ModelPortOut;
import br.scodewr.integroq.application.usecase.ProcessGMUDByChatInteraction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {

    @Bean
    ChatClientInteraction chatClientInteraction(ModelPortOut modelPortOut){
        return new ChatClientInteraction(modelPortOut);
    }

    @Bean
    ProcessGMUDByChatInteraction chatClientInteractionWithTemplate(ReadFilesPortOut readFilesPortOut,
                                                                   ModelPortOut modelPortOut){
        return new ProcessGMUDByChatInteraction(readFilesPortOut, modelPortOut);
    }
}
