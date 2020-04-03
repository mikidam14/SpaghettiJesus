/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Utente;

/**
 *
 * @author michele
 */
public interface UtenteService{
    Utente findById(int id);
    List<Utente> findAllUtenti();
}
