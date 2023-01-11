package com.codegym.exam3.controller;

import com.codegym.exam3.dto.HouseholdDto;
import com.codegym.exam3.model.Household;
import com.codegym.exam3.service.IHouseholdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Size;
import java.util.List;

@Controller
@RequestMapping("/household")
public class HouseholdController {
    @Autowired
    private IHouseholdService householdService;
    @GetMapping("")
    public String showList(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<Household> householdPage = householdService.findAll(pageable);
        model.addAttribute("householdPage",householdPage);
        return "view/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id,Model model){
        Household household = householdService.findById(id);
        HouseholdDto householdDto = new HouseholdDto();
        BeanUtils.copyProperties(household,householdDto);
        model.addAttribute("householdDto",householdDto);
        return "view/update";
    }

    @PostMapping("/update")
    public String update(@Validated HouseholdDto householdDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        new HouseholdDto().validate(householdDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "view/update";
        }
        Household household = new Household();
        BeanUtils.copyProperties(householdDto,household);
        householdService.update(household);
        redirectAttributes.addFlashAttribute("mess", "chỉnh sửa thành công");
        return "redirect:/household";
    }
}
