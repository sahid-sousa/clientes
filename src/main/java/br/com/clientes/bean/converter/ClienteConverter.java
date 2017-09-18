/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.bean.converter;

import br.com.clientes.entidades.Cliente;
import br.com.clientes.rn.ClienteRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author SHD
 */
@FacesConverter(value = "conversorDeCliente")
public class ClienteConverter implements Converter {

    private ClienteRN RN = new ClienteRN();

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
        if (o == null || !(o instanceof Cliente)) {
            return null;
        }
        Cliente cliente = (Cliente) o;
        if (cliente.getId() == null) {
            return null;
        }
        return String.valueOf(cliente.getId());
    }
}
