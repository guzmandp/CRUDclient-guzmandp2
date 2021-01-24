package com.guzmandp.crudclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guzmandp.crudclient.dto.ClientDTO;

import com.guzmandp.crudclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired	
	private ClientService service;
	
		@GetMapping
		public ResponseEntity<List<ClientDTO>> findAll(){
			List<ClientDTO> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		@GetMapping(value = "/{id}")
		public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
			ClientDTO dto = service.findById(id);
			return ResponseEntity.ok().body(dto);
		}
}
