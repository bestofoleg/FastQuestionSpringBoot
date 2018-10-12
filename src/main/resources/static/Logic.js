var myQuestionsPlace;
var askAndQuestionPlace;
var answersCounter = 0;
var canAskQuestion = false;
var myAnswerTextField;
var myQuestionTextField;
var languageList;
var currentQuestion;

function start()
{
    //тут нужна инициализация currentQuestion?
}

function onGetStartBtnClick()
{
    setFromInFrom(askAndQuestionPlace, "getAnswerForm", "answer_form");
    showOrHideForm(askAndQuestionPlace);
    //обновить вопрос
    onSkipBtnClick();
}

function onSkipBtnClick()
{
    var questionData = getRandomQuestionByLanguage(languageList.val());
    currentQuestion = questionData;
    question = createQuestionHtml(questionData);
    askAndQuestionPlace.children("#question_place").html(question);
}

function onSendAnswerBtnClick()
{
    myAnswerTextField = $("#my_answer_text");
    canAskQuestion = getQuestionStatus();

    var message = {

        message : myAnswerTextField.val(),
        question_id : currentQuestion

    };
    addMessage(message);

    if(canAskQuestion)
    {
        setFromInFrom(askAndQuestionPlace, "getQuestionForm", "question_form");;
        answersCounter = 1;
    }
    else
    {
        //обновить вопрос
        onSkipBtnClick();
        answersCounter ++;
    }
}

function onSendQuestionBtnClick()
{
    myQuestionTextField = $("#my_question_text");
    canAskQuestion = getQuestionStatus();

    if(canAskQuestion)
    {
        setFromInFrom(askAndQuestionPlace, "getQuestionForm", "question_form");
        //заглушка
        var languageId = 4;

        if(languageList.val() == "russian")
        {languageId = 4;}
        else
        {languageId = 5;}

        var language = {

            id : languageId,
            language_name : languageList.val()

        };
        //
        var questionData = {

            question : myQuestionTextField.val(),
            language_id : language

        };
        addQuestion(questionData);
        answersCounter = 1;
    }/*
    else
    {
        var questionData = getRandomQuestionByLanguage(languageList.val());
        currentQuestion = questionData;
        question = createQuestionHtml(questionData);
        askAndQuestionPlace.children("#question_place").html(question);
        answersCounter ++;
    }*/
    onUpdateBtnClick();
}

function onUpdateBtnClick()
{
    var messagesListData = getMyMessages();
    myQuestionsPlace.html(createMessagesListHtml(messagesListData));
}