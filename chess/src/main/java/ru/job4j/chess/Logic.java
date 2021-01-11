package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32]; // массив на 32 элемента
    private int index = 0;

/** Метод добавляет фигуру в массив фигур
 * @param figure новая фигура *
 * */
    public void add(Figure figure) {
        figures[index++] = figure;
    }

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
     * что фигуры из него не занимают элементы из массива cells.
     */
    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (int i = 0; i < figures.length; i++) {
                for (int j = 0; j < steps.length; j++) {
                    if (figures[i] != null && figures[i].position().equals(steps[j])) {
                        throw new OccupiedCellException();
                    }
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
