#practice 4
#googoodan


#print the first line
for n in range(1,10):   
    '''
    #을 왼쪽정렬, 3칸
    n단 글씨는 2칸(한글이 2칸 자리를 먹으므로 결과적으로 3칸)
    #을 오른쪽정렬, 3칸
    '''
    print ("%-3s%-2s%3s"%("#",str(n)+"단","#"), end=" ")
#insert line
print("")

#print the rest lines
for n1 in range(1,10):#row
    for n2 in range(1,10):#column
        '''
        이제 2칸+'X'
        2칸+'='
        ' ' + 2칸
        따라서 3칸 3칸 3칸
        줄맞춤 완-벽
        '''

        print ("%-2dX%2d= %2d"%(n2, n1, n2*n1), end=" ")
    print("")# new line