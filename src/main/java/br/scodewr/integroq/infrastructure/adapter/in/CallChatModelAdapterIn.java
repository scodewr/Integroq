package br.scodewr.integroq.infrastructure.adapter.in;

import br.scodewr.integroq.application.ChatClientInteraction;
import br.scodewr.integroq.infrastructure.adapter.dto.ModelReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CallChatModelAdapterIn {

    private final ChatClientInteraction chatClientInteraction;

    @PostMapping("/ai/inference")
    public ResponseEntity<ModelReplyDTO> interact(@RequestBody String prompt){
        var response = chatClientInteraction.interact(prompt);
        return ResponseEntity.ok(new ModelReplyDTO(response));
    }
}
