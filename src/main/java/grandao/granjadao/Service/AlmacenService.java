package grandao.granjadao.Service;

import grandao.granjadao.Model.Almacen;

public interface AlmacenService {
    void save(Almacen almacen, String rutaArchivo) throws Exception;
    Almacen getByRuta(String rutaArchivo) throws Exception;
}
