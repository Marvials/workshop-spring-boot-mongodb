package com.marvi.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marvi.workshopmongo.domain.Post;
import com.marvi.workshopmongo.domain.User;
import com.marvi.workshopmongo.repository.PostRepository;
import com.marvi.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository PostRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		PostRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços", maria);
		Post post2 = new Post(null, sdf.parse("04/01/2023"), "Partiu viagem 2.0", "Vou viajar para Rio Grande do Sul, Abraços", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		PostRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
