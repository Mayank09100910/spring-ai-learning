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