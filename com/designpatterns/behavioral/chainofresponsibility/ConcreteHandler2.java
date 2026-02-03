public class ConcreteHandler2 extends BaseHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request2")) {
            System.out.println("ConcreteHandler2 handled the request: " + request);
            super.handleRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

}
