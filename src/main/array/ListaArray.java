package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] _listaArray;
    private int _ultimoID;

    public int size(){
        return _ultimoID;
    }


    public ListaArray() {
        _listaArray = new int[5];
        _ultimoID = 0;
    }

    public int ultimoElemento(){
        return _listaArray[_ultimoID -1];
    }


    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < _ultimoID; i++) {
            if (_listaArray[i] == valor){
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if ((valor < 0) || (valor >= _ultimoID)){
            return -1;
        }
        return _listaArray[valor];
    }

    public int buscaIndiceValor(int valor){
        for (int i = 0; i < _ultimoID; i++) {
            if (_listaArray[i] == valor){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int minimo() {
        if (_ultimoID == 0) {
            return -1;
        }
        int minimo = _listaArray[0];
        for (int i = 1; i < _ultimoID; i++) {
            if (_listaArray[i] < minimo) {
                minimo = _listaArray[i];
            }
        }
        return minimo;
    }

    @Override
    public int maximo() {
        if (_ultimoID == 0) {
            return -1;
        }
        int maximo = _listaArray[0];
        for (int i = 1; i < _ultimoID; i++) {
            if (_listaArray[i] > maximo) {
                maximo = _listaArray[i];
            }
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        if ((valor > 1) && (valor < _ultimoID)) {
            int posicao = buscaIndiceValor(valor);
            if (posicao != -1) {
                return _listaArray[posicao - 1];
            } else
                return -1;
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        if ((valor > -1) && (valor < _ultimoID-1)) {
            int posicao = buscaIndiceValor(valor);
            if (posicao != -1) {
                return _listaArray[posicao + 1];
            } else
                return -1;
        } else {
            return -1;
        }
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice < _ultimoID) {
            int[] temparray = new int[_listaArray.length + 5];
            for (int i = 0; i < buscaIndice; i++) {
                temparray[i] = _listaArray[i];
            }
            temparray[buscaIndice] = valor;
            for (int i = buscaIndice + 1; i < _ultimoID; i++) {
                temparray[i] = _listaArray[i-1];
            }
            _listaArray = temparray;
            _ultimoID += 1;
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (_ultimoID >= _listaArray.length) {
            int [] listatemp = new int[_listaArray.length + 5];
            for (int i = 0; i < _listaArray.length; i++) {
                listatemp[i+1] = _listaArray[i];
            }
            _listaArray = listatemp;
            _listaArray[0] = valor;
            _ultimoID += 1;
        } else {
            for (int i = (_ultimoID -1); i > 0; i--) {
                _listaArray[i] = _listaArray[i-1];
            }
            _listaArray[0] = valor;
            _ultimoID += 1;
        }
    }

    @Override
    public void insereFim(int valor) {
        if (_ultimoID >= _listaArray.length) {
            int [] listatemp = new int[_listaArray.length + 5];
            for (int i = 0; i < _listaArray.length; i++) {
                listatemp[i] = _listaArray[i];
            }
            _listaArray = listatemp;
            _listaArray[_ultimoID] = valor;
            _ultimoID += 1;
        } else {
            _listaArray[_ultimoID] = valor;
            _ultimoID += 1;
        }
    }

    @Override
    public void remove(int valor) {
        if (remove(valor, false)){
            remove(valor);
        }
    }

    private boolean remove(int valor, boolean b){
        int posicao = buscaIndiceValor(valor);
        if (posicao != -1) {
            for (int i = posicao; i < _ultimoID - 1; i++) {
                _listaArray[i] = _listaArray[i + 1];
            }
            _ultimoID -= 1;
            return true;
        }
        return false;
    }


    @Override
    public void removeIndice(int indice) {
        if ((indice >= 0) && (indice < _ultimoID)) {
            for (int i = indice; i < _ultimoID - 1; i++) {
                _listaArray[i] = _listaArray[i + 1];
            }
            _ultimoID -= 1;
        }
    }


    @Override
    public void removeInicio() {
        removeIndice(0);
    }

    @Override
    public void removeFim() {
        removeIndice(_ultimoID - 1);
    }
    
}
