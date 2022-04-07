package pe.com.mau.app.bean.request;

import java.util.Date;

import lombok.Data;
@Data
public class ProductoRequest {
	private int id;
	private String nombre;
	private int cantidad;
	private double precio;
	private String estado;
	
	private Date fecha;
}
