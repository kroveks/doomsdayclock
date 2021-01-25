
$(document).ready ( function(){
    parseDictionary(3);
});


function dictionaryList(userId) {
    let query = 'http://localhost:5557/api/dictionary/user/' + userId;
    return fetch(query, {
        method: 'GET',
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    }).then(response => {
        if (response.ok) {
            return response.json()
        } else {
            let error = new Error();
            error.response = response.text();
            throw error;
        }
    }).catch(error => error.response.then(message => console.log(message)));
}

function parseDictionary(userId) {

    $('#dictionaryList').children().remove()

    dictionaryList(userId).then(function (response) {
        for (var i = 0; i < response.length; i++) {

            //номер айди словаря в базе данных, завёрнутый в строку чтоб легче вставлять
            var DictionaryIdAttribute = "data-id = \"" + response[i].id + "\""

            $('#dictionaryList').append(
                "<a href=\"#\" id=\"dictionary" + i + "\" "+ DictionaryIdAttribute + " class=\"list-group-item list-group-item-action tablinks\" onclick=\"openContent(id, 'wordList')\">\n" +
                "    <div class=\"d-flex w-100 justify-content-between\">\n" +
                "      <h5 class=\"mb-1\">"+ response[i].title + "</h5>\n" +
                "      <small>last update 5 days ago</small>\n" +
                "    </div>\n" +
                "</a>"
            )
        }
    })



}








