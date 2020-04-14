/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.AzioneCorrettiva;

/**
 *
 * @author michele
 */
public interface AzioneCorrettivaService {
    AzioneCorrettiva findById(int id);
    void saveAzioneCorrettiva(AzioneCorrettiva azionecorrettiva);
    void deleteAzioneCorrettiva(int id);
    List<AzioneCorrettiva> findAllAzioniCorrettive();
}
