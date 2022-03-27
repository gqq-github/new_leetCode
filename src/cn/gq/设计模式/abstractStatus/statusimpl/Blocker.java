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
public class Blocker extends ThreadStatus {
    public Blocker() {
        status = "阻塞状态";
        System.out.println("阻塞状态");
    }

    public void resume(ThreadContext context) {
        if (isSupport(context)) {
            context.setThreadStatus(new Runnable());
        } else {
            System.out.println("当前的状态不是阻塞状态不能转化为就绪状态");
        }
    }
}