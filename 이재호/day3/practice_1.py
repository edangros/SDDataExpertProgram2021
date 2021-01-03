#Function practice #1 - #3
#practice 1-3까지 다른 함수를 만들어야 할 수도 있지만, 아래와 같이 인자를 여럿 받을 수도 있음
#sign function을 받기 위해 numpy 가져오기


def printRepetitiveString(s :str, start :int, end :int, step :int = 1):
    for i in range(start,end,step):
        print(s*i)
    print(s*end)#range특성상 마지막 한칸 빠지니까 한번 더

printRepetitiveString("*",1,7)
printRepetitiveString("*",7,1,-1)
printRepetitiveString("*",1,7)
