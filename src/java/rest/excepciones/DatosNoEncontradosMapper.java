package rest.excepciones;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import rest.modelo.MensajeError;

@Provider
public class DatosNoEncontradosMapper
        implements ExceptionMapper<DatosNoEncontradosExcepcion> {
  
  @Override
  public Response toResponse(DatosNoEncontradosExcepcion e) {
    MensajeError mensaje = new MensajeError("Datos no encontrados", 404, "Esta información no se encuentra");
    return Response.status(Response.Status.NOT_FOUND)
            .entity(mensaje)
            .type(MediaType.APPLICATION_JSON)
            .build();
  }
  
}
