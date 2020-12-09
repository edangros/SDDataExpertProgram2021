#prob.8
from timeit import default_timer as dt
#find the number is prime
def isprime (num :int) ->bool:
    """Check the number is prime

    Args:
        num (int): the number to check

    Returns:
        bool: if the number is prime number, return True. Return False if not.
    """
    #2 is the exception
    if(num == 2):
        return True
    #initialize variables
    result = False
    i=1
    #check the number smaller than square
    while i < num**(0.5):
        i=i+1
        #if the number can be devided by other number, its not prime
        if(num%i==0):
            result = True
    #return the value
    return not (result)

n   :int=0
primenumbers    :list[int] = [2]
startt  :float = dt()
try:
    n = int(input("type the number:"))
except ValueError:
    exit # if error, just exit the program
currentno = 2 #check from 2
count =0
#check all number smallor or equal to n
while currentno <= n:
    if(isprime(currentno)):
        primenumbers.append(currentno)
        count = count +1
    currentno = currentno+1

print ("%d이하 소수의 갯수 : %d"%(n,count))

print ("목록",primenumbers.__str__())
elapsedtime = dt() - startt
print ("elapsed time = %.3fms"%elapsedtime)

