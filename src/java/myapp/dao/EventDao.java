/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Event;

/**
 *
 * @author michele
 */
public interface EventDao {
    Event findById(int id);
    void saveEvent(Event event);
    void deleteEvent(int id);
    List<Event> findAllEvents();
}
