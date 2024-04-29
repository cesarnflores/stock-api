package com.utoppia.stockapi.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "stock_data")
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stock_data_id")
    private Integer stockDataId;
    @Column(name="symbol")
    private String symbol;
    @Column(name="current_price")
    private double currentPrice;

    @Column(name="change")
    private double change;
    @Column(name="percent_change")
    private double percentChange;

    @Column(name="high_price")
    private double highPrice;
    @Column(name="low_price")
    private double lowPrice;
    @Column(name="open_price")
    private double openPrice;
    @Column(name="prev_close_price")
    private double previousClosePrice;
    @Column(name="timestamp")
    private long timestamp;

    public StockData() {
    }

    public StockData(Integer stockDataId, String symbol, double currentPrice, double change,
                     double percentChange, double highPrice, double lowPrice, double openPrice,
                     double previousClosePrice, long timestamp) {
        this.stockDataId = stockDataId;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.change = change;
        this.percentChange = percentChange;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.openPrice = openPrice;
        this.previousClosePrice = previousClosePrice;
        this.timestamp = timestamp;
    }

    public Integer getStockDataId() {
        return stockDataId;
    }

    public void setStockDataId(Integer stockDataId) {
        this.stockDataId = stockDataId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "stockDataId=" + stockDataId +
                ", symbol='" + symbol + '\'' +
                ", currentPrice=" + currentPrice +
                ", change=" + change +
                ", percentChange=" + percentChange +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", openPrice=" + openPrice +
                ", previousClosePrice=" + previousClosePrice +
                ", timestamp=" + timestamp +
                '}';
    }
}
