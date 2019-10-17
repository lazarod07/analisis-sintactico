/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * @author lazarod
 */
public class Nodo {
    String prod;
    public Nodo link;
    public void setProd(String prod) {
        this.prod = prod;
    }
    

    public String getProd() {
        return prod;
    }

    public Nodo(String prod) {
        this.prod = prod;
    }
}
