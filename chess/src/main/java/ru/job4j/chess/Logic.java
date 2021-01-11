package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32]; // массив на 32 элемента
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    } // на входе фигура, ее место в массиве

    public void move(Cell source, Cell dest) //
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        if (free(steps)) {
            figures[index] = figures[index].copy(dest);
        }

    }

    /**
     * Метод free должен пройтись по массиву figures и проверить,
     * что фигуры из не занимают элементы из массива cells.
     */

    private boolean free(Cell[] steps) throws OccupiedCellException { //
        for (Cell celX : steps) {
            System.out.println("координаты: " + celX.getX() + " " + celX.getY());
            Cell temp = Cell.findBy(celX.getX(), celX.getY());
            if (temp != null) {
                return false;
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
