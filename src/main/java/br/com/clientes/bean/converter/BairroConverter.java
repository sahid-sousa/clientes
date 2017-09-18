/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.bean.converter;

import br.com.clientes.entidades.Bairro;
import br.com.clientes.rn.BairroRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author SHD
 */
@FacesConverter(value = "conversorDeBairro")
public class BairroConverter implements Converter {

    private BairroRN RN = new BairroRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.trim().isEmpty() || "null".equalsIgnoreCase(string)) {
            return null;
        }
        try {
            return RN.obter(Integer.valueOf(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || !(o instanceof Bairro)) {
            return null;
        }
        Bairro bairro = (Bairro) o;
        if (bairro.getId() == null) {
            return null;
        }
        return String.valueOf(bairro.getId());
    }
}
