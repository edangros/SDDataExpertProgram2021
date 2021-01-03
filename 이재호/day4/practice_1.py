#입력 파일에 값들이 저장되어 있다고 할 때, 파일을 읽어서 합계 와 평균을 계산하고 새로운 파일에 저장하는 프로그램

#파일 일기
tot = 0.0
with open("이재호/day4/inputnum.txt") as fhand:
    for line in fhand:
        try:
            tot += float(line.rstrip().replace(" ",""))
        except:
            print("invalid file")
            quit()

fhand = open("이재호/day4/outputnum.txt","w")
fhand.write(str(int(tot)))