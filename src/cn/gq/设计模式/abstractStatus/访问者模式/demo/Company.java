package cn.gq.设计模式.abstractStatus.访问者模式.demo;

/**
*@Author:cherry_xx
*@Date: 2021/7/3 13:20
*方法解释： 定义一个关于公司的一个抽象接口，用来模拟实现公司的一个访问者
*/
public interface Company {

    void visit(MaterialPaper materialPaper);

    void visit(MaterialCopper materialCopper);
}

class ArtCompany implements Company{

    @Override
    public void visit(MaterialPaper materialPaper) {
        System.out.println(materialPaper.materialName()+"用来生产画");
    }

    @Override
    public void visit(MaterialCopper materialCopper) {
        System.out.println(materialCopper.materialName()+"用来生产铜像");
    }
}


class MintCompany implements Company{

    @Override
    public void visit(MaterialPaper materialPaper) {
        System.out.println(materialPaper.materialName()+"用来生产纸币");
    }

    @Override
    public void visit(MaterialCopper materialCopper) {
        System.out.println(materialCopper.materialName()+"用来生产硬币");
    }
}