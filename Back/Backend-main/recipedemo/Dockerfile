# 1. 기본 JDK 이미지 설정
FROM openjdk:17-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드한 JAR 파일을 컨테이너에 복사
COPY build/libs/recipedemo-0.0.1-SNAPSHOT.jar app.jar

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
