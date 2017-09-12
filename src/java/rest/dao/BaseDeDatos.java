package rest.dao;

import java.util.ArrayList;
import java.util.List;
import rest.modelo.Articulo;

public final class BaseDeDatos {

  private final static BaseDeDatos baseDeDatos = new BaseDeDatos();
  private final List<Articulo> listado = new ArrayList<>();

  private BaseDeDatos() {
    Articulo art1 = new Articulo(1, "Primer artículo", "Primer contenido", "Jeff");
    Articulo art2 = new Articulo(2, "Segundo artículo", "Segundo contenido", "Andrea");
    Articulo art3 = new Articulo(3, "Tercer artículo", "Tercer contenido", "Churi");

    listado.add(art1);
    listado.add(art2);
    listado.add(art3);
  }

  public static BaseDeDatos getInstancia() {
    return baseDeDatos;
  }

  public List<Articulo> getListado() {
    return listado;
  }

}
