package NovasClasses;

import list.FilaComPilha;

public class ClassFilaComPilha implements FilaComPilha {

    private ClassPilha _dados_1;
    private int _tamanho;

    public ClassFilaComPilha(){
        _dados_1 = new ClassPilha();
        _tamanho = 0;
    }


    @Override
    public void enqueue(int item) {
        ClassPilha temp = new ClassPilha();
        while (!_dados_1.isEmpty()) {
            temp.push(_dados_1.pop());
        }
        temp.push(item);
        while (!temp.isEmpty()) {
            _dados_1.push(temp.pop());
        }
        _tamanho++;
    }

    @Override
    public int dequeue() {
        _tamanho--;
        return _dados_1.pop();
       
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
