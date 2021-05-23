package Mockito.ch01;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AnimalTest {


    @Mock
    Animal animal;

    @Test
    public void mockTest(){
        MockitoAnnotations.initMocks(this);
        assertTrue(animal != null);

        // 2번째 Mock 생성방법
        Animal animalMock = mock(Animal.class);
        assertTrue(animalMock != null);


        Animal animal2 = null;
        assertFalse(animal2 != null);

    }
}