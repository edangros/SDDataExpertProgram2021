#=================================
#day3 practice : typing Game
#=================================

#랜덤하게 문자열 추출 -> random 필요
import random
#시간 카운팅 -> timeit 필요
from time import time as pt

#리스트 초기화

words   :list[str]  = ["cat","dog","fox","raptor","whale","butterfly","snake","monkey","elephant","frog"]
st      :float #시작 시간 기록
tries   :int        = 0 #시도 횟수
word    :str        = "" #선정된 문자
#시작 대기
input("준비되었으면 Enter를 누르세요")
#타이머 초기화
st = pt()

#메인루프 -> break로만 빠져나올 수 있음
while True:
    #문제 구문
    tries += 1
    while True: #한번 더 -> 틀리면 되돌아오게
        word = random.choice(words)
        print(word)
        if (input()==word):
            break
            
    if(tries>=5):#5회 완료하였다면 종료
        break
print("소모시간 : %.2fs"%(pt()-st))

            

