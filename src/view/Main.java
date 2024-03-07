package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kill = new KillController();
		int num = 0, pid = 0;
		String nome;
		while(num != 9) {
			num = Integer.parseInt(JOptionPane.showInputDialog(" Digite a opcao desejada"
					+ "\n 1 - Lista de Processos. \n 2 - Mata Processos por PID. \n 3 - "
					+ "Mata Processo por NOME. \n 9 - FINALIZAR. "));
			switch(num){
				case 1: kill.listaProcessos();
					break;
				case 2: pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo para eliminar."));
						kill.mataPid(pid);
					break;
				case 3: nome = JOptionPane.showInputDialog("Digite o NOME do processo para eliminar");
						kill.mataNome(nome);
					break;
				case 9: System.out.println("Processo Finalizado.");
					break;
				default: System.out.println("Opcao invalida.");
					break;
			}
		}
	}

}
