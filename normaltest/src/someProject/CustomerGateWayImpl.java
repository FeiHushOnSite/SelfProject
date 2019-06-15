//package someProject;
//
//import someProject.Model.BasicResponse;
//import someProject.Model.HystrixTemplate;
//import someProject.Model.InboxMessage;
//import someProject.Model.MessageDetailDTO;
//import someProject.Model.ResponseStatus;
//
//public class CustomerGateWayImpl implements CustomerGateWay{
//
//    private final String CUSTOMER_GW = "customer_gw";
//    private final HystrixTemplate hystrixTemplate = new HystrixTemplate(CUSTOMER_GW);
//
//    @Override
//    public BasicResponse<MessageDetailDTO> getMessageDetail(String relationId,Long messageId, Long personId) {
//
//        Observable<BasicResponse<InboxMessage> > response = hystrixTemplate.observeWithCircuitBreaker("getMessageDetail",
//                () -> customerGatewayService.getMyMessage(relationId,messageId,personId));
//
//        BasicResponse<InboxMessage> basicResponse = response.toBlocking().first();
//
//        BasicResponse<MessageDetailDTO> messageDetailResponse= BasicResponse.ok();
//        if (basicResponse.getCode() == ResponseStatus.OK.getCode() ){
//            InboxMessage message = basicResponse.getValue();
//            MessageDetailDTO messageDetailDTO = new MessageDetailDTO();
//            messageDetailDTO.setType(message.getType());
//            messageDetailDTO.setCampaignTrackId(message.getCampaignTrackId());
//            messageDetailDTO.setTemplateCode(message.getTemplateCode());
//            messageDetailDTO.setDataSourceId(message.getMessageSourceId());
//            messageDetailDTO.setRead(MessageConverter.isRead(message));
//            if (message.getSubject() == null) {
//                LOG.debug("Message ID: " + message.getId() + ". Subject value is " + message.getSubject() + ". Value of 'subject' will be set to empty string.");
//                messageDetailDTO.setSubject(StringUtils.EMPTY);
//            } else {
//                messageDetailDTO.setSubject(message.getSubject());
//            }
//            messageDetailDTO.setBody(renderInboxMessage(message));
//            messageDetailResponse.setValue(messageDetailDTO);
//        };
//
//        messageDetailResponse.setCode(basicResponse.getCode());
//        messageDetailResponse.setMessage(basicResponse.getMessage());
//        return messageDetailResponse;
//    }
//}
