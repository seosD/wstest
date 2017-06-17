package spark.rest;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int requestLimitForCountingWord= 10;
        boolean isTimeToShow500Error = false;
        int requestCounter = 0;
//TODO ask using session
//TODO try to use date java 8 api
       get("/count", (req, resp) -> {
            boolean isStrCountOn = true;
            //boolean is500ErrorOn = false;
            //boolean is403ErrorOn = true;
            String bodyLine = "";

            if(isStrCountOn) {
                String str = req.queryParams("str");
                int wordCounter = countWords(str);
                bodyLine = "Line: " + str + ". Number of words: " + wordCounter;
            }/* else if(is500ErrorOn){
                resp.status(500);
                bodyLine = "Error 500";
            } else if(is403ErrorOn){
                resp.status(403);
                bodyLine = "Error 403";
            }*/
            return bodyLine;
        });
    }

    public static int countWords(String str ){
        int wordCounter = 0;
        if(!(str == null || str.trim().isEmpty())){
           String[] arrayString = str.split(" ");
           wordCounter = arrayString.length;
        }
        return  wordCounter;
    }
}
