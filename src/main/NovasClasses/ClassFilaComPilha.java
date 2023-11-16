package NovasClasses;

import list.FilaComPilha;

public class ClassFilaComPilha implements FilaComPilha {

    private ClassPilha _dados_1,_dados_2;
    private int _tamanho;

    public ClassFilaComPilha(){
        _dados_1 = new ClassPilha();
        _tamanho = 0;
    }

    public ClassPilha trocar(ClassPilha a){
        ClassPilha temp = new ClassPilha();
        while (! a.isEmpty()) {
            temp.push(a.pop());
        }
        return temp;
    }


    @Override
    public void enqueue(int item) {
        _dados_1.push(item);
        _dados_2 = trocar(_dados_1);
        _tamanho++;
    }

    @Override
    public int dequeue() {
        int r = _dados_2.pop();
        _dados_1 = trocar(_dados_2);
        _tamanho--;
        return r;
    }

    @Override
    public boolean isEmpty() {
        return _dados_1.isEmpty();
    }

    @Override
    public int size() {
        return _tamanho;
    }
    
}
