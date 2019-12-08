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
    private Funcionario funcionario;
    protected Mesa next;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Mesa getNext() {
        return next;
    }

    public void setNext(Mesa next) {
        this.next = next;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
            return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
            this.funcionario = funcionario;
    }
	
}
