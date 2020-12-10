#binary search
#linear search에 비해 비교적 균등하고 빠른 검색속도를 가짐
import random
#linear search function
def linearSearch(num    :int, minimum   :int, maximum   :int) ->int:
    """linearly search the num in the range of minimum-maximum

    Args:
        num (int): the target number to find
        minimum (int): the minimum limit of the num
        maximum (int): the maximum limit of the num

    Returns:
        the searching count
    """
    count = 0
    for i in range(minimum,maximum+1):
        count += 1
        if (i==num):
            break
    return count

#binary search function
def binarySearch(num    :int, minimum   :int, maximum   :int) -> int:
    """binary search the num in the range of minimum-maximum

    Args:
        num (int): the target number to find
        minimum (int): the minimum limit of the num
        maximum (int): the maximum limit of the num

    Returns:
        the searching count
    """
    #search loop
    count = 0
    tempmin = minimum
    tempmax = maximum
    while True:
        count += 1
        n = (tempmin+tempmax)//2
        if (n==num):
            break
        elif (n>num):
            tempmax = n+1#일단 옮겨놓은 뒤 range 미세조정 -> 엉뚱한데 끼어있는거 방지
        else:
            tempmin = n-1#일단 옮겨놓은 뒤 range 미세조정 -> 엉뚱한데 끼어있는거 방지
        if (count >= maximum*10):#무한루프방지구문
            break

    return count

#공정한 비교를 위해 랜덤을 10번 돌려봅시다
min = 1
max = 100
cnt_lin = 0
cnt_bi = 0
for i in range(1,11):
    ans = random.randint(min,max)
    cnt_lin += linearSearch(ans,min,max)
    cnt_bi += binarySearch(ans,min,max)

print("10번 결과 선형탐색은 %d번, 이진탐색은 %d번"%(cnt_lin,cnt_bi))
    