package pe.com.mau.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mau.app.bean.response.ListaResponse;
import pe.com.mau.app.service.ProductoServiceInf;
@RestController
@RequestMapping("/api/productos-externos")
public class ProductoRest {
	@Autowired
	private ProductoServiceInf productoService;
	@GetMapping
	public ListaResponse listarPorductos() {
		
		return this.productoService.obtenerProductosExt();
	}
}
