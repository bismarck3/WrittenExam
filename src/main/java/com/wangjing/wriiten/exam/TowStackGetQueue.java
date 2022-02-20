/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.TowStackGetQueue
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;

import java.util.LinkedList;

/**
 * TowStackGetQueue
 *
 * @description 用2个栈实现队列
 * @thinking
 * 栈：先进后出；队列：先进先出
 * 所以：出站的时候，利用一下栈的特性，重新入栈；原本先进的元素，会被放到out栈的栈顶，
 * 实现先出
 * @author wangjing
 * @date 2020/12/5 21:59
 * @version v1.0.0
 */
public class TowStackGetQueue {

    private LinkedList<Integer> intStack = new LinkedList<>();

    private LinkedList<Integer> outStack = new LinkedList<>();

    public void offer(Integer number) {
        intStack.push(number);
    }

    public Integer poll() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!intStack.isEmpty()) {
            Integer pop = intStack.pop();
            outStack.push(pop);
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        TowStackGetQueue queue = new TowStackGetQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

