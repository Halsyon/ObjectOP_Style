package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    /**
     * Проверка метода position. Создайте объект и вызовите у него метод position.
     * Проверьте, что он занимает ту же ячейку, что и при создании объекта.
     */

    @Test
    public void position() {
        BishopBlack bishB = new BishopBlack(Cell.A3); //какая позиция на старте
        assertThat(bishB.position(), is(Cell.A3));
    }

    /**
     * Проверка метода copy. Создайте объект и вызовите у него метод copy.
     * Проверьте, что, возвращенный объект имеет правильную позицию.
     */

    @Test
    public void copy() {
        BishopBlack bishB = new BishopBlack(Cell.A3);
        Figure bishF = bishB.copy(Cell.C1);
        assertThat(bishF.position(), is(Cell.C1));
    }

    /**
     * Далее создайте тест-метод для проверки метода way.
     * Для этого создайте объект с начальным положением C1.
     * Вызовите метод way с указанием C1 и G5.
     * Метод должен вернуть массив из 4 клеток. D2, E3, F4, G5.
     * После этого реализуйте метод way.
     */

    @Test // проверить работу исключения если фигура переместилась не по диагонали
    public void way() {
        BishopBlack bishS = new BishopBlack(Cell.C1);
        assertThat(bishS.way(Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}