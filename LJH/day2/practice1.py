#practice 1 : sum to certain number
no  :int = 0
try:
    no = int(input ("숫자를 입력하세요:"))
except ValueError:
    exit
count   :int = 0
for i in range(1,no+1):
    count = count + i
print ("1에서 %d까지의 합계:%d"%(no,count))