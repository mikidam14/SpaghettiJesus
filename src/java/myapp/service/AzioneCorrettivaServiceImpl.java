/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.AzioneCorrettivaDao;
import myapp.model.AzioneCorrettiva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("azionecorrettivaService")
@Transactional
public class AzioneCorrettivaServiceImpl implements AzioneCorrettivaService{
    @Autowired
    private AzioneCorrettivaDao dao;
    
    @Override
    public AzioneCorrettiva findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveAzioneCorrettiva(AzioneCorrettiva azionecorrettiva) {
        dao.saveAzioneCorrettiva(azionecorrettiva);
    }

    @Override
    public void deleteAzioneCorrettiva(int id) {
        dao.deleteAzioneCorrettiva(id);
    }

    @Override
    public List<AzioneCorrettiva> findAllAzioniCorrettive() {
        return dao.findAllAzioniCorrettive();
    }
    
}
