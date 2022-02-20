/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.Fibonacci
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * Fibonacci
 *
 * @description 斐波那契
 *
 * @author wangjing
 * @date 2020/12/5 22:19
 * @version v1.0.0
 */
public class Fibonacci {

    public static int getNumber(int n) {
        if (n <= 1) {
            return n;
        }
        return getNumber(n-1) + getNumber(n-2);
    }

    public static int getNumber2(int n) {
        int[] numbers = new int[n+1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i < n+1; i++) {
            numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers[n];
    }

    public static void main(String[] args) {
        System.out.println(getNumber(4));
        System.out.println(getNumber2(4));
    }
}
