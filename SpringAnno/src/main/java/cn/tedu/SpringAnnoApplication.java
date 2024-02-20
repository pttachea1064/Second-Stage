package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 該類在創建SpringBoot項目時,會自動創建
 * 並且代碼也會自動生成
 * 該類我們稱為 主啟動類型 只有運行這個類型,SpringBoot項目才會被正式啟動
 * 啟動後 ,項目中所有資源才會被加載,否則都是關閉狀態
 * 當項目啟動時候 SpringBoot會自動掃描主啟動類所在的包下所有的類
 * 如果類上添加有標記為交給Spring容器中的註解,會自動將這些類加入倒容器中
 */
@SpringBootApplication
public class SpringAnnoApplication {

    public static void main(String[] args) {
        //返回的就是Spring容器
        SpringApplication.run(SpringAnnoApplication.class, args);
    }

}
