// This class stores game data
final public class Data {
      private static int resource;

      public static int getResource() {
            return resource;
      }

      public static void setResource(int input) {
            resource = input;
      }

      public static void addResource(int input) {
            resource += input;
      }

      public static boolean subResource(int input) {
            final boolean valid = (resource >= input);
            if (valid)
                  resource -= input;
            return valid; 
      }

      private Data() {}
}
