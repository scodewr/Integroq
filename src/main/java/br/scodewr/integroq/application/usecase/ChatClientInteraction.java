package br.scodewr.integroq.application.usecase;

import br.scodewr.integroq.application.port.ModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class ChatClientInteraction {

    private final ModelPortOut modelPortOut;

    public String interact(String prompt){
        return modelPortOut.interact(prompt);
    }

}
