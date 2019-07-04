
public class Lista {
	public Elemento inicio;
	public int tamLista;

	public Lista() {
		super();
		this.inicio = null;
	}

	public void listarElemento() {
		Elemento i = inicio;
		if (i == null) {
			System.out.println("\nElemento(s) nao encontrado(s)");
		}
		System.out.println("");
		while (i != null) {
			System.out.println(" | ANTERIOR: " + i.a + " | ATUAL: " + i.d + " | PROXIMO: " + i.p + " | ");
			i = i.p;
		}
	}

	public boolean inserirElementoInicio(Dado d) {
		Elemento novo = new Elemento(d);
		Elemento i = inicio;
		novo.a = null;
		novo.p = i;
		inicio = novo;
		if (novo.p != null) {
			novo.p.a = novo;
		}
		tamLista++;
		return true;
	}

	public boolean inserirElementoFinal(Dado d) {
		Elemento novo = new Elemento(d);
		Elemento i = inicio;
		if (i == null) {
			inserirElementoInicio(d);
			return true;
		} else {
			while (i.p != null) {
				i = i.p;
			}
			i.p = novo;
			novo.a = i;
			novo.p = null;
			tamLista++;
			return true;
		}
	}

	public boolean inserirElementoIndice(Dado d, int id) {
		Elemento i = inicio;
		if (id < 0 || id > tamanho()) {
			return false;
		} else if (id == 0) {
			return inserirElementoInicio(d);
		} else {
			int idx = 0;
			Elemento novo = new Elemento(d);
			while (idx < id - 1) {
				i = i.p;
				idx++;
			}
			novo.p = i.p;
			i.p = novo;
			novo.a = i;
			if (novo.p != null) {
				novo.p.a = novo;
			}
			tamLista++;
		}
		return true;
	}

	public boolean removerInicio() {
		Elemento i = inicio;
		inicio = i.p;
		i.p.a = null;
		i = null;
		tamLista--;
		return true;
	}

	public boolean removerFim() {
		Elemento i = inicio;
		while (i.p != null) {
			i = i.p;
		}
		i.a.p = null;
		tamLista--;
		return true;
	}

	public boolean removerPorIndice(int id) {
		Elemento i = inicio;
		int idx = 0;
		Elemento aux = null;
		if (id < 0 || id > tamanho()) {
			return false;
		}
		if (i == null) {
			return false;
		}
		if (id == 0) {
			inicio = i.p;
			i.p.a = null;
			i = null;
			tamLista--;
			return true;
		} else {
			while (i.p != null && idx < id - 1) {
				i = i.p;
				idx++;
			}
			if (idx == id - 1) {
				aux = i.p;
				i.p = aux.p;
				i.p.a = i;
				aux = null;
				tamLista--;
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		Elemento i = inicio;
		int cont = 0;
		while (i != null) {
			cont++;
			i = i.p;
		}
		return cont;
	}

	public Elemento getIdElemento(int id) {
		int cont;
		Elemento i = inicio;
		Elemento elemento = null;
		if (i != null) {
			cont = 0;
			elemento = i;
			while (cont < id) {
				elemento = elemento.p;
				cont++;
			}
			return elemento;
		}
		return null;
	}

	public void selectionSort() {
		int i, j, menor;
		for (i = 0; i < tamLista - 1; i++) {
			menor = i;
			for (j = i + 1; j < tamLista; j++) {
				if (getIdElemento(j).d.getNumero() < getIdElemento(menor).d.getNumero())
					menor = j;
			}
			if (i != menor) {
				trocando(getIdElemento(i), getIdElemento(menor));
			}
		}
	}

	public void bubbleSort() {
		int i, j;
		for (i = 0; i < tamLista; i++) {
			for (j = 0; j < tamLista - i - 1; j++) {
				if (getIdElemento(j + 1) != null) {
					if (getIdElemento(j).d.getNumero() > getIdElemento(j + 1).d.getNumero()) {
						trocando(getIdElemento(j), getIdElemento(j + 1));
					}
				}
			}
		}
	}

	public void insertionSort() {
		int j, i;
		for (i = 1; i < tamLista; i++) {
			int temp = getIdElemento(i).d.getNumero();
			j = i;
			while (j > 0 && temp < getIdElemento(j - 1).d.getNumero()) {
				trocando(getIdElemento(j - 1), getIdElemento(j));
				j--;
			}
		}
	}

	public void trocando(Elemento aux1, Elemento aux2) {
		if (aux1 == inicio) {
			inicio = aux2;
		}
		Elemento temp = aux1.p;
		aux1.p = aux2.p;
		aux2.p = temp;

		if (aux1.p != null) {
			aux1.p.a = aux1;
		}
		if (aux2.p != null) {
			aux2.p.a = aux2;
		}

		temp = aux1.a;
		aux1.a = aux2.a;
		aux2.a = temp;

		if (aux1.a != null) {
			aux1.a.p = aux1;
		}
		if (aux2.a == null) {
			return;
		}
		aux2.a.p = aux2;
	}
}
