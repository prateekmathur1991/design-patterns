public class ConcreteHandler1 extends BaseHandler {
    @Override
    public void handleRequest(String request) {
        System.out.println("ConcreteHandler1 received the request: " + request);
        if (request.equals("Request1")) {
            System.out.println("ConcreteHandler1 handled the request: " + request);
            super.handleRequest(request);
        } else {
            System.out.println("ConcreteHandler1 cannot handle the request: " + request);
            super.handleRequest(request);
        }
    }

}
