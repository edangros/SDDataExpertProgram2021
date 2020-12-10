#prob.8
from timeit import default_timer as dt
#repetitive calling of the isprime improves the performance

#use isPrime in Prob.7
#while seems faster than for, so modify it
#=========================prob.7=================================
primenumbers    :list[int] = [2] #prime number cache
#find the number is prime
def isPrime (num :int) ->bool:
    """Check the number is prime

    Args:
        num (int): the number to check

    Returns:
        bool: if the number is prime number, return True. Return False if not.
    """
    pn   :int =0
    #2 is the exception
    if (num == 2):
        return True
    #1st check : devide by primenumbers -> use 'for' cuz primenumbers list is already exists
    for pn in primenumbers:
        if (pn>(num**(0.5))):
            break #exit the loop if all prime numbers are checked
        if (num % pn)==0:
            return False

    #2nd check : devide by the numbers within the maximum primenumbers - root(num)
    #while seems faster than for

    while pn <= int(num**0.5):
        if (num % pn)==0:
            return False
        pn += 1
    #For now, the number is prime number so add it to the list
    primenumbers.append(num)
    return True
#=====================================================================================


def numberOfPrime(num   :int)   ->int:
    """count the prime numbers smaller than input number num

    Args:
        num (int): input number

    Returns:
        int: the number of the prime numbers smaller than num
    """
    currentno = 2 #check from 2
    count =0
    #check all number smaller or equal to n
    #it seems that while is faster than for...
    while currentno <= num:
        if(isPrime(currentno)):
            count = count +1
        currentno = currentno+1

    return count


#test code
startt = dt() #initialize Timer
print("prime numbers in 0-10 : %d"%numberOfPrime(10))
print("eleapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-100 : %d"%numberOfPrime(100))
print("eleapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-1000 : %d"%numberOfPrime(1000))
print("eleapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-10000 : %d"%numberOfPrime(10000))
print("eleapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-100000 : %d"%numberOfPrime(100000))
print("eleapsed time : %.2fms"%((dt()-startt)*1000))

'''
prime numbers in 0-10 : 4
eleapsed time : 14.19ms
prime numbers in 0-100 : 25
eleapsed time : 0.85ms
prime numbers in 0-1000 : 168
eleapsed time : 4.00ms
prime numbers in 0-10000 : 1229
eleapsed time : 51.98ms
prime numbers in 0-100000 : 9592
eleapsed time : 615.72ms
for문을 쓸때보다 100ms정도 절약!
=>for는 range에서 리스트를 생성하고 내부 순회의 원리 -> 리스트 생성 및 삭제 소요시간이 발생
'''