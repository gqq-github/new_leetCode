package cn.gq.多线程.锁;

/**
 * @author cherry_xx
 * @create 2021/4/10 12:35
 * @update 2021/4/10
 * Description: 所锁对象的学习
 * @since 1.0.0
 */
public class LearnLock {
    public static void main(String[] args) {
        OutClass tes = new OutClass("tes");
//        tes.inClass =

        OutClass.InClass inClass = tes.new InClass();
        tes.inClass = inClass;


        OutClass.InStaticClass inStaticClass = new OutClass.InStaticClass();
        inStaticClass.test();
        OutClass tes2 = new OutClass("tes222");

        OutClass tes3 = new OutClass("tes222");

//        System.out.println(tes.inClass.toString());
//        System.out.println(tes.inClass ==  tes2.inClass );
//        System.out.println(tes2.inClass ==  tes3.inClass );
//        System.out.println(tes2.inClass.toString());

//       new Thread(OutClass.InClass::addI).start();
//       new Thread(OutClass.InClass::addI).start();
        new Thread(tes,"tes").start();

        new Thread(tes2,"tes2").start();

        new Thread(tes3,"tes3").start();


//        tes.inClass = new OutClass.InClass();
//       new Thread(tes.inClass::addI).start();

    }
}
class OutClass implements Runnable {
    private String name;
    public static InClass inClass;
    public OutClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        inClass.addI();
    }

     class InClass {
        public InClass () {
          //  System.out.println("我被初始化");
        }
           synchronized  void  addI()  {
            System.out.println( Thread.currentThread().getName()+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
              System.out.println("我睡醒了"+Thread.currentThread().getName());
        }
   }
   static  class InStaticClass{
        public void test () {

        }
   }
}
