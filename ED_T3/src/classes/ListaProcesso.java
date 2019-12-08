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
public class ListaProcesso {
    private Processo inicioLista;
    private Processo fimLista;
    
    public void inserir(Processo novo) {
        if (this.getInicioLista() == null)
            this.setInicioLista(novo);
        else 
            this.getFimLista().setNext(novo);
        this.setFimLista(novo);
    }
    
    public Processo removerItem(int id) {
        Processo procRem = this.getInicioLista();
        while (procRem != null) {
            if (procRem.getId() == id) {
                Processo procAnt = this.getInicioLista();
                while (procAnt != null) {
                    if (procAnt.getNext() == procRem) {
                        procAnt.setNext(procRem.getNext());
                        return procRem;
                    } else
                        procAnt = procAnt.getNext();
                }
            } else
                procRem = procRem.getNext();
        }
        return null;
    }

    public Processo getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(Processo inicioLista) {
        this.inicioLista = inicioLista;
    }

    public Processo getFimLista() {
        return fimLista;
    }

    public void setFimLista(Processo fimLista) {
        this.fimLista = fimLista;
    }
    
    /*
	private Processo inicioLista;
	private Processo fimLista;

	public void add(Processo novo) {
		if (fimLista != null) {
			fimLista.next = novo;
		} else {
			inicioLista = novo;
		}
		fimLista = novo;
	}

	public Processo get(int index) {
		Processo aux = inicioLista;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux;

	}

	public void remove(int index) {
		Processo aux = inicioLista;
		if (index == 0) {
			inicioLista = inicioLista.next;
		} else {
			for (int i = 0; i < index-1; i++) {
				aux = aux.next;
			}
			aux.next = aux.next.next;
		}
	}
*/
}
