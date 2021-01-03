#prob.8
from timeit import default_timer as dt
from test_7_noncache import isPrime #import module!
#repetitive calling of the isprime improves the performance

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
print("elapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-100 : %d"%numberOfPrime(100))
print("elapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-1000 : %d"%numberOfPrime(1000))
print("elapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer
print("prime numbers in 0-10000 : %d"%numberOfPrime(10000))
print("elapsed time : %.2fms"%((dt()-startt)*1000))
startt = dt() #initialize Timer

#Computer will explode if use that large number with this algorithm...

###startt = dt() #initialize Timer
###print("prime numbers in 0-100000 : %d"%numberOfPrime(100000))
###print("elapsed time : %.2fms"%((dt()-startt)*1000))

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