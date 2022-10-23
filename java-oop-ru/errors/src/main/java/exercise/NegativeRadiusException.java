package exercise;

public class NegativeRadiusException extends Exception {

    private final String error;

    public NegativeRadiusException(String error) {
        this.error = error;
    }

   @Override
   public String toString() {
       return "NegativeRadiusException";
   }
}
