package enums;

import lombok.Getter;

/**
 * @author 王振辉
 * @date 2025/9/12
 */
@Getter
public enum ExpressStatus {
    CREATED("已揽收"),TRANSIT("在途中"),SUCCESS("签收");
    private final String info;

    ExpressStatus(String  info) {
        this.info = info;
    }

}
