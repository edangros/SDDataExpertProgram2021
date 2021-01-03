#prob.7
# searching the whole number is not efficient! -> use the prime numbers previously searched
# repetitive calling of the isprime improves the performance

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

    #2nd check : devide by the numbers within the maximum primenumbers - squareroot(num)
    for nn in range(pn,int(num**0.5)):
        if (num % nn)==0:
            return False
    #For now, the number is prime number so add it to the list
    primenumbers.append(num)
    return True
