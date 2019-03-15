package com.sbi.mvs.controller;

import com.sbi.mvs.entity.*;
import com.sbi.mvs.repository.AtmRepository;
import com.sbi.mvs.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class GreetingController
{

    @Autowired
    AtmRepository atmRepository;

    @Autowired
    BranchRepository branchRepository;

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

        /*Branch branch1 = new Branch();
        branch1.setBranchId(100L);
        branch1.setBranchName("Branch 1");
        cashLinkBranch.add(branch1);
        Branch branch2 = new Branch();
        branch2.setBranchId(200L);
        branch2.setBranchName("Branch 2");
        cashLinkBranch.add(branch2);*/

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
    public String step3(@ModelAttribute ATM atmIn, Model model)
    {
        System.out.println(atmIn);

        ATM atmOut = atmRepository.getOne(atmIn.getAtmId());
        Branch br = atmOut.getCashLinkBranch();
        Pfhrms brmgr = br.getBranchPeopleData().getBranchManager();
        Pfhrms atmofr = br.getBranchPeopleData().getAtmOfficer();

        model.addAttribute("br", br);
        model.addAttribute("atmIn", atmOut);
        model.addAttribute("brmgr", brmgr);
        model.addAttribute("atmofr", atmofr);
        model.addAttribute("currTab", "STEP3");
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


    @GetMapping("/atmList/{branchType}/{branchId}")
    public String states(Model model, @PathVariable("branchType") String branchType, @PathVariable("branchId") Long branchId)
    {
        System.out.println(branchType);
        System.out.println(branchId);
        List<ATM> atmList = new ArrayList<>();
        Optional<Branch> branch = branchRepository.findById(branchId);
        if(branch.isPresent()) {
            if ("owner".equals(branchType)) {
                atmList = atmRepository.findByOwnerBranch(branch.get());
            } else {
                atmList = atmRepository.findByCashLinkBranch(branch.get());
            }
        }

        model.addAttribute("atmList", atmList);
        return "fragments :: atmlistFrag";
    }

    @GetMapping("/loadForAtm/{atmId}")
    public String loadForAtm(Model model, @PathVariable("atmId") String atmId)
    {
        System.out.println(atmId);
        Optional<ATM> atm = atmRepository.findById(atmId);
        /*ATM atm = new ATM();
        atm.setAtmId("100002322320L");
        atm.setSiteType("Offsite");
        atm.setOwnershipType("Opex-TOM");
        atm.setNetworkType("SBI-CONNECT");
        atm.setOem("Hyosung");
        atm.setModel("NCR22E");
        atm.setMsVendor("Hitachi");*/
        model.addAttribute("atmIn", atm.get());
        System.out.println(atm.get());

        //model.addAttribute("atmType", atm.get().getAtmType());
        model.addAttribute("siteList", Arrays.asList("Onsite", "Offsite"));
        model.addAttribute("ownershipTypeList", Arrays.asList("Capex", "Opex-TOM", "Opex-MOF"));
        model.addAttribute("nwTypeList", Arrays.asList("SBI-CONNECT", "VSAT-HCL", "VSAT-HUGHES", "VSAT-AIRTEL"));
        model.addAttribute("oemList", Arrays.asList("Diebold", "Hitachi", "NCR", "Hyosung"));
        model.addAttribute("modelList", Arrays.asList("NCR22E", "NCR22"));
        model.addAttribute("msVendorList", Arrays.asList("FSS", "Hitachi", "NCR", "CMS"));

        return "fragments :: atmFullFrag";
    }
}
