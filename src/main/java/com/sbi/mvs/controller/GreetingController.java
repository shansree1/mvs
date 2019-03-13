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

        List<Branch> areaList = new ArrayList<>();
        Branch area1 = new Branch();
        area1.setBranchId(40001L);
        area1.setBranchName("East Mumbai");
        areaList.add(area1);

        Branch area2 = new Branch();
        area2.setBranchId(45003L);
        area2.setBranchName("South Goa");
        areaList.add(area2);

        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> cashLinkBranch = atmList.stream().map(ATM::getCashLinkBranch).collect(Collectors.toSet());

        model.addAttribute("cashbranchList", cashLinkBranch);

        List<Branch> branchList = new ArrayList<>();
        Branch branch1 = new Branch();
        branch1.setBranchId(66666L);
        branch1.setBranchName("Owner Branch 1");
        branchList.add(branch1);

        Branch branch2 = new Branch();
        branch2.setBranchId(55555L);
        branch2.setBranchName("Owner Branch 2");
        branchList.add(branch2);

        Set<Branch> ownerBranch = atmList.stream().map(ATM::getOwnerBranch).collect(Collectors.toSet());

        model.addAttribute("ownerbranchList", ownerBranch);

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


    @GetMapping("/states")
    public String states(Model model)
    {

        List<Region> stateList = new ArrayList<>();
        Region branch1 = new Region();
        branch1.setRegionName("S1BB10032");
        stateList.add(branch1);

        Region branch2 = new Region();
        branch2.setRegionName("S1BJ10037");
        stateList.add(branch2);

        model.addAttribute("stateList", stateList);
        return "fragments :: statelistFrag";
    }
}
