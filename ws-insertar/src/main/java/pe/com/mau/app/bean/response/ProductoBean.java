package pe.com.mau.app.bean.response;

import lombok.Data;
@Data
public class ProductoBean {
	private int id;
	private String nombre;
	private int cantidad;
	private double precio;
	private String estado;
	
	private String fecha;
}
