package cn.gq.设计模式.abstractStatus.责任链模式;

/**
 * @author cherry_xx
 * @create 2021/6/27 15:08
 * @update 2021/6/27
 * Description: 链式的任务抽象
 * @since 1.0.0
 */
public abstract class Handler {
    /**
    *  下一个任务
    * */
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    protected boolean isSupport(HandlerTask t) {
        return true;
    }

    protected abstract void coreHandler(HandlerTask t);

    public void doHandler(HandlerTask t){
       try{
           if (isSupport(t)) {
               coreHandler(t);
               if(t.getSuccess()){
                   System.out.println(t.getTaskType()+"处理成功");
               }else {
                   getNext().doHandler(t);
               }
           }else {
               getNext().doHandler(t);
           }
       }catch (Exception e) {
           System.out.println(t.getTaskType()+"处理结束:"+t.getSuccess());
       }
    }

}
