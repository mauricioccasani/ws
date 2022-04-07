package pe.com.mau.app.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import pe.com.mau.app.bean.reques.ProductoRequest;
import pe.com.mau.app.bean.response.MensajeResponse;
import pe.com.mau.app.bean.response.ProductResponse;
import pe.com.mau.app.bean.response.ProductoResponse;
import pe.com.mau.app.service.ProductoServiceInf;

@RestController
@RequestMapping("/api/productos")
@Log4j2
public class ProductoController {
	@Autowired
	private ProductoServiceInf productoService;

	@GetMapping
	public ProductoResponse consultar() {

		return this.productoService.obtener();
	}

	@PostMapping("/insertar")
	public ProductResponse insertar(@RequestBody @Validated ProductoRequest request, BindingResult result) {
		ProductResponse response = new ProductResponse();
		MensajeResponse obMsg = new MensajeResponse();

		request.setFecha(LocalDateTime.now());
		if (result.hasErrors()) {
			String er = result.getFieldErrors().get(0).getDefaultMessage();
			obMsg.setCode(-1);
			obMsg.setMessage(er);
			response.setData(null);
			response.setMensaje(obMsg);
			log.info("Error: {}", response.toString());
			return response;
		}
		
		if (validaDuplicidad(request.getNombre())) {
			obMsg.setCode(-2);
			obMsg.setMessage("el producto ya existe");
			response.setData(null);
			response.setMensaje(obMsg);
			log.info("Error: {}", response.toString());
			return response;
		}
		response = this.productoService.insertar(request);

		obMsg.setCode(0);
		obMsg.setMessage("OK");
		response.setMensaje(obMsg);

		log.info("Datos de entrada: {}", request.toString());
		return response;
	}
	
	boolean validaDuplicidad(String request) {
		boolean duplicidad=false;
		if (this.productoService.existsByNombre(request)) {
			duplicidad =true;
		}
		return duplicidad;
		
	}

}
