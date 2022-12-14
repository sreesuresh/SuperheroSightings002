package com.example.superherosightings002.controller;

import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Organization;
import com.example.superherosightings002.service.HeroService;
import com.example.superherosightings002.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class OrganizationController {

    private final OrganizationService organizationService;
    private final HeroService heroService;

    public OrganizationController(OrganizationService organizationService, HeroService heroService) {
        this.organizationService = organizationService;
        this.heroService = heroService;
    }

    Set<ConstraintViolation<Organization>> violations = new HashSet<>();

    @GetMapping("organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationService.getAllOrganizations();
        model.addAttribute("organizations", organizations);
        return "organizations";
    }

    @GetMapping("/organizations/addOrganization")
    public String displayAddOrganizations(Model model) {
        List<Hero> heros = heroService.getAllHeros();
        model.addAttribute("heros", heros);

        model.addAttribute("errors", violations);

        return "/organizations/addOrganization";
    }

    @PostMapping("/organizations/addOrganization")
    public String addOrganization(HttpServletRequest request, Model model) {
        violations.clear();

        String name = request.getParameter("organizationName");
        boolean isHero = Boolean.parseBoolean(request.getParameter("isHero"));
        String description = request.getParameter("organizationDescription");
        String address = request.getParameter("organizationAddress");
        String contact = request.getParameter("organizationContact");
        String[] heroIds = request.getParameterValues("heroId");

        List<Hero> heros = new ArrayList<>();
        if (heroIds != null) {
            for (String heroId : heroIds) {
                heros.add(heroService.getHeroById(Integer.parseInt(heroId)));
            }
        }

        Organization organization = organizationService.createOrganization(name, isHero, description, address, contact, heros);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);
        if (violations.isEmpty()) {
            organizationService.addOrganization(organization);
        }

        model.addAttribute("errors", violations);


        return "redirect:/organizations/addOrganization";
    }

    @GetMapping("/organizations/deleteOrganization")
    public String deleteOrganization(Integer id) {
        organizationService.deleteOrganizationById(id);
        return "redirect:/organizations";
    }

    @GetMapping("/organizations/editOrganization")
    public String displayEditOrganization(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Organization organization = organizationService.getOrganizationById(id);
        model.addAttribute("organization", organization);

        List<Hero> heros = heroService.getAllHeros();
        model.addAttribute("heros", heros);

        model.addAttribute("errors", violations);

        return "organizations/editOrganization";
    }

    @PostMapping("/organizations/editOrganization")
    public String editOrganization(HttpServletRequest request, Model model) {
        violations.clear();

        int id = Integer.parseInt(request.getParameter("organizationId"));
        String name = request.getParameter("organizationName");
        boolean isHero = Boolean.parseBoolean(request.getParameter("isHero"));
        String description = request.getParameter("organizationDescription");
        String address = request.getParameter("organizationAddress");
        String contact = request.getParameter("organizationContact");
        String[] heroIds = request.getParameterValues("heroId");

        List<Hero> heros = new ArrayList<>();
        if (heroIds != null) {
            for (String heroId : heroIds) {
                heros.add(heroService.getHeroById(Integer.parseInt(heroId)));
            }
        }

        Organization organization = organizationService.createOrganization(name, isHero, description, address, contact, heros);
        organization.setId(id);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);
        if (violations.isEmpty()) {
            organizationService.updateOrganization(organization);
            return "redirect:/organizations";
        } else {
            organization = organizationService.getOrganizationById(organization.getId());
            model.addAttribute("organization", organization);

            heros = heroService.getAllHeros();
            model.addAttribute("heros", heros);

            model.addAttribute("errors", violations);

            return "organizations/editOrganization";
        }
    }

    @GetMapping("organizations/detailsOrganization")
    public String displayDetailsOrganization(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Organization organization = organizationService.getOrganizationById(id);
        model.addAttribute("organization", organization);

        return "organizations/detailsOrganization";
    }
}
