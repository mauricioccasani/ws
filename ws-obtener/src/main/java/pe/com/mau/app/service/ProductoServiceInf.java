package pe.com.mau.app.service;

import pe.com.mau.app.bean.reques.ProductoRequest;
import pe.com.mau.app.bean.response.ProductResponse;
import pe.com.mau.app.bean.response.ProductoResponse;

public interface ProductoServiceInf {
 public ProductoResponse obtener();
 
 public ProductResponse insertar(ProductoRequest request);
 
 public boolean existsByNombre(String nombre);
}
