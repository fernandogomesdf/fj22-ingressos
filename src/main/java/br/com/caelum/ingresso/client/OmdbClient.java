package br.com.caelum.ingresso.client;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {
	
	public <T> Optional<T> request(Filme filme, Class<T> tClass) {
		try {
			RestTemplate client = new RestTemplate();
			String titulo = filme.getNome().replaceAll(" ", "+");
			String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s",  titulo);
			return Optional.of(client.getForObject(url, tClass));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
