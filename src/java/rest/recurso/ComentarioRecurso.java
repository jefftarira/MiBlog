package rest.recurso;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.modelo.Comentario;
import rest.servicio.ComentarioServicio;

@Path("/")
public class ComentarioRecurso {

  ComentarioServicio servicio = new ComentarioServicio();

  @GET
 
  public List<Comentario> getComentarios(@PathParam("articuloId") int articuloId) {
    return servicio.getComentarios(articuloId);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{comentarioId}")
  public Comentario getComentario(@PathParam("articuloId") int articuloId,
          @PathParam("comentarioId") int comentarioId) {
    return servicio.getComentario(articuloId, comentarioId);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Comentario addComentario(@PathParam("articuloId") int articuloId,
          Comentario comentario) {
    return servicio.addComentario(articuloId, comentario);
  }

  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{comentarioId}")
  public void deleteComentario(@PathParam("articuloId") int articuloId,
          @PathParam("comentarioId") int comentarioId) {
    servicio.deleteComentario(articuloId, comentarioId);
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{comentarioId}")
  public Comentario updateComentario(@PathParam("articuloId") int articuloId,
          @PathParam("comentarioId") int comentarioId,
          Comentario comentario) {
    comentario.setId(comentarioId);
    return servicio.updateComentario(articuloId, comentario);
  }

}
