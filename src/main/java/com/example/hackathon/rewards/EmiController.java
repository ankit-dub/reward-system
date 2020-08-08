package com.example.hackathon.rewards;

import com.example.hackathon.model.MyEmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EmiController {
    @Autowired
    private EmiService emiService;

    @GetMapping("/{id}/emi")
    public String findTransactionAll(@PathVariable Integer id, Model model) {
        MyEmi emi=emiService.getEmi(id);
        model.addAttribute("emi", emi);
        model.addAttribute("id",id);
        return "EmiSection";
    }
    @RequestMapping(value = "/newemi/{id}")
    public String addEmi(@PathVariable Integer id,Model model) {
        {
            model.addAttribute("emi", new MyEmi());
            model.addAttribute("id",id);
            return "newEmi";
        }
    }
    @RequestMapping(path = "/createEmi", method = RequestMethod.POST)
    public String createEmi(@Valid MyEmi myEmi)
    {
        myEmi = emiService.save(myEmi);
        return "redirect:/1000/emi";
    }

}
