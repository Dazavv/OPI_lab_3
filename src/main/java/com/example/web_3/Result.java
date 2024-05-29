package com.example.web_3;

import jakarta.persistence.*;

/**
 * Класс, представляющий результат проверки попадания точки в область.
 */
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "x")
    private float x;

    @Column(name = "y")
    private float y;

    @Column(name = "r")
    private float r;

    @Column(name = "isInside")
    private boolean isInside;

    @Column(name = "currentTime")
    private String currentTime;

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
    public boolean getInside() {
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
}