/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Web;

import tutoria.Modelo.Bicicleta;
import tutoria.Servicios.ServiciosBicicleta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Bike")
public class BicicletaWeb {
     @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    @Autowired
    private ServiciosBicicleta servicio;
    @GetMapping("all")
    public List <Bicicleta> getBicicleta(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Bicicleta> getOrthesis(@PathVariable("id") int idBicicleta) {
        return servicio.getBicicleta(idBicicleta);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicleta save(@RequestBody Bicicleta bicicleta) {
        return servicio.save(bicicleta);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicleta update(@RequestBody Bicicleta bicicleta) {
        return servicio.update(bicicleta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bicicletaId) {
        return servicio.deleteBicicleta(bicicletaId);
    }
}
