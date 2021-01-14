    function openContent(evt, contentName){

        //evt - айдишник того объекта по которому кликнули
        //contentName - айдишник того фрагмента который надо отобразить

        var i, tabcontent, tablinks;

        //достаём все элементы с классом tabcontent, этим классом помечены следующие фрагменты:
        //      - addWord.html
        //      - wordList.html
        //проходять по всем полученным элементам делаем их неотображаемыми
        tabcontent = document.getElementsByClassName("tabcontent");
        for(i=0; i<tabcontent.length; i++){
            tabcontent[i].style.display = "none";
        }

        //достаём все элементы с классом tablinks, этим классом помечены все словари
        tablinks = document.getElementsByClassName("tablinks");
        for(i=0; i<tablinks.length; i++){
                //Проходим по всем словарям и делаем их не активными (не выделенными)
            tablinks[i].className = tablinks[i].className.replace(" active", "");
                //делаем выделенный словарь Кликаемым
                // (Надо поскольку у нас алгорит в том что выдленный словарь делать неКликаемым(это сделаем позже)
                // на данном этапе нам важно перевести все словари в одно состояние
                // по аналогии с циклом выше, когда мы сделали все неотображаемым)
            if(!tablinks[i].hasAttribute("onclick")) {
                tablinks[i].setAttribute("onclick", "openContent(id, 'wordList')");
            }
        }

        //удаляем кнопки, опять же переводим все словари к одному состоянию
        tablinks = document.getElementsByClassName("MyButtons");
        for(i=0; i<tablinks.length; i++){
            tablinks[i].remove();
        }

        //Начинаем добавлять кнопки
        let div = document.createElement('div');
        div.className = "MyButtons";
        div.innerHTML = "<button type=\"button\" id=\"addWordButton\" class=\"btn btn-primary mr-0\" onclick=\"sidebarButtonsEvent(id, 'addWord')\">Добавить слово</button>" +
            "<button type=\"button\" id=\"wordListButton\" class=\"btn btn-primary float-right ml-0\" onclick=\"sidebarButtonsEvent(id, 'wordList')\">Список слов</div>";
        document.getElementById(evt).append(div);
        //заканчиваем обавлять кнопки

            //делаем кликнутый  словарь активным
        document.getElementById(evt).className += " active";
        //запрещаем кликать по активному словарю
        document.getElementById(evt).removeAttribute("onclick")
        //делает требуемый контент видимым
        document.getElementById(contentName).style.display = "block";
    }

