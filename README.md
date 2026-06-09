# SatAgro Monitor - Entrega DevOps

Containerização da aplicação Spring Boot com PostgreSQL utilizando Docker e Docker Compose.

## Tecnologias

- Java 17
- Spring Boot 4.0.6
- PostgreSQL 16 (Alpine)
- Docker + Docker Compose

## Estrutura Docker

- **rm556460-app**: Container da aplicação Spring Boot (roda com usuário não-root `spring`)
- **rm556460-db**: Container do PostgreSQL com volume nomeado para persistência
- Ambos os containers estão na mesma rede (`satagro-net`)

## Arquitetura Macro

![Arquitetura Macro da Solução](docs/arquitetura.png)

## Como Executar

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/SEU-USUARIO/satagromonitor.git
cd satagromonitor

# 1.5 (Opcional) Instalar Java 17 no GitHub Codespace
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# 2. Dê permissão ao Maven Wrapper (obrigatório em Linux/Codespace)
chmod +x mvnw

# 3. Compile a aplicação
./mvnw clean package -DskipTests

# 4. Suba os containers
docker compose up --build

A aplicação estará disponível em: http://localhost:8080
```

#Comandos para Verificação:

# Verificar se os containers estão rodando
docker ps

# Acessar o container da aplicação
docker exec -it rm556460-app sh
whoami
pwd
ls -la
exit

# Acessar o container do banco de dados
docker exec -it rm556460-db psql -U postgres -d satagro

# Verificar tabelas e persistência de dados
\dt
SELECT * FROM areas_agricolas;
SELECT * FROM leituras_satelite;
\q

# Listar áreas agrícolas
curl http://localhost:8080/api/areas

# Criar uma área agrícola
curl -X POST http://localhost:8080/api/areas \
  -H "Content-Type: application/json" \
  -d '{
    "nomeFazenda": "Fazenda São João",
    "cultura": "Soja",
    "hectares": 180.5,
    "latitude": -22.315,
    "longitude": -47.892
  }'

# Listar todas as leituras de satélite
curl http://localhost:8080/api/leituras

# Criar uma leitura de satélite
curl -X POST http://localhost:8080/api/leituras \
  -H "Content-Type: application/json" \
  -d '{
    "areaId": 1,
    "ndvi": 0.82,
    "temperaturaSolo": 26.4,
    "umidadeSolo": 58.7,
    "riscoDesastre": "Médio",
    "observacoes": "Monitoramento realizado com sucesso"
  }'
