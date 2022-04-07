package pe.com.mau.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mau.app.bean.ProductoEntity;
import pe.com.mau.app.bean.response.ListaResponse;
import pe.com.mau.app.bean.response.ProductoBean;
import pe.com.mau.app.bean.response.ProductoResponse;
import pe.com.mau.app.client.ProductoClienInf;
import pe.com.mau.app.dao.ProductoDao;
import pe.com.mau.app.util.Constante;
@Service
public class ProductoServiceImpl  implements ProductoServiceInf{
	@Autowired
	private ProductoDao productoDao;
	@Autowired
	private ProductoClienInf productoClien;

	

	@Override
	public ListaResponse obtenerProductosExt() {
		ListaResponse resonse=new ListaResponse();
		ProductoEntity oProductoEntity=new ProductoEntity();
		ProductoResponse productoResponse= this.productoClien.obtener("123456789");
		if (null!=productoResponse && Constante.MSG_EXITO.equals(productoResponse.getMsgRespuesta())
				&&!productoResponse.getProductos().isEmpty()) {
			for (ProductoBean productos : productoResponse.getProductos()) {
				oProductoEntity.setId(productos.getId());
				oProductoEntity.setNombre(productos.getNombre());
				oProductoEntity.setCantidad(productos.getCantidad());
				oProductoEntity.setPrecio(productos.getPrecio());
				oProductoEntity.setEstado(productos.getEstado());
				oProductoEntity.setFecha(LocalDateTime.parse(productos.getFecha()));
				this.productoDao.save(oProductoEntity);
			}
		}
		List<ProductoEntity>lst= this.productoDao.findAll();
		resonse.setProductos(lst);
		resonse.setCodRespuesta(Constante.COD_EXITO);
		resonse.setMsgRespuesta(Constante.MSG_EXITO);
		
		return resonse;
	}

	


}
