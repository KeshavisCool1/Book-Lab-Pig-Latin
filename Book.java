import java.util.regex.Matcher;
import java.util.regex.Pattern;


//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...



import java.text.CharacterIterator;

public class Book{
  public String pigLatin(String word){

    String newWord = "";
    char first =  word.charAt(0);
    String first_string = word.substring(0,1);
    String digits = "0123456789";
    String vowels = "aeiouyAEIOUY";
    
    if(word.length() == 0){
      return word;
    }
    

    if(digits.contains(word.substring(0,1))){
      return word;
    }

    else if(vowels.indexOf(word.substring(0,1)) >= 0){
      return word + "yay";
    }

    else if(word.length() == 1){
      return word + "ay";
    }

      // no punc no caps
      if(endPunctuation(word) == -1 && Character.isUpperCase(first) == false){
        for(int i = 0; i< word.length(); i++){
          if(vowels.indexOf(word.substring(i,i+1))>= 0 ){
            String left = word.substring(0,i);
            String right = word.substring(i);
            return right + left + "ay";
          }
        }
      }
      // caps no punc : Hae-Llo -> Ae-Llohay
      if(endPunctuation(word) == -1 && Character.isUpperCase(first) == true){

        for(int i = 0; i< word.length(); i++){
          if(vowels.indexOf(word.substring(i,i+1))>= 0 ){
            String left = word.substring(0,i);
            String first_of_left = left.substring(0,1);
            first_of_left = first_of_left.toLowerCase();
            left = first_of_left + word.substring(1,i);
            String right = word.substring(i);
            String fist_letter = right.substring(0, 1);
            fist_letter = fist_letter.toUpperCase();
            String right_rest = right.substring(1);
            return fist_letter + right_rest + left + "ay";
          }
        }
      }

      // no caps and punc
      if(endPunctuation(word) != -1 && Character.isUpperCase(first) == false){
        String pucn = word.substring(endPunctuation(word));
        String only_word = word.substring(0,endPunctuation(word));

        for(int i = 0; i< only_word.length(); i++){
          if(vowels.indexOf(only_word.substring(i,i+1))>= 0 ){
            String left = only_word.substring(0,i);
            String right = only_word.substring(i);
            String fist_letter = right.substring(0, 1);
            String right_rest = right.substring(1);
            return fist_letter + right_rest + left + "ay" + pucn;
          }
        }
      }

      //caps and punc  : Hae-Llo!! -> Ae-Llohay!!
      if(endPunctuation(word) != -1 && Character.isUpperCase(first) == true){

        String pucn = word.substring(endPunctuation(word));
        String only_word = word.substring(0,endPunctuation(word));

        for(int i = 0; i< only_word.length(); i++){
          if(vowels.indexOf(only_word.substring(i,i+1))>= 0 ){
            String left = only_word.substring(0,i);
            String first_of_left = left.substring(0,1);
            first_of_left = first_of_left.toLowerCase();
            left = first_of_left + word.substring(1,i);
            String right = only_word.substring(i);
            String fist_letter = right.substring(0, 1);
            fist_letter = fist_letter.toUpperCase();
            String right_rest = right.substring(1);
            return fist_letter + right_rest + left + "ay" + pucn;
          }
        }
      }
      
      return newWord;

  }//end of translate




  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {
    int indexofexclamation = word.length(), indexofperiod = word.length(), indexofcoma = word.length(),indexofquestion = word.length(),indexofsemi = word.length(),indexofsemicolin = word.length();
    if(word.contains("!")||word.contains(".")||word.contains(",")||word.contains("?")||word.contains(";")||word.contains(":")){
      if(word.contains("!")){
         indexofexclamation = word.indexOf("!");
      }
      if(word.contains(".")){
         indexofperiod = word.indexOf(".");
      } 
      if(word.contains(",")){
        indexofcoma = word.indexOf(",");
      }
      if(word.contains("?")){
        indexofquestion = word.indexOf("?");
      }
      if(word.contains(";")){
        indexofsemi = word.indexOf(";");
      }
      if(word.contains(":")){
        indexofsemicolin = word.indexOf(";");
      }
      int smallest_index = indexofexclamation;
      if(indexofperiod < smallest_index){
        smallest_index = indexofperiod;
      }
      if(indexofcoma <smallest_index ){
        smallest_index = indexofcoma;
      }
      if(indexofquestion < smallest_index){
        smallest_index = indexofquestion;
      }
      if(indexofsemi < smallest_index){
        smallest_index = indexofsemi;
      }
      if(indexofsemicolin < smallest_index){
        smallest_index = indexofsemicolin;
      }

      return smallest_index;

    }
    return -1;
  }


  public String translateWord(String word)    //to share with class
  {
    return pigLatin(word);
  }

  public String translateSentence(String sentence){
    String retSentence = "";
    int index = 0;
    int i = 0;
    int len = sentence.length();

    while(i<len){
      if(sentence.substring(i, i+1).equals(" ")){
        retSentence = retSentence + " ";
        i++;
        continue;
      }
      String new_word = "";
      for(int j = i;j<len;j++){
        if (sentence.substring(j,j+1).equals(" ")) {
          break;
        }
        i++;
        new_word = new_word + sentence.substring(j,j+1);
      }
      if(!new_word.equals("")){
        String word = translateWord(new_word);
        retSentence = retSentence + word;
      }
    }
    return retSentence;
  }
}
