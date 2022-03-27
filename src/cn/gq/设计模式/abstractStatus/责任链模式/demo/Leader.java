package cn.gq.设计模式.abstractStatus.责任链模式.demo;

import cn.gq.设计模式.abstractStatus.责任链模式.HandlerTask;

/**
 * @author cherry_xx
 * @create 2021/6/27 23:06
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public abstract class Leader {
    private Leader next;
    protected String name;
    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }
    protected  boolean isSupport (HandlerTask<Days> task) {
        return true;
    }
    protected  void doHandler(HandlerTask task) {
        if(isSupport(task)) {
            System.out.println(name+"批注你的假期");
        }else {
            if(getNext()!=null){
                getNext().doHandler(task);
            }else {
                System.out.println("你的假期不在批准的范围内");
            }
        }
    }
}
class Days {
    private Integer leaveDays;

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }
}
 // 班主任
class ClassAdviser extends Leader  {
    public ClassAdviser() {
        name = "班主任";
     }
    @Override
     protected boolean isSupport(HandlerTask<Days> task) {
         return task.getT().getLeaveDays() <= 2;
     }
 }
class DepartmentHeader extends Leader {
    public DepartmentHeader() {
        name = "系主任";
    }

    @Override
    protected boolean isSupport(HandlerTask<Days> task) {
        return task.getT().getLeaveDays()<=7;
    }
}

class Dean extends Leader {
    public Dean() {
        name = "院长";
    }

    @Override
    protected boolean isSupport(HandlerTask<Days> task) {
        return task.getT().getLeaveDays()<=10;
    }
}
