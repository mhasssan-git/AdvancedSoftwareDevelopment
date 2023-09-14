package order;

public class InternationalAddress extends Address{
    private String country;


    public InternationalAddress(String street, String city, String zip, String country) {
        super(street, city, zip);
        this.country = country;
    }

    @Override
    public String toString() {
        return "InternationalAddress{" +
                super.toString()+
                "country='" + country + '\'' +
                '}';
    }
}
