package myapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author michele
 */
@Entity
@Table(name="EVENT")
public class Event implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id_E")
    private int id;
 
    @Column(name = "Name")
    private String name;
 
 
    @Column(name = "Date")
    private Date date;
	
    @Column(name = "Description")
    private String description;
	
    
    @JoinColumn(name = "Category", referencedColumnName = "Id_C")
    @ManyToOne(optional = false)
    private Category category;
	
    //@ManyToMany (mappedBy = "events")
    //private Collection<Follower> followers;
    @JoinTable(name = "FOLLOWING", 
        joinColumns = @JoinColumn(name = "FId_E", referencedColumnName = "Id_E"),
        inverseJoinColumns = @JoinColumn(name = "FId_F", referencedColumnName = "Id_F"))
    @ManyToMany
    private List<Follower> followers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }
    
 }