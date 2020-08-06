package com.example.hackathon.rewards;

import com.example.hackathon.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RewardsController implements ErrorController {


	@Autowired
	private RewardsService rewardsService;

	@Override
	@GetMapping("/error")
	public String getErrorPath() {
		return "error";
	}

	@GetMapping("/customers")
	public String findCustomerAll(Model model) {
		List<Customer> customers=rewardsService.getCustomerAll();
		model.addAttribute("costumers", customers);
		return "customer";
	}
	
	@GetMapping("/customers/{id}")
	public String getCustomer(@PathVariable Integer id,Model model) {
		Customer customer = rewardsService.getCustomerById(id);
		model.addAttribute("costumer", customer);
		return "profile";
	}
	@GetMapping("/{id}/offers")
	public String redeem(@PathVariable Integer id,Model model) {
		Customer customer = rewardsService.getCustomerById(id);
		Long mtcoins=customer.getRewardPoints();
		model.addAttribute("mtcoins", mtcoins);
		return "offer";
	}
	
}
