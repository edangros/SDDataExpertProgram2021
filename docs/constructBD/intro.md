---
layout: poCBD
title: "시스템 재구축 주간 - 1.리눅스 가상머신 설치 및 Remote 원격제어 구축"
chapter: 0
comments: true
---


# 시스템 재구축 주간 - 1.리눅스 가상머신 설치 및 Remote 원격제어 구축

지난 2주간은 빅데이터 분석을 위한 각종 툴을 맛보는 시간이었다. 리눅스 설치부터 시작해서 ELK스택, 하둡과 주키퍼, KAFKA까지 진행되었다. 거기에 조금이라도 더 편한 개발을 위해서 원격개발환경 구축에 클러스터 구축까지 진행해야 하였다.

이번 주에는 OS설치 및 원격접속 구축부터 재시작하고, 하둡 클러스터 및 Spark를 위한 파이썬/스칼라 개발환경까지 구축하여 워크플로우를 확립, 이후 학습과 프로젝트 진행에 대비하는 것이 목표이다.

 - [1. 리눅스 가상머신 설치 및 Remote 원격제어 구축](1_linux.md)
    - [번외 : VSCode Remote를 이용한 리눅스 환경에서 파이썬 실행](1_1_Pylinux.md)
 - [2. ELK스택 설치 및 Logstash 파이프라인 구축](2_ELK.md)
 - [3. Hadoop 설치 및 데이터 로드/언로드](3_Hadoop.md)
 - [4. Metricbeat를 이용한 원격 클러스터 모니터링 시스템 구축](4_remote.md)
 - [5. Kafka와 Zookeeper 설치 및 로그 파이프라인 구축](5_kafka.md)
 - [6. Spark 개발환경의 구축](6_spark.md)

거기에 시간이 허락한다면 아래 내용도 진행할 예정이다. 지금은 외부 링크가 걸려있지만 내가 하고, 내 링크로 바꿀 것이다. 오늘의 나 말고 내일의 내가.
 - [7. Docker를 이용한 클러스터 재가상화](https://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/DockerContainers.html)
 - [8. Kubernates를 이용한 클러스터의 완성](http://blog.madhukaraphatak.com/horizontal-scaling-k8s-part-1/)
