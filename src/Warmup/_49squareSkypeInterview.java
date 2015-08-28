package Warmup;

/* 


HEY, I THINK I LOST YOU!
I'm GOING TO TRY CALLING BACK ON SKYPE







ABSOLUTE URL:
CURRENT: http://a.com/b/c/d.html
LINK:    https://b.com/e/f/g.html
RESULT:  https://b.com/e/f/g.html

ABSOLUTE PATH:
CURRENT: http://a.com/b/c/d.html
LINK:    /e/f/g.html
RESULT:  http://a.com/e/f/g.html

RELATIVE PATH:
CURRENT: http://a.com/b/c/d.html
LINK:    e/f/g.html
RESULT:  http://a.com/b/c/e/f/g.html

RELATIVE PATH #2:
CURRENT: http://a.com/b/c/d.html
LINK:    ../../e/f/g.html
RESULT:  http://a.com/e/f/g.html

RELATIVE PATH #3:
CURRENT: http://a.com/b/c/d.html
LINK:    ../../e/f/../g.html
RESULT:  http://a.com/e/g.html

SCHEME:  a-z characters followed by a ':'.
https:  http:   ftp:  gopher:  mailto:  abcdefg:

AUTHORITY:  '//' followed by non-'/' characters
//squareup.com  //localhost  //127.0.0.1:8080

PATH: everything else
/register/items/index.html  ../../e/f/g.html

 */

public class _49squareSkypeInterview {
  public static void main(String[] args) throws Exception {
    System.out.println("Output 1 "+whateverYouCallIt("http://a.com/b/c/d.html", "https://b.com/e/f/g.html"));
    //https://b.com/e/f/g.html

    System.out.println("Output 2 "+whateverYouCallIt("http://a.com/b/c/d.html", "/e/f/g.html"));
    //http://a.com/e/f/g.html

    System.out.println("Output 3 "+whateverYouCallIt("http://a.com/b/c/d.html", "e/f/g.html"));
    // http://a.com/b/c/e/f/g.html
    //done
    
    System.out.println("Output 4 "+whateverYouCallIt("http://a.com/b/c/d.html", "../../e/f/g.html"));
    // http://a.com/e/f/g.html
    
    System.out.println("Output 5 "+whateverYouCallIt("http://a.com/b/c/d.html", "../../e/f/../g.html"));
    // http://a.com/e/g.html
    
    System.out.println("Output 6 "+whateverYouCallIt("http://a.com/b/c/d.html", "https://b.com/e/f:///g.html"));
    // https://b.com/e/f:///g.html
    
    System.out.println("Output 7 "+whateverYouCallIt("http://a.com/b/c/d.html", "/e/f:///g.html"));
    // http://a.com/e/f:///g.html
    
    
  }
  public static String whateverYouCallIt(String currentURL,String linkURL){
    if(linkURL.split("://")[0].length()>0 && linkURL.split("://")[0].indexOf("/")==-1){
      return linkURL;
    }
    else if(linkURL.split("/").length>0 && linkURL.charAt(0)=='/'){
          /*System.out.println("Output 2 "+whateverYouCallIt("http://a.com/b/c/d.html", "/e/f/g.html"));*/
    //http://a.com/e/f/g.html
      String outputString=currentURL.split("://")[0]+"://"+currentURL.split(":    //")[1].split("/")[0]+"/";
        System.out.println(currentURL.split("://")[1].split("/").length);
      for(int i=1;i<currentURL.split("://")[1].split("/").length-2;i++){
        outputString+=currentURL.split("://")[1].split("/")[i];
      }
      return outputString+linkURL;
    }
     else if(linkURL.charAt(0)!='/' && linkURL.charAt(0)!='.'){
         System.out.println("In case 3");
        String linkUrlArray[]=currentURL.split("/");
       String outputString="";
       for(int i=0;i<linkUrlArray.length-1;i++){
         outputString+=linkUrlArray[i]+"/";
       }
       outputString+=linkURL;
       return outputString;
    }
    return "TODO";
  }
}
