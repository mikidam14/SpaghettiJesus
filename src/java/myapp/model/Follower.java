/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;
 
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author michele
 */
@Entity
@Table(name="FOLLOWER")
public class Follower implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id_F")
    private int id;
 
    @Column(name = "Username")
    private String username;
	
    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;
	
    //@ManyToMany(cascade = CascadeType.ALL )
    /*@JoinTable(
        username = "FOLLOWING", 
        joinColumns = { @JoinColumn(username = "Id_F" , referencedColumnName ="Id_F") }, 
        inverseJoinColumns = { @JoinColumn(username = "Id_E" , referencedColumnName = "Id_E") }
    )
    private List<Event> events;*/
    @ManyToMany(mappedBy = "followers")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
