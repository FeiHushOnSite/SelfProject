package someProject;

import someProject.Model.BasicResponse;
import someProject.Model.MessageDetailDTO;

public interface CustomerGateWay {
    BasicResponse<MessageDetailDTO> getMessageDetail(String relationId, Long messageId, Long personId);
}
