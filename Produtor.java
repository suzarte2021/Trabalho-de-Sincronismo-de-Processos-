package ProdutorConsumidor;

public class Produtor extends Thread {

	private Buffer buffer;
	
	public Produtor(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		for (int i = 0; i< 5; i++) {
			this.buffer.inserir((i+1)*10);
			
		}
	}
}
