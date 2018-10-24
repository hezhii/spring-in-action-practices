package com.whezh;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cake implements Dessert {
    @Override
    public void eat() {
        System.out.println("Eat cake");
    }
}
