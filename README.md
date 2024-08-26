# 📝 Projeto de Visualização e Análise de Logs 

## 📈 Visão Geral
Este projeto tem como foco a geração e visualização de logs a partir de uma aplicação Spring Boot. O objetivo principal é identificar e utilizar uma ferramenta de visualização de logs para analisar os logs produzidos pela aplicação. As etapas do projeto incluem:

- Recomendação de ferramentas de visualização de logs.
- Seleção de uma ferramenta específica para análise dos logs.
- Configuração e uso da ferramenta escolhida para visualizar os logs.
- Documentação e relatório do processo e dos resultados.

## 🛠️ Ferramentas de Visualização de Logs Utilizadas
1. Kibana (On-premise)

**Descrição:** Parte do stack ELK (Elasticsearch, Logstash, Kibana), o Kibana oferece recursos poderosos de visualização para interagir e explorar seus dados.

**Capacidades:** Permite busca em tempo real, criação de dashboards interativos, visualização de gráficos, tabelas e mais.

![image](https://github.com/user-attachments/assets/8f4a1ab0-e509-4dfa-8941-69e0678b9bcc)

### ⚙️ Configuração e Visualização

### 👞 Passos para Configuração

**Instalação:** A ferramenta Kibana foi instalada utilizando o pacote ELK, que inclui Elasticsearch e Logstash. A instalação foi realizada seguindo as instruções oficiais.

**Configuração:** Após a instalação, Kibana foi configurada para conectar-se ao Elasticsearch. Os logs da aplicação Spring Boot foram integrados através de um pipeline com Logstash, permitindo que os dados fossem armazenados e indexados no Elasticsearch.

**Visualização**: Os logs foram visualizados utilizando dashboards customizados no Kibana. Gráficos de linha, tabelas dinâmicas e mapas de calor foram criados para fornecer uma visão detalhada e interativa dos dados de log.

![image](https://github.com/user-attachments/assets/a239648a-0187-4c65-b296-9ddb4f57ebfc)

## 📃 Relatório de Visualização de Logs

