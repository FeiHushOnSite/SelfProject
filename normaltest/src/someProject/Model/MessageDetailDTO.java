package someProject.Model;

import java.io.Serializable;

public class MessageDetailDTO implements Serializable {
    private static final long serialVersionUID = 1097236870190810891L;

    private String body;

    private String subject;

    private MessageType type;

    private Boolean read;

    private Integer templateCode;

    private Long campaignTrackId;

    private Long dataSourceId;

    public MessageDetailDTO() {
    }

    public MessageDetailDTO(String body, String subject, MessageType type, Boolean read, Integer templateCode, Long campaignTrackId, Long dataSourceId) {
        this.body = body;
        this.subject = subject;
        this.type = type;
        this.read = read;
        this.templateCode = templateCode;
        this.campaignTrackId = campaignTrackId;
        this.dataSourceId = dataSourceId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Integer getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(Integer templateCode) {
        this.templateCode = templateCode;
    }

    public Long getCampaignTrackId() {
        return campaignTrackId;
    }

    public void setCampaignTrackId(Long campaignTrackId) {
        this.campaignTrackId = campaignTrackId;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    @Override
    public String toString() {
        return "MessageDetailDTO{" +
                "body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                ", read=" + read +
                ", templateCode=" + templateCode +
                ", campaignTrackId=" + campaignTrackId +
                ", dataSourceId=" + dataSourceId +
                '}';
    }
}
