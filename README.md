# 自動採点ツール

## Description

自動採点ツールです

## Setup

* Docker

https://hub.docker.com/editions/community/docker-ce-desktop-mac

```bash
$ docker-compose up -d
$ docker exec -it -u root jenkins bash
$ apt-get update
$ apt-get install build-essential
$ apt-get install -y libreadline-dev

```

```bash
$ brew install groovy
```

## Usage

```bash
$ docker-compose start
$ ./gradlew test --tests suite.GebishSuite -Psite=Gebish
$ ./gradlew test --tests suite.FacelookSuite -Psite=Facelook
$ docker-compose end
```

## tools

* Jenkins

http://0.0.0.0:18080/

* Adminer

http://0.0.0.0:8080/
admin / admin