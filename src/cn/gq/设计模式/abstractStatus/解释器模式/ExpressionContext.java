package cn.gq.设计模式.abstractStatus.解释器模式;

import jdk.nashorn.internal.runtime.Context;

/**
 * @author cherry_xx
 * @create 2021/7/3 21:28
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class ExpressionContext {
    private String[] cities = {"西安","延安","安塞"};
    private String[] persons = {"老人","孕妇","儿童"};
    private String split = "的";
    private Expression cityAndPersonExpression;
    public ExpressionContext(){
        cityAndPersonExpression = new PersonAndCityExpression(split,cities,persons);
    }
    public void doExpression(String info) {
        if(cityAndPersonExpression.interpret(info)) {
            System.out.println(info+"免费");
        }else {
            System.out.println(info+"不免费");
        }
    }

    public static void main(String[] args) {
        ExpressionContext expressionContext = new ExpressionContext();
        expressionContext.doExpression("北京的老人");
        expressionContext.doExpression("西安的老人");
        expressionContext.doExpression("西安的孕妇");
        expressionContext.doExpression("延安的年轻人");
        expressionContext.doExpression("上海的儿童");
        expressionContext.doExpression("安塞的儿童");
    }
}
