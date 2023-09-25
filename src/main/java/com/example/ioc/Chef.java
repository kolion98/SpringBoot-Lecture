package com.example.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    private final IngredientFactory ingredientFactory;

    public String cook(String menu) {
        //재료 준비
        Ingredient ingredient = ingredientFactory.getIngredient(menu);

        //요리하기...

        //요리결과
        return ingredient.getName() + "으로 만든 " + menu;
    }
}
