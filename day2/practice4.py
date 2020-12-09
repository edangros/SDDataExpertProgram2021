#practice 3
#googoodan


#print the first line
for n in range(1,10):   
    print ("%-3s"%"#"+"%-2s"%(str(n)+"단")+"%3s"%"#", end=" ")
#insert line
print("")

#print the rest lines
for n1 in range(1,10):#row
    for n2 in range(1,10):#column
        print ("%-2dX%2d= %2d"%(n2, n1, n2*n1), end=" ")
    print("")# new line