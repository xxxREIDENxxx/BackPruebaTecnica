package com.arleyrivera.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arleyrivera.app.entity.Pedido;
import com.arleyrivera.app.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	// read all delivery
	@GetMapping(path = "/buscar")
	public List <Pedido> readAList(){
		List<Pedido> pedido = StreamSupport
				.stream(pedidoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	return pedido;
	}
	
	@GetMapping(path = "/buscar/{id}")
	public List <Pedido> readAListUser(@PathVariable(value = "id") Long id){
	
		return (List<Pedido>) pedidoService.findPedidoForUser(id);
	}
	
	@GetMapping(path = "/buscar/{date1}/{date2}")
	public List <Pedido> readAListUser(@PathVariable(value = "date1") String date1, @PathVariable(value = "date2") String date2 ) throws ParseException{
		//OffsetDateTime fecha1 = OffsetDateTime.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//OffsetDateTime fecha2 = OffsetDateTime.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  // Convert String to LocalDateTime using LocalDate's parse() method
	     LocalDate fecha1 = LocalDate.parse(date1,dateTimeFormatter);
	     LocalDate fecha2 = LocalDate.parse(date2,dateTimeFormatter);
	     
	     
		System.out.print(fecha1 + "/" + fecha2);
		return (List<Pedido>) pedidoService.getFecha(fecha1, fecha2);
	}
	
	@GetMapping(path = "/estado/{estado}")
	public List <Pedido> getEstado(@PathVariable(value = "estado") Boolean estado){
	
		return (List<Pedido>) pedidoService.getEstado(estado);
	}
	
	
	// create a new delivery
	@PostMapping(path = "/guardar")
	public Pedido pedido (@RequestBody Pedido pedido) {
		return pedidoService.save(pedido);
	}
			
	// Update an delivery
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update (@RequestBody Pedido
		pedidoDetails, @PathVariable(value = "id") Long pedidoId){
		Optional<Pedido> pedido = pedidoService.findById(pedidoId);
		
		if(!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedido.get().setEstado(pedidoDetails.getEstado());
		pedido.get().setLugar(pedidoDetails.getLugar());
		pedido.get().setFecha(pedidoDetails.getFecha());
		pedido.get().setUser(pedidoDetails.getUser());
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido.get()));
	}
	
	//delete an delivery
	@DeleteMapping(path = "/eliminar/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long pedidoId){
		if(!pedidoService.findById(pedidoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		pedidoService.deleteById(pedidoId);
		return ResponseEntity.ok().build(); 
	}
	
	
}

	
	

