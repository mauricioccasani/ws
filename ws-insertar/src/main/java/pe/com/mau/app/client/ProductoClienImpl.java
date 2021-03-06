package pe.com.mau.app.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;
import pe.com.mau.app.bean.response.ProductoResponse;
import pe.com.mau.app.util.PropertiesExterno;

@Service
@Log4j2
public class ProductoClienImpl implements ProductoClienInf {
	@Autowired
	private PropertiesExterno propExt;

	@Override
	public ProductoResponse obtener(String idTxt) {
		long tiempoInicio = System.currentTimeMillis();
		ProductoResponse response =new ProductoResponse(); 
		ObjectMapper objectMapper = new ObjectMapper();
		String responseJson = null;

		String url = propExt.urlProducto;
		Integer timeoutConexion= 2;
		Integer timeoutEjecucion = 5;

		try {

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	
			

			log.info("{} URL para obtener productos: ",idTxt,url);
			log.info("{} Tipo: {}",idTxt , HttpMethod.GET);
			
			
			
			HttpEntity<String> httpEntity = new HttpEntity<>(null,httpHeaders);

			SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
			httpRequestFactory.setConnectTimeout(timeoutConexion);
			httpRequestFactory.setReadTimeout(timeoutEjecucion);

			log.info("{} Timeout conexion (ms): {}",idTxt, timeoutConexion);
			log.info("{} Timeout ejecucion (ms): {}",idTxt,timeoutEjecucion);


			RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
			ResponseEntity<String> responseEntity = restTemplate.exchange(
					url, HttpMethod.GET, httpEntity, String.class);

			log.info("{} Servicio REST ejecutado",idTxt);

			responseJson = responseEntity.getBody();
			response = objectMapper.readValue(responseJson, ProductoResponse.class);

		}catch (HttpClientErrorException e) {
		
		
			log.error("{} Codigo Error Modificar  Orden : {}",idTxt,e.getStatusCode());
			log.error("{} Mensaje Error Modificar Orden : {}",idTxt, e.getResponseBodyAsString());
		} catch (Exception e) {
			
			log.error("{} Error en modificar orden: {}",idTxt , e.getMessage(), e);

		} finally {
			log.info("{} Datos de Salida:\n {}" ,idTxt, responseJson);
			log.info("{} Tiempo invocacion: {}" ,idTxt, (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos");
		}

		return response;
	}
}
