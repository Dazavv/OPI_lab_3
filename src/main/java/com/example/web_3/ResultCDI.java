package com.example.web_3;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * CDI бин для управления результатами.
 */
@Named
@SessionScoped
public class ResultCDI implements Serializable {

    /**
     * Координата X точки.
     */
    private float x;

    /**
     * Координата Y точки.
     */
    private float y;

    /**
     * Радиус области.
     */
    private float r;

    /**
     * Флаг, указывающий, находится ли точка внутри области.
     */
    private boolean isInside;

    /**
     * Текущее время проверки.
     */
    private String currentTime;

    /**
     * Внедренный EJB для управления результатами.
     */
    @Inject
    private ResultEJB resultEJB;

    /**
     * Получает координату X.
     *
     * @return координата X
     */
    public float getX() {
        return x;
    }

    /**
     * Устанавливает координату X.
     *
     * @param x координата X
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Получает координату Y.
     *
     * @return координата Y
     */
    public float getY() {
        return y;
    }

    /**
     * Устанавливает координату Y.
     *
     * @param y координата Y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Получает радиус области.
     *
     * @return радиус области
     */
    public float getR() {
        return r;
    }

    /**
     * Устанавливает радиус области.
     *
     * @param r радиус области
     */
    public void setR(float r) {
        this.r = r;
    }

    /**
     * Проверяет, находится ли точка внутри области.
     *
     * @return true, если точка внутри области, иначе false
     */
    public boolean isInside() {
        return isInside;
    }

    /**
     * Устанавливает, находится ли точка внутри области.
     *
     * @param inside true, если точка внутри области, иначе false
     */
    public void setInside(boolean inside) {
        isInside = inside;
    }

    /**
     * Получает текущее время.
     *
     * @return текущее время
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * Устанавливает текущее время.
     *
     * @param currentTime текущее время
     */
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Создает результат проверки.
     */
    public void makeResult(){
        resultEJB.makeResult(x, y, r);
    }

    /**
     * Создает результат проверки из параметров SVG.
     */
    public void makeResultFromSVG(){
        resultEJB.makeResultFromSVG();
    }

    /**
     * Удаляет все данные.
     */
    public void deleteData(){
        resultEJB.deleteData();
    }

    /**
     * Получает все результаты.
     *
     * @return список всех результатов
     */
    public List<Result> getAllResults(){
        return resultEJB.getAllResults();
    }
}
