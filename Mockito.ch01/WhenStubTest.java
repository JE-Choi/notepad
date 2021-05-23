package Mockito.ch01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * when() 메서드 그리고 stub
 */
public class WhenStubTest {
    @Test
    public void mockTest(){
        Animal animal = mock(Animal.class);
        // mock이 이런 값을 return하는 객체라면?
        when(animal.getAge()).thenReturn(30);
        when(animal.getName()).thenReturn("뽀짝한 참새");
        when(animal.getFly()).thenReturn(true);

        // 이런걸 예상합니다.
        assertTrue(animal.getAge() == 30);
        assertTrue(animal.getName().equals("뽀짝한 참새"));
        assertTrue(animal.getFly() == true);
    }

    /**
     * 객체 자체를 stub으로 만들어내는 과정
     */
    @Test
    public void mockTest2(){
        Animal animal = mock(Animal.class);

        List<String> animalList = new ArrayList<>();
        animalList.add("어흥하는 호랑이");
        animalList.add("뿌우하는 코끼리");
        animalList.add("슈웅하는 독수리");

        when(animal.getAnimalList()).thenReturn(animalList);
        assertNotNull(animalList);
        assertEquals(animalList.size(), 3);

        // mock객체의 2번째 요소가 코끼리인걸 알 수 있음.
        System.out.println(animal.getAnimalList().get(2));
    }
}
