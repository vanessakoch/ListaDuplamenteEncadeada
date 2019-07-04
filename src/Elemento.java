
public class Elemento {
	public Elemento p;
	public Elemento a;
	public Dado d;

	public Elemento(Dado d) {
		super();
		this.p = null;
		this.a = null;
		this.d = d;
	}

	public String toString() {
		return "" + d;
	}

}
