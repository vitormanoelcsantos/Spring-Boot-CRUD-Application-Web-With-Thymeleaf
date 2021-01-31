package com.vmcs.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vmcs.challenge.domain.model.Func;
import com.vmcs.challenge.domain.repository.FuncRepository;

@Controller
@RequestMapping("/funcionario")
public class FuncController {

	@Autowired
	private FuncRepository funcRepository;

	@GetMapping("/signup")
	public String showSignUpForm(Func func) {
		return "add-func";
	}

	@GetMapping(path = "/listfunc") // método de listagem
	private String List(Model model) {
		model.addAttribute("func", funcRepository.findAll());

		return "returnwithouthfunc";
	}

	@PostMapping("/addfunc") // método de inserção
	public String addFunc(@Valid Func func, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			funcRepository.save(func);
			model.addAttribute("func", func);
			return "add-func";
		}

		return "index";
	}

	@GetMapping("/index") //método para retornar ao index.html
	public String showIndexList(Model model) {
		model.addAttribute("func", funcRepository.findAll());
		return "index";
	}

	 @GetMapping("editfunc/{cpf}") //método para editar os funcionários usando o Cpf como Id
	    public String editFunc(@PathVariable("cpf") String cpf, Model model) {
	        Func func = funcRepository.findById(cpf)
	            .orElseThrow(() -> new IllegalArgumentException("Cpf inválido cpf:" + cpf));
	        model.addAttribute("func", func);
	        return "update-func";
	    }

	 @PostMapping("updatefunc/{cpf}")
	    public String updateFunc(@PathVariable("cpf") String cpf, @Valid Func func, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            func.setCpf(cpf);	            
	            return "update-func";
	        }

	        funcRepository.save(func);
	        model.addAttribute("func", funcRepository.findAll());
	        return "index";
	    }

	@GetMapping("/deletefunc/{cpf}") //método para exclusão de um funcionário usando o Cpf como Id
	public String deleteFunc(@PathVariable("cpf") String cpf, Model model) {
		funcRepository.findById(cpf).orElseThrow(() -> new IllegalArgumentException("Funcionario inválido Cpf:" + cpf));
		funcRepository.deleteById(cpf);
		return "index";
		
		
	}
	
}
