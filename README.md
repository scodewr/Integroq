# Integroq

Integração com a API Groq para interagir com modelos de linguagem abertos.

## ? Descrição

Aplicação Spring Boot que fornece uma API REST para interagir com modelos de IA através do Spring AI e Groq API.

## ?? Tecnologias

- Java 25
- Spring Boot 4.0.2
- Spring AI 2.0.0-M2
- Maven
- Lombok

## ? Estrutura do Projeto

```
src/main/java/br/scodewr/integroq/
??? application/
?   ??? ChatClientInteraction.java      # Application Service
?   ??? port/
?       ??? ModelPortOut.java           # Interface da porta de saída
??? infrastructure/
?   ??? adapter/
?   ?   ??? in/
?   ?   ?   ??? CallChatModelAdapterIn.java   # REST Controller
?   ?   ??? dto/
?   ?   ?   ??? ModelReplyDTO.java     # DTO de resposta
?   ?   ??? out/
?   ?       ??? OpenAiChatModelAdapterOut.java # Implementação da porta
?   ??? config/
?       ??? DependencyInjectionConfig.java     # Configuração de DI
```

## ? Como Usar

### Pré-requisitos

- Java 25+
- Maven 3.8+
- Chave da API Groq/OpenAI configurada

### Instalação

```bash
mvn clean install
```

### Executar a Aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080)

## ? Endpoints

### POST /ai/inference

Realiza uma inferência com o modelo de IA.

**Request:**

```bash
curl -X POST http://localhost:8080/ai/inference \
  -H "Content-Type: application/json" \
  -d "Qual é a capital da França?"
```

**Response:**

```json
{
  "response": "A capital da França é Paris."
}
```

## ?? Arquitetura

O projeto segue Domain-Driven Design (DDD) com:

- **Application Layer**: Lógica de negócio agnóstica a frameworks (`ChatClientInteraction`)
- **Adapter Pattern**: Adapta requisições HTTP e chamadas externas
- **Ports & Adapters**: `ModelPortOut` define contrato; `OpenAiChatModelAdapterOut` implementa
- **Dependency Injection**: Configurado em `DependencyInjectionConfig`

## ?? Configuração

Configure as credenciais da API no `application.yml`:

```yaml
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
      base-url: ${OPENAI_BASE_URL}
```
