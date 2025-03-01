package grandao.granjadao.Service;

import grandao.granjadao.Model.Almacen;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Override
    public void save(Almacen almacen, String rutaArchivo) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(almacen, new File(rutaArchivo));
    }
    @Override
    public Almacen getByRuta(String rutaArchivo) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Almacen) unmarshaller.unmarshal(new File(rutaArchivo));
    }
}
