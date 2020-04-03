/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Segnalazione;

/**
 *
 * @author michele
 */
public interface SegnalazioneService {
    Segnalazione findById(int id);
    List<Segnalazione> findAllSegnalazioni();
    void saveSegnalazione(Segnalazione segnalazione);
    void deleteSegnalazione(int id);
}
