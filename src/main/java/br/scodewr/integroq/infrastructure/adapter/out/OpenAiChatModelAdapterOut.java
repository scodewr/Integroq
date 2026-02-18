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

        var chatClient = this.chatClientBuilder.build();

        var response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        log.info("Resposta do modelo: {}", response);

        return response;
    }
}
