/*
 * Creation : 26 Apr 2021
 */
package com.ust.pricemarket.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketPrice {

    @JsonProperty("uniqueID")
    private long uniqueID;

    @JsonProperty("instrumentName")
    private String instrumentName;

    @JsonProperty("bid")
    private double bid;

    @JsonProperty("ask")
    private double ask;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    public MarketPrice() {
        super();
    }

    public MarketPrice(long uniqueID, String instrumentName, double bid, double ask, Timestamp timestamp) {
        super();
        this.uniqueID = uniqueID;
        this.instrumentName = instrumentName;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(ask);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bid);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((instrumentName == null) ? 0 : instrumentName.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MarketPrice other = (MarketPrice) obj;
        if (Double.doubleToLongBits(ask) != Double.doubleToLongBits(other.ask))
            return false;
        if (Double.doubleToLongBits(bid) != Double.doubleToLongBits(other.bid))
            return false;
        if (instrumentName == null) {
            if (other.instrumentName != null)
                return false;
        } else if (!instrumentName.equals(other.instrumentName))
            return false;
        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp.equals(other.timestamp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Market Price {\n");

        sb.append("    ID: ").append(toIndentedString(uniqueID)).append("\n");
        sb.append("    instrument name: ").append(toIndentedString(instrumentName)).append("\n");
        sb.append("    bid: ").append(toIndentedString(bid)).append("\n");
        sb.append("    ask: ").append(toIndentedString(ask)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
