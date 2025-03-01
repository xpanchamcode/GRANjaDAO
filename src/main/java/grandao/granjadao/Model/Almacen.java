package grandao.granjadao.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "almacen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Almacen {
    private Integer id;
    private String nombre;
    private String ubicacion;
}

