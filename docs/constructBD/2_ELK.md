---
layout: poCBD
title: "시스템 재구축 주간 - 2. ELK스택 설치 및 Logstash 파이프라인 구축"
chapter: 2
comments: true
---

# 시스템 재구축 주간 - 2. ELK스택 설치 및 Logstash 파이프라인 구축

지난 2주간은 빅데이터 분석을 위한 각종 툴을 맛보는 시간이었다. 리눅스 설치부터 시작해서 ELK스택, 하둡과 주키퍼, KAFKA까지 진행되었다. 거기에 조금이라도 더 편한 개발을 위해서 원격개발환경 구축에 클러스터 구축까지 진행해야 하였다.

이번 주에는 OS설치 및 원격접속 구축부터 재시작하고, 하둡 클러스터 및 Spark를 위한 파이썬/스칼라 개발환경까지 구축하여 워크플로우를 확립, 이후 학습과 프로젝트 진행에 대비하는 것이 목표이다.

 - [1. 리눅스 가상머신 설치 및 Remote 원격제어 구축](1_linux.md)
 - [2. ELK스택 설치 및 Logstash 파이프라인 구축](2_ELK.md)
 - [3. Hadoop 설치 및 데이터 로드/언로드](3_Hadoop.md)
 - [4. Metricbeat를 이용한 원격 클러스터 모니터링 시스템 구축](4_remote.md)
 - [5. Kafka와 Zookeeper 설치 및 로그 파이프라인 구축](5_kafka.md)
 - [6. Spark 개발환경의 구축](6_spark.md)

거기에 시간이 허락한다면 아래 내용도 진행할 예정이다. 지금은 외부 링크가 걸려있지만 내가 하고, 내 링크로 바꿀 것이다. 오늘의 나 말고 내일의 내가.
 - [7. Docker를 이용한 클러스터 재가상화](https://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/DockerContainers.html)
 - [8. Kubernates를 이용한 클러스터의 완성](http://blog.madhukaraphatak.com/horizontal-scaling-k8s-part-1/)

<br>

 ## 1. ELK 스택 설치
 수업동안에는 공식 홈페이지에서 yum을 통해 설치하도록 안내한 대로 레포지토리 생성 -> 설치의 과정을 밟았다. 이 방식은 버전관리가 간편하다는 장점은 있지만, 시스템이 기본적으로 설치경로를 할당한다는 문제가 존재한다. 이번에는 인터넷에서 압축파일을 받은 뒤, 설치를 진행하는데, Remote를 이용해서 또 말도 안되게 빠르게 모든 걸 완료할 것이다.

 일단, 모든 프로그램은 Standalone 형태로 한 모듈 안에 모두 설치할 거다. 클러스터로의 확장은 이후 진행하도록 한다.

 ### 1.1 준비물

  - tar.gz파일을 풀 수 있는 압축해제 프로그램 (ex. 반디집)
  - 완성된 Remote-SSH 연결

위 내용만 봐도 뭔가 앞으로의 흐름이 짐작될 것이다. 


### 1.2 다운로드 및 압축 해제, 리눅스로 전송
[Elastic Stack 공식 홈페이지](https://www.elastic.co/kr/downloads/)로 가서 ELK와 Beat의 리눅스 버전을 다운받는다. LINUX X86_64버전을 다운로드받으면 된다. 그리고 폴더 하나에 고이 모은 뒤, 압축을 해제한다.

**그 다음, Remote로 연결되어있는 리눅스 호스트에 폴더째로 드래그해서 옮겨버린다.**

끝이다. 정말로. 저것만 하면 tar같은 명령어 쓰다가 오타에 씨름할 필요도 없고, 폴더명도 미리 다 정리해서 가져다 넣을 수 있다.

다음으로, 압축폴더들 이름이 너무 기니까 적당히 줄여서 *심볼릭 링크*를 만들자.
```sh
ln -s [폴더명] [심볼릭링크 파일명]
```
이렇게 심볼릭 링크를 만들어두고 환경변수를 심볼릭 링크에 걸어둔다면 이후, ELK스택 버전을 바꾸거나 할 때 환경변수를 다시 바꿀 필요 없이 심볼릭링크의 링크 대상만 바꾸면 되므로 매우 편리하게 사용 가능하다.

### 1.3 설정파일 설정 및 환경변수 설정

### 1.4 서비스 설정 및 등록

## 2. Logstash 파이프라인 설정

## 3. 파일 수정 권한 부여 및 서비스 실행