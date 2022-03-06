package io.web.medpaharm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.web.medpaharm.entities.User;
import io.web.medpaharm.repositories.UserRepository;

@Controller
@RequestMapping(value="/app/")
public class UserController {
	
	@Autowired
	private  UserRepository useRepo;
	
	  @GetMapping("signup")
	    public String showSignUpForm(User user) {
	        return "add-user";
	    }
	
	@GetMapping(value="list",  produces = "application/json")
	public String returnUsers(Model model) {
		model.addAttribute("users", useRepo.findAll());
		return "index";
	}
	
//	@PostMapping(value="adduser")
	@RequestMapping(value="adduser", method=RequestMethod.GET)
    public String addUser(@Valid  User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/add-user";
        }
        
        useRepo.save(user);
        
        return "redirect:list";
	
	}
	
	  @GetMapping("edit/{id}")
	    public String editUserById(@PathVariable("id") long id, Model model) {
	        User user = useRepo.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
	        model.addAttribute("user", user);
	        return "update-user";
	    }
	  
	  @PostMapping("update/{id}")
	    public String updateUserById(@PathVariable("id") long id, @Valid User user, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            user.setId(id);
	            return "update-user";
	        }

	        useRepo.save(user);
	        model.addAttribute("users", useRepo.findAll());
	        return "index";
	    }
	  
	  @GetMapping("delete/{id}")
	  public String deleteUser(@PathVariable("id") long id, Model model) {
		  User user = useRepo.findById(id)
				  .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
	        model.addAttribute("users", useRepo.findAll());
	        return "index";
	  }
	  
	  
}
