#필요 모듈 임포트
import socket

#소켓을 정의합니다. 도메인은 인터넷, 소켓 특성은 스트림(TCP/IP).
mysock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#인터넷 DNS를 이용. 해당 사이트의 80번 포트로 접속
mysock.connect( ('data.pr4e.org', 80) )
#주소를 쓰려면 인코딩을 맞추어주어야 함.(UTF-8? ASCII? -> 웹주소는 보통 UTF-8)
#\r\n은 유닉스계열 줄바꿈 문자 (windows에서는 \n이었고... 이건 요즘 웹서버/에디터에서 상호변환을 많이 지원함)
cmd = 'GET http://data.pr4e.org/romeo.txt HTTP/1.0\r\n\r\n'.encode(encoding="UTF-8")
#만들어둔 소켓으로 보냄
mysock.send(cmd)

#해석 루프
while True:
    #데이터를 받아옴. 버퍼(한번에 받아올 수 있는 임시저장공간)은 512바이트
    data = mysock.recv(512)
    #데이터가 없으면 나감
    if (len(data) < 1):
        break
    #데이터를 디코드해서 받아옴.
    print(data.decode(),end='')
#다 쓴 소켓은 닫음
mysock.close()
'''
HTTP/1.1 200 OK                                                     <-서버로부터의 ok 메세지
Date: Mon, 14 Dec 2020 01:03:14 GMT
Server: Apache/2.4.18 (Ubuntu)
Last-Modified: Sat, 13 May 2017 11:22:22 GMT
ETag: "a7-54f6609245537"
Accept-Ranges: bytes
Content-Length: 167
Cache-Control: max-age=0, no-cache, no-store, must-revalidate
Pragma: no-cache
Expires: Wed, 11 Jan 1984 05:00:00 GMT
Connection: close
Content-Type: text/plain

But soft what light through yonder window breaks
It is the east and Juliet is the sun
Arise fair sun and kill the envious moon
Who is already sick and pale with grief
'''