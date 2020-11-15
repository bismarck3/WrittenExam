/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.ReplaceSpace
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * ReplaceSpace
 *
 * @description 替换空格：将一个字符串中的空格替换成 "%20"。
 * @thinking 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。
 * 因为一个空格要替换成三个字符（%20），
 * 因此当遍历到一个空格时，需要在尾部填充两个任意字符。
 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。
 * P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，
 * 就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
 * 否则就填充上 P1 指向字符的值。
 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
 * @author wangjing
 * @date 2020/11/15 16:42
 * @version v1.0.0
 */
public class ReplaceSpace {

    private static String replaceSpace(String word) {
        StringBuilder bufferString = new StringBuilder(word);
        int p1 = word.length() - 1;
        for (int i = 0 ; i < p1 ; i++) {
            if (bufferString.charAt(i) == ' ') {
                // 每一个空格加2个任意字符
                bufferString.append("  ");
            }
        }
        int p2 = bufferString.length() - 1;
        while( p1 >= 0 && p2 > p1 ) {
            char c = bufferString.charAt(p1--);
            if (c == ' ') {
                bufferString.setCharAt(p2--, '0');
                bufferString.setCharAt(p2--, '2');
                bufferString.setCharAt(p2--, '%');
            } else {
                bufferString.setCharAt(p2--, c);
            }
        }
        return bufferString.toString();
    }

    public static void main(String[] args) {

    }
}
