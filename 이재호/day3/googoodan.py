#구구단 예재
#다만 중복 처리를 다른 방식으로 함.
#중복시 다시 생성 알고리즘 -> 운이 아주 나쁠 경우 구구단 생성시간이 길어짐
#미리 만들고 섞은 뒤 차례로 뽑는 알고리즘 -> '항상' 중복 방지 (카드섞기 알고리즘!)
#결과는 리스트, aXb = ans (o)...

import random
from timeit import default_timer as dt
googoolist  :list[tuple[int,int]] = [] #모든 구구단 정보가 담긴 리스트!

#2단 제외!
for i in range(3,10):
    for j in range(3,10):
        #5단은 빼래
        if(i!=5)and(j!=5):#룰 더 정하려면 if문 추가할것
            googoolist.append((i,j))

#카드섞기 알고리즘
#n번째 카드와 랜덤번째 카드를 섞는다. 이걸 모든 영역에 걸쳐 반복 -> 균등하게 섞임!
for i in range(0,len(googoolist)):
    j = random.randint(0,len(googoolist)-1)
    #전형적인 바꾸기 알고리즘
    temp = googoolist[i]
    googoolist[i] = googoolist[j]
    googoolist[j] = temp

#그런데 중복되지 않는 구구단 갯수에는 한계가 있음
#따라서 구구단 갯수 최댓값을 정하자
while True:
    try:
        opportunity = int(input("몇 번 할까요? (최대 20회): "))
    except:
        print("숫자를 입력하세요")
        continue
    else:
        break
#최대값 넘길시 20으로 재조정
opportunity = min(opportunity,20)

# ======================================
# =============구구단 파트==============
# ======================================
count   :int = 0
probs   :list[str] =[]
correctAns  :int = 0
wrongAns    :int = 0
timeout     :int = 3
#전체 시험 타이머 시작
initialtime = dt()
st          :float = 0.0
#이제 그냥 가장 앞 n개만 뽑으면 됨
print("문제시작:",end="")
while count < opportunity:
    #그냥 앞에서부터 하나씩 긁어오기만 해도 충-분
    realAns = (googoolist[count][0]*googoolist[count][1])
    #문제 타이머 시작
    st = dt()
    try:
        #인풋 받기
        inp = int(input("%dX%d = "%googoolist[count]))
        #정답을 맞추었고
        if(inp == realAns):
            #시간안에 풀으면 정답처리
            if((dt()-st)<3):
                print("맞았습니다.(소요시간:%.1ss)\n다음문제:"%(dt()-st),end="")
                correctAns += 1
                probs.append("%dX%d = \t"%googoolist[count]+str(inp)+"\t(O)")
            #시간안에 못풀면 오답
            else:
                print("시간을 넘겼어요!.(소요시간:%.1ss)\n다음문제:"%(dt()-st),end="")
                wrongAns += 1
                probs.append("%dX%d = \t"%googoolist[count]+str(inp)+"\t(Timeout)")
        #답을 틀려도 오답
        else:
            print("틀렸네요. 답은 %d입니다.(소요시간:%.1ss)\n다음문제:"%(realAns,dt()-st),end="")
            probs.append("%dX%d = \t"%googoolist[count]+str(inp)+"\t(X)\t정답 : %d"%realAns)
    #아예 숫자를 입력 안하면 에러
    except ValueError:
        print("숫자를 입력하셨어야죠.(소요시간:%.1ss)\n다음문제:"%(dt()-st),end="")
        probs.append("%dX%d = \t"%googoolist[count]+"\t에러(X)\t정답 : %d"%realAns)
    count = count +1


print("문제종료")
print("%d번중 정답 %d번, 오답 %d번, 에러 %d번"%(opportunity,correctAns,wrongAns,(opportunity-correctAns-wrongAns)))
print("총 소요시간 : %.1fs"%(dt()-initialtime))
print("======세부정보======")
for l in probs:
    print(l)