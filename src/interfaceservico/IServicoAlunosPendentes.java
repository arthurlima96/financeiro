package interfaceservico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import principal.Aluno;

public interface IServicoAlunosPendentes extends Remote{
	
	public List<Aluno> listaAlunosComPendencias() throws RemoteException;
}
