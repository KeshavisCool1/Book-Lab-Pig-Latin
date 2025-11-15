class App {
  public static void main(String[] args) {
    Book aBook = new Book();
    // System.out.println(" ");
    // System.out.println("I can now speak in Pig-Latin? WOW!!! I can translate words and sentences for the students at Foothill High School.");
    // System.out.println(aBook.translateSentence("I can now speak in Pig-Latin? WOW!!! I can translate words and sentences for the students at Foothill High School."));
    //output : Iyay ancay ownay eakspay inyay Ig-Latinpay? OWway!!! Iyay ancay anslatetray ordsway andyay entencessay orfay ethay udentsstay atyay Oothillfay Ighhay Oolschay.
    // System.out.println(" ");


    aBook.readBook("https://www.gutenberg.org/cache/epub/6130/pg6130.txt");
    // num of words 196929 (with split)
    // num of words 192262 (with iteration in the trasnlate word)

  }
}
