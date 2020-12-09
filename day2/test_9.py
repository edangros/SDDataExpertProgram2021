#prob.9

n   :int = 0
while True:
    try:
        n = int(input("type the number:"))
    except ValueError:
        continue
    if (n>0) and (n<=10):
        break

i=0
while (i < n):
    i=i+1
    if(n%i==0):
        print('*'*i)