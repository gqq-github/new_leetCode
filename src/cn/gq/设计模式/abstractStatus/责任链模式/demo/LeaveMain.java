package cn.gq.设计模式.abstractStatus.责任链模式.demo;

import cn.gq.设计模式.abstractStatus.责任链模式.HandlerTask;

/**
 * @author cherry_xx
 * @create 2021/6/27 23:18
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class LeaveMain {
    public static void main(String[] args) {
        Days days = new Days();
        days.setLeaveDays(99);
        ClassAdviser classAdviser = new ClassAdviser();
        DepartmentHeader departmentHeader = new DepartmentHeader();
        Dean dean = new Dean();
        classAdviser.setNext(departmentHeader);
        departmentHeader.setNext(dean);
        HandlerTask<Days> daysHandlerTask = new HandlerTask<>(days);
        classAdviser.doHandler(daysHandlerTask);
    }
}
