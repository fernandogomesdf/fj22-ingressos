package br.com.caelum.ingresso.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.SessaoForm;

@Controller
public class SessaoController {
	
	@Autowired
	private FilmeDao filmeDao;
	
	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private SessaoDao sessaoDao;
	
	@GetMapping({"/admin/sessao"})
    public ModelAndView form(@RequestParam("salaId")Optional<Integer> salaId, SessaoForm form){
        ModelAndView modelAndView = new ModelAndView("sessao/sessao");

        modelAndView.addObject("filmes",filmeDao.findAll());
        modelAndView.addObject("form",form);
        if (salaId.isPresent()) {
        	modelAndView.addObject("sala",salaDao.findOne(salaId.get()));
        }
        
        return modelAndView;
    }
	
	@PostMapping({"/admin/sessao"})
	@Transactional
    public ModelAndView salva(@Valid SessaoForm form){
		
		Sessao sessao = form.toSessao(salaDao, filmeDao);
		sessaoDao.save(sessao);
        
        return new ModelAndView("redirect:/admin/sala/"+form.getSalaId()+"/sessoes");
    }
}
