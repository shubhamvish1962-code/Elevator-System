class InvalidFloorException extends Exception {
   InvalidFloorException() {
      super("This floor does not exist");
   }

   public InvalidFloorException(String var1) {
      super(var1);
   }
}