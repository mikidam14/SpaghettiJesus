/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.AzioneVerifica;

/**
 * 
 * @author marco
 */
public interface AzioneVerificaService {
    AzioneVerifica findById(int id);
    void saveAzioneVerifica(AzioneVerifica azioneverifica);
    void deleteAzioneVerifica(int id);
    List<AzioneVerifica> findAllAzioniVerifica();
}
