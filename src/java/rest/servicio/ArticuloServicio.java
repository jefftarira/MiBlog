package rest.servicio;

import java.util.GregorianCalendar;
import java.util.List;
import rest.dao.BaseDeDatos;
import rest.modelo.Articulo;

public class ArticuloServicio {

  private List<Articulo> listado = BaseDeDatos.getInstancia().getListado();

  public List<Articulo> getArticulos() {
    return listado;
  }

  public Articulo getArticulo(int id) {
    for (Articulo articulo : listado) {
      if (articulo.getId() == id) {
        return articulo;
      }
    }
    return null;
  }

  public Articulo addArticulo(Articulo articulo) {
    articulo.setId(getMaximo());
    articulo.setCreado(new GregorianCalendar());
    listado.add(articulo);
    return articulo;
  }

  public Articulo updateArticulo(Articulo articulo) {
    int posicion = getPosicion(articulo.getId());
    try {
      listado.set(posicion, articulo);
    } catch (IndexOutOfBoundsException ex) {
      return null;
    }
    return articulo;
  }

  public void deleteArticulo(int id) {
    int posicion = getPosicion(id);
    listado.remove(posicion);

  }

  private int getPosicion(int id) {
    for (int i = 0; i < listado.size(); i++) {
      if (listado.get(i).getId() == id) {
        return i;
      }
    }
    return -1;
  }

  private int getMaximo() {
    int size = listado.size();
    if (size > 0) {
      return listado.get(size - 1).getId() + 1;
    } else {
      return 1;
    }
  }

}
