/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutoria.Interface;

import tutoria.Modelo.Bicicleta;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar Nieto
 */
public interface InterfaceBicicleta extends CrudRepository<Bicicleta,Integer>{
    
}
