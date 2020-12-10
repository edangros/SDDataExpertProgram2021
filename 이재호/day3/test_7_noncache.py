#prob.7
#find the number is prime
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
        i=i+1
        #if the number can be devided by other number, its not prime
        if(num%i==0):
            return False
    #return the value
    return True
