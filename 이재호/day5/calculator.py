#계산기
#다중항 지원 바로 하게 합시다.
def calculate(inp):
    #해석 루프
    #시작하기 전에 모든 리스트 계산
    for i in range(0,len(inp)):
        if type(inp[i]) is list:
            inp[i] = calculate(inp[i])
    while True:
        #끝이면 루프 나감
        if len(inp) == 1:
            break
        #다음칸이 다층리스트면 계산 먼저
        if type(inp[1]) is list:
            inp[1] = calculate(inp[1])
        #그게 아니면 숫자+연산자일테니 아무 문제 없음
        op = inp[0][-1:] #연산자는 앞쪽 항목의 마지막글자
        v1 = float(inp[0][:-1]) #나머지는 숫자
        tail = inp[1][-1:] #뒤쪽 연산자는 이번 연산 끝나고 붙임
        v2 = float(inp[1][:-1]) #나머지는 숫자
        if op == "+":
            inp[0]=str(v1+v2)+tail
        if op == "-":
            inp[0]=str(v1-v2)+tail
        if op == "*":
            inp[0]=str(v1*v2)+tail
        if op == "/":
            inp[0]=str(v1/v2)+tail#여기서 오류날 수 있음
        #pos+1번은 이미 끝난 계산이니 없애버림!
        del inp[1]
        print(inp)
    #다 끝났으면 숫자 하나 + '+' 남겠네
    return inp[0]





