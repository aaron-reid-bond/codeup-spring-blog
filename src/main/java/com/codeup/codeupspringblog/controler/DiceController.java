package com.codeup.codeupspringblog.controler;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showDiceForm() {
        return "roll/roll";
    }

    @GetMapping("/roll-dice/{n}")
    public String showDiceForm(@PathVariable Integer n, Model model) {
        System.out.println("n = " + n);
        int rand = (int) ((Math.random() * 6 - 1 + 1) + 1);
        System.out.println("rand = " + rand);
        if(rand == n){
            model.addAttribute("gNumber", 1);
        } else {
            model.addAttribute("bNumber", 1);
        }
        model.addAttribute("number", n);
        model.addAttribute("rand", rand);
        return "roll/result";
    }
}
