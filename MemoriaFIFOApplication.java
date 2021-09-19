package memoriaFIFO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoriaFIFOApplication {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String resp = null;
		int count = 0;
		List <String>filaTemp = new ArrayList();
		
		System.out.println("ADICIONE UM UNICO CARACTERE POR VEZ A FILA DE MEMORIA \n"
				+ "PODERÃO SER ADICIONADO 5 CARACTERES \n"
				+ "'SAIR' ENCERRA O PROGRAMA");
		while(count < 5 && resp != "sair") {
			System.out.print(">>> ");
			resp = in.nextLine();
			resp = resp.strip();
			resp = resp.toLowerCase();
			if(resp.length() > 1) {
				System.out.println("INSTRUÇÃO INCORRETA. ENCERRANDO.");
				resp = "sair";
			}else {
				filaTemp.add(resp);
				count++;
			}
		}
		
		Fila fila = new Fila(filaTemp);
		
		System.out.println("INSIRA CARACTERES QUE SERÃO ACEITOS COMO SE FOSSEM INSTRUÇÕES DE MEMORIA \n"
				+ "UM CARACTERE POR INSTRUÇÃO \n"
				+ "A MEMORIA TEM CINCO INSTRUÇÕES SALVAS, TENTE ENTENDER O \n"
				+ "FUNCIONAMENTO DO ALGORITMO FIFO");
		while(resp != "sair") {
			System.out.print(">>> ");
			resp = in.nextLine();
			if(resp.length() > 1) {
				System.out.println("INSTRUÇÃO INCORRETA. ENCERRANDO.");
				resp = "sair";
			}else {
				if(fila.estaNaFila(resp)) {
					System.out.println("CARACTERE JÁ EXISTE NA MEMORIA!!! \n"
							+ "NENHUMA MUDANÇA NECESSÁRIA.");
				}else {
					System.out.println("CARACTERE NÃO DISPONIVEL NA FILA.");
					System.out.print("ESTADO ANTERIOR DA FILA: ");
					fila.mostrarFila();
					fila.pop();
					fila.addFila(resp);
				}
				System.out.print("ESTADO ATUAL DA FILA: ");
				fila.mostrarFila();
			}
		}
		in.close();
	}
}
