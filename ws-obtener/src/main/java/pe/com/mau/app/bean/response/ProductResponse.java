package pe.com.mau.app.bean.response;



import lombok.Data;
import pe.com.mau.app.bean.ProductoBean;

@Data
public class ProductResponse {
	private MensajeResponse mensaje;
	private ProductoBean data;
	
}
