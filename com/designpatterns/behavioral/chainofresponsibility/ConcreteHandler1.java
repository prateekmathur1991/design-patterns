public class ConcreteHandler1 extends BaseHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request1")) {
            System.out.println("ConcreteHandler1 handled the request: " + request);
            super.handleRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

}
