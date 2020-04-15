/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author marco
 */
@Entity
@Table(name = "AZIONE_VERIFICA")
public class AzioneVerifica implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IdVr")
    private int id;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "UTENTE", referencedColumnName = "Username")
    private Utente utente;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AZIONE_CORRETTIVA", referencedColumnName="IdCr")
    private AzioneCorrettiva azCr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public AzioneCorrettiva getAzioneCorrettiva() {
        return azCr;
    }

    public void setAzioneCorrettiva(AzioneCorrettiva azCr) {
        this.azCr = azCr;
    }
}
