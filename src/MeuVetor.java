import java.util.*;

public class MeuVetor implements MinhaLista {
  private final int CAPACIDADE_INICIAL = 10;
  protected Object elementos[];
  protected int contadorDeElementos;

  public MeuVetor() {
    this.elementos = new Object[CAPACIDADE_INICIAL];
    contadorDeElementos = 0;
  }

  public int size() {
    return contadorDeElementos;
  }

  public boolean add(Object elemento) {
    assegureCapacidade(contadorDeElementos + 1);
    elementos[contadorDeElementos++] = elemento;
    return true;
  }

  private void assegureCapacidade(int capacidadeMínima) {
    int capacidadeVelha = elementos.length;
    if(capacidadeMínima > capacidadeVelha) {
      Object dadosVelhos[] = elementos;
      int capacidadeNova = 2 * elementos.length;
      if(capacidadeNova < capacidadeMínima) {
        capacidadeNova = capacidadeMínima;
      }
      elementos = new Object[capacidadeNova];
      System.arraycopy(dadosVelhos, 0, elementos, 0, contadorDeElementos);
    }
  }

  public void add(int index, Object elemento) {
    if(index >= contadorDeElementos + 1) {
      throw new ArrayIndexOutOfBoundsException(index + " > " + contadorDeElementos);
    }
    assegureCapacidade(contadorDeElementos + 1);
    System.arraycopy(elementos, index, elementos, index + 1, contadorDeElementos - index);
    elementos[index] = elemento;
    contadorDeElementos++;
  }

  public Object get(int index) {
    if(index >= contadorDeElementos) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    return elementos[index];
  }

  public Object remove(int index) {
    if(index >= contadorDeElementos) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    Object valorVelho = elementos[index];
    int numMovidos = contadorDeElementos - index - 1;
    if(numMovidos > 0) {
      System.arraycopy(elementos, index+1, elementos, index, numMovidos);
    }
    elementos[--contadorDeElementos] = null; // Coleta de lixo deve ser feita
    return valorVelho;
  }

  public boolean remove(Object elemento) {
    int i = indexOf(elemento);
    if(i >= 0) {
      remove(i);
	    return true;
    }
    return false;
  }

  public void clear() {
    for(int i = 0; i < contadorDeElementos; i++) {
      elementos[i] = null; // Coleta de lixo deve ser feita
    }
    contadorDeElementos = 0;
  }

  public boolean contains(Object elemento) {
    return indexOf(elemento) >= 0;
  }

  public int indexOf(Object elemento) {
    if(elemento == null) {
      for(int i = 0; i < contadorDeElementos; i++) {
        if(elementos[i] == null) {
          return i;
        }
      }
    } else {
      for(int i = 0; i < contadorDeElementos; i++) {
        if(elemento.equals(elementos[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  public Iterator iterator() {
    return new Iterator() { // classe interna anônima
      int cursor = 0;

      public boolean hasNext() {
          return cursor < size();
      }

      public Object next() {
        try {
          Object next = get(cursor);
          cursor++;
          return next;
        } catch(IndexOutOfBoundsException e) {
          throw new NoSuchElementException();
        }
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
