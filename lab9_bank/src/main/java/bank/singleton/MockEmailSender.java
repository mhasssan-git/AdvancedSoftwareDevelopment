package bank.singleton;

public class MockEmailSender implements IEmailSender {
    private static  MockEmailSender sender;

    private MockEmailSender() {
    }

    public static MockEmailSender getSender() {
        if (sender == null) {
            synchronized (MockEmailSender.class) {
                if (sender == null) {
                    sender = new MockEmailSender();
                }
            }
        }
        return sender;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email from mock email: " + message);
    }
}
