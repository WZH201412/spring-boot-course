package enums;

import lombok.Getter;

@Getter
public enum DrinkType {
    COFFEE("咖啡",12.5),
    TEA("茶",10),
    JUICE("果汁",8);

    private final String label;
    private final double price;

    DrinkType(String label,double price){
        this.label = label;
        this.price = price;
    }
}
