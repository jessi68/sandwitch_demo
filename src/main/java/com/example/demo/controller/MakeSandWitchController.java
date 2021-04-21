package com.example.demo.controller;

import com.example.demo.domain.Ingredient;
import com.example.demo.domain.SandWitch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/make")
public class MakeSandWitchController {

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CT", "Cherry Thomatoes", Ingredient.Type.TOMATO),
                new Ingredient("RICO", "Ricotta", Ingredient.Type.CHEESE),
                new Ingredient("CB", "Canadian Bacon", Ingredient.Type.HAM)
        );
        Ingredient.Type[] types = Ingredient.Type.values();

        for(Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                             filterByType(ingredients, type));
        }
        model.addAttribute("sandwitch", new SandWitch());
        return "design";
    }


}
