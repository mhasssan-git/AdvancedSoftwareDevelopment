package bank.singleton;

public  class EmailSender implements IEmailSender {
    private static EmailSender sender;
    private EmailSender(){

    }
    public static EmailSender getSender(){
        if(sender==null)
        {
            synchronized (EmailSender.class) {
                if(sender==null) {
                    sender = new EmailSender();
                }
            }
        }
       return sender;
    }
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email from production email: "+message);
    }
}
