---
layout: post
title: "Kibana"
date: 2021-01-07 17:05:51 UTC+9
comments: true
---

# Kibana
Kibana는 데이터 시각화 도구로 시작하였으나 기능이 확장되어 [Elastic Stack](intro.md)의 전반적인 GUI이자 허브로 동작하게 되었다. 

## Kibana의 기능

![kibana 기능](https://www.elastic.co/guide/en/kibana/current/images/intro-kibana.png)

### 오픈소스 분석/시각화 플랫폼
Kibana는 Elasticsearch 데이터를 탐색할 수 있고, 그에 대한 대시보드와 다양한 종류의 뛰어난 시각화를 제공할 수 있다. Kibana의 기본 입력 스트림은 Elasticsearch로, Elasticsearch가 데이터를 저장하고 (Logstacsh를 사용하거나, 사용하지 않거나) 데이터를 분석, 가공하면 그 결과를 Kibana가 표시할 수 있다.

### Elastic Stack의 허브
Kibana에서 보안 설정, 역할 설정, 스냅샷 설정, 데이터 구성 등의 모든 세팅을 할 수 있으며, 동시에 로그를 확인하고 다른 기능들에 접근하는 허브로써 기능할 수 있다.

## Kibana의 인터페이스

### Discover : 탐색과 쿼리
Discover를 통해 Kibana에서도 데이터의 관계와 숨겨진 정보들을 찾아낼 수 있다. 그를 통해서 원하는 데이터만을 찾아낼 수 있고, 그것만을 다시 시각화할 수도 있다.


### Lens, Dashboard : 데이터의 시각화
Lens 인터페이스에서는 드래그 앤 드롭을 통해 빠르게 차트와 표, 통계 자료 등을 만들어낼 수 있다. 또한 Lens는 더 나은 시각화 방법을 제안하고, 시각화 모델 사이를 쉽게 전환해가며 비교할 수 있게 해준다.

Dashboard는 그러한 시각화 자료를 통합해 볼 수 있게 해준다. 그 외에도 픽셀 단위의 그림을 그리는 Canvas, 다양한 지리 데이터를 시각화해주는 Maps, 시간 데이터를 처리하는 TSVB 등이 시각화 툴로 제공된다.

### Spaces : 조직 및 보안
다른 사람이나 팀과 협력할 때, 각 시각화 자료, 대시보드, 색인 등에 대한 접근을 제어할 수 있다. 각 팀원들에 맞는 기능만을 켜서 권한을 제어하고 필요 없는 기능을 노출시키지 않을 수 있다.
