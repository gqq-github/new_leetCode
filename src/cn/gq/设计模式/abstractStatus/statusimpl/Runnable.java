package cn.gq.设计模式.abstractStatus.statusimpl;

import cn.gq.设计模式.abstractStatus.ThreadContext;
import cn.gq.设计模式.abstractStatus.ThreadStatus;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:43
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class Runnable extends ThreadStatus {
    public Runnable () {
        status = "就绪状态";
        System.out.println("就绪状态");
    }
    public void getCpu(ThreadContext context) {
        if(isSupport(context)) {
            context.setThreadStatus(new Running());
        }else {
            System.out.println("当前状态不是就绪状态不能转换为运行状态");
        }
    }
}