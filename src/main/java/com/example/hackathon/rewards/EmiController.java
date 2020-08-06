package com.example.hackathon.rewards;

import com.example.hackathon.model.Customer;
import com.example.hackathon.model.MyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmiController {
    @Autowired
    private EmiService emiService;

    @GetMapping("/emi")
    public String findTransactionAll(Model model) {
        List<MyTransaction> emis=emiService.getTransactionAll();
        model.addAttribute("emis", emis);
        return "EmiSection";
    }
    @RequestMapping(value = "/newemi")
    public String addExpense(Model model) {
        {
            model.addAttribute("emi", new MyTransaction());
            return "createEmi";
        }
    }
    @RequestMapping(path = "/createEmi", method = RequestMethod.POST)
    public String createExpense(@Valid MyTransaction myTransaction)
    {
        myTransaction = emiService.save(myTransaction);
        return "redirect:/emi";
    }

}
