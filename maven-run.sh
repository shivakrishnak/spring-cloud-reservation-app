cd config-service
mvn clean package -DskipTests spring-boot:run
cd ..

cd eureka-service
mvn clean package -DskipTests spring-boot:run
cd ..

cd guest-service
mvn clean package -DskipTests spring-boot:run
cd ..

cd reservation-service
mvn clean package -DskipTests spring-boot:run
cd ..

cd room-service
mvn clean package -DskipTests spring-boot:run
cd ..

cd room-reservation-service
mvn clean package -DskipTests spring-boot:run
cd ..

