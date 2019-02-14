# 自動採点ツール

## Description

自動採点ツールです

## Setup

* Docker

https://hub.docker.com/editions/community/docker-ce-desktop-mac

```bash
$ brew install groovy
$ brew cask install chromedriver
$ brew install jenkins
```

* Jenkins起動

```bash
$ brew services start jenkins
```

http://localhost:8080/

* Jenkinsテストjob作成

```bash:
#!/bin/bash
source ~/.bash_profile

git clone https://$USER_NAME:$PASSWORD@github.com/YukiFujisawa/auto-scoring-tool.git

bundle install
yarn install
rails db:migrate:reset RAILS_ENV=development
rails s -d
cd auto-scoring-tool
./gradlew test --tests suite.FacelookSuite -Psite=Facelook
pkill -f 'puma'
```

## Usage

* DockerでPostgres起動

```bash
$ docker-compose up -d
```

* Jenkinsテストjob実行

* Jenkins停止

```bash
$ brew services stop jenkins
```

## tools

* Adminer

http://0.0.0.0:18080/
admin / admin