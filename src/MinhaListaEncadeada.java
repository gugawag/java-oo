import java.util.*;

public class MinhaListaEncadeada implements MinhaLista {
	private Nodo cabeçalho = new Nodo(null, null, null);

	private int contadorDeElementos = 0;

	public MinhaListaEncadeada() {
		cabeçalho.próximo = cabeçalho.anterior = cabeçalho;
	}

	public int size() {
		return contadorDeElementos;
	}

	public boolean add(Object elemento) {
		adicionarAntes(elemento, cabeçalho);
		return true;
	}

	private Nodo adicionarAntes(Object elemento, Nodo nodo) {
		Nodo novoNodo = new Nodo(elemento, nodo, nodo.anterior);
		novoNodo.anterior.próximo = novoNodo;
		novoNodo.próximo.anterior = novoNodo;
		contadorDeElementos++;
		return novoNodo;
	}

	public void add(int index, Object elemento) {
		adicionarAntes(elemento, (index == contadorDeElementos ? cabeçalho
				: nodoNoIndex(index)));
	}

	private Nodo nodoNoIndex(int index) {
		if (index < 0 || index >= contadorDeElementos) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ ", Tamanho: " + contadorDeElementos);
		}
		Nodo nodo = cabeçalho;
		if (index < contadorDeElementos / 2) {
			for (int i = 0; i <= index; i++) {
				nodo = nodo.próximo;
			}
		} else {
			for (int i = contadorDeElementos; i > index; i--) {
				nodo = nodo.anterior;
			}
		}
		return nodo;
	}

	public Object get(int index) {
		return nodoNoIndex(index).elemento;
	}

	public Object remove(int index) {
		Nodo nodo = nodoNoIndex(index);
		remove(nodo);
		return nodo.elemento;
	}

	public boolean remove(Object elemento) {
		if (elemento == null) {
			for (Nodo nodo = cabeçalho.próximo; nodo != cabeçalho; nodo = nodo.próximo) {
				if (nodo.elemento == null) {
					remove(nodo);
					return true;
				}
			}
		} else {
			for (Nodo nodo = cabeçalho.próximo; nodo != cabeçalho; nodo = nodo.próximo) {
				if (elemento.equals(nodo.elemento)) {
					remove(nodo);
					return true;
				}
			}
		}
		return false;
	}

	private void remove(Nodo nodo) {
		if (nodo == cabeçalho) {
			throw new NoSuchElementException();
		}
		nodo.anterior.próximo = nodo.próximo;
		nodo.próximo.anterior = nodo.anterior;
		contadorDeElementos--;
	}

	public void clear() {
		cabeçalho.próximo = cabeçalho.anterior = cabeçalho;
		contadorDeElementos = 0;
	}

	public boolean contains(Object elemento) {
		return indexOf(elemento) >= 0;
	}

	public int indexOf(Object elemento) {
		int index = 0;
		if (elemento == null) {
			for (Nodo nodo = cabeçalho.próximo; nodo != cabeçalho; nodo = nodo.próximo) {
				if (nodo.elemento == null) {
					return index;
				}
				index++;
			}
		} else {
			for (Nodo nodo = cabeçalho.próximo; nodo != cabeçalho; nodo = nodo.próximo) {
				if (elemento.equals(nodo.elemento)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}

	public Iterator iterator() {
		return new ListItr();
	}

	public ListIterator listIterator() {
		return new ListItr();
	}

	private class ListItr implements ListIterator {
		private Nodo últimoRetornado = cabeçalho; // para saber o que remover
													// no remove()

		private Nodo próximo;

		private int próximoIndex;

		ListItr() {
			próximo = cabeçalho;
		}

		public boolean hasNext() {
			return próximoIndex != contadorDeElementos;
		}

		public Object next() {
			if (próximoIndex == contadorDeElementos) {
				throw new NoSuchElementException();
			}
			últimoRetornado = próximo;
			próximo = próximo.próximo;
			próximoIndex++;
			return últimoRetornado.elemento;
		}

		public boolean hasPrevious() {
			return próximoIndex != 0;
		}

		public Object previous() {
			if (próximoIndex == 0) {
				throw new NoSuchElementException();
			}
			últimoRetornado = próximo = próximo.anterior;
			próximoIndex--;
			return últimoRetornado.elemento;
		}

		public int nextIndex() {
			return próximoIndex;
		}

		public int previousIndex() {
			return próximoIndex - 1;
		}

		public void remove() {
			// chamada de remove de outra classe (LinkedList)
			MinhaListaEncadeada.this.remove(últimoRetornado);
			if (próximo == últimoRetornado) {
				próximo = últimoRetornado.próximo;
			} else {
				próximoIndex--;
			}
			últimoRetornado = cabeçalho;
		}

		public void set(Object elemento) {
			if (últimoRetornado == cabeçalho) {
				throw new IllegalStateException();
			}
			últimoRetornado.elemento = elemento;
		}

		public void add(Object elemento) {
			últimoRetornado = cabeçalho;
			adicionarAntes(elemento, próximo);
			próximoIndex++;
		}
	}

	private static class Nodo {
		Object elemento;

		Nodo próximo;

		Nodo anterior;

		Nodo(Object elemento, Nodo próximo, Nodo anterior) {
			this.elemento = elemento;
			this.próximo = próximo;
			this.anterior = anterior;
		}
	}
}
