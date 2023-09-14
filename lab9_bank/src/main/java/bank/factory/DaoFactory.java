package bank.factory;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    private IFactory factory;
    private static String ProductionEnvironment="production";
    private static String MockEnvironment="test";
    public  DaoFactory(){
        String rootPath=Thread.currentThread().getContextClassLoader()
                .getResource("").getPath();
        try{
            Properties prop=new Properties();
            prop.load(new FileInputStream(rootPath+"/config.properties"));
            String environment=prop.getProperty("environment");
            if(environment.equals(ProductionEnvironment))
            {
                factory=new ProductionFactory();
            }
            else if(environment.equals(MockEnvironment)){
                factory=new MockFactory();
            }
            else {
                System.out.println("environment property not set correctly");
            }
        }
        catch (FileNotFoundException e){

        }
        catch (IOException e)
        {

        }

    }
    public IFactory getFactoryInstace(){
        return factory;
    }
}
