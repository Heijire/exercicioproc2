package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	public void listaProcessos() {
		String os = os();
		String Lista;
		if(os.contains("Windows")) {
			Lista = "TASKLIST /FO TABLE";
		} else if(os.contains("Linux")) {
			Lista = "ps -ef";
			}	else {
					System.out.println("Sistema não suportado");
					return;
			}
		try {
			 Process proc = Runtime.getRuntime().exec(Lista);
			 InputStream fluxo = proc.getInputStream();
			 InputStreamReader leitor = new InputStreamReader(fluxo);
			 BufferedReader buffer = new BufferedReader(leitor);
			 String linha = buffer.readLine();
			 while(linha != null) {
				 System.out.println(linha);
				 linha = buffer.readLine();
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid(int parametro) {
		String os = os();
		StringBuffer buffer = new StringBuffer();
		if(os.contains("Windows")) {
			buffer.append("TASKKILL /PID");
		} else if (os.contains("Linux")) { 
			buffer.append("kill -9");
		}else {
			System.out.println("Sistema não Suportado");
		}
			buffer.append(" ");
			buffer.append(parametro);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
					e.printStackTrace();
			}
		}	
	public void mataNome(String parametro) {
		String os = os();
		StringBuffer buffer = new StringBuffer();
		if(os.contains("Windows")) {
			buffer.append("TASKKILL /IM");
		}	else if(os.contains("Linux")) {
			buffer.append("pkill -f");
			} 	else {
				System.out.println("Sistema não suportado");
			}
		buffer.append(" ");
		buffer.append(parametro);
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}