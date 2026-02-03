public class ConcreteHandler3 extends BaseHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request3")) {
            System.out.println("ConcreteHandler3 handled the request: " + request);
            super.handleRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

}
