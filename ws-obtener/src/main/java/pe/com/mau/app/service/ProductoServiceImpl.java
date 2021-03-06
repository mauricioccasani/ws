package pe.com.mau.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mau.app.bean.ProductoBean;
import pe.com.mau.app.bean.reques.ProductoRequest;
import pe.com.mau.app.bean.response.ProductResponse;
import pe.com.mau.app.bean.response.ProductoResponse;
import pe.com.mau.app.dao.ProductoDao;
import pe.com.mau.app.util.Constantes;

@Service
public class ProductoServiceImpl implements ProductoServiceInf {
	@Autowired
	private ProductoDao productoDao;

	@Override
	public ProductoResponse obtener() {
		ProductoResponse response=new ProductoResponse();
		List<ProductoBean>list= this.productoDao.findAll();
		if (list.isEmpty()) {
			
			response.setCodRespuesta(Constantes.COD_ERROR);
			response.setMsgRespuesta(Constantes.MSG_ERROR);
			response.setProductos(new ArrayList<>());
		}else {
			response.setCodRespuesta(Constantes.COD_EXITO);
			response.setMsgRespuesta(Constantes.MSG_EXITO);
			response.setProductos(list);
		}
		return response;
	}

	@Override
	public ProductResponse insertar(ProductoRequest request) {
		ProductResponse response=new ProductResponse();
		ProductoBean bean=new ProductoBean();
		
		bean.setNombre(request.getNombre());
		bean.setCantidad(request.getCantidad());
		bean.setPrecio(request.getPrecio());
		bean.setEstado(request.getEstado());
		bean.setFecha(request.getFecha());
		
		ProductoBean productoBean= this.productoDao.save(bean);
		response.setData(productoBean);
		
		return response;
	}

	@Override
	public boolean existsByNombre(String nombre) {
		return this.productoDao.existsByNombre(nombre);
	}
	
}
