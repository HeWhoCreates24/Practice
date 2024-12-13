let userScore = 0;
let botScore = 0;
const rock = document.querySelector("#rock");
const paper = document.querySelector("#paper");
const scissors = document.querySelector("#scissors");
const result = document.querySelector(".result");
const msg = document.querySelector(".msg")
const uScore = document.querySelector("#user-score");
const bScore = document.querySelector("#bot-score");
document.querySelector(".result").addEventListener("click", () => {
    result.style.display = "none";
});
rock.addEventListener("click", () => {
    playGame("Rock");
})
paper.addEventListener("click", () => {
    playGame("Paper");
})
scissors.addEventListener("click", () => {
    playGame("Scissors");
})
const playGame = (userChoice) => {
    let botChoice = bot();
    if (userChoice == botChoice){
        draw(userChoice);
        showResult();
    }
    else if (userChoice == "Rock"){
        if (botChoice == "Paper"){
            lost(userChoice, botChoice);
            showResult();

        }
        else{
            won(userChoice, botChoice);
            showResult();
        }
    }
    else if (userChoice == "Paper"){
        if (botChoice == "Rock"){
            won(userChoice, botChoice);
            showResult();

        }
        else{
            lost(userChoice, botChoice);
            showResult();
        }
    }
    else{
        if (botChoice == "Paper"){
            won(userChoice, botChoice);
            showResult();

        }
        else{
            lost(userChoice, botChoice);
            showResult();
        }
    }
}
const bot = () => {
    let botChoice;
    let random = Math.floor(Math.random()*3);
    if (random == 0){
        botChoice = "Rock";
    }
    else if (random == 1){
        botChoice = "Paper";
    }
    else{
        botChoice = "Scissors";
    }
    return botChoice;
}
const draw = (choice) => {
    msg.innerHTML = `It was a DRAW!, both chose ${choice}.`;
    msg.style.backgroundColor = "var(--c3)";
}
const showResult = () => {
    result.style.display = "flex";
    document.querySelector(".result").addEventListener("click", () => {
        result.style.display = "none";
    })

}
const won = (uChoice, bChoice) => {
    msg.innerHTML = `You WON!, Your ${uChoice} beats his ${bChoice}.`;
    msg.style.backgroundColor = "green";
    userScore++;
    uScore.innerHTML = userScore;
}
const lost = (uChoice, bChoice) => {
    msg.innerHTML = `You LOST!, his ${bChoice} beats Your ${uChoice}.`;
    msg.style.backgroundColor = "red";
    botScore++;
    bScore.innerHTML = botScore;
}