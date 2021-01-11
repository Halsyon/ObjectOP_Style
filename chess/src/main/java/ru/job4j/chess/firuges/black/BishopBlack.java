package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        this.position = ps;
    }

    /**
     * Метод используется для получения позиции фигуры на поле.
     * @return  возвращает тип перечисления.
     */
    @Override
    public Cell position() {
        return position;
    }

    /**
     * Метод возвращает массив с клетками,
     * которые должна пройти фигура от клетки position до клетки dest.
     */
    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) { //Пользователь может перетащить слона на клетку, которая отличается от диагонали.
            throw new IllegalStateException(//В этом случае наш код не будет работать. Давайте добавим в метод BishopBlack проверку.
                    String.format("Could not way by diagonal from %s to %s", position, dest));
        }
        int size = Math.abs(position().getX() - dest.getX()); //как определить размер?
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position().getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - position().getY() > 0 ? 1 : -1;
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
                x += deltaX;
                y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    /**
     * source где стоит фигура/ dest -куда ее хотят поставить
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    /**
     * Этот метод создаст объект класса с позицией dest.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
