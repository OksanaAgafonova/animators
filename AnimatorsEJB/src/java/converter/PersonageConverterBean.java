/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import entity.Users2;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Оксана
 */
@ManagedBean
@FacesConverter(value = "personageConverter")
public class PersonageConverterBean implements Converter{
    
    @PersistenceContext(unitName = "AnimatorsEJBPU")
    private EntityManager em;
    
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of PersonageConverterBean
     */
    public PersonageConverterBean() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return em.find(Users2.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Users2) value).getId().toString();
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
