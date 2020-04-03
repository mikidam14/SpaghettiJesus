/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Segnalazione;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
public interface SegnalazioneDao {
    Segnalazione findById(int id);
    void saveSegnalazione(Segnalazione segnalazione);
    void deleteSeganalazione(int id);
    List<Segnalazione> findAllSegnalazioni();
}
