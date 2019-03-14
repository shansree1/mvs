package com.sbi.mvs.controller;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.ATMAuxInfo;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.Region;
import com.sbi.mvs.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

        Branch branch1 = new Branch();
        branch1.setBranchId(100L);
        branch1.setBranchName("Branch 1");
        cashLinkBranch.add(branch1);
        Branch branch2 = new Branch();
        branch2.setBranchId(200L);
        branch2.setBranchName("Branch 2");
        cashLinkBranch.add(branch2);

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
    public String step3(Model model)
    {
        model.addAttribute("currTab", "STEP3");

        model.addAttribute("atmAux", new ATMAuxInfo());
        return "step3";
    }

    @PostMapping("/step4")
    public String step4(Model model)
    {
        model.addAttribute("currTab", "STEP3");

        model.addAttribute("atmAux", new ATMAuxInfo());
        return "step4";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/atmList/{radioSel}/{brSel}")
    public String states(Model model, @PathVariable("radioSel") String radioSel, @PathVariable("brSel") String brSel)
    {
        System.out.println(radioSel);
        System.out.println(brSel);
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

    @GetMapping("/loadForAtm/{atmId}")
    public String states(Model model, @PathVariable("atmId") String atmId)
    {
        System.out.println(atmId);
        ATM atm = new ATM();
        atm.setAtmId("100002322320L");
        atm.setSiteType("Offsite");
        atm.setOwnershipType("Opex-TOM");
        atm.setNetworkType("SBI-CONNECT");
        atm.setOem("Hyosung");
        atm.setModel("NCR22E");
        atm.setMsVendor("Hitachi");
        model.addAttribute("atm", atm);

        model.addAttribute("siteList", Arrays.asList("Onsite", "Offsite"));
        model.addAttribute("ownershipTypeList", Arrays.asList("Capex", "Opex-TOM", "Opex-MOF"));
        model.addAttribute("nwTypeList", Arrays.asList("SBI-CONNECT", "VSAT-HCL", "VSAT-HUGHES", "VSAT-AIRTEL"));
        model.addAttribute("oemList", Arrays.asList("Diebold", "Hitachi", "NCR", "Hyosung"));
        model.addAttribute("modelList", Arrays.asList("NCR22E", "NCR22"));
        model.addAttribute("msVendorList", Arrays.asList("FSS", "Hitachi", "NCR", "CMS"));

        return "fragments :: atmFullFrag(atmIn=${atm})";
    }
}
