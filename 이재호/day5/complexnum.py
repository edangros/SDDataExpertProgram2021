


#아래 내용들 대부분은 '연산자 오버라이딩'이라고 부름. 각 언어마다 처리하는 방식은 약간씩 다름
class ComplexNumber:
    #초기화
    def __init__(self, real, img):
        self.real   :float = real
        self.img    :float = img
    #덧셈
    def __add__(self, cn):
        return ComplexNumber(self.real + cn.real, self.img + cn.img)
    #뻴셈
    def __sub__(self, cn):
        return ComplexNumber(self.real - cn.real, self.img - cn.img)

    #복소수곱. float같은게 그대로 들어오면 .real같은게 없으니 별도처리
    def __mul__(self, x):
        if (type(x) == int)or(type(x) == float):
            return ComplexNumber(self.real * x, self.img * x)
        elif type(x) == ComplexNumber:
            return ComplexNumber(self.real * x.real - self.img * x.img, self.real * x.img + self.img * x.real)
        #            (a + bj) * (c + dj) = (ac - bd) + (ad + bc)j 
    #문자열로 변경
    def __str__(self):
        if self.img >= 0:
            return '{} + {}j'.format(self.real, self.img)
        else:
            return '{} - {}j'.format(self.real, abs(self.img))
    #복소수가 서로 같은가
    def __eq__(self, cn):
        return self.real == cn.real and self.img == cn.img
    #복소수가 서로 다른가
    def __ne__(self, cn):
        return not (self.real == cn.real and self.img == cn.img)
    #복소수의 절대값(복소평면에서 원점과의 거리)
    def __abs__(self):
        return (self.real ** 2 + self.img ** 2)**0.5
    #길이의 제곱
    def __len__(self):
        return self.real ** 2 + self.img ** 2


#실재실행내용
a = ComplexNumber(3, 2)
b = ComplexNumber(2, 5)
print("복소수 a: ",a)
print("복소수 b: ",b)
print("복소수 a+b: ",a+b)
print("복소수 a-b: ",a-b)
print("복소수 a*b: ",a*b)
print("복소수 a와 b가 같은가? ",a==b)
print("복소수 a와 b가 다른가? ",a!=b)
print("복소수 a 크기: ",abs(a))
print("복소수 a 크기의 제곱: ",len(a))
