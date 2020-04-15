/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author marco
 */
@Entity
@Table(name="TEAM")
public class Team implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @Column(name = "IdTeam")
    private int idTeam;
	
    @Column(name = "Nome")
    private String nome;

    @JoinColumn(name = "SETTORE", referencedColumnName = "IdStr")
    @ManyToOne(optional = false)
    private Settore settore;  

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<AzioneCorrettiva> azionicorrettive;
    
    /*
    @ManyToMany(mappedBy="team")
    private List<Utente> utenti;
    
    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }*/
    
    
    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Settore getSettore() {
        return settore;
    }

    public void setSettore(Settore settore) {
        this.settore = settore;
    }

    public List<AzioneCorrettiva> getAzionicorrettive() {
        return azionicorrettive;
    }

    public void setAzionicorrettive(List<AzioneCorrettiva> azionicorrettive) {
        this.azionicorrettive = azionicorrettive;
    }
}
