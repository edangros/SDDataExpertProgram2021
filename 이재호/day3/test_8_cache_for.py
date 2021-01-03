#prob.8
from timeit import default_timer as dt
#repetitive calling of the isprime improves the performance

#use isPrime in Prob.7
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
    #1st check : devide by primenumbers
    for pn in primenumbers:
        if (pn>(num**(0.5))):
            break #exit the loop if all prime numbers are checked
        if (num % pn)==0:
            return False

    #2nd check : devide by the numbers within the maximum primenumbers - root(num)
    for nn in range(pn,int(num**0.5)+1):
        if (num % nn)==0:
            return False
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
eleapsed time : 7.96ms
prime numbers in 0-100 : 25
eleapsed time : 1.42ms
prime numbers in 0-1000 : 168
eleapsed time : 5.03ms
prime numbers in 0-10000 : 1229
eleapsed time : 54.48ms
prime numbers in 0-100000 : 9592
eleapsed time : 753.35ms
cache algorithm -> 훨씬 짧은 처리시간!
캐시가 함수가 끝나도 계속 유지되므로 0-10에서 사용한 캐시를 0-100에서 다시 사용, 오히려 검색시간이 감소함!
'''