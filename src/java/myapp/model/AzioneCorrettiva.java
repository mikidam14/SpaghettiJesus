/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name = "AZIONE_CORRETTIVA")
public class AzioneCorrettiva implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IdCr")
    private int id;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "TEAM", referencedColumnName = "IdTeam")
    private Team team;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SEGNALAZIONE", referencedColumnName="IdSgn")
    private Segnalazione segnalazione;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Segnalazione getSegnalazione() {
        return segnalazione;
    }

    public void setSegnalazione(Segnalazione segnalazione) {
        this.segnalazione = segnalazione;
    }
}
