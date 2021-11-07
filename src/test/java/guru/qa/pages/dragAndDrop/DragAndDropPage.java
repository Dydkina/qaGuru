package guru.qa.pages.dragAndDrop;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.gitHub.GitHubSelenideWikiPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropPage {

    SelenideElement pageTitle = $("div.example h3"),
            squareA = $("#column-a"),
            squareB = $("#column-b"),
            secondSquare = $("div#columns div:nth-child(2)");

    public void openDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        pageTitle.shouldHave(text("Drag and Drop"));
    }

    public void dragAndDropSquareBToA() {
        squareA.dragAndDropTo(squareB);
        secondSquare.shouldHave(text("A"));
    }
}
