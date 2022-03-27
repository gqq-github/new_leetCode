package cn.gq.设计模式.abstractStatus.访问者模式.demo;
/**
*@Author:cherry_xx
*@Date: 2021/7/3 13:18
*方法解释： 定义一个关于材料的抽象接口
*/
public interface Material {
    void accept(Company company);
}

class MaterialPaper implements Material{
    @Override
    public void accept(Company company) {
        company.visit(this);
    }
    public String materialName () {
        return "原材料纸张";
    }
}

class MaterialCopper implements Material{
    @Override
    public void accept(Company company) {
        company.visit(this);
    }

    public String materialName () {
        return "原材料铜";
    }
}

