/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Event;

/**
 *
 * @author michele
 */
public interface EventService {
    Event findById(int id);
    List<Event> findAllEvents();
}
