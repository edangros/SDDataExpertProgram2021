
from timeit import default_timer as dt
fileHandle = open("mbox.txt")

#e메일이 가득 들어있는 텍스트파일이네요
#filehandle vs readlines
#readlines를 사용하면 파일의 모든 내용을 읽어서 메모리에 로드!
#메모리의 용량 <<<<하드디스크 용량
#메모리 접근 속도 >>넘사벽>>하드디스크 접근 속도
#이건 파일이 좀 많이 기므로 하드에서 천천히 불러옵시다