package ProdutorConsumidor;

public class Consumidor extends Thread {
	private Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
public void run() {
	for (int i = 0; i< 5; i++) {
		this.buffer.retirar();
		
	}
}
}
