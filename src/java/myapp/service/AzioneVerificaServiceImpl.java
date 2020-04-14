/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.AzioneVerificaDao;
import myapp.model.AzioneVerifica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author marco
 */
@Service("azioneverificaService")
@Transactional
public class AzioneVerificaServiceImpl implements AzioneVerificaService{
    @Autowired
    private AzioneVerificaDao dao;

    @Override
    public AzioneVerifica findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveAzioneVerifica(AzioneVerifica azioneverifica) {
        dao.saveAzioneVerifica(azioneverifica);
    }

    @Override
    public void deleteAzioneVerifica(int id) {
        dao.deleteAzioneVerifica(id);    
    }

    @Override
    public List<AzioneVerifica> findAllAzioniVerifica() {
        return dao.findAllAzioniVerifica();
    }
    
}
