# docker-compose 데모
### Jenkins 실행하기

**docker-compose.yml**

```ruby
version: '2'
services:
  jenkins:
    image: 'docker.io/bitnami/jenkins:2-debian-10'
    ports:
      - '8080:8080'
    volumes:
      - 'jenkins_data:/bitnami/jenkins'
volumes:
  jenkins_data:
    driver: local
```

**쉘 스크립트**

- 실행: docker-compose up
- 중지: docker-compose down

**미리보기**

- http://localhost:8080