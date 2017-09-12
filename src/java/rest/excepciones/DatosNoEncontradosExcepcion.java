package rest.excepciones;

public class DatosNoEncontradosExcepcion extends RuntimeException {

  public DatosNoEncontradosExcepcion(String mensaje) {
    super(mensaje);    
  }

}
