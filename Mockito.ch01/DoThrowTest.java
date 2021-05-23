package Mockito.ch01;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * doThrow()를 통한 예외 발생
 * doThrow() 메서드를 이용하여 예외를 발생시킬 수 있다.
 * 아래에서 animal.setAge(20)을 통해 예외가 발생하는 과정이다.
 * <p>
 * 출처: https://www.crocus.co.kr/1556 [Crocus]
 */
public class DoThrowTest {
    @Test
    public void mockTest() {
        Animal animal = mock(Animal.class);
        doThrow(new RuntimeException()).when(animal).setAge(eq(20));
        animal.setAge(10);
        try {
            animal.setAge(20);
            assertFalse(false);
        } catch (RuntimeException e){
            // 예상한 곳에서 예외 잘 발생했음.
            assertTrue(true);
        }
    }
}
