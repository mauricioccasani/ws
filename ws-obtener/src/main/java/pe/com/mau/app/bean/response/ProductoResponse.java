package pe.com.mau.app.bean.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.mau.app.bean.ProductoBean;
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductoResponse extends GenericResponse{
	private List<ProductoBean>productos;
}
