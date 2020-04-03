/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.SegnalazioneDao;
import myapp.model.Segnalazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("segnalazioneService")
@Transactional
public class SegnalazioneServiceImpl implements SegnalazioneService{
    @Autowired
    private SegnalazioneDao dao;
    
    @Override
    public Segnalazione findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Segnalazione> findAllSegnalazioni() {
        return dao.findAllSegnalazioni();
    }

    @Override
    public void saveSegnalazione(Segnalazione segnalazione) {
        dao.saveSegnalazione(segnalazione);
    }

    @Override
    public void deleteSegnalazione(int id) {
        dao.deleteSeganalazione(id);
    }
    
}
