package pe.com.mau.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.mau.app.bean.ProductoEntity;
@Repository
public interface ProductoDao extends JpaRepository<ProductoEntity, Integer>{

}
