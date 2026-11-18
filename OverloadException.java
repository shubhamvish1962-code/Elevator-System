class OverloadException extends Exception {
   OverloadException() {
      super("Weight is more than the elevator limit");
   }

   public OverloadException(String var1) {
      super(var1);
   }
}
