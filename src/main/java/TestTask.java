import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestTask {

    public List<WebElement> getSomeElements(String path) {
        if (path == null){
            throw new IllegalArgumentException("getElements: illegal path (NULL)"); // 1!!! после throw должно быть new
            //path = "//*[@id='Hello']"; // находит элемент на страницес в id = "Hello" располагающийся в любом месте
            //Но, смысла в этой присваивании нет, так как код программы не дойдет до переменной path,
            // после throw new exception уже ничего выполняться не будет!
        }
        WebDriverHelper wd = new WebDriverHelper(); // WebDriverHelper - самописный класс,
                                                    // помогающий сконструировать класс WebDriver
        List<WebElement> result = new ArrayList<WebElement>();// задать тип ArrayList.
        // List<WebElement> result = new ArrayList<WebElement>(); судя из возвращаемого методом getSomeElements типа
        // и из типа используемого в цикле  for(WebElement element : result) ниже
        result.add(wd.getElements(path)); // список result положили элемент, находящийся по пути path
        // при помощи метода getElement(path) принимающего string, и возвращающего WebElement

        if (!result.isEmpty()){
            // не соответствие условия содержанию. если список пустой, нет смысла перебирать его элементы
            // предположительно условие должно выглядеть так: if (!result.isEmpty()) или if (result.size() > 0)
            for(WebElement element : result){
                if(element.getText().equals("remove")) {
                    // идет сравнение содержимого WebElement.getText() со строкой "remove"
                    // предположительно сравнение корректней делать через equals тогда условие должно выглядеть так
                    result.remove(element); //внутри цикла foreach нельзя производить добавление или удаление
                    // элементов коллекции. как выход, создать еще один список, и добавлять в него только те элементы,
                    // которые удовлетворяют требованиям
                }
            }
        } else {
            return null;
            //разобраться в условии что приходит в else и если в него приходит пустой result,
            // то как мы можем вернуть не существующий нулевой элемент?
            // возможно return null
        }

        if (!wd.isElementsPresent(path)) { //возможно  isElementsPresent возвращает boolean, разобраться в его ответах.
            // предположительно if (!wd.isElementsPresent(path))
            System.out.println("There aren't any elements by this path");
            return null; //  мы возвращаем List<WebElement>
            // предположительно return null;
            // разобраться с предыдущим возвратом null
        }

        return result;
    }
}
