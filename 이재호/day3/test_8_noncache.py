#prob.8
from timeit import default_timer as dt
#repetitive calling of the isprime improves the performance

#use isPrime in Prob.7
#=========================prob.7=================================
def isPrime (num :int) ->bool:
    """Check the number is prime

    Args:
        num (int): the number to check

    Returns:
        bool: if the number is prime number, return True. Return False if not.
    """
    #2 is the exception
    if(num == 2):
        return True
    #check the number smaller than square
    for i in range(2,int(num**1/2)+1):
        #if the number can be devided by other number, its not prime
        if(num%i==0):
            return False
    #return the value
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

#Computer will explode if use that large number with this algorithm...

###startt = dt() #initialize Timer
###print("prime numbers in 0-100000 : %d"%numberOfPrime(100000))
###print("eleapsed time : %.2fms"%((dt()-startt)*1000))

'''
prime numbers in 0-10 : 5
eleapsed time : 6.08ms
prime numbers in 0-100 : 26
eleapsed time : 8.92ms
prime numbers in 0-1000 : 169
eleapsed time : 19.63ms
prime numbers in 0-10000 : 1230
eleapsed time : 1110.07ms
n제곱근 서칭을 하기 때문에 n^(3/2)에 비례하는게 이론(n번 서치 X n제곱근번 서치)
덕분에 숫자가 크면 클수록 기하급수적으로 소요시간 증가
'''