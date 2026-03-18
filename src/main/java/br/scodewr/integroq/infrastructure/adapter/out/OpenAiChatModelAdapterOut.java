package br.scodewr.integroq.infrastructure.adapter.out;

import br.scodewr.integroq.application.port.ModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class OpenAiChatModelAdapterOut implements ModelPortOut {

    private final ChatClient.Builder chatClientBuilder;

    @Override
    public String interact(String prompt) {
        log.info("Iniciando interação com modelo");
        var chatClient = this.chatClientBuilder.build();

        var response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        log.info("Resposta do modelo: {}", response);
        log.info("Interação realizada");
        return response;
    }

    @Override
    public String interactionWithTemplate(String prompt, String template) {
        log.info("Iniciando interação com modelo utilizando template");
        var chatClient = this.chatClientBuilder.build();

        var response = chatClient.prompt()
                .user(prompt)
                .tools() // functions to feed the model
                .call()
                .content();

        log.info("Resposta do modelo: {}", response);
        log.info("Interação realizada");

        return response;
    }
}
