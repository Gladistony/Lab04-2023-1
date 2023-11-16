package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import NovasClasses.ClassFila;
import NovasClasses.ClassPilha;
import NovasClasses.ClassFilaComPilha;

public class AppTest {

    private ClassFila e;
    private ClassPilha f;
    private ClassFilaComPilha d;

    @Before
    public void setUp() throws Exception {
        e = new ClassFila();
        f = new ClassPilha();
        d = new ClassFilaComPilha();
    }

    @Test
    public void testFila() {
        e.enqueue(1);
        e.enqueue(2);
        e.enqueue(2);
        e.enqueue(5);
        assertEquals("Não é o primeiro " + 0, 1, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 5, e.dequeue());
    }

    @Test
    public void testPilha() {
        f.push(0);
        f.push(2);
        f.push(2);
        f.push(5);
        assertEquals("Não é o primeiro " + 0, 5, f.pop());
        assertEquals("Não é o primeiro " + 0, 2, f.pop());
        assertEquals("Não é o primeiro " + 0, 2, f.pop());
        assertEquals("Não é o primeiro " + 0, 0, f.pop());
    }

    @Test
    public void testFilaPilha() {
        d.enqueue(1);
        d.enqueue(2);
        d.enqueue(2);
        d.enqueue(5);
        assertEquals("Não é o primeiro " + 0, 1, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 5, d.dequeue());
    }

}
