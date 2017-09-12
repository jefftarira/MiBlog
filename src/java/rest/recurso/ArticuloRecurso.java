package rest.recurso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import rest.modelo.Articulo;
import rest.servicio.ArticuloServicio;

@Path("/articulos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArticuloRecurso {

  ArticuloServicio servicio = new ArticuloServicio();

  @GET
  public List<Articulo> getArticulos(@QueryParam("autor") String autor,
          @QueryParam("year") int year,
          @QueryParam("mes") int month) {

    if (autor != null && autor.length() > 0) {
      return servicio.getArticuloPorAutor(autor);
    }

    if (year > 0 && month > 0) {
      return servicio.getArticuloPorFecha(year, month);
    }
    return servicio.getArticulos();
  }

  @GET
  @Path("/{articuloId}")
  public Articulo getArticulo(@PathParam("articuloId") int id) {
    return servicio.getArticulo(id);
  }

  @POST
  public Response addArticulo(Articulo articulo, @Context UriInfo uriInfo) throws URISyntaxException {
    Articulo respuesta = servicio.addArticulo(articulo);
    URI uri = uriInfo.getAbsolutePathBuilder()
            .path(String.valueOf(respuesta.getId()))
            .build();
    
    return Response.created(uri)
            .entity(respuesta)
            .build();
  }

  @DELETE
  @Path("/{articuloId}")
  public void deleteArticulo(@PathParam("articuloId") int id) {
    servicio.deleteArticulo(id);
  }

  @PUT
  @Path("/{articuloId}")
  public Articulo updateArticulo(@PathParam("articuloId") int id, Articulo articulo) {
    articulo.setId(id);
    return servicio.updateArticulo(articulo);
  }

  @Path("/{articuloId}/comentarios")
  public ComentarioRecurso getComentarios() {
    return new ComentarioRecurso();
  }

}
