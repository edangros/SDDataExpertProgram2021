#prob.8
from timeit import default_timer as dt
#repetitive calling of the isprime improves the performance

primenumbers    :list[int] = [2] #prime number cache
#find the number is prime
def isprime_imp (num :int) ->bool:
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
    for nn in range(pn,int(num**0.5)):
        if (num % nn)==0:
            return False
    #For now, the number is prime number so add it to the list
    primenumbers.append(num)
    return True

startt = dt() #initialize Timer
n   :int=0
try:
    n = int(input("type the number:"))
except ValueError:
    exit # if error, just exit the program
currentno = 2 #check from 2
count =0
#check all number smallor or equal to n
while currentno <= n:
    if(isprime_imp(currentno)):
        count = count +1
    currentno = currentno+1

print ("%d이하 소수의 갯수 : %d"%(n,count))
print ("목록",primenumbers.__str__())
elapsedtime = dt() - startt
print ("elapsed time = %.3fms"%(elapsedtime*1000))


