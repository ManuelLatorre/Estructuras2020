package lineales.estaticas;

public class Cola {
	private int tama�o=10;
	private Object []array=new Object[this.tama�o];
	private int frente=0;
	private int fin=0;
	
	public Cola() {
	}
	
	public boolean poner(Object elem) {
		boolean exito=false;
		if((this.fin+1) % this.tama�o != frente) { //Como el array es circular con el mod obtengo el valor que obtendria "dando la vuelta"
			this.array[fin]=elem; //Al final de la cola pongo el elemento
			this.fin= (this.fin+1)%tama�o; //Mi nuevo final va a ser la siguiente posicion a la derecha (Dando la vuelta si llega al final del arreglo)
			exito=true;
		}	
		return exito;
	}
	
	public boolean sacar() {
		boolean exito=false;
		if(this.fin!=this.frente) {
			this.frente= (this.frente+1)%this.tama�o;
			exito=true;
		}
		return exito;
	}
	
	public Object obtenerFrente() {
		Object elem;
		if(this.frente==this.fin) {
			elem=null;
		}else {
			elem=array[this.frente];
		}
		return elem;
	}
	
	public boolean esVacia() {
		return this.frente==this.fin;
	}
	
	public void vaciar() {
		while(this.fin!=this.frente) {
			this.array[frente]=null;
			this.frente=(this.frente+1)%tama�o;
		}
		this.frente=0;
		this.fin=0;
		
	}
	
	public Cola clone() {
		Cola clon=new Cola();
		clon.frente=this.frente;
		clon.fin=this.fin;
		clon.array=this.array.clone();
		return clon;
	}
	
	public String toString() {
		String cadena= "FRENTE<--- " ;
		
		int flagFrente=this.frente;
		
		while(this.fin!=flagFrente) {
			cadena+= array[flagFrente];
			flagFrente= (flagFrente+1) % this.tama�o;
			if(this.fin!=flagFrente) {
				cadena+=", ";
			}
		}
		cadena+=" <---FIN";
		return cadena;
	}
	
}
