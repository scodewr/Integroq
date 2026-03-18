package br.scodewr.integroq.application.port;

public interface ModelPortOut {
    String interact(String prompt);
    String interactionWithTemplate(String prompt, String template);
}
