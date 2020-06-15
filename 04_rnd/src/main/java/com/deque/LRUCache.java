package com.deque;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
    static Deque<Integer> dq;
    static HashSet<Integer> dqSet;
    static int n;

    public LRUCache(int n){
        dq = new LinkedList<>();
        dqSet = new HashSet<>();
        this.n = n;
    }

    public void refer(int x){
        if(!dqSet.contains(x)){
            if(dq.size() == n){
                int last = dq.removeLast();
                dqSet.remove(last);
                System.out.println("Miss :" + x);
            }
        } else {
/*            int index = 0;
            int i = 0;
            Iterator<Integer> itr = dq.iterator();

            while(itr.hasNext()){
                if(x == itr.next()){
                    index = i;
                    break;
                }
                i++;
            }*/
            dq.remove(x);
            dqSet.remove(x);
            System.out.println("hit: " + x);
        }

        dq.push(x);
        dqSet.add(x);
    }

    public void display (){
        Iterator<Integer> itr = dq.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public static void main(String... args){
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(4);
        ca.display();
        ca.refer(5);
        ca.display();
        ca.refer(6);
        ca.refer(5);
        ca.refer(4);
        ca.display();
        ca.refer(1);
        ca.display();
        ca.refer(3);
        ca.refer(2);
        ca.refer(1);
        ca.display();
    }
}

