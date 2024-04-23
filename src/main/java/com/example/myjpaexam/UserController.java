package com.example.myjpaexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	

	
	
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/create")
	public String create(User user) {
		
		userService.create(user);
		
		return "redirect:/";
	}

	
	@GetMapping("/")
	public String readlist(Model model) {
		
		model.addAttribute("users", userService.readlist());
		
		return "readlist";
	}
	
	
	@GetMapping("/readdetail/{uno}")
	public String readdetail(@PathVariable("uno") Integer uno,
			Model model) {
		
		model.addAttribute("user", userService.readdetail(uno));
		
		return "readdetail";
	}
	
	
	@GetMapping("/update/{uno}")
	public String update(@PathVariable("uno") Integer uno,
			Model model) {
		model.addAttribute("user", userService.readdetail(uno));

		return "update";
	}
	
	@PostMapping("/update")
	public String update(User user) {
		
		userService.update(user);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{uno}")
	public String delete(@PathVariable("uno") Integer uno) {
		userService.delete(uno);
		return "redirect:/";
	}
}
