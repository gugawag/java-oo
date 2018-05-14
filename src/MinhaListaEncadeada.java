import java.util.*;

public class MinhaListaEncadeada implements MinhaLista {
	private Nodo cabe�alho = new Nodo(null, null, null);

	private int contadorDeElementos = 0;

	public MinhaListaEncadeada() {
		cabe�alho.pr�ximo = cabe�alho.anterior = cabe�alho;
	}

	public int size() {
		return contadorDeElementos;
	}

	public boolean add(Object elemento) {
		adicionarAntes(elemento, cabe�alho);
		return true;
	}

	private Nodo adicionarAntes(Object elemento, Nodo nodo) {
		Nodo novoNodo = new Nodo(elemento, nodo, nodo.anterior);
		novoNodo.anterior.pr�ximo = novoNodo;
		novoNodo.pr�ximo.anterior = novoNodo;
		contadorDeElementos++;
		return novoNodo;
	}

	public void add(int index, Object elemento) {
		adicionarAntes(elemento, (index == contadorDeElementos ? cabe�alho
				: nodoNoIndex(index)));
	}

	private Nodo nodoNoIndex(int index) {
		if (index < 0 || index >= contadorDeElementos) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ ", Tamanho: " + contadorDeElementos);
		}
		Nodo nodo = cabe�alho;
		if (index < contadorDeElementos / 2) {
			for (int i = 0; i <= index; i++) {
				nodo = nodo.pr�ximo;
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
			for (Nodo nodo = cabe�alho.pr�ximo; nodo != cabe�alho; nodo = nodo.pr�ximo) {
				if (nodo.elemento == null) {
					remove(nodo);
					return true;
				}
			}
		} else {
			for (Nodo nodo = cabe�alho.pr�ximo; nodo != cabe�alho; nodo = nodo.pr�ximo) {
				if (elemento.equals(nodo.elemento)) {
					remove(nodo);
					return true;
				}
			}
		}
		return false;
	}

	private void remove(Nodo nodo) {
		if (nodo == cabe�alho) {
			throw new NoSuchElementException();
		}
		nodo.anterior.pr�ximo = nodo.pr�ximo;
		nodo.pr�ximo.anterior = nodo.anterior;
		contadorDeElementos--;
	}

	public void clear() {
		cabe�alho.pr�ximo = cabe�alho.anterior = cabe�alho;
		contadorDeElementos = 0;
	}

	public boolean contains(Object elemento) {
		return indexOf(elemento) >= 0;
	}

	public int indexOf(Object elemento) {
		int index = 0;
		if (elemento == null) {
			for (Nodo nodo = cabe�alho.pr�ximo; nodo != cabe�alho; nodo = nodo.pr�ximo) {
				if (nodo.elemento == null) {
					return index;
				}
				index++;
			}
		} else {
			for (Nodo nodo = cabe�alho.pr�ximo; nodo != cabe�alho; nodo = nodo.pr�ximo) {
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
		private Nodo �ltimoRetornado = cabe�alho; // para saber o que remover
													// no remove()

		private Nodo pr�ximo;

		private int pr�ximoIndex;

		ListItr() {
			pr�ximo = cabe�alho;
		}

		public boolean hasNext() {
			return pr�ximoIndex != contadorDeElementos;
		}

		public Object next() {
			if (pr�ximoIndex == contadorDeElementos) {
				throw new NoSuchElementException();
			}
			�ltimoRetornado = pr�ximo;
			pr�ximo = pr�ximo.pr�ximo;
			pr�ximoIndex++;
			return �ltimoRetornado.elemento;
		}

		public boolean hasPrevious() {
			return pr�ximoIndex != 0;
		}

		public Object previous() {
			if (pr�ximoIndex == 0) {
				throw new NoSuchElementException();
			}
			�ltimoRetornado = pr�ximo = pr�ximo.anterior;
			pr�ximoIndex--;
			return �ltimoRetornado.elemento;
		}

		public int nextIndex() {
			return pr�ximoIndex;
		}

		public int previousIndex() {
			return pr�ximoIndex - 1;
		}

		public void remove() {
			// chamada de remove de outra classe (LinkedList)
			MinhaListaEncadeada.this.remove(�ltimoRetornado);
			if (pr�ximo == �ltimoRetornado) {
				pr�ximo = �ltimoRetornado.pr�ximo;
			} else {
				pr�ximoIndex--;
			}
			�ltimoRetornado = cabe�alho;
		}

		public void set(Object elemento) {
			if (�ltimoRetornado == cabe�alho) {
				throw new IllegalStateException();
			}
			�ltimoRetornado.elemento = elemento;
		}

		public void add(Object elemento) {
			�ltimoRetornado = cabe�alho;
			adicionarAntes(elemento, pr�ximo);
			pr�ximoIndex++;
		}
	}

	private static class Nodo {
		Object elemento;

		Nodo pr�ximo;

		Nodo anterior;

		Nodo(Object elemento, Nodo pr�ximo, Nodo anterior) {
			this.elemento = elemento;
			this.pr�ximo = pr�ximo;
			this.anterior = anterior;
		}
	}
}
