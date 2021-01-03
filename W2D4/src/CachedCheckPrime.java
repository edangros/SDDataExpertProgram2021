//static을 이용해서 Python에서 만들었던 매우 빠른 소수찾기 프로그램 (캐시 사용)을 자바로 만들어봅시다.

import java.util.ArrayList;//파이썬에서 썼던 List와 같은거라고 보면 됩니다. '배열같이 쓸 수 있는 리스트'

//'추상' 클래스로 소수검사기를 일단 만듭니다.
//"난 너가 내부적으로 어떻게 하는지는 몰라! 다만 아래 일들은 처리할 수 있어야 해!"
abstract class PrimeNumberChecker{
    public abstract boolean isPrime(int num);//주어진 수가 소수인가
    public abstract ArrayList<Integer> getPrimeList(int limit);//주어진 수 이하 소수의 리스트
    public abstract int countPrimeNumbers(int limit);//주어진 수 이하 소수의 갯수
}

class CachedPrimeNumberChecker extends PrimeNumberChecker{
    private static ArrayList<Integer> cache = new ArrayList<Integer>(100);//캐시를 넉넉히 만듭니다. 프로그램이 돌면서 하나만 있으면 충분!
    //<>안에 형식을 넣은건 '제네릭'이라고 부릅니다. <>안의 형식에 따라 처리를 해주어야 하는 클래스나 메서드에서 사용합니다.
    //리스트는 어떤 자료형을 담아야 하니 자료형을 제네릭으로 받습니다.
    //https://yaboong.github.io/java/2019/01/19/java-generics-1/
    //파이썬은 자료형 없이 그냥 막 써도 알아서 들어가지만 자바는 모든 자료형을 명확히 해주어야 해서 사용됩니다.
    //정 하고 싶다면 Object형을 받으면 되긴 한데, 저 링크에서 말하듯이 컴파일 단계에서 에러를 못잡아내므로 바람직하지 않습니다.
    // +arraylist는 참조 타입만 담을 수 있으므로 기본형 int 대신 래퍼 클래스 Integer를 사용해야 함

    //리스트에 직접 접근하기 싫으므로 private로 선언하고(캡슐화)
    //밖에서는 이게 소수인지 아닌지, 해당 숫자 이하의 소수가 몇개인지, 소수 배열을 줄 수 있는지
    //딱 이거 3개만 쓸겁니다.
    //따라서 모든 다른 메서드는 private!
    private static void inputCache(int data){//캐시 관련 메서드는 굳이 static이 아닐 필요가 없습니다
        cache.add(data);
    }
    private static boolean smallerThanCached(int num){
        if (cache.size() == 0){return false;}//캐시가 비어있으면 false겠지
        return (num<=cache.get(cache.size()-1));
    }//캐시안에 들어있는지 비교

    @Override
    public boolean isPrime(int num){
        if (cache.size()==0){cache.add(2);}//캐시가 아무것도 없으면 첫값을 넣어 에러 방지
        if(num==2){return true;}//2는 예외
        if(smallerThanCached(num)){return cache.contains(num);}//캐시된 값보다 작다면 리스트에 있는지만 검사하고 빨리 통과
        //캐시 쓰는 소수 로직은 두 가지 페이즈로 구성
        //검사해본 적 없는 숫자 -> 검사해서 소수면 cache에 삽입
        //검사해본 숫자 -> cache만 확인
        for (int i : cache){ //캐시를 끝까지 돔.
            if(i>Math.sqrt(num)){break;} //num의 제곱근 이상은 검사할 필요 없음
            if(num%i==0){return false;} //캐시 안에 있는 값으로 나누어지면 false 반환
        }
        for (int i = cache.get(cache.size()-1);i<=Math.sqrt(num);i++){//남은 숫자 - num의 제곱근까지 돔.
            if(num%i==0){return false;} //캐시 안에 있는 값으로 나누어지면 false 반환
        }
        //여기까지 남았으면 num은 소수이므로
        inputCache(num);//캐시에 삽입하고 true반환
        return true;
    }

    @Override
    public ArrayList<Integer> getPrimeList(int limit){
        return new ArrayList<Integer>(cache.subList(0,countPrimeNumbers(limit)));//0부터 소수 갯수만큼의 데이터를 반환
    }

    @Override
    public int countPrimeNumbers(int limit) {
        //캐시보다 작다면 자기보다 작은 소수 갯수만 세어 보냄
        if(smallerThanCached(limit)){
            int count = 0;
            for(int i = 0; i<=cache.size()-1;i++){
                if (cache.get(i)>limit){break;}
                count++;
            }
            return count;
        }
        if (cache.size()==0){cache.add(2);}//캐시가 아무것도 없으면 첫값을 넣어 에러 방지
        //캐시에 들어가지 않은 소수를 모두 찾아야 함
        for(int i = cache.size()-1;i<=limit;i++){
            isPrime(i);
        }
        return cache.size();
    }
}

public class CachedCheckPrime {
    public static void main(String[] args){
        ArrayList<Integer> res = new CachedPrimeNumberChecker().getPrimeList(100);
        for (int i:res) {
            System.out.println(i);
        }
        System.out.println(new CachedPrimeNumberChecker().countPrimeNumbers(100));
    }
}
