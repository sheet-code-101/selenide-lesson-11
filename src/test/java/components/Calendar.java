package components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {

    public void setDate(String year, String month, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String daySelector = format(".react-datepicker__day--0%s", day);
        $(daySelector).click();
    }

}