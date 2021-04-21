package com.example.demo.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private String id;
    private String name;
    private Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public static enum Type{
        TOMATO, EGG, HAM, CHEESE, CABBAGE
    }
}
