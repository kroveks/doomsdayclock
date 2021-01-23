function addNewWord() {

    let wordCreateDto = {
        value: $('#new_word').val(),
        userId: 3,
        dictionaryId: 5,
        translationValue: $('#word_translation').val(),
        exampleSentence: $('#word_sentence').val()
    };

    if (!fetch('http://localhost:5557/api/word/add', {
        method: 'POST',
        headers: {
            'content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(wordCreateDto)
    }).then(response => response.json()).then( x => {
        window.location.href = 'http://localhost:5557/main';
    })) {
        alert('Слово не было добавлено');
    }

}