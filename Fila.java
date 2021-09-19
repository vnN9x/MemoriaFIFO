package memoriaFIFO;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	private List <String> fila = new ArrayList();
	
	public Fila(List <String> aFila) {
		this.fila = aFila;
	}
	
	public void pop() {
		this.fila.remove(0);
	}
	
	public void mostrarFila() {
		System.out.println(this.fila);
	}
	
	public void addFila(String caract) {
		this.fila.add(caract);
	}
	
	public boolean estaNaFila(String procura) {
		for(String p : this.fila) {
			if(p.equals(procura)) {
				return true;
			}
		}
		return false;
	}
}
