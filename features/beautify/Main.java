class Main {

   static String more;

   Main() {
      more = "more";
   }

   public static void main(String[] args) {
      original(args);
      System.out.println(more);
   }

}