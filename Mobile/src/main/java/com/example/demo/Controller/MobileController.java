package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.demo.Model.MobileModel;
import com.example.demo.Repository.MobileRepository;


@Controller
public class MobileController {

    @Autowired
    MobileRepository m1;

    @PostMapping("/Add")
    public String AddRecord(MobileModel m2) {
        m1.save(m2);
        return "redirect:/mobile/display";
    }

    @GetMapping("/mobile/display")
    public String displayMobile(Model model) {
        List<MobileModel> mobile_list = m1.findAll();
        model.addAttribute("hi", mobile_list);
        return "display";
    }

    @GetMapping("/mobile/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id) {
        m1.deleteById(id);
        return "redirect:/mobile/display";
    }

    @GetMapping("/mobile/edit/{id}")
    public String editCar(@PathVariable("id") Integer id, Model model) {
        MobileModel m = m1.findById(id).get();
        model.addAttribute("mobile", m); // Use "mobile" here
        return "edit";
    }

    @PostMapping("/mobile/edit")
    public String editCar(MobileModel m3) {
        MobileModel m4 = m1.findById(m3.getId()).get();
        m4.setBrand(m3.getBrand());
        m4.setModel(m3.getModel());
        m4.setPrice(m3.getPrice());
        m1.save(m4);
        return "redirect:/mobile/display";
    }
}
