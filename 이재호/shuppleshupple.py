names = ["배형근","유연경","곽동희","이관영","백용균","윤성훈","홍지영","김지언","이주희","박경태","정현모","김인기","변영준","이재호","윤두균","양재옥","이지민","이찬","박근상","김준균","김동현","김용준"]

group = 6

import random

for i in range(0,len(names)):
    j = random.randint(0,len(names)-1)
    temp = names[i]
    names[i]=names[j]
    names[j]=temp
    
for n in names:
    print (n)