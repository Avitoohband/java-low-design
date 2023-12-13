package elevatorsystem.model;

public class Request implements Comparable<Request> {
    private final InternalRequest internalRequest;
    private final ExternalRequest externalRequest;

    public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
        this.internalRequest = internalRequest;
        this.externalRequest = externalRequest;
    }

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public ExternalRequest getExternalRequest() {
        return externalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest.setDestinationFloor(internalRequest.getDestinationFloor());

    }

    public void setExternalRequest(ExternalRequest externalRequest) {
        this.externalRequest.setSourceFloor(externalRequest.getSourceFloor());
        this.externalRequest.setDirection(externalRequest.getDirection());
    }

    @Override
    public int compareTo(Request req) {
        return Integer.compare(getInternalRequest().getDestinationFloor(),
                req.getInternalRequest().getDestinationFloor());
    }
}
