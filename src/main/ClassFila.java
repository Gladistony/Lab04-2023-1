import array.ListaArray;
import list.Fila;

public class ClassFila implements Fila {

    ListaArray _dados;

    public ClassFila(){
        _dados = new ListaArray();
    }

    @Override
    public void enqueue(int item) {
        _dados.insereFim(item);
    }

    @Override
    public int dequeue() {
        int v = _dados.buscaIndice(0);
        _dados.removeInicio();
        return v;
    }

    @Override
    public boolean isEmpty() {
        return _dados.buscaIndice(0) == -1;
    }

    @Override
    public int size() {
        return _dados.size();
    }
    
}