eq      :str = ""
while True: #프로그램 메인 루프
    eq = input("수식:")
    #수식 유효성 검사
    #정규식을 쓸 수도 있지만 그냥 이렇게 하자
    tmp     :str = eq
    #문자 검사
    for ch in ['0','1','2','3','4','5','6','7','8','9','-','+','/','*'," ",".","(",")"]:
        tmp = tmp.replace(ch,"")
    #올바른 수식이라면 tmp가 남아있으면 안됨
    if not (tmp==""):
        print("수식을 올바르게 입력해주세요")
    #공백은 모두 지워버려
    eq = eq.replace(" ","")
    #마지막칸에 연산자 하나 붙이자
    eq = eq+"+"


    #이제 이렇게 포맷할거임
    #1+2+3*4+(5+6)*7
    #->[1+,2+,[3*,4+],[[5+,6*],7]]]
    #그건 이렇게 계산함
    #1: [3+,12+,[[5+,6*],7]] ->1+2까지 계산하고 다음은 가장 안쪽 리스트인 3*4 계산
    #2: [15+,77] ->3+12까지 계산하고 가장 안쪽 리스트인 5+6, 그 다음 안쪽 리스트인 11*7 계산
    #3: [92]->다시 15+77 계산
    #...귀찮아 괄호는 안할래

    #6*(1+3)
    #(1+3)*6
    eqlist = []
    #몇차 리스트까지 들어왔나?
    level = 0
    #되돌아갈 리스트가 필요하니 0차~n차 리스트의 레퍼런스를 미리 받아서 되돌아갈수 있게!
    levellist = [eqlist]
    lastpos = 0
    #곱셈/나눗셈 나온 뒤 덧셈이 나오면 레벨을 되돌아가야 하니, 곱셈/나눗셈이었는지를 기억함
    #그런데 이것도 레벨 기억해야하네
    multdiv = [False]
    count_left = 0
    count_right = 0
    parsing_error = False
    for i in range(0,len(eq)):
        #한단계 들어갈시
        if eq[i] == "(":
            #이전 글씨가 숫자였다면 곱하기 하나 붙여 밖으로 뺌
            if i!=0 and eq[i-1] in "0123456789":
                levellist[level].append(eq[lastpos:i]+"*")
                #그리고 곱셈은 true다
                multdiv[level] = True
            #무조건 레벨 올려야죠
            temp = [] #temp에 새로운 리스트 만들고
            levellist[level].append(temp) #결과 리스트에 temp 집어넣고
            level += 1 #레벨을 하나 더 들어가서
            levellist.append(temp) #temp의 레퍼런스를 작업중인 새 레벨에 집어넣음
            multdiv.append(False) #새로운 레벨에도 곱셈 검사여부 만듬. 새로운 시작이니 False로 진행
            count_left += 1 #괄호수 하나 증가
            lastpos = i+1 #다음 문자로 포인터 옮김
            print("level up")
        #lastpos가 더 큰 상태면 그냥 스킵
        if lastpos>=i:
            continue
        #괄호 잘못적었으면 파싱에러
        if count_left<count_right:
            parsing_error = True
            break
        #특수문자 파악
        if eq[i] in "+-": #가장 순위 낮은 연산자라면(덧셈, 뺄셈)
            levellist[level].append(eq[lastpos:i+1]) #연산자까지 불러옵시다
            #이전 문자가 곱셈/나눗셈중이었다면 레벨을 1단계 되돌림
            if multdiv[level]:
                print("level down")
                #multdiv 정리
                del multdiv[level]
                levellist.remove(levellist[level])#현재 레벨 리스트에서 제외
                level -= 1
            lastpos = i+1 #다음 문자로 포인터 옮김
        #여기가 재미있는건데 리스트를 한겹 더 씌워서 우선계산해야 한다는걸 표시할 겁니다.
        if eq[i] in "*/": #곱셈,나눗셈이라면
            if not multdiv[level]: #곱셈/나눗셈중이 아니라면 레벨 하나 들어가야함
                multdiv[level] = True
                temp = [] #temp에 새로운 리스트 만들고
                levellist[level].append(temp) #결과 리스트에 temp 집어넣고
                level += 1 #레벨을 하나 더 들어가서
                levellist.append(temp) #temp의 레퍼런스를 작업중인 새 레벨에 집어넣음
                multdiv.append(True) #새로운 레벨에도 곱셈 검사여부 만듬. 이전이 곱셈이었으니 일단 값은 True임
                print("level up")
            levellist[level].append(eq[lastpos:i+1]) #그리고 연산자까지 입력
            lastpos = i+1 #다음 문자로 포인터 옮김
        #괄호도 처리
        #한단계 나올시
        if eq[i] == ")":
            #다음 연산자 취득해서 합친 뒤 append
            #괄호가 아닌 글자를 찾아야 함
            j = i #i부터 검색 시작
            temp = levellist[level] #현재 레벨배열 기억
            currlastpos = lastpos #현재 마지막문자열 기억
            while True: #검색 루프
                if eq[j]==")": #괄호가 나올 때마다
                    #레벨리스트는 정리하면 큰일남;;
                    del multdiv[level]
                    levellist.remove(levellist[level])#현재 레벨 리스트에서 제외
                    level -= 1 #레벨을 하나 더 내림
                    count_right += 1 #괄호수 하나 증가
                    lastpos = j+1 #다음 문자로 포인터 옮김
                    print("level down")
                    print(multdiv)
                    print(eqlist)
                else:
                    if eq[j] in "+-/*":
                        temp.append(eq[currlastpos:j+1].replace(")","")) #연산자가 집혔으면 그거 뱉음
                        lastpos = j+1 #다음 문자로 포인터 옮김
                    else:
                        parsing_error = True #그게 아니면 파싱에러지 뭐
                    break
                j += 1#다음 글자 확인
        if parsing_error: #돌리다가 파싱 에러가 난 상태면 루프 종료
            break
        print(level)
        print(multdiv)
        print(eqlist)


    #괄호 수가 다르다면 이것도 파싱에러
    if count_left != count_right:
        parsing_error == True
    #파싱 에러가 났으면 중단
    if parsing_error:
        print("괄호가 잘못되었습니다")
        continue
    print(level)
    print(eqlist)

    #이제 계산돌리는데 나눗셈은 오류나겠지?
    try:
        print(calculate(eqlist))
    except ZeroDivisionError:
        print("0으로 나누기 발생")
    else:
        break

        


#(1+3)*5+5*5+5(1+3)+5*(1+3)

