package com.codegym.controller;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String facilityTypeName, @PageableDefault(size = 5) Pageable pageable) {
        Page<Facility> facilityPage = facilityService.findByNameAndFacilityType(name, facilityTypeName, pageable);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeName",facilityTypeName);
        return "facility/list";
    }

    @GetMapping("/create")
    public String showAdd(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/update")
    public String update( Facility facility, RedirectAttributes redirectAttributes){
        facilityService.update(facility);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/facility";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        Facility facility = facilityService.findById(id).orElse(null);
        model.addAttribute("facility",facility);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/create")
    public String add(Facility facility, RedirectAttributes redirectAttributes){
        facilityService.add(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/facility";
    }
}
