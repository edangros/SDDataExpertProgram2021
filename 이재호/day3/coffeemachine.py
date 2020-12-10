#practice : 커피 자동 주문기
'''
시작
->선택할 수 있는 음료와 가격 목록 출력
->각 음료별 몇 잔인지 입력 대기
->각 음료에 대한 가격 계산
->총 금액 요구
->금액 입력
->가격 비교 및 거스름돈 계산
->결과 확인
'''

#initialization
menu     = []
order    = {}
#set menus
#(메뉴이름,가격) 튜플을 사용할거야! -> 두개의 리스트는 불안하니까 메뉴와 가격을 무조건 짝지음
#문자열과 마찬가지로 튜플은 딕셔너리 키로 사용 가능 ("에스프레소3000"이나 마찬가지. 고유한 데이터)
menu.append(("에스프레소",3000))
menu.append(("아메리카노",3500))
menu.append(("카페라떼",5000))
menu.append(("카푸치노",6000))
menu.append(("바닐라라떼",6500))
menu.append(("프라푸치노",8000))
#print the menu list
print("===가격표===")
for item in menu:
    print("%s\t\t\t%d"%item)#tab을 이용해 위치 정렬. 튜플 데이터형이므로 바로 넣을 수 있음
print("")#줄바꿈
input("주문을 진행하시려면 Enter를 눌러주세요")
print("")
for item in menu:
    while True:#이상한거 입력하면 다시 돌려
        try:
            order[item] = int(input("%s  (%d원) 몇 개를 주문하시겠습니까? : "%item))#바로 딕셔너리로 넣음 (튜플은 딕셔너리의 키로 가능)
        except ValueError:
            continue#에러나면 다시
        else:
            break#똑바로 되면 루프 통과

#주문서 출력 및 가격계산
price   :int = 0
print("===주문서===")
for item in menu:
    print(("%s  (%d원)"%item) + ("\t\t\t:%d개\t\t%d원"%(order[item],order[item]*item[1])))
    price += (order[item]*item[1])
print("============")
print("총액 : %d"%price)
print("")#빈줄 출력

paid = 0
while True: #돈 다 받을때까지 무한루프
    try:
        paid += int(input("금액을 입력해주세요 (필요금액 : %d, 투입 금액 : %d)"%(price,paid)))
    except ValueError:
        continue #에러뜨면 되돌리기
    if (paid>=price):
        break #돈 다넣었으면 루프 종료

#거스름돈 계산
print ("거스름돈 : %d원"%(paid-price))
print ("감사합니다.")