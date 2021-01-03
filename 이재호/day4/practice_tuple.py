#tuple 내역을 3일차 파일이랑 섞어봅시다.
#가장 많이 e메일을 보낸 사람을 찾는걸로 개조


#3일차 메일박스 입력파일
fhand = open('이재호/day3/mbox.txt')

# 딕셔너리 정의(3.8.5버전 파이썬이면 형식선언 제거해야함)
mails  :dict[str,int] = {}
# 파일 읽으며
for lin in fhand :
    # 공백은 지우고
    lin = lin.rstrip()
    # 공백 기준으로 나누고
    words = lin.split(' ')
    for word in words :
        #e메일은 @이 있음
        if "@" in word:
            #특수문자 제거는 하는데 뭔가 많이 안좋음 -> 개선이 필요하겟군요. (문자열을 몇번 만드는겨)
            #사실 파싱과정에서 특수문자제거는 중요하긴 함. 이 방식 말고 정규식으로 처리하지만.
            key = word.strip().replace(";","").replace("<","").replace(">","")
            mails[key] = mails.get(key,0) + 1
        
# 리스트 컴프리헨션 => k,v를 mail의 모든 항목에 대해 이터레이션하며 (v,k)튜플로 입력, 내림차순 정렬 후 상위 5개만 추출
# C#에서 써봤는데 여기서도...
print(sorted([(v,k) for (k,v) in mails.items()],reverse=True)[:5])