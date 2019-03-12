package br.com.caelum.ingresso.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessaoController {
	
	@GetMapping({"/admin/sessao"})
    public ModelAndView form(@PathVariable("salaId")Optional<Integer> salaId){
        ModelAndView modelAndView = new ModelAndView("sessao/sessao");



        return modelAndView;
    }
}
