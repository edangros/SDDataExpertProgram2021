#practice 2 : input all range value
st  :int = 0
en  :int = 0
gap :int = 0
try:
    st = int(input ("시작값을 입력하세요:"))
    en = int(input ("끝값을 입력하세요:"))
    gap = int(input ("간격을 입력하세요:"))
except ValueError:
    exit
count   :int = 0
for i in range(st,en+1,gap):
    count = count + i
print ("%d에서 %d까지 %d간격의 합계:%d"%(st,en,gap,count))