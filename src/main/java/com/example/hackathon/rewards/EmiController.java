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
import java.util.List;

@Controller
public class EmiController {
    @Autowired
    private EmiService emiService;

    @GetMapping("/{id}/emi")
    public String findTransactionAll(@PathVariable Integer id, Model model) {
        List<MyEmi> emis=emiService.getTransactionAll(id);
        model.addAttribute("emis", emis);
        model.addAttribute("id",id);
        return "EmiSection";
    }
    @RequestMapping(value = "/newemi")
    public String addEmi(Model model) {
        {
            model.addAttribute("emi", new MyEmi());
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
