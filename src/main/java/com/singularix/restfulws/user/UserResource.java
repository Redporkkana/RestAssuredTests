package com.singularix.restfulws.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class UserResource {
	// /GET/users
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	} 
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user = service.findOne(id);
		if (user==null)
			throw new UserNotFoundException("id: "+id);
		return user;
	}

	// /POST /users
/*	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User newUser = service.save(user);
		// /users/4 => /users/{id} => id = user.getId
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId()).toUri();
		//location header /users/4
		return ResponseEntity.created(location).build();
	}
*/
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
	    User newUser = service.save(user);
	    URI location = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(newUser.getId())
	            .toUri();
	    return ResponseEntity.created(location).body(newUser); // ✅ return the created user as JSON
	}

	// /PUT /users
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user) {
	    User existingUser = service.findOne(id);
	    if (existingUser == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Update existing user's fields
	    existingUser.setName(user.getName());
	    existingUser.setBirthday(user.getBirthday());

	    // No need to increment ID or add again — it’s already in the list
	    return ResponseEntity.ok(existingUser);
	}

	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
		
	}
}
