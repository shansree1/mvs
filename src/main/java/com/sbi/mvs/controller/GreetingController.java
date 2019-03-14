package com.sbi.mvs.controller;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.Region;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController
{
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


        Branch area3 = new Branch();
        area3.setBranchId(47003L);
        area3.setBranchName("North Delhi");
        areaList.add(area3);

        model.addAttribute("cashbranchList", areaList);

        List<Branch> branchList = new ArrayList<>();
        Branch branch1 = new Branch();
        branch1.setBranchId(66666L);
        branch1.setBranchName("Owner Branch 1");
        branchList.add(branch1);

        Branch branch2 = new Branch();
        branch2.setBranchId(55555L);
        branch2.setBranchName("Owner Branch 2");
        branchList.add(branch2);

        model.addAttribute("ownerbranchList", branchList);

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
        branch1.setAtmId(100002322320L);
        branch1.setSiteType("Offsite");
        stateList.add(branch1);

        ATM branch2 = new ATM();
        branch2.setAtmId(300002322320L);
        stateList.add(branch2);

        model.addAttribute("atmList", stateList);
        return "fragments :: atmlistFrag";
    }

    @GetMapping("/loadForAtm/{atmId}")
    public String states(Model model, @PathVariable("atmId") String atmId)
    {
        System.out.println(atmId);
        ATM atm = new ATM();
        atm.setAtmId(100002322320L);
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
