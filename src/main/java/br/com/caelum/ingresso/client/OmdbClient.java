package br.com.caelum.ingresso.client;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {
	
	public Optional<DetalhesDoFilme> request(Filme filme) {
		try {
			RestTemplate client = new RestTemplate();
			String titulo = filme.getNome().replaceAll(" ", "+");
			String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s",  titulo);
			DetalhesDoFilme detalhesDoFilme = client.getForObject(url, DetalhesDoFilme.class);
			return Optional.ofNullable(detalhesDoFilme);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
