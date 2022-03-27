package cn.gq.设计模式.abstractStatus.访问者模式.demo;

/**
 * @author cherry_xx
 * @create 2021/7/3 13:16
 * @update 2021/7/3
 * Description: 实现一个基于访问者模式的Demo
 *利用“访问者（Visitor）模式”模拟艺术公司与造币公司的功能。
 *
 * 分析：艺术公司利用“铜”可以设计出铜像，利用“纸”可以画出图画；造币公司利用“铜”可以印出铜币，
 * 利用“纸”可以印出纸币（点此下载运行该程序后所要显示的图片）。
 * 对“铜”和“纸”这两种元素，两个公司的处理方法不同，所以该实例用访问者模式来实现比较适合。
 * @since 1.0.0
 */
public class DemoPatten {
    public static void main(String[] args) {
        ArtCompany artCompany = new ArtCompany();
        MintCompany mintCompany = new MintCompany();
        MaterialCopper materialCopper = new MaterialCopper();
        MaterialPaper materialPaper = new MaterialPaper();
        MaterialStructure materialStructure = new MaterialStructure(materialCopper, materialPaper);
        materialStructure.accept(artCompany);
        materialStructure.accept(mintCompany);
    }
}
