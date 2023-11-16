import list.Pilha;
import array.ListaArray;

public class ClassPilha implements Pilha {

    ListaArray _dados; 

    public ClassPilha() {
        _dados =  new ListaArray();
    }    

    @Override
    public boolean isEmpty() {
        return _dados.buscaIndice(0) == -1;
    }

    @Override
    public void push(int item) {
        _dados.insereFim(item);
    }

    @Override
    public int pop() {
        int v = _dados.ultimoElemento();
        _dados.removeFim();
        return v;
    }
    
}
