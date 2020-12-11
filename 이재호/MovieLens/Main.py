import pandas as pd

#pandas의 기본 파싱 문자는 ','와 '|'가 있음
#따라서 아래 두 파일은 같은 결과를 나타내게 됨!

#이재호/MovieLens/data/testmovie.csv
'''"movieId","title","genres"
1,"Toy Story (1995)","Adventure|Animation|Children|Comedy|Fantasy"
2,"Jumanji (1995)","Adventure|Children|Fantasy"
3,"Grumpier Old Men (1995)","Comedy|Romance"
4,"Waiting to Exhale (1995)","Comedy|Drama|Romance"
5,"Father of the Bride Part II (1995)","Comedy"
6,"Heat (1995)","Action|Crime|Thriller"
7,"Sabrina (1995)","Comedy|Romance"
8,"Tom and Huck (1995)","Adventure|Children"
9,"Sudden Death (1995)","Action"
10,"GoldenEye (1995)","Action|Adventure|Thriller"
'''
movies = pd.read_csv('이재호/MovieLens/data/testmovie.csv')
print(movies)
print(movies.genres.str.get_dummies())

#이재호/MovieLens/data/testmovie2.csv
'''
"movieId","title","genres"
1,"Toy Story (1995)","Adventure,Animation,Children,Comedy,Fantasy"
2,"Jumanji (1995)","Adventure,Children,Fantasy"
3,"Grumpier Old Men (1995)","Comedy,Romance"
4,"Waiting to Exhale (1995)","Comedy,Drama,Romance"
5,"Father of the Bride Part II (1995)","Comedy"
6,"Heat (1995)","Action,Crime,Thriller"
7,"Sabrina (1995)","Comedy,Romance"
8,"Tom and Huck (1995)","Adventure,Children"
9,"Sudden Death (1995)","Action"
10,"GoldenEye (1995)","Action,Adventure,Thriller"
'''
movies = pd.read_csv('이재호/MovieLens/data/testmovie2.csv')
print(movies)
print(movies.genres.str.get_dummies())