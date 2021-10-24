/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Servicios;

import tutoria.Modelo.Bicicleta;
import tutoria.Repositorio.BicicletaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosBicicleta {
        @Autowired
    private BicicletaRepositorio metodosCrud;
    
    public List<Bicicleta> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Bicicleta> getBicicleta(int idBicicleta){
        return metodosCrud.getBicicleta(idBicicleta);
    }
    
    public Bicicleta save(Bicicleta bicicleta){
        if(bicicleta.getId()==null){
            return metodosCrud.save(bicicleta);
        }else{
            Optional<Bicicleta> evt=metodosCrud.getBicicleta(bicicleta.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(bicicleta);
            }else{
                return bicicleta;
            }
        }
    }
    public Bicicleta update(Bicicleta bicicleta){
        if(bicicleta.getId()!=null){
            Optional<Bicicleta> e=metodosCrud.getBicicleta(bicicleta.getId());
            if(!e.isEmpty()){
                if(bicicleta.getName()!=null){
                    e.get().setName(bicicleta.getName());
                }
                if(bicicleta.getAddress()!=null){
                    e.get().setAddress(bicicleta.getAddress());
                }
                if(bicicleta.getExtension()!=null){
                    e.get().setExtension(bicicleta.getExtension());
                }
                if(bicicleta.getDescription()!=null){
                    e.get().setDescription(bicicleta.getDescription());
                }
                if(bicicleta.getCategory()!=null){
                    e.get().setCategory(bicicleta.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bicicleta;
            }
        }else{
            return bicicleta;
        }
    }


    public boolean deleteBicicleta(int bicicletaId) {
        Boolean aBoolean = getBicicleta(bicicletaId).map(bicicleta -> {
            metodosCrud.delete(bicicleta);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
