package com.codegym.controller;

import com.codegym.model.Motel;
import com.codegym.dto.MotelDto;
import com.codegym.service.IMotelService;
import com.codegym.service.IPaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/motel")
public class MotelController {
    @Autowired
    private IMotelService motelService;
    @Autowired
    private IPaymentService paymentService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "-1") int paymentId, Model model){
        List<Motel> motelList;
        if(paymentId!=-1){
            motelList = motelService.findThree(name,phone,paymentId);
        }else {
            motelList= motelService.findTwo(name,phone);
        }
        model.addAttribute("motelList",motelList);
        model.addAttribute("paymentList",paymentService.findAll());
        model.addAttribute("paymentId",paymentId);
        return "view/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("motelDto",new MotelDto());
        model.addAttribute("paymentList",paymentService.findAll());
        return "view/create";
    }

    @PostMapping("/create")
    public String create(@Validated MotelDto motelDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        new MotelDto().validate(motelDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("paymentList",paymentService.findAll());
            return "view/create";
        }
        Motel motel = new Motel();
        BeanUtils.copyProperties(motelDto,motel);
        motelService.add(motel);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/motel";
    }

    @PostMapping("/delete")
    public String delete(int id, RedirectAttributes redirectAttributes){
        motelService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/motel";
    }
}
