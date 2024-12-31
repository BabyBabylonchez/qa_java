package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> expectedFoodList;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFoodList) {
        this.animalKind = animalKind;
        this.expectedFoodList = expectedFoodList;
    }

    @Parameterized.Parameters
        public static Object[][] setParamsForTest() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void getFoodIsCorrect() throws Exception {
        MatcherAssert.assertThat("Неподходящий рацион для животного", new Animal().getFood(animalKind), equalTo(this.expectedFoodList) );
    }

}
