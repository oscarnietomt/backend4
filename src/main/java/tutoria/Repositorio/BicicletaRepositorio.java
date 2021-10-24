/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Modelo.Bicicleta;
import tutoria.Interface.InterfaceBicicleta;

/**
 *
 * @author USUARIO
 */
@Repository
public class BicicletaRepositorio {
      @Autowired
    private InterfaceBicicleta crud;
    

    public List<Bicicleta> getAll(){
        return (List<Bicicleta>) crud.findAll();       
    }
    
    public Optional <Bicicleta> getBicicleta(int id){
        return crud.findById(id);
    }
    
    public Bicicleta save(Bicicleta bicicleta){
        return crud.save(bicicleta);
    }
     public void delete(Bicicleta bicicleta){
        crud.delete(bicicleta);
    }
    
}
