#urllib 전체 가져오지 말고 저 세개만 임포트 (다 가져와도 됨)
import urllib.request, urllib.parse, urllib.error

#소켓, 포트 등등을 한줄로 가능. 인코딩이고 뭐고 필요없음
fhand = urllib.request.urlopen('http://data.pr4e.org/romeo.txt')
#파일이랑 똑같음. (IO라는 동일 인터페이스로, 정말로 '똑같이' 쓸 수 있음)
for line in fhand:
    #디코딩은 자동이 아님. (사실 파일을 읽을때도 UTF-8을 주로 써서 그러지 종종 디코딩이 필요한 경우가 있음)
    print(line.decode().strip())

#이전 파일에서 빈도세는 예재 코드 그대로 사용가능
#다시 오픈
fhand = urllib.request.urlopen('http://data.pr4e.org/romeo.txt')
counts  :dict[str,int] = {}
for line in fhand:
    words = line.decode().split()
    for word in words:
        counts[word] = counts.get(word, 0) + 1
print(counts)