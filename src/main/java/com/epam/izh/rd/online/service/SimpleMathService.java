package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        return(Integer.compare(value1, value2));
        /**
         *  if(value1 < value2) {
         *      return -1;
         *  } else if(value1 > value2) {
         *      return 1;
         *  } else {return 0;}
         *
         * Можно было сделать и так, но в одном из уроков призывали
         * пользоваться стандартными готовыми решениями
         *
         */
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Integer.max(value1, value2);
        // или так: return (value1 > value2) ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maximum = 0;
        for (int i:values) {
            maximum = Math.max(i, maximum);
        }
        return maximum;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int i:values) {
            sum += i;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        List<Integer> listEvenDigits = new ArrayList<Integer>();
        for (int i:values) {
            if (i % 2 == 0) {
                listEvenDigits.add(i);
            } else {
                continue;
            }
        }
        int[] arrayEvenDigits = new int[listEvenDigits.size()];
        for(int j = 0; j < listEvenDigits.size(); j++)  {
            arrayEvenDigits[j] = listEvenDigits.get(j);
        }
        return arrayEvenDigits;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long fact = 1;

        for (int i = 1; i <= initialVal; i++) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long prev = 0;
        long next = 1;
        long fib = 0;
        for (int i = 2; i <= number; i++) {
            fib = prev + next;
            prev = next;
            next = fib;
        }
        if (number >= 2) {
            return fib;
        } else if (number == 1) {
            return 1L;
        } else return 0L;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);
        return values;

        /**
         * Также возможен вариант без применения специализированных классов, например пузьком:
         *         for (int i = values.length - 1; i > 0; i--) {
         *             for (int j = 0; j < i; j++) {
         *                 if (values[j] > values[j+1]) {
         *                     int temp = values[j];
         *                     values[j] = values[j+1];
         *                     values[j+1] = temp;
         *                 }
         *             }
         *         }
         */
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        if (((number % 2 != 0) || (number == 2)) && ((number % 3 != 0) || (number == 3)) && ((number % 5 != 0) || (number == 5)) && ((number % 7 != 0) || (number == 7)) && (number != 1)) {
            return true;
        } else {
            return false;
        }
        /**
         * Есть ещё способ, реализованный в BigInteger:
         * Метод BigInteger.probablePrime(...)
         * генерирует случайное число и использует Тест Миллера для определения простое оно или нет,
         * в результате у числа вероятность быть составным не превышает 2^-100
         *
         * BigInteger bigInteger = BigInteger.valueOf(number);
         * return bigInteger.isProbablePrime((int) Math.log(number));
         */
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        for (int i = 0, j = values.length - 1; i < j; i++, j--) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        return values;
    }
}
