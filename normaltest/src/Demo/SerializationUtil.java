package Demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtil {
    public static void main(String[] args) throws Exception{
        AgencyVoInfo result = new AgencyVoInfo();
        result.setId(1);
        result.setSerialNo(11);
        result.setAgencyCode("test1");
        result.setAgencyName("name");
        result.setBranchCode("branch");

            String serializeObject = serializeObject(result);
            System.out.println("这是序列化后的结果：" + serializeObject);


            Object object = stringSerializeObject(serializeObject);
            System.out.println("这是反序列化后的结果：" + object);

    }

    /**
     * 对象序列化为字符串
     *
     * @param object
     * @return
     */
    public static String serializeObject(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(object);
        //必须是ISO-8859-1
        String objectStr = byteArrayOutputStream.toString("ISO-8859-1");
        out.close();
        byteArrayOutputStream.close();
        return objectStr;
    }

    /**
     * 字符串序列化为对象
     *
     * @param objectStr
     * @return
     * @throws Exception
     */
    public static Object stringSerializeObject(String objectStr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objectStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return object;
    }
}

class AgencyVoInfo implements Serializable {
    protected int id;
    protected int SerialNo;
    protected String AgencyCode;
    protected String AgencyName;
    protected String BranchCode;

    public AgencyVoInfo() {
    }

    public AgencyVoInfo(int id, int serialNo, String agencyCode, String agencyName, String branchCode) {
        this.id = id;
        SerialNo = serialNo;
        AgencyCode = agencyCode;
        AgencyName = agencyName;
        BranchCode = branchCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(int serialNo) {
        SerialNo = serialNo;
    }

    public String getAgencyCode() {
        return AgencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        AgencyCode = agencyCode;
    }

    public String getAgencyName() {
        return AgencyName;
    }

    public void setAgencyName(String agencyName) {
        AgencyName = agencyName;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
    }

    @Override
    public String toString() {
        return "AgencyVoInfo{" +
                "id=" + id +
                ", SerialNo=" + SerialNo +
                ", AgencyCode='" + AgencyCode + '\'' +
                ", AgencyName='" + AgencyName + '\'' +
                ", BranchCode='" + BranchCode + '\'' +
                '}';
    }
}