//static을 이용해서 Python에서 만들었던 매우 빠른 소수찾기 프로그램 (캐시 사용)을 자바로 만들어봅시다.

import java.util.ArrayList;//파이썬에서 썼던 List와 같은거라고 보면 됩니다

class PrimeNumberChecker{
    private static ArrayList<Integer> cache = new ArrayList<>();//캐시를 만듭니다. 프로그램이 돌면서 하나만 있으면 충분!
    //arraylist는 참조 타입만 담을 수 있으므로 기본형 int 대신 래퍼 클래스 Integer를 사용해야 함
    //리스트에 직접 접근하기 싫고, 밖에서는 이게 소수인지 아닌지, 해당 숫자 이하의 소수가 몇개인지, 소수 배열을 줄 수 있는지
    //딱 이거 3개만 쓸겁니다.
    //따라서 모든 다른 메서드는 private!
    private void inputCache(int data){
        cache.add(data);
    }

    public boolean isPrime(int num){
        if(num==2){return true;}//2는 예외
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
        this.inputCache(num);//캐시에 삽입하고 true반환
        return true;
    }

    public ArrayList<Integer> getPrimeList(int limit){
        ArrayList<Integer> result = new ArrayList<>();

        //캐시값보다 작은 수는 검사 하지도 말고 그냥 더함
        for (int i : cache){ //캐시를 끝까지 돔.
            if(i>limit){break;} //limit 이상 값은 리스트에 담으면 안되지
            result.add(i);
        }

    }
}
public class CachedCheckPrime {
}
