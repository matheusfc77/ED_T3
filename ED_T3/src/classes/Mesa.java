/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author matheus
 */
public class Mesa {
    private int numero;
    protected Mesa proximo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Mesa getProximo() {
        return proximo;
    }

    public void setProximo(Mesa proximo) {
        this.proximo = proximo;
    }
	
}
