package IJSE.DEP.Module;
import java.util.ArrayList;
import java.util.Date;

public class Oder {

    private String OderId;
    private Date OderDate;
    private String CuId;
    private ArrayList<PlaseOder> orderDetails = new ArrayList<>();

    public Oder() {
    }

    public Oder(String oderId, Date oderDate, String cuId, ArrayList<PlaseOder> orderDetails) {
        OderId = oderId;
        OderDate = oderDate;
        CuId = cuId;
        this.orderDetails = orderDetails;
    }

    public String getOderId() {
        return OderId;
    }

    public void setOderId(String oderId) {
        OderId = oderId;
    }

    public Date getOderDate() {
        return OderDate;
    }

    public void setOderDate(Date oderDate) {
        OderDate = oderDate;
    }

    public String getCuId() {
        return CuId;
    }

    public void setCuId(String cuId) {
        CuId = cuId;
    }

    public ArrayList<PlaseOder> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<PlaseOder> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "OderId='" + OderId + '\'' +
                ", OderDate='" + OderDate + '\'' +
                ", CuId='" + CuId + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
