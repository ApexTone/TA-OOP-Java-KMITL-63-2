package Lab04;

/*
* Testcase
* handle previousClosingPrice = 0
* */

public class Stock {
    private String symbol, name;
    private double previousClosingPrice, currentPrice;

    public Stock() {
        this("","");
    }
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = 0;
        this.currentPrice = 0;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getChangePercent(){
        if(previousClosingPrice == 0)
            return 0;
        return (currentPrice-previousClosingPrice)/previousClosingPrice * 100;
    }

    @Override
    public String toString() {
        return "Symbol: " + this.symbol + '\n' +
                "Name: " + this.name + '\n' +
                "Previous Closing Price: " + this.previousClosingPrice + '\n' +
                "Current Price: " + this.currentPrice + "\n" +
                "Price Change: " + this.getChangePercent();
    }

    public static void main(String[] args) {
        Stock oracle = new Stock("ORCL", "Oracle Corp");
        oracle.setPreviousClosingPrice(34.5);
        oracle.setCurrentPrice(34.35);
        System.out.println(oracle);
    }
}


