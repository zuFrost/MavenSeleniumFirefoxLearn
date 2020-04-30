import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItcSolutionClearCode {

    //Begin test code


    public List<WebElement> getSomeElements(String path) {
        if (path == null){
            throw new IllegalArgumentException("getElements: illegal path (NULL)");
        }

        WebDriverHelper wd = new WebDriverHelper();
        List<WebElement> result = new ArrayList<WebElement>();
        result.add(wd.getElements(path));
        if (!result.isEmpty()){

            List<WebElement> tempResult = new ArrayList<WebElement>();
            for(WebElement element : result){
                if(!element.getText().equals("remove")) {
                    tempResult.add(element);
                }
            }
            result = tempResult;

        } else {
            return null;
        }

        if (!wd.isElementsPresent(path)) {
            System.out.println("There aren't any elements by this path");
            return null;
        }

        return result;
    }

    //End test code

}
