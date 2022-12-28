package com.marvi.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marvi.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		User marvi = new User("1", "Marvi", "marvi@gmail.com");
		User ket = new User("2", "Ket", "Ket@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(marvi, ket));
		return ResponseEntity.ok().body(list);
	}
	
}
