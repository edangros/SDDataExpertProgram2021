#tuple 내역을 3일차 파일이랑 섞어봅시다.
#가장 많이 e메일을 보낸 사람을 찾는걸로 개조
#파싱은 정규식으로!

#정규식 라이브러리 임포트
import re


# 딕셔너리 정의
mails  = {}
# 일단 다 긁어옴
#3일차 메일박스 입력파일
with open('이재호/day3/mbox.txt') as fhand:
    for line in fhand:
        #검사범위는 @전후 공백까지(\S), @를 무조건 포함하고(*) @ 뒤에 무조건 글자가 있는데(*[]) 그 글자들은 알파벳A-Za-Z또는 숫자0-9 또는.만 있어야 함
        addresses = re.findall('[A-Za-z0-9.]\S*@\S*[A-Za-z0-9.]',line)
        for address in addresses:
            mails[address] = mails.get(address,0)+1
# 얻은 메일 주소를 집어넣자
with open('이재호/day4/tupleoutput.txt', 'w') as fhand:
    # 먼저 set을 통해 중복되는거 다 제거
    adset = set(mails)
    for s in adset:
        fhand.write(s)

# 리스트 컴프리헨션 => k,v를 mail의 모든 항목에 대해 이터레이션하며 (v,k)튜플로 입력, 내림차순 정렬 후 상위 5개만 추출
# 람다까지 결합해서 다시 뒤집어줌
switch= lambda item: (item[1],item[0]) #이렇게 정의된 함수는 '이터레이터'(반복자)로 작용 가능
print(list(map(switch ,sorted([(v,k) for (k,v) in mails.items()],reverse=True)[:5])))