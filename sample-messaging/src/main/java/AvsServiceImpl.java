import com.l8mdv.sample.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.util.Assert;

public class AvsServiceImpl implements AvsService {

    private static final Logger logger
            = LoggerFactory.getLogger(AvsServiceImpl.class);
    public static final String MISSING_MANDATORY_ARG
            = "Mandatory argument is missing.";
    private AvsGateway avsGateway;

    public AvsServiceImpl(final AvsGateway avsGateway) {
        this.avsGateway = avsGateway;
    }

    public Message<AvsResponse> service(Message<AvsRequest> message) {

        Assert.notNull(message, MISSING_MANDATORY_ARG);
        Assert.notNull(message.getPayload(), MISSING_MANDATORY_ARG);

        MessageHeaders requestMessageHeaders = message.getHeaders();
        Message<AvsResponse> responseMessage = null;
        try {
            logger.debug("Entering AVS Gateway");
            responseMessage = avsGateway.send(message);
            if (responseMessage == null)
                responseMessage = buildNewResponse(requestMessageHeaders,
                        AvsResponseType.NULL_RESULT);
            logger.debug("Exited AVS Gateway");
            return responseMessage;
        } catch (Exception e) {
            return buildNewResponse(responseMessage, requestMessageHeaders,
                    AvsResponseType.EXCEPTION_RESULT, e);
        }
    }

    private Message<AvsResponse> buildNewResponse(MessageHeaders requestMessageHeaders,
                                                  AvsResponseType avsResponseType) {

        Assert.notNull(requestMessageHeaders, MISSING_MANDATORY_ARG);
        Assert.notNull(avsResponseType, MISSING_MANDATORY_ARG);

        AvsResponse avsResponse = new AvsResponse();
        avsResponse.setError(avsResponseType);

        return MessageBuilder.withPayload(avsResponse)
                .copyHeadersIfAbsent(requestMessageHeaders).build();
    }

    private Message<AvsResponse> buildNewResponse(Message<AvsResponse> responseMessage,
                                                  MessageHeaders requestMessageHeaders,
                                                  AvsResponseType avsResponseType,
                                                  Exception e) {

        Assert.notNull(responseMessage, MISSING_MANDATORY_ARG);
        Assert.notNull(responseMessage.getPayload(), MISSING_MANDATORY_ARG);
        Assert.notNull(requestMessageHeaders, MISSING_MANDATORY_ARG);
        Assert.notNull(avsResponseType, MISSING_MANDATORY_ARG);
        Assert.notNull(e, MISSING_MANDATORY_ARG);

        AvsResponse avsResponse = new AvsResponse();
        avsResponse.setError(avsResponseType,
                responseMessage.getPayload(), e);

        return MessageBuilder.withPayload(avsResponse)
                .copyHeadersIfAbsent(requestMessageHeaders).build();
    }
}
