package cn.gq.多线程;

import cn.gq.设计模式.abstractStatus.ThreadStatus;

/**
 * @author cherry_xx
 * @create 2022/3/24 21:58
 * @update 2022/3/24
 * Description:多线程的练习
 * @since 1.0.0
 */
public class MyThreadTest {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5, 6};
        char[] chars = new char[]{'a','b','c','d','e','f'};
        SynLock synLock = new SynLock();
        PrintNumber printNumber = new PrintNumber(num, synLock);
        PrintChar printChar = new PrintChar(chars, synLock);
        new Thread(new PrintThread(printNumber)).start();
        new Thread(new PrintThread(printChar)).start();

    }
}
interface  MyLock {
    void lock();
    void nuLock();

    void lock1();
    void nuLock1();
}

class SynLock implements MyLock {

    private  volatile Boolean flag = false;

    @Override

    public void lock() {
         while(flag) {
             Thread.yield();
         }
    }

    @Override
    public void nuLock() {
        flag = true;
    }

    @Override
    public void lock1() {
      while(!flag){
          Thread.yield();
      }
    }

    @Override
    public void nuLock1() {
        flag = false;
    }
}

class PrintNumber implements  Print {
    private int[] num;
    private MyLock mylock;
    PrintNumber(int [] num,MyLock mylock) {
        this.num = num;
        this.mylock = mylock;
    }
    @Override
    public void print() {
        for (int i : num) {
            mylock.lock();
            System.out.println("数字"+i);
            mylock.nuLock();
        }
    }
}

class PrintChar implements  Print {
    private char [] chars;
    private MyLock mylock;
    PrintChar(char [] chars,MyLock mylock) {
        this.chars = chars;
        this.mylock = mylock;
    }
    @Override
    public void print() {
        for (char a : chars) {
            mylock.lock1();
            System.out.println("字母"+a);
            mylock.nuLock1();
        }
    }
}

class PrintThread implements  Runnable , Print {

    private Print print;
    PrintThread(Print print) {
        this.print = print;
    }
    @Override
    public void run() {
        print();
    }

    @Override
    public void print() {
        print.print();
    }
}
interface  Print  {

    void print();
}