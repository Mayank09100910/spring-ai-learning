# spring-ai-learning
My daily hands-on learning journey with Spring AI, Java, and OpenRouter.
## Day 2 — Running LLMs Locally with Ollama

### What I Learned
- Installed Ollama on macOS.
- Learned how to download an LLM locally.
- Learned how to run a model using the Ollama CLI.
- Understood the basics of running AI models locally without a cloud API key.

### Commands Practiced
```bash
ollama -v
ollama pull qwen2.5:3b
ollama list
ollama run qwen2.5:3b
```

### Key Takeaway
Ollama allows me to run supported language models locally on my machine without paying per-token API charges. Local execution depends on my system's available resources.

## Day=03
ChatClientApi=>
1 chatclient is like a helper class that makes it super easy to talk to AI models (like gpt-4,gpt-3.5,azure,open Ai)
2 it hides all complex stuff(like writting raw Http requests,handling tokens,parsing JSON)
3 you just call its method like a normal Spring Service and it gives you Ai responses

Key points of chatclient
1 fluent Api (chatclient uses a simple,chain-style api to talk to Ai models ex=>chatClient.prompt("Hello").call())
2 Support different modes (works on both synchronus(normal blocking) and streaming(reactive,real time) ways)
3 prompt building(a prompt =instruction you give to the ai. a prompt is made up of messages)
4 types of messages(1user message->your input(ex=> "write a poem") 2System messages->system rules that guide Ai behaviour
5 Dynamic Placeholders(Prompts can include placeholders(like {name}),which get filled with real values at runtime)
6 Prompt Options( you can set Ai model name,you can adjust temperature->controls creativity/randomness of answer)

## chatModel API
1 represent a specific chat model provider(ex azure,openai)
2 Defines the core contract:given some messages,return model output.
3 Each vendor has its own implementation ex Openaichatmodel
4 we usually donot use chatmodel directly in our business app(inless you need fine-grained control)

## Internal working 
controller<---chatclient<---chatmodel--------LLM
                              |
                            openaichatmodel


How OPen Ai Chat MOdel is created 
We add the Stater 
.org.springframework.ai:spring-ai-stater-model-openai on the classpath
. Spring boot then runs on auto-config
Auto-configuration kicks in
.OpenAiChatAutoConfiguration is loaded (if spring.ai.model.chat=openai,which is the default) It binds your properties and creates a singleton OpenAiChatModel bean for you.

