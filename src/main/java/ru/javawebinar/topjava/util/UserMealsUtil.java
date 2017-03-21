package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();


            }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> mealListBetween = new ArrayList<UserMealWithExceed>();
        for (int i=0; i<mealList.size(); i++) {
            boolean t = false;
            if (mealList.get(i).getCalories()>caloriesPerDay) t = true;
LocalTime thisTime = LocalTime.of(mealList.get(i).getDateTime().getHour(), mealList.get(i).getDateTime().getMinute());
        if (TimeUtil.isBetween(thisTime, startTime, endTime)) mealListBetween.add(new UserMealWithExceed(mealList.get(i).getDateTime(), mealList.get(i).getDescription(), mealList.get(i).getCalories(), t));

        }

        for (int l=0; l<mealListBetween.size(); l++) System.out.println(mealListBetween.get(l).getDateTime()+" "+mealListBetween.get(l).getDescription()+" "+mealListBetween.get(l).getCalories()+" "+mealListBetween.get(l).getExceed());
        return mealListBetween;
    }

}
