/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Оксана
 */
@ManagedBean
@ViewScoped
public class SearchPersonageBean {
    
    String nameFiler;

    public String getNameFiler() {
        return nameFiler;
    }

    public void setNameFiler(String nameFiler) {
        this.nameFiler = nameFiler;
    }
    /**
     * Creates a new instance of SearchPersonageBean
     */
    public SearchPersonageBean() {
    }
    
}
