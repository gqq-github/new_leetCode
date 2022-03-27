package cn.gq.设计模式.abstractStatus.statusimpl;

import cn.gq.设计模式.abstractStatus.ThreadContext;
import cn.gq.设计模式.abstractStatus.ThreadStatus;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:08
 * @update 2021/6/27
 * Description: \
 * @since 1.0.0
 */
public class NewStatus extends ThreadStatus {
    public NewStatus() {
        status = "新建";
        System.out.println("新建状态");
    }

    public void start(ThreadContext context) {

        if (isSupport(context)) {
            context.setThreadStatus(new Runnable());
        }else {
            System.out.println("当前状态不是新建状态不不能转换就绪状态");
        }
    }
}





