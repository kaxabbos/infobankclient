package com.infobankclient.controller.main;

import com.infobankclient.model.enums.*;
import org.springframework.ui.Model;

import java.util.HashMap;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesEnums(Model model) {
        model.addAttribute("yesnos", YesNo.values());
        model.addAttribute("citizenships", Citizenship.values());
        model.addAttribute("maritals", Marital.values());
        model.addAttribute("origins", Origin.values());
        model.addAttribute("disabilities", Disability.values());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAllByOrderByRole());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesHuman(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("human", usersRepo.getReferenceById(id));
    }

    protected void AddAttributesProfile(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("human", usersRepo.getReferenceById(getUser().getId()));
    }


    protected void AddAttributesHumanEdit(Model model, Long id) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("human", usersRepo.getReferenceById(id));
    }

    protected void AddAttributesCatalog(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("humans", usersRepo.findAllByRole(Role.CLIENT));
    }

    protected void AddAttributesReviews(Model model) {
        AddAttributes(model);
        model.addAttribute("reviews", reviewsRepo.findAll());
    }

    protected void AddAttributesApps(Model model) {
        AddAttributes(model);
        if (getRole().equals(Role.MANAGER.toString())) {
            model.addAttribute("apps", appsRepo.findAll());
        } else if (getRole().equals(Role.CLIENT.toString())) {
            model.addAttribute("apps", appsRepo.findAllByOwner(getUser()));
        }
    }

    protected void AddAttributesCatalogSearch(Model model, Marital marital, Origin origin, Citizenship citizenship, YesNo retiree, YesNo conscripted, Disability disability) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("humans", usersRepo.findAllByRoleAndTertiary_MaritalAndTertiary_OriginAndTertiary_CitizenshipAndTertiary_RetireeAndTertiary_ConscriptedAndTertiary_Disability(Role.CLIENT, marital, origin, citizenship, retiree, conscripted, disability));
        model.addAttribute("marSelect", marital);
        model.addAttribute("oriSelect", origin);
        model.addAttribute("citSelect", citizenship);
        model.addAttribute("retSelect", retiree);
        model.addAttribute("conSelect", conscripted);
        model.addAttribute("disSelect", disability);
    }

    protected void AddAttributesStats(Model model) {
        AddAttributes(model);
        HashMap<String, Integer> maritals = new HashMap<>();
        HashMap<String, Integer> origins = new HashMap<>();
        HashMap<String, Integer> citizenships = new HashMap<>();
        HashMap<String, Integer> retirees = new HashMap<>();
        HashMap<String, Integer> conscripteds = new HashMap<>();
        HashMap<String, Integer> disabilities = new HashMap<>();
        for (Marital i : Marital.values()) {
            maritals.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Marital(Role.CLIENT, i).size());
        }
        for (Origin i : Origin.values()) {
            origins.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Origin(Role.CLIENT, i).size());
        }
        for (Citizenship i : Citizenship.values()) {
            citizenships.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Citizenship(Role.CLIENT, i).size());
        }
        for (YesNo i : YesNo.values()) {
            retirees.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Retiree(Role.CLIENT, i).size());
        }
        for (YesNo i : YesNo.values()) {
            conscripteds.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Conscripted(Role.CLIENT, i).size());
        }
        for (Disability i : Disability.values()) {
            disabilities.put(i.getName(), usersRepo.findAllByRoleAndTertiary_Disability(Role.CLIENT, i).size());
        }
        model.addAttribute("maritals", maritals);
        model.addAttribute("origins", origins);
        model.addAttribute("citizenships", citizenships);
        model.addAttribute("retirees", retirees);
        model.addAttribute("conscripteds", conscripteds);
        model.addAttribute("disabilities", disabilities);
    }
}
