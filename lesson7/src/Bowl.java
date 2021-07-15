

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
    }

    public boolean decreaseFood(int amount) {
        if (this.foodAmount - amount < 0 ) {
            System.out.println("в миске недостаточно еды, кот не наелся");
            return false;
        } else {
            this.foodAmount -= amount;
            return true;
        }

    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
