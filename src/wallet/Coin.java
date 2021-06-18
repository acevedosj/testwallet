package wallet;

public class Coin {

    private int Quantity;
    private int Multiplier;

    public Coin(int multiplier) {
        Quantity = 0;
        Multiplier = multiplier;
    }

    public int getAmount() {
        return Quantity*Multiplier;
    }


    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = Quantity+quantity;
    }

    public int getMultiplier() {
        return Multiplier;
    }

    public void setMultiplier(int multiplier) {
        Multiplier = multiplier;
    }
}
