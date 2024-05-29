package com.example.web_3;

import jakarta.ejb.Stateless;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * EJB для управления результатами.
 */
@Stateless
public class ResultEJB implements Serializable {
    @PersistenceContext(unitName = "ExamplePU")
    private EntityManager entityManager;

    /**
     * Получает все результаты из базы данных.
     *
     * @return список всех результатов
     */
    public List<Result> getAllResults(){
        return entityManager.createQuery("SELECT r FROM Result r", Result.class).getResultList();
    }

    /**
     * Создает результат проверки.
     *
     * @param x координата X
     * @param y координата Y
     * @param r радиус области
     */
    public void makeResult(float x, float y, float r){
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("kk:mm:ss"));
        boolean isInside = new CheckResult().check(x, y, r);

        Result res = new Result();
        res.setX(x);
        res.setY(y);
        res.setR(r);
        res.setInside(isInside);
        res.setCurrentTime(currentTime);
        loadResult(res);
    }

    /**
     * Создает результат проверки из параметров SVG.
     */
    public void makeResultFromSVG() {
        try {
            float x = 0f;
            float y = 0f;
            float r = 0f;

            for (Object obj : FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().entrySet()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) obj;
                if (entry.getKey().equals("x")) {
                    x = Float.parseFloat(entry.getValue());
                } else if (entry.getKey().equals("y")) {
                    y = Float.parseFloat(entry.getValue());
                } else if (entry.getKey().equals("r")) {
                    r = Float.parseFloat(entry.getValue());
                }
            }

            makeResult(x, y, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаляет все данные из базы данных.
     */
    public void deleteData(){
        entityManager.createQuery("DELETE FROM Result").executeUpdate();
    }

    /**
     * Сохраняет результат в базе данных.
     *
     * @param res результат для сохранения
     */
    public void loadResult(Result res){
        entityManager.persist(res);
        entityManager.flush();
    }
}