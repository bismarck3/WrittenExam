/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.GetRepeatNumber
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * GetRepeatNumber
 *
 * @description 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * @thinking 对于这种数组元素在 [0, n-1] 范围内的问题，
 * 可以将值为 i 的元素调整到第 i 个位置上进行求解。
 * @author wangjing
 * @date 2020/11/15 16:11
 * @version v1.0.0
 */
public class GetRepeatNumber {

    private static int getRepeatNumber(int[] numbers) {
        int duplicationNumber;
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplicationNumber = numbers[i];
                    return duplicationNumber;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] numbers, int i, int number) {
        int temp = numbers[i];
        numbers[i] = numbers[number];
        numbers[number] = temp;
    }

    public static void main(String[] args) {
        System.out.println(getRepeatNumber(new int[] {2, 3, 1, 0, 2, 5}));
    }
}
