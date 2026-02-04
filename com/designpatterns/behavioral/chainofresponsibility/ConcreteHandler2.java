public class ConcreteHandler2 extends BaseHandler {
    @Override
    public void handleRequest(String request) {
        System.out.println("ConcreteHandler2 received the request: " + request);
        if (request.equals("Request2")) {
            System.out.println("ConcreteHandler2 handled the request: " + request);
            super.handleRequest(request);
        } else {
            System.out.println("ConcreteHandler2 cannot handle the request: " + request);
            super.handleRequest(request);
        }
    }

}
