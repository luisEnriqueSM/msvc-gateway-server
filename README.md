# msvc-gateway-server

# Comandos Docker para levantar el contenedor de msvc-gateway-server


```bash
# Limpiar, generar Jar file y omitir tests
.\mvnw clean package -DskipTests

# Construir imagen
docker build -t msvc-gateway-server .

# Correr contenedor
docker run -d -p 8090:8090 --name msvc-gateway-server --network springcloud -e IP_ADDR=http://192.168.68.108:9100 msvc-gateway-server:v1