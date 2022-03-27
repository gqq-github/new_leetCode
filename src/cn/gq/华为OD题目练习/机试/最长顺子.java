package cn.gq.华为OD题目练习.机试;

import java.util.*;

/**
 * @author cherry_xx
 * @create 2022/3/12 12:28
 * @update 2022/3/12
 * Description:
 * @since 1.0.0
 */
public class 最长顺子 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ownStr = in.nextLine();
        String otherStr = in.nextLine();
        String[] splitOwn = ownStr.split("-");
        String[] splitOther = otherStr.split("-");
        String[] data = {"3","4","5","6","7","8","9","10","J","Q","K","A"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], 4);
        }
        for (int i = 0; i < splitOwn.length; i++) {
            if(map.containsKey(splitOwn[i]))
             map.put(splitOwn[i], map.get(splitOwn[i])-1);
        }
        for (int i = 0; i < splitOther.length; i++) {
            if (map.containsKey(splitOther[i]))
            map.put(splitOther[i], map.get(splitOther[i])-1);
        }
        int i, j = 0;

        List<StringBuffer> res = new ArrayList<>();
        for ( i = 0; i < data.length; i++) {
            if(map.get(data[i])==0) {
                continue;
            }
            int tip = 1 ;
            for ( j = i+1 ;j<data.length;j++) {
                if(map.get(data[j])>0){
                    tip++;
                }else {
                    break;
                }
            }
            if(tip>=5){
                StringBuffer bf = new StringBuffer();
                for (int k = i ; k<j ; k++ ) {
                    bf.append(data[k]).append("-");
                }
                res.add(bf);
            }
            i = j;
        }
      if(res.size()>0) {
          System.out.println(res.get(res.size()-1).delete(res.get(res.size()-1).lastIndexOf("-"),res.get(res.size()-1).length()));
      }else {
          System.out.println("NO-CHAIN");
      }

    }
}
