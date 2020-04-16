/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import myapp.model.AzioneCorrettiva;
import myapp.model.AzioneVerifica;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import myapp.model.Segnalazione;
import myapp.model.Team;
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
    
    Utente loggeduser = null;
    int global_id;
    
    
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
        loggeduser = null;
        return "login";
    }
    
    //QUESTO METODO SERVE PER VERIFICARE SE IL LOGIN E' CORRETTO
    @RequestMapping(value = {"/checkLogin"}, method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("utente") Utente u, ModelMap model){
        loggeduser = utenteservice.findById(u.getUsername());
        List<Utente> users = utenteservice.findAllUtenti();
        for(Utente ui : users){
            if(ui.getUsername().equals(u.getUsername()) && ui.getPassword().equals(u.getPassword())){
                if(ui.getResponsabile() == 'N') return "redirect:/showmenuUtente";
                else return "redirect:/showmenuResp";
            }
        }
        return "redirect:/";
    }
    
    //QUESTO METODO SERVE PER FAR VEDERE IL MENU DELL'UTENTE
    @RequestMapping(value = {"/showmenuUtente"}, method = RequestMethod.GET)
    public String showMenuUtente(ModelMap model) {
        /*List<AzioneCorrettiva> ac = azionecorrettivaservice.findAllAzioniCorrettive();
        ArrayList<AzioneCorrettiva> acu = new ArrayList<AzioneCorrettiva>();
        List<Team> lt = loggeduser.getTeam();
        for(AzioneCorrettiva a: ac){
            for(Team t : lt){
                if(t.getNome().equals(a.getTeam().getNome())) acu.add(a);
            }
        }*/
        //model.addAttribute("azioniverifica", azioneverificaservice.findAllAzioniVerifica());
        model.addAttribute("loggedusername", loggeduser.getNome() + " " + loggeduser.getCognome());
        model.addAttribute("azionicorrettive", azionecorrettivaservice.findAllAzioniCorrettive());
        return "menuUtente";
    }
    
    //QUESTO METODO SERVE PER FAR VEDERE IL MENU DEL RESPONSABILE
    @RequestMapping(value = {"/showmenuResp"}, method = RequestMethod.GET)
    public String showMenuResp(ModelMap model) {
        model.addAttribute("loggedusername", loggeduser.getNome() + " " + loggeduser.getCognome());
        model.addAttribute("segnalazioni", segnalazioneservice.findAllSegnalazioni());
        model.addAttribute("azionicorrettive", azionecorrettivaservice.findAllAzioniCorrettive());
        //model.addAttribute("azioniverifica", azioneverificaservice.findAllAzioniVerifica());
        return "menuResp";
    }
    
    //QUESTO METODO SERVE PER APRIRE IL FORM PER SALVARE UNA SEGNALAZIONE
    @RequestMapping(value = {"/apriSegnalazione"}, method = RequestMethod.GET)
    public String apriSegnalazione(ModelMap model){
        model.addAttribute("segnalazione", new Segnalazione());
        model.addAttribute("username", loggeduser.getUsername());
        model.addAttribute("settore", loggeduser.getSettore().getId());
        return "segnalazione";
    }
    
    //QUESTO METODO SERVE PER SALVARE LA SEGNALAZIONE
    @RequestMapping(value= {"/apriSegnalazione"}, method = RequestMethod.POST)
    public String apriSegnalazione(@ModelAttribute("segnalazione") Segnalazione s, ModelMap model){
	this.segnalazioneservice.saveSegnalazione(s);
	return "redirect:/showmenuUtente";
		
    }
    
    //QUESTO METODO SERVE PER APRIRE IL FORM PER SALVARE UN'AZIONE CORRETTIVA
    @RequestMapping(value = {"/apriAzioneCorrettiva/{id}"}, method = RequestMethod.GET)
    public String apriAzioneCorrettiva(@PathVariable("id") int id, ModelMap model){
        global_id = id;
        model.addAttribute("azionecorrettiva", new AzioneCorrettiva());
        model.addAttribute("segnalazione", id);
        return "azionecorrettiva";
    }
    
    //QUESTO METODO SERVE PER SALVARE L'AZIONE CORRETTIVA
    @RequestMapping(value = {"/apriAzioneCorrettiva"}, method = RequestMethod.POST)
    public String apriAzioneCorrettiva(@ModelAttribute("azionecorrettiva") AzioneCorrettiva ac, ModelMap model){
        //this.segnalazioneservice.deleteSegnalazione(global_id);
        this.azionecorrettivaservice.saveAzioneCorrettiva(ac);
        return "redirect:/showmenuUtente";
    }
    
    //QUESTO METODO SERVE PER APRIRE IL FORM PER SALVARE UN'AZIONE DI VERIFICA
    @RequestMapping(value = {"/apriAzioneVerifica/{id}"}, method = RequestMethod.GET)
    public String apriAzioneVerifica(@PathVariable("id") int id, ModelMap model){
        //global_id = id;
        //model.addAttribute("azioneverifica", new AzioneVerifica()); 
        //model.addAttribute("azionecorrettiva", id);
        return "azioneverificafk";
    }
    
    //QUESTO METODO SERVER PER SALVARE IL FORM CON L'AZIONE DI VERIFICA
    @RequestMapping(value = {"/apriAzioneVerifica"}, method = RequestMethod.GET)
    public String apriAzioneVerifica(@ModelAttribute("azioneverifica") AzioneVerifica av, ModelMap model){
        //this.azionecorrettivaservice.deleteAzioneCorrettiva(global_id);
        //this.azioneverificaservice.saveAzioneVerifica(av);
        return "azioneverificafk";
    }
    
    //QUESTO METODO SERVE PER FARE IL LOGOUT
    @RequestMapping(value= {"/logout"}, method = RequestMethod.POST)
    public String logout(){
	return "redirect:/";
    }
    
    //QUESTI METODI SERVONO PER FAR VEDERE LE PAGINE CONTENENTI LE TABELLE CON I DATI CHE ANDIAMO A RICAVARE (QUIDNI SEGNALAZIONI, AZIONI CORRETTIVE E AZIONI DI VERIFICA
    @RequestMapping(value = {"/mostraSE"}, method = RequestMethod.POST)
    public String mostraSE(ModelMap model){
        model.addAttribute("segnalazioni", segnalazioneservice.findAllSegnalazioni());
        return "segnalazionipage";
    }
    
    @RequestMapping(value = {"/mostraAC"}, method = RequestMethod.POST)
    public String mostraAC(ModelMap model){
        model.addAttribute("azionicorrettive", azionecorrettivaservice.findAllAzioniCorrettive());
        if('N' == loggeduser.getResponsabile()) return "azionicorrettivepage";
        else return "azionicorrettivepageresp";
    }
    
    @RequestMapping(value = {"/mostraAV"}, method = RequestMethod.POST)
    public String mostraAV(ModelMap model){
        /*model.addAttribute("azioniverifica", azioneverificaservice.findAllAzioniVerifica());
        if('N' == loggeduser.getResponsabile()) return "azioniverificapage";
        else return "azioniverificapageresp";*/
        if('N' == loggeduser.getResponsabile()) return "azioniverificapagefk";
        else return "azioniverificapagerespfk";
    }
    
    //QUESTO METODO SERVE PER TORNARE AL MENU DA UNA DELLE PAGINE PRECEDENTI
    @RequestMapping(value= {"/backtout"}, method = RequestMethod.POST)
    public String backtout(ModelMap model){
	if('N' == loggeduser.getResponsabile()) return "redirect:/showmenuUtente"; 
        else return "redirect:/showmenuResp";
    }
    
    //QUESTO METODO SERVE PER RIMUOVERE UNA SEGNALAZIONE
    @RequestMapping("/removeSe/{id}")
    public String rimuoviSegnalazione(@PathVariable("id") int id){
        //global_id = id;
        //this.segnalazioneservice.deleteSegnalazione(id);
        return "redirect:/showmenuResp";
    }
    
    /*
    QUESTI METODI DANNO DEI PROBLEMI QUINDI NON POSSIAMO USARLI
    //QUESTO METODO APRE LA PAGINA DI CONFERMA DELLA RIMOZIONE
    @RequestMapping("/confirm/{id}")
    public String confirmremove(@PathVariable("id") int id, ModelMap model){
        //global_id = id;
        return "confirmremove";
    }
    
    //QUESTO METODO SERVE PER RIMUOVERE UNA SEGNALAZIONE
    @RequestMapping("/removeSe")
    public String rimuoviSegnalazione(ModelMap model){
        //this.segnalazioneservice.deleteSegnalazione(global_id);
        if('N' == loggeduser.getResponsabile()) return "redirect:/showmenuUtente"; 
        else return "redirect:/showmenuResp";
    }*/
    
    //QUESTO METODO SERVE PER RIMUOVERE UN'AZIONE DI VERIFICA
    @RequestMapping("/removeAV/{id}")
    public String rimuoviAzioneVerifica(@PathVariable("id") int id){
	//this.azioneverificaservice.deleteAzioneVerifica(id);
        return "redirect:/showmenuResp";
    }
}
