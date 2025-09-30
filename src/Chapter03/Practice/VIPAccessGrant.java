package Chapter03.Practice;

class user{
    int age;
    boolean isPremium;

    void grantAccess(){
        if(age>=18 && isPremium==true){
            System.out.println("Access Granted");
        }
        else{
            System.out.println("Access Denied");
        }
    }
}

public class VIPAccessGrant {
    public static void main(String[] args) {
        user A = new user();
        A.age = 23;
        A.isPremium = true;
        A.grantAccess();
    }
}
