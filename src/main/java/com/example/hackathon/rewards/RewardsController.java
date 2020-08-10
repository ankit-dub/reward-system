package com.example.hackathon.rewards;

import com.example.hackathon.Exception.RecordNotFoundException;
import com.example.hackathon.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String offers(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		Long mtcoins=customer.getRewardPoints();
		model.addAttribute("customer",customer);
		model.addAttribute("mtcoins",mtcoins);
		return "offer";
	}

	@GetMapping("/{id}/offer")
	public String offer(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		Long mtcoins=customer.getRewardPoints()-500l;
		model.addAttribute("customer",customer);
		model.addAttribute("mtcoins",mtcoins);
		return "offer";
	}
	@GetMapping("/{id}/offrs")
	public String offrs(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		Long mtcoins=0l;
		model.addAttribute("customer",customer);
		model.addAttribute("mtcoins",mtcoins);
		return "offer";
	}
	@GetMapping("/{id}/amazon")
	public String amazon(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		customer.setRewardPoints(customer.getRewardPoints()-500l);
		model.addAttribute("customer",customer);
		return "AmazonCoupon";
	}
	@GetMapping("/{id}/myntra")
	public String myntra(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		customer.setRewardPoints(45l);
		customerRepository.save(customer);
		return "MyntraCoupon";
	}
	@GetMapping("/{id}/magic")
	public String magic(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		model.addAttribute("customer",customer);
		return "MagicCard";
	}
	@GetMapping("/{id}/mgcRwrd")
	public String magicRwrd(@PathVariable Integer id,Model model) throws RecordNotFoundException{
		Customer customer = rewardsService.getCustomerById(id);
		model.addAttribute("customer",customer);
		return "MagicReward";
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
