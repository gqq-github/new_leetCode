package cn.gq.设计模式.abstractStatus.statusimpl;

import cn.gq.设计模式.abstractStatus.ThreadContext;
import cn.gq.设计模式.abstractStatus.ThreadStatus;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:44
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class Running extends ThreadStatus {
    public Running() {
        status = "运行状态";
        System.out.println("运行状态");
    }

    public void suspend(ThreadContext context) {
        if (isSupport(context)) {
            context.setThreadStatus(new Blocker());
        } else {
            System.out.println("当前的状态不是运行状态不能转为阻塞状态");
        }
    }

    public void stop(ThreadContext context) {
        if (isSupport(context)) {
            context.setThreadStatus(new Stop());
        } else {
            System.out.println("当前的状态不是运行状态不能转为死亡状态");
        }
    }
}

