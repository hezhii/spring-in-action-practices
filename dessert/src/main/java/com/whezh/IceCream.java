package com.whezh;

import org.springframework.stereotype.Component;

@Component
//@Qualifier("cold") // 默认限定符为 bean 的 ID。
@Cold
@Creamy
public class IceCream implements Dessert {
    @Override
    public void eat() {
        System.out.println("Eat ice cream");
    }
}
