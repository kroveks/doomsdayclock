function sidebarButtonsEvent(evt, contentName) {

    //evt - айдишник того объекта по которому кликнули (в данном скрипте не нужный параметр, понадобится позже (возможно))
    //contentName - айдишник того фрагмента который надо отобразить

    var i, tabcontent;

    //достаём все элементы с классом tabcontent, этим классом помечены следующие фрагменты:
    //      - addWord.html
    //      - wordList.html
    //проходять по всем полученным элементам делаем их неотображаемыми
    tabcontent = document.getElementsByClassName("tabcontent");
    for(i=0; i<tabcontent.length; i++){
        tabcontent[i].style.display = "none";
    }

    //Достаём у родителя родительского элемента кнопки айдишник словаря в БД (этот суперродительский эллемент это блок словаря выделенный синим)
    var dictionaryId  = document.getElementById(evt).parentElement.parentElement.getAttribute("data-id")

    document.getElementById("addButton").setAttribute("onclick", "addNewWord(3,"+ dictionaryId +")")

    //делает требуемый контент видимым
    document.getElementById(contentName).style.display = "block";
}