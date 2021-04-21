package com.example.demo.domain;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SandWitch {
    private String name;
    private List<Ingredient> ingredients;
}
