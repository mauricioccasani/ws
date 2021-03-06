package pe.com.mau.app.bean.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.mau.app.bean.ProductoEntity;

@Data
@EqualsAndHashCode(callSuper=false)
public class ListaResponse extends GenericResponse{
	private List<ProductoEntity> productos;
}
