package com.sbi.mvs.controller;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.Region;
import com.sbi.mvs.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class GreetingController
{

    @Autowired
    AtmRepository atmRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("currTab", "STEP1");
        return "index";
    }

    @GetMapping("/step2")
    public String step2(Model model)
    {
        model.addAttribute("currTab", "STEP2");


        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> cashLinkBranch = atmList.stream().map(ATM::getCashLinkBranch).collect(Collectors.toSet());

        model.addAttribute("cashbranchList", cashLinkBranch);

        Set<Branch> ownerBranch = atmList.stream().map(ATM::getOwnerBranch).collect(Collectors.toSet());

        model.addAttribute("ownerbranchList", ownerBranch);

        List<String> siteList = new ArrayList<>();
        siteList.add("Onsite");
        siteList.add("Offsite");
        model.addAttribute("siteList", siteList);

        ATM atmOut = new ATM();
        model.addAttribute("atmOut", atmOut);

        return "step2";
    }


    @PostMapping("/step3")
    public String step3(@ModelAttribute("typeSel") String typeSel,
                        @ModelAttribute("area") String area,
                        Model model)
    {
        System.out.println(typeSel);
        System.out.println(area);
        model.addAttribute("currTab", "STEP3");
        return "step3";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/atmList")
    public String states(Model model)
    {

        List<ATM> stateList = new ArrayList<>();
        ATM branch1 = new ATM();
        branch1.setAtmId("100002322320L");
        branch1.setSiteType("Offsite");
        stateList.add(branch1);

        ATM branch2 = new ATM();
        branch2.setAtmId("300002322320L");
        stateList.add(branch2);

        model.addAttribute("atmList", stateList);
        return "fragments :: atmlistFrag";
    }
}
