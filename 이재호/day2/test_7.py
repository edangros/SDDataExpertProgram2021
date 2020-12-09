#prob.7
n   :int = 0

try:
    n = int(input("type the number:"))
except ValueError:
    exit
result = False
i = 1
while i < n**(0.5):
    i=i+1
    if(n%i==0):
        result = True

if result:
    print("%d는 소수가 아닙니다"%n)
else:
    print("%d는 소수입니다"%n)

