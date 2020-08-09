package com.example.hackathon.rewards;

import com.example.hackathon.Exception.RecordNotFoundException;
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
public class RewardsController {


	@Autowired
	private RewardsService rewardsService;

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers/{id}")
	public String getCustomer(@PathVariable Integer id,Model model) throws RecordNotFoundException {
		Customer customer = rewardsService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "profile";
	}
	@GetMapping("/{id}/offers")
	public String offer(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		//Long mtcoins=customer.getApprvamount();
		model.addAttribute("customer",customer);
		return "offer";
	}
	@GetMapping("/{id}/amazon")
	public String amazon(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		customer.setRewardPoints(450l);
		customerRepository.save(customer);
		return "AmazonCoupon";
	}
	@GetMapping("/{id}/myntra")
	public String myntra(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		customer.setRewardPoints(450l);
		customerRepository.save(customer);
		return "MyntraCoupon";
	}
	@GetMapping("/{id}/magic")
	public String magic(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		customer.setRewardPoints(450l);
		customerRepository.save(customer);
		return "MagicCard";
	}
	@GetMapping("/redeem")
	public String redeem() {

		return "scratch";
	}
	@GetMapping("/scratch")
	public String scratch() {

		return "scratchReward";
	}
}
