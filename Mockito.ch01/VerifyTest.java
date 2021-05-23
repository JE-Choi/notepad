package Mockito.ch01;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Verify()를 이용한 검증
 */
public class VerifyTest {
    @Test
    public void mockTest() {
        Animal animal = mock(Animal.class);
        animal.setName("참새");
        
        // n번 호출했는지 체크
        verify(animal, times(1)).setName(any(String.class));

        // 해당 함수를 호출 안했는지 체크
        verify(animal, never()).getName(); // success
        verify(animal, never()).setName(eq("호랑이")); // success
//        verify(animal, never()).setName(eq("참새")); // fail

        // 최소 1번 이상 호출했는지 체크
        verify(animal, atLeastOnce()).setName(any(String.class)); // success

        // 2번 이하 호출했는지
        verify(animal, atMost(2)).setName(any(String.class)); // success

        // 2번이상 호출했는지
//        verify(animal, atLeast(2)).setName(any(String.class)); // fail

        // 지정된 시간 안에(millis) 호출했는지 체크
        verify(animal, timeout(100)).setName(any(String.class));// success

        //지정된 시간(millis)안으로 1번이상 메소드를 호출했는지 체크
        verify(animal, timeout(100).atLeast(1)).setName(any(String.class)); // success
    }
}
