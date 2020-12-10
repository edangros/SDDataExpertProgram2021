#Regular Expression!!!!

#메일 하나를 받았습니다. 저널에 논문을 내달라는 메일인데 저를 교수라고 부르네요(...)
#이걸로 정규식을 연습하겠습니다.
#저널 도중에 line을 보면 ,로 구분된 Topic들이 있는데, 이건 split과 정규식 둘 다로 리스트를 얻을 수 있습니다.
#그 라인을 찾으려면 Topic을 써야 합니다.
'''Topics covered in AJEST:
Engineering Topics: 
Engineering Technology Sciences, ...Aerospace Engineering
'''
#도중에 email도 받고, 홈페이지 주소도 받읍시다.

#먼저 파일 input
import os
from typing import Dict
topicName     :str = ""
topics        :Dict[str,list[str]] = {}
lines         :str
direc         :str = os.path.dirname(__file__)#python 설치경로에 파일 담고 하기 귀찮으니 이 .py 저장경로로
    
#한 줄씩 읽기
filehandle = open(os.path.join(direc,"JournalEmail.txt"),"r")#이렇게 파일명과 저장경로를 합칠 수 있음

#파일이 그렇게 길진 않을것이므로 핸들러로부터 모든 데이터를 다 읽어와 메모리에 올린 뒤 돌림
#(파일이 아주 길어 수MB 할 경우 readlines를 쓰지 말고 핸들러로부터 한줄씩 읽어오기)
for lines in filehandle.readlines():
    lines =lines.rstrip()#줄바꿈기호 삭제
    #아무 내용도 없는 줄이면 버리기
    if lines == "":
        continue
    #토픽 줄이라면
    print(lines)
    if topicName != "":
        topics[topicName] = lines.split(",")
        #다 넣었으니까 삭제!
        topicName = ""
    #이 줄이 "Topics:"로 끝난다면
    if lines[-7:].strip() == "Topics:":
        print("###topic###")
        #다음줄은 토픽 목록이니 토픽 제목을 집어넣읍시다
        topicName = lines.split(" ")[0]
filehandle.close()
print(topics.__str__())
    