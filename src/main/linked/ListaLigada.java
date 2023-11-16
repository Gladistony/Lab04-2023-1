package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No _cabeca;

    public ListaLigada() {
        _cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        if (_cabeca == null) {
            return false;
        }
        for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (_cabeca == null) {
            return -1;
        }
        int posicao = 0;
        for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
            if (posicao == valor) {
                return atual.getValor();
            }
            posicao += 1;
        }
        return -1;
    }

    @Override
    public int minimo() {
        int minimum = _cabeca.getValor();
        for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() < minimum) {
                minimum = atual.getValor();
            }
        }
        return minimum;
    }

    @Override
    public int maximo() {
        int maximum = _cabeca.getValor();
        for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() > maximum) {
                maximum = atual.getValor();
            }
        }
        return maximum;
    }

    @Override
    public int predecessor(int valor) {
        if (valor > 1){
            int posicao = 1;
            for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
                if (posicao == valor) {
                    return atual.getValor();
                }
                posicao += 1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        int posicao = -1;
        for (No atual = _cabeca; atual != null; atual = atual.getProximo()) {
            posicao += 1;
            if (posicao == valor) {
                if (atual.getProximo() != null) {
                    return atual.getProximo().getValor();
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        No novo = new No(valor);
        if (_cabeca == null) {
            _cabeca = novo;
        } else {
            No atual = _cabeca;
            _cabeca = new No(valor);
            _cabeca.setProximo(atual);
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No novo = new No(valor);
        if (_cabeca == null) {
            _cabeca = novo;
        } else {
            No atual = _cabeca;
            int id_atual = 0;
            if (buscaIndice == 0){
                novo.setProximo(_cabeca);
                _cabeca = novo;
            } else {
                while (atual.getProximo() != null){
                    atual = atual.getProximo();
                    id_atual += 1;
                    if (id_atual == buscaIndice){
                        novo.setProximo(atual);
                        atual.setProximo(novo);
                    }
                }
            }
        }
    }

    @Override
    public void insereInicio(int valor) {
        insereElemento(valor);
    }

    @Override
    public void insereFim(int valor) {
        No novo = new No(valor);
        if (_cabeca == null) {
            _cabeca = novo;
        } else {
            for (No atual = _cabeca; atual != null; atual = atual.getProximo()){
                if (atual.getProximo() == null){
                    atual.setProximo(novo);
                    break;
                }
            }
        }
    }

    @Override
    public void remove(int valor) {
        if (_cabeca == null) {
            return;
        }
        if (_cabeca.getValor() == valor) {
            _cabeca = _cabeca.getProximo();
        } else {
            No atual = _cabeca;
            while (atual.getProximo() != null) {
                if (atual.getProximo().getValor() == valor) {
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
            }   
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (_cabeca == null) {
            return;
        }
        if (indice == 0) {
            _cabeca = _cabeca.getProximo();
        } else {
            No atual = _cabeca;
            int posicao = 0;
            while (atual.getProximo() != null) {
                if (posicao == indice - 1) {
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
                posicao += 1;
            }
        }
    }

    @Override
    public void removeInicio() {
        if (_cabeca == null) {
            return;
        }
        _cabeca = _cabeca.getProximo();
    }

    @Override
    public void removeFim() {
        if (_cabeca == null) {
            return;
        } 
        No atual = _cabeca;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getProximo() == null) {
                atual.setProximo(null);
                return;
            }
            atual = atual.getProximo();
        }
    }
    
}
