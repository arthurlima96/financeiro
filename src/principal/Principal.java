package principal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import servico.ServicoAlunosPendentes;

public class Principal {
	 public static void main(String[] args) {
		try {
			ServicoAlunosPendentes sap = new ServicoAlunosPendentes();
			
			LocateRegistry.createRegistry(1099);
			
			Naming.rebind("//localhost/alunosPendentes", sap);
			
			System.out.println("Servidor executando . . .");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
