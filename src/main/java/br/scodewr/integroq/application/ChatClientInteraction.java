package br.scodewr.integroq.application;

import br.scodewr.integroq.application.port.ModelPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class ChatClientInteraction {

    private final ModelPortOut portOut;

    public String interact(String prompt){
        log.info("Iniciando interação com modelo");
        var response = portOut.interact(prompt);
        log.info("Interação realizada");
        return response;
    }

}
