/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import myapp.model.AzioneCorrettiva;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import myapp.model.Segnalazione;
import myapp.model.Utente;
import myapp.service.AzioneCorrettivaService;
import myapp.service.AzioneVerificaService;
import myapp.service.SegnalazioneService;
import myapp.service.SettoreService;
import myapp.service.UtenteService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
 
@Controller
@RequestMapping("/")
@ComponentScan("myapp.service")
public class AppController {
    /*
    @Autowired
    EmployeeService service;
    
    @Autowired
    FollowerService fservice;
    
    @Autowired
    CategoryService cservice;
    
    @Autowired
    EventService eservice;
    */
    
    @Autowired
    SettoreService settoreservice;
    
    @Autowired
    UtenteService utenteservice;
    
    @Autowired
    SegnalazioneService segnalazioneservice;
    
    @Autowired
    AzioneCorrettivaService azionecorrettivaservice;
    
    @Autowired
    AzioneVerificaService azioneverificaservice;
    
    /*
     * This method will list all existing employees.
     */
    /*
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("tutti", employees);
        return "impiegatil";
    }
 
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add";
    }

    
    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addEmpl(@ModelAttribute("employee") Employee e){
		
	if(e.getId() == 0) this.service.saveEmployee(e);
        else this.service.updateEmployee(e);
        
	return "redirect:/";
		
    }
	
    @RequestMapping("/remove/{id}")
    public String removeEmpl(@PathVariable("id") int id){
	this.service.deleteEmployee(id);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("employee", this.service.findById(id));
        return "edit";
    }
    
    @RequestMapping("/increment/{id}")
    public String incrementSalary(@PathVariable("id") int id, ModelMap model){
        this.service.incrementSalary(id);
        return "redirect:/";
    }
    
    @RequestMapping("/incrementsalary")
    public String incrementSalary2(ModelMap model){
        this.service.incrementSalary();
        return "redirect:/";
    }*/
    
    
    /*
           ROBA VECCHIA; SERVE PER ESEMPIO!!! NON TOCCARE!!!

    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("follower", new Follower());
        return "login2";
    }
    
    @RequestMapping(value = {"/checkLogin"}, method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("follower") Follower f, ModelMap model){
        model.addAttribute("user", f);
        List<Follower> followers = fservice.findAllFollowers();
        for(Follower fi : followers){
            if(fi.getUsername().equals(f.getUsername()) && fi.getPassword().equals(f.getPassword())) return "redirect:/showcategories";
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = {"/showcategories"}, method = RequestMethod.GET)
    public String showCategories(ModelMap model) {
        List<Category> categories = cservice.findAllCategories();
        //List<Event> events = eservice.findAllEvents();
        model.addAttribute("categories", categories);
        //model.addAttribute("events", events);
        return "categoriespage";
    }
    
    @RequestMapping(value = {"/showevents/{id}"})
    public String showEvents(@PathVariable("id") int id, ModelMap model){
        List<Event> events = cservice.findById(id).getEvents();
        model.addAttribute("events", events);
        return "eventspage";
    }
    
    @RequestMapping(value = {"/subscribe/{id}"})
    public String subscribe(@PathVariable("id") int id, ModelMap model){
        
        return "redirect:/showcateogires";
    }
    */
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }   

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("utente", new Utente());
        model.addAttribute("settori", settoreservice.findAllSettori());
        return "login";
    }
    
    @RequestMapping(value = {"/checkLogin"}, method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("utente") Utente u, ModelMap model){
        model.addAttribute("loggeduser", u);
        List<Utente> users = utenteservice.findAllUtenti();
        for(Utente ui : users){
            if(ui.getUsername().equals(u.getUsername()) && ui.getPassword().equals(u.getPassword())){
                if(ui.getResponsabile() == 'N') return "redirect:/showmenuUtente";
                else return "redirect:/showmenuResp";
            }
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = {"/showmenuUtente"}, method = RequestMethod.GET)
    public String showMenuUtente(ModelMap model) {
        model.addAttribute("azionicorrettive", azionecorrettivaservice.findAllAzioniCorrettive());
        model.addAttribute("azioniverifica", azioneverificaservice.findAllAzioniVerifica());
        return "menuUtente";
    }
    
    @RequestMapping(value = {"/showmenuResp"}, method = RequestMethod.GET)
    public String showMenuResp(ModelMap model) {
        model.addAttribute("segnalazioni", segnalazioneservice.findAllSegnalazioni());
        model.addAttribute("azionicorrettive", azionecorrettivaservice.findAllAzioniCorrettive());
        //model.addAttribute("azioniverifica", azioneverificaservice.findAllAzioniVerifica());
        return "menuResp";
    }
    
    @RequestMapping(value = {"/apriSegnalazione"}, method = RequestMethod.GET)
    public String apriSegnalazione(ModelMap model){
        model.addAttribute("segnalazione", new Segnalazione());
        return "segnalazione";
    }
    
    @RequestMapping(value= {"/apriSegnalazione"}, method = RequestMethod.POST)
    public String apriSegnalazione(@ModelAttribute("segnalazione") Segnalazione s, ModelMap model){
		
	if(s.getId() == 0) this.segnalazioneservice.saveSegnalazione(s);
        else this.segnalazioneservice.saveSegnalazione(s);
	return "redirect:/showmenuUtente";
		
    }
    
    @RequestMapping("/removeSe/{id}")
    public String rimuoviSegnalazione(@PathVariable("id") int id){
	//this.segnalazioneservice.deleteSegnalazione(id);
        return "redirect:/showmenuResp";
    }
    
    
    @RequestMapping(value = {"/apriAzioneCorrettiva/{id}"}, method = RequestMethod.GET)
    public String apriAzioneCorrettiva(@PathVariable("id") int id, ModelMap model){
        //this.segnalazioneservice.deleteSegnalazione(id);
        model.addAttribute("azionecorrettiva", new AzioneCorrettiva());
        return "azionecorrettiva";
    }
    
    @RequestMapping(value = {"/apriAzioneCorrettiva"}, method = RequestMethod.POST)
    public String apriAzioneCorrettiva(@ModelAttribute("azionecorrettiva") AzioneCorrettiva ac, ModelMap model){
        if(ac.getId() == 0) this.azionecorrettivaservice.saveAzioneCorrettiva(ac);
        else this.azionecorrettivaservice.saveAzioneCorrettiva(ac);
        return "redirect:/showmenuUtente";
    }
    
    @RequestMapping(value = {"/apriAzioneVerifica/{id}"}, method = RequestMethod.GET)
    public String apriAzioneVerifica(@PathVariable("id") int id, ModelMap model){
        //this.azionecorrettivaservice.deleteAzioneCorrettiva(id);
        //model.addAttribute("azioneverifica", new AzioneVerifica()); QUESTO BISOGNA ANCORA FARLO
        return "segnalazione";
    }
}
