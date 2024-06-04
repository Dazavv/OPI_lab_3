package com.example.web_3;

/**
 * Класс для проверки попадания точки в заданную область.
 */
public class CheckResult {

    /**
     * Проверяет, находится ли точка с координатами (x, y) внутри заданной области радиуса r.
     *
     * @param x координата X точки
     * @param y координата Y точки
     * @param r радиус области
     * @return true, если точка находится внутри области, иначе false
     */
    public boolean check (float x, float y, float r){
        // квадрат
        if (x >= 0 && y >= 0 && x <= r && y <= r / 2) return true;
        // треугольник
        if (x <= 0 && y <= 0 && ((-1 * x) + (-1 * y)) <= r) return true;
        // четверть круга
        if (x <= 0 && y >= 0 && ((x * x + y * y) <= r * r)) return true;
        else return false;
    }
}