package com.example.ioc;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Chicken implements Ingredient{
    private final String name;
//    final int age;
//    int eggCount;
//
//    public Chicken(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
