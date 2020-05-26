
### Hotel Reservation Microservices

#### Config Server

http://localhost:8888/reservation-client/default

http://localhost:8888/guest-client/default

http://localhost:8888/room-client/default

#### Eureka Server

http://localhost:8761/

#### guest-service

http://localhost:8800/guests

http://localhost:8800/swagger-ui.html


#### reservation-service

http://localhost:8801/reservations

http://localhost:8801/swagger-ui.html


#### room-service

http://localhost:8802/rooms

http://localhost:8801/swagger-ui.html

#### room-reservation-service 

> Loadbalance with ribbon and Feign Client

http://localhost:8008/room-reservations


#### client-edge-service 

> Zuul Microproxy

http://localhost:9999/guest-service/guests

http://localhost:9999/reservation-service/reservations

http://localhost:9999/room-service/rooms
