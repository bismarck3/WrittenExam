/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.ArraySearch
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * ArraySearch
 *
 * @description 二维数组查询
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * @thinking 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
 * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
 * 当前元素的查找区间为左下角的所有元素。
 * @author wangjing
 * @date 2020/11/15 16:20
 * @version v1.0.0
 */
public class ArraySearch {

    private boolean arraySearch(int[][] numbers, int target) {
        int rows = numbers.length, cols = numbers[0].length;
        int r = 0, c = cols -1;
        while (r <= rows -1 && c >= 0) {
            if (target == numbers[r][c]) {
                return true;
            }
            else if (target > numbers[r][c]) {
                r++;
            } else {
                c --;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
