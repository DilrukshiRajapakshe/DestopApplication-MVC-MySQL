package IJSE.DEP.Module;

public class Customer {
    private String CuId;
    private String CuName;
    private String CuAddress;
    private int CuTel;

    public Customer() {
    }

    public Customer(String cuId, String cuName, String cuAddress, int cuTel) {
        CuId = cuId;
        CuName = cuName;
        CuAddress = cuAddress;
        CuTel = cuTel;
    }

    public String getCuId() {
        return CuId;
    }

    public void setCuId(String cuId) {
        CuId = cuId;
    }

    public String getCuName() {
        return CuName;
    }

    public void setCuName(String cuName) {
        CuName = cuName;
    }

    public String getCuAddress() {
        return CuAddress;
    }

    public void setCuAddress(String cuAddress) {
        CuAddress = cuAddress;
    }

    public int getCuTel() {
        return CuTel;
    }

    public void setCuTel(int cuTel) {
        CuTel = cuTel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CuId='" + CuId + '\'' +
                ", CuName='" + CuName + '\'' +
                ", CuAddress='" + CuAddress + '\'' +
                ", CuTel='" + CuTel + '\'' +
                '}';
    }
}
