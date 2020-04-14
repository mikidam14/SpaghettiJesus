/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author michele
 */
@Entity
@Table(name="SEGNALAZIONE")
public class Segnalazione implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IdSgn")
    private int id;
    
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @Column(name = "Prodotto")
    private String prodotto;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "UTENTE", referencedColumnName = "Username")
    private Utente utente;
    
    @JoinColumn(name = "SETTORE", referencedColumnName = "IdStr")
    @ManyToOne(optional = false)
    private Settore settore;
    
    @OneToOne(mappedBy = "segnalazione")
    private AzioneCorrettiva azionecorrettiva;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Settore getSettore() {
        return settore;
    }

    public void setSettore(Settore settore) {
        this.settore = settore;
    }

    public AzioneCorrettiva getAzionecorrettiva() {
        return azionecorrettiva;
    }

    public void setAzionecorrettiva(AzioneCorrettiva azionecorrettiva) {
        this.azionecorrettiva = azionecorrettiva;
    }
}
