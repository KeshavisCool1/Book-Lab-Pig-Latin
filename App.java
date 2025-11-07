class App {
  public static void main(String[] args) {
    Book aBook = new Book();
    System.out.println(" ");
    System.out.println("I can now speak in Pig-Latin? WOW!!! I can translate words and sentences for the students at Foothill High School.");
    System.out.println(aBook.translateSentence("I can now speak in Pig-Latin? WOW!!! I can translate words and sentences for the students at Foothill High School."));
    //output : Iyay ancay ownay eakspay inyay Ig-Latinpay? OWway!!! Iyay ancay anslatetray ordsway andyay entencessay orfay ethay udentsstay atyay Oothillfay Ighhay Oolschay.
    System.out.println(" ");
    System.out.println(aBook.pigLatin("WOW!!!"));

    // System.out.println(aBook.pigLatin("hello!"));
    // System.out.println(aBook.pigLatin("What?!?"));
    // System.out.println(aBook.pigLatin("Allons-y"));

  }
}
