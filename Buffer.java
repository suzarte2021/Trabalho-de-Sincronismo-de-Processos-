package ProdutorConsumidor;
import java.util.concurrent.Semaphore;
public class Buffer {

	// esse � o cara a ser armagenado
	
	private int item;
	private Semaphore semFull;   // semFull
	private Semaphore semEmpety; // semEmpty
	
	public Buffer() {
		this.semFull = new Semaphore(0); // Um Vazio
		this.semEmpety = new Semaphore(1);// Um cheio
		
	}
	
    public void inserir(int novoItem) { // Inserindo novo Item
    	try {
    		semEmpety.acquire(); // Tento acessar o sem�foro das posi�oes vazias
    	
    		// aqui � regiao critica
    		this.item = novoItem;
    		System.out.println("PRODUZIDO(" +this.item+")");
    		
    		semFull.release();
    		
    	}
    	catch(InterruptedException ex) {
    		System.out.println(" BUFFER: Erro ao inserir" +ex.getMessage());
    		
    		
    	}
}
    public void retirar() {
    	try {
    		semFull.acquire(); //tento acessar pelo sem�foro de posi�oes cheias
    		
    		System.out.println("CONSUMIDO ("+this.item+")");
    		semEmpety.release(); // Posicao nova para ser consumido
    	
    	}
    		catch(InterruptedException ex) {
        		System.out.println("BUFFER: Erro ao retirar" +ex.getMessage());

    		}
    	}
    }
    
    