import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItcSolutionCodeWithCommentsAndVariants {

    //Begin test code


    public List<WebElement> getSomeElements(String path) {
        if (path == null){
//            throw IllegalArgumentException("getElements: illegal path (NULL)");
            throw new IllegalArgumentException("getElements: illegal path (NULL)"); // после throw должно быть new
            //path = "//*[@id='Hello']"; // находит элемент на страницес в id = "Hello" располагающийся в любом месте
            //Но, смысла в этой присваивании нет, так как код программы не дойдет до переменной path,
            // после throw new exception уже ничего выполняться не будет!
        }

        WebDriverHelper wd = new WebDriverHelper();
        // WebDriverHelper - самописный класс, скорей всего наследник WebDriver,
        // помогающий сконструировать экземпляр наследника класса WebDriver со всеми параметрами

//        List<String> result = new ArrayList<>();
        List<WebElement> result = new ArrayList<WebElement>(); // требуется задать тип данных, хранимых в ArrayList. WebElement
        //судя из возвращаемого методом getSomeElements типа
        // и из типа используемого в цикле  for(WebElement element : result) ниже
        result.add(wd.getElements(path)); // в список result положили элемент,
        // возвращаемый методом getElement(path) принимающим string, и возвращающим WebElement

//        if (result.isEmpty()){ //  isEmpty true if this list contains no elements
        if (!result.isEmpty()){
            // не соответствие условия содержанию. если список пустой, нет смысла перебирать его элементы
            // предположительно условие должно выглядеть так: if (!result.isEmpty()) или if (result.size() > 0)
            for(WebElement element : result){
//                if(element.getText() == "remove")
                // идет сравнение содержимого WebElement.getText() со строкой "remove"
                // сравнение данных типа String корректней делать через equals тогда условие должно выглядеть так
                // if(element.getText().equals("remove"))
                // пропущено оформление в {} выполняемого тела, после условия
                if(element.getText().equals("remove")) {
//                    result.remove(element); //внутри цикла foreach нельзя производить добавление или удаление
                    // элементов коллекции. как выход, создать еще один список, и добавлять в него только те элементы,
                    // которые удовлетворяют требованиям см часть кода ниже
                    // Второй вариант - использовать цикл fori
                }
            }
            // рекомендуемая реализация удаления из коллекции, методом создания другой коллекции
            List<WebElement> tempResult = new ArrayList<WebElement>();
            for(WebElement element : result){
                if(!element.getText().equals("remove")) {
                    tempResult.add(element);
                }
            }
            result = tempResult;
            // второй вариант через fori
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).equals("remove")) {
                    result.remove(i);
                    i--;
                }
            }


        } else {
//            return result.get(0); // isEmpty -  true.  This list contains no elements.
            // то как мы можем не можем вернуть не существующий нулевой элемент, выскочит IndexOutOfBoundsException
            // возможно return null
            return null;
        }

//        if (wd.isElementsPresent(path)) { //метод самописного класса WebDriverHelper, возвращает boolean.
        if (!wd.isElementsPresent(path)) {
            // Судя по названию проверяет наличие элементов по определенному пути.
            // Судя по типу выдаваемого в консоль сообщения, условие должно срабатывать при отсутствии элементов
            // в таком случае условие должно выглядеть, как if (!wd.isElementsPresent(path))
            System.out.println("There aren't any elements by this path");
//            return; // возвращаемое методом getSomeElements значение типа List<WebElement>.
            // Так как мы рассматриваем вариант отсутствия элемента !wd.isElementsPresent(path) то логично возвращать null
            return null;
        }

        return result; // возвращаем значение типа List<WebElement>.
    }

    //End test code

}
