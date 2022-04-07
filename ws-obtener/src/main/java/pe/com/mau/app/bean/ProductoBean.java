package pe.com.mau.app.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class ProductoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=5, max=60, message="El nombre es requerido y debe ser mayor que 5 y máximo 60 caracteres")
	private String nombre;
	private int cantidad;
	private double precio;
	@Size(min=1, max=2, message="El estado es requerido")
	private String estado;
	private LocalDateTime fecha;
}
