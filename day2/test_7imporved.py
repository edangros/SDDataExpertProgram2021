#prob.7-improved algorithm
#checking all numbers are not efficient
#collect the prime numbers and devide by them
#number lower than the largest prime number in list -> devide by prime numbers
#higher than the largest prime number -> check that's the prime number

#this list must be always remembered
#repetitive calling of isprime improves the performance(prime numbers are cached)
primenumbers    :list[int] = [2]

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
