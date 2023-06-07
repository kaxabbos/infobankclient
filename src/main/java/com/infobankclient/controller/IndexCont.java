package com.infobankclient.controller;

import com.infobankclient.controller.main.Attributes;
import com.infobankclient.model.enums.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexCont extends Attributes {

    @GetMapping
    public String index1() {
        return "redirect:/about";
    }

    @GetMapping("/index")
    public String index2() {
        return "redirect:/about";
    }

    @GetMapping("/catalog")
    public String index2(Model model) {
        AddAttributesCatalog(model);
        return "catalog";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam Marital marital, @RequestParam Origin origin, @RequestParam Citizenship citizenship,
                         @RequestParam YesNo retiree, @RequestParam YesNo conscripted, @RequestParam Disability disability) {
        AddAttributesCatalogSearch(model, marital, origin, citizenship, retiree, conscripted, disability);
        return "catalog";
    }
}
