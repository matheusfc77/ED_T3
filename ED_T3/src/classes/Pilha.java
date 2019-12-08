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
public class Pilha {
    private Processo topoPilha;
    
    public void inserir(Processo novo) {
        if (this.getTopoPilha() == null)
            this.setTopoPilha(novo);
        else {
            novo.next = this.getTopoPilha();
            this.setTopoPilha(novo);
        }
    }
    
    public Processo proxima() {
        if (this.getTopoPilha() != null) {
            Processo prox = this.getTopoPilha();
            this.setTopoPilha(this.getTopoPilha().next);
            return prox;
        }
        return null;
    }

    public Processo getTopoPilha() {
        return topoPilha;
    }

    public void setTopoPilha(Processo topoPilha) {
        this.topoPilha = topoPilha;
    }
    
    
    
    /*
        Processo newer;
	Processo older;
	int length;

	public void showFields(Object o) {
		Class<?> clazz = o.getClass();

		for (Field field : clazz.getDeclaredFields()) {
			// you can also use .toGenericString() instead of .getName(). This will
			// give you the type information as well.

			System.out.println(field.getName());
		}
		
	}

	public void add(Processo processo) {
		if (newer != null) {
			newer.next = processo;
			processo.before = newer;
		}
		newer = processo;
		length++;
	}

	public Processo get() {
		return newer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Processo processo = newer;
		builder.append("[");
		try {
			for (int i = length; i > 0; i--) {
				builder.append("{");
				builder.append(processo);
				builder.append("}");
				processo = processo.before;
			}
		} catch (Exception e) {
		}
		builder.append("]");
		return builder.toString();
	}
*/
}
