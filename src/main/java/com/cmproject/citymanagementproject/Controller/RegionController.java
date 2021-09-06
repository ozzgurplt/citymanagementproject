package com.cmproject.citymanagementproject.Controller;

import com.cmproject.citymanagementproject.Model.Region;
import com.cmproject.citymanagementproject.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listRegion",regionService.getAllRegion());
        return "index";
    }
    @GetMapping("/showNewRegionForm")
    public String showNewRegionForm(Model model){
        Region region=new Region();
        model.addAttribute("region",region);
        return "new_region";

    }
    @PostMapping("/saveRegion")
    public String saveRegion(@ModelAttribute("region")Region region){
        regionService.saveRegion(region);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model){
      Region region = regionService.getRegionById(id);
        model.addAttribute("region", region);
        return "update_region";
    }

    @GetMapping("/deleteRegion/{id}")
    public String deleteRegion(@PathVariable (value = "id") long id){
        this.regionService.deleteRegionById(id);
        return "redirect:/";

    }
}
