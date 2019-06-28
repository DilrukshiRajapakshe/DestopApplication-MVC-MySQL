package IJSE.DEP.Module;

public class Item {
    private String ItId;
    private String ItName;
    private int ItQty;
    private Double ItPrice;

    public Item() {
    }

    public Item(String itId, String itName, int itQty, Double itPrice) {
        ItId = itId;
        ItName = itName;
        ItQty = itQty;
        ItPrice = itPrice;
    }

    public String getItId() {
        return ItId;
    }

    public void setItId(String itId) {
        ItId = itId;
    }

    public String getItName() {
        return ItName;
    }

    public void setItName(String itName) {
        ItName = itName;
    }

    public int getItQty() {
        return ItQty;
    }

    public void setItQty(int itQty) {
        ItQty = itQty;
    }

    public Double getItPrice() {
        return ItPrice;
    }

    public void setItPrice(Double itPrice) {
        ItPrice = itPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItId='" + ItId + '\'' +
                ", ItName='" + ItName + '\'' +
                ", ItQty=" + ItQty +
                ", ItPrice=" + ItPrice +
                '}';
    }
}
