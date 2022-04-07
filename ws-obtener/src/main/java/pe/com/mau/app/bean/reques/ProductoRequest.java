package pe.com.mau.app.bean.reques;

import java.time.LocalDateTime;
import javax.validation.constraints.Size;
import lombok.Data;
@Data
public class ProductoRequest {
	private int id;
	@Size(min=5, max=60, message="El nombre es requerido y debe ser mayor que 5 y máximo 60 caracteres")
	private String nombre;
	private int cantidad;
	private double precio;
	@Size(min=1, max=2, message="El estado es requerido")
	private String estado;
	private LocalDateTime fecha;
}
